CREATE EXTENSION hstore;
CREATE SCHEMA audit;

CREATE OR REPLACE FUNCTION audit.audit_table(
    target_table regclass,
    audit_rows boolean,
    audit_query_text boolean,
    ignored_cols text[])
  RETURNS void AS
$BODY$
DECLARE
  stm_targets text = 'INSERT OR UPDATE OR DELETE OR TRUNCATE';
  _q_txt text;
  _ignored_cols_snip text = '';
BEGIN
    EXECUTE 'DROP TRIGGER IF EXISTS audit_trigger_row ON ' || target_table;
    EXECUTE 'DROP TRIGGER IF EXISTS audit_trigger_stm ON ' || target_table;

    IF audit_rows THEN
        IF array_length(ignored_cols,1) > 0 THEN
            _ignored_cols_snip = ', ' || quote_literal(ignored_cols);
        END IF;
        _q_txt = 'CREATE TRIGGER audit_trigger_row AFTER INSERT OR UPDATE OR DELETE ON ' || 
                 target_table || 
                 ' FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func(' ||
                 quote_literal(audit_query_text) || _ignored_cols_snip || ');';
        RAISE NOTICE '%',_q_txt;
        EXECUTE _q_txt;
        stm_targets = 'TRUNCATE';
    ELSE
    END IF;
    _q_txt = 'CREATE TRIGGER audit_trigger_stm AFTER ' || stm_targets || ' ON ' ||
             target_table ||
             ' FOR EACH STATEMENT EXECUTE PROCEDURE audit.if_modified_func('||
             quote_literal(audit_query_text) || ');';
    RAISE NOTICE '%',_q_txt;
    EXECUTE _q_txt;

END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION audit.audit_table(
    target_table regclass,
    audit_rows boolean,
    audit_query_text boolean)
  RETURNS void AS
$BODY$
SELECT audit.audit_table($1, $2, $3, ARRAY[]::text[]);
$BODY$
  LANGUAGE sql VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION audit.audit_table(target_table regclass)
  RETURNS void AS
$BODY$
SELECT audit.audit_table($1, BOOLEAN 't', BOOLEAN 't');
$BODY$
  LANGUAGE sql VOLATILE
  COST 100;

CREATE TABLE audit.logged_actions
(
  event_id bigserial NOT NULL, -- Unique identifier for each auditable event
  schema_name text NOT NULL, -- Database schema audited table for this event is in
  table_name text NOT NULL, -- Non-schema-qualified table name of table event occured in
  relid oid NOT NULL, -- Table OID. Changes with drop/create. Get with 'tablename'::regclass
  session_user_name text, -- Login / session user whose statement caused the audited event
  action_tstamp_tx timestamp without time zone NOT NULL, -- Transaction start timestamp for tx in which audited event occurred
  action_tstamp_stm timestamp without time zone NOT NULL, -- Statement start timestamp for tx in which audited event occurred
  action_tstamp_clk timestamp without time zone NOT NULL, -- Wall clock time at which audited event's trigger call occurred
  transaction_id bigint, -- Identifier of transaction that made the change. May wrap, but unique paired with action_tstamp_tx.
  application_name text, -- Application name set when this audit event occurred. Can be changed in-session by client.
  client_addr inet, -- IP address of client that issued query. Null for unix domain socket.
  client_port integer, -- Remote peer IP port address of client that issued query. Undefined for unix socket.
  client_query text, -- Top-level query that caused this auditable event. May be more than one statement.
  action text NOT NULL, -- Action type; I = insert, D = delete, U = update, T = truncate
  row_data hstore, -- Record value. Null for statement-level trigger. For INSERT this is the new tuple. For DELETE and UPDATE it is the old tuple.
  changed_fields hstore, -- New values of fields changed by UPDATE. Null except for row-level UPDATE events.
  statement_only boolean NOT NULL, -- 't' if audit event is from an FOR EACH STATEMENT trigger, 'f' for FOR EACH ROW
  CONSTRAINT logged_actions_pkey PRIMARY KEY (event_id),
  CONSTRAINT logged_actions_action_check CHECK (action = ANY (ARRAY['I'::text, 'D'::text, 'U'::text, 'T'::text]))
);

CREATE INDEX logged_actions_action_idx
  ON audit.logged_actions
  USING btree
  (action COLLATE pg_catalog."default");

CREATE INDEX logged_actions_action_tstamp_tx_stm_idx
  ON audit.logged_actions
  USING btree
  (action_tstamp_stm);

CREATE INDEX logged_actions_relid_idx
  ON audit.logged_actions
  USING btree
  (relid);


CREATE OR REPLACE FUNCTION audit.if_modified_func()
  RETURNS trigger AS
$BODY$
DECLARE
    audit_row audit.logged_actions;
    include_values boolean;
    log_diffs boolean;
    h_old hstore;
    h_new hstore;
    excluded_cols text[] = ARRAY[]::text[];
    usuario_sessao text;
BEGIN
    IF TG_WHEN <> 'AFTER' THEN
        RAISE EXCEPTION 'audit.if_modified_func() may only run as an AFTER trigger';
    END IF;
    usuario_sessao = SPLIT_PART(current_query(), '--@user:',2);	
    audit_row = ROW(
        nextval('audit.logged_actions_event_id_seq'), -- event_id
        TG_TABLE_SCHEMA::text,                        -- schema_name
        TG_TABLE_NAME::text,                          -- table_name
        TG_RELID,                                     -- relation OID for much quicker searches
        usuario_sessao,                           -- session_user_name
        current_timestamp,                            -- action_tstamp_tx
        statement_timestamp(),                        -- action_tstamp_stm
        clock_timestamp(),                            -- action_tstamp_clk
        txid_current(),                               -- transaction ID
        current_setting('application_name'),          -- client application
        inet_client_addr(),                           -- client_addr
        inet_client_port(),                           -- client_port
        current_query(),                              -- top-level query or queries (if multistatement) from client
        substring(TG_OP,1,1),                         -- action
        NULL, NULL,                                   -- row_data, changed_fields
        'f'                                           -- statement_only
        );

    IF audit_row.session_user_name = '' THEN
    	audit_row.session_user_name = 'postgres';
    END IF;

    IF NOT TG_ARGV[0]::boolean IS DISTINCT FROM 'f'::boolean THEN
        audit_row.client_query = NULL;
    END IF;

    IF TG_ARGV[1] IS NOT NULL THEN
        excluded_cols = TG_ARGV[1]::text[];
    END IF;
    
    IF (TG_OP = 'UPDATE' AND TG_LEVEL = 'ROW') THEN
        audit_row.row_data = hstore(OLD.*);
        audit_row.changed_fields =  (hstore(NEW.*) - audit_row.row_data) - excluded_cols;
        IF audit_row.changed_fields = hstore('') THEN
            -- All changed fields are ignored. Skip this update.
            RETURN NULL;
        END IF;
    ELSIF (TG_OP = 'DELETE' AND TG_LEVEL = 'ROW') THEN
        audit_row.row_data = hstore(OLD.*) - excluded_cols;
    ELSIF (TG_OP = 'INSERT' AND TG_LEVEL = 'ROW') THEN
        audit_row.row_data = hstore(NEW.*) - excluded_cols;
    ELSIF (TG_LEVEL = 'STATEMENT' AND TG_OP IN ('INSERT','UPDATE','DELETE','TRUNCATE')) THEN
        audit_row.statement_only = 't';
    ELSE
        RAISE EXCEPTION '[audit.if_modified_func] - Trigger func added as trigger for unhandled case: %, %',TG_OP, TG_LEVEL;
        RETURN NULL;
    END IF;
    INSERT INTO audit.logged_actions VALUES (audit_row.*);
    RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- CEP
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON cep
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON cep
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- CONDICAO_OCUPACAO
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON condicao_ocupacao
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON condicao_ocupacao
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- DEFICIENCIA
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON deficiencia
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON deficiencia
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- DOCUMENTO PROVIDENCIAVEL
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON documento_providenciavel
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON documento_providenciavel
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- ESCOLARIDADE
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON escolaridade
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON escolaridade
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- ESPECIFICIDADE SOCIAL
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON especificidade_social
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON especificidade_social
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- FAMILIA
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON familia
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON familia
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- FAMILIA_MEMBRO
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON familia_membro
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON familia_membro
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- FAMILIA_MEMBRO_CONTATO
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON familia_membro_contato
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON familia_membro_contato
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- FAMILIA_MEMBRO_DOCUMENTO_PROVIDENCIAVEL
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON familia_membro_documento_providenciavel
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON familia_membro_documento_providenciavel
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- FORMA_INGRESSO
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON forma_ingresso
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON forma_ingresso
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- GRAU_PARENTESCO
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON grau_parentesco
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON grau_parentesco
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- MUNICIPIO
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON municipio
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON municipio
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- PAIS
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON pais
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON pais
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- UF
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON uf
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON uf
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- UNIDADE_ATENDIMENTO
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON unidade_atendimento
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON unidade_atendimento
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- USUARIO
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON usuario
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON usuario
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

-- USUARIO_SEGURANCA
CREATE TRIGGER audit_trigger_row
  AFTER INSERT OR UPDATE OR DELETE
  ON usuario_seguranca
  FOR EACH ROW
  EXECUTE PROCEDURE audit.if_modified_func('true', '{audit_user}');

CREATE TRIGGER audit_trigger_stm
  AFTER TRUNCATE
  ON usuario_seguranca
  FOR EACH STATEMENT
  EXECUTE PROCEDURE audit.if_modified_func('true');

