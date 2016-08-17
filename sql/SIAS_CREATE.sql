	CREATE TABLE usuario (
	  usuario_id     BIGSERIAL NOT NULL, 
	  usuario_unidade_atendimento_id bigint NOT NULL,
	  usuario_tipo  smallint NOT NULL,
	  usuario_email varchar(50) NOT NULL UNIQUE, 
	  usuario_senha varchar(100) NOT NULL, 
	  usuario_nome  varchar(50) NOT NULL, 
	  usuario_foto  varchar,
	  PRIMARY KEY (usuario_id)
	);

	CREATE TABLE usuario_seguranca (
	  usuario_seguranca_id         BIGSERIAL NOT NULL, 
	  usuario_seguranca_codigo    varchar(30) NOT NULL, 
	  usuario_seguranca_usuario_id bigint NOT NULL, 
	  PRIMARY KEY (usuario_seguranca_id)
	);

	CREATE TABLE unidade_atendimento (
	  unidade_atendimento_id          BIGSERIAL NOT NULL, 
	  unidade_atendimento_codigo     varchar(10) NOT NULL UNIQUE, 
	  unidade_atendimento_descricao  varchar(100) NOT NULL, 
	  unidade_atendimento_tipo       smallint NOT NULL, 
	  unidade_atendimento_cep_endereco_id      bigint NOT NULL, 
	  unidade_atendimento_logradouro_endereco varchar(255) NOT NULL, 
	  unidade_atendimento_numero_endereco     varchar(10) NOT NULL, 
	  unidade_atendimento_bairro_endereco     varchar(100) NOT NULL, 
	  PRIMARY KEY (unidade_atendimento_id)
	);

	CREATE TABLE cep (
	  cep_id           BIGSERIAL NOT NULL, 
	  cep_codigo      varchar(10) NOT NULL UNIQUE, 
	  cep_logradouro  varchar(255) NOT NULL, 
	  cep_bairro      varchar(100) NOT NULL, 
	  cep_municipio_id bigint NOT NULL, 
	  PRIMARY KEY (cep_id)
	);

	CREATE TABLE municipio (
	  municipio_id          BIGSERIAL NOT NULL, 
	  municipio_descricao  varchar(50) NOT NULL, 
	  municipio_codigo_ibge bigint NOT NULL UNIQUE, 
	  municipio_uf_id       bigint NOT NULL, 
	  PRIMARY KEY (municipio_id)
	);

	CREATE TABLE pais (
	  pais_id           BIGSERIAL NOT NULL, 
	  pais_sigla       varchar(3) NOT NULL UNIQUE, 
	  pais_descricao   varchar(100) NOT NULL UNIQUE, 
	  pais_codigo_bacen bigint NOT NULL UNIQUE, 
	  PRIMARY KEY (pais_id)
	);

	CREATE TABLE uf (
	  uf_id          BIGSERIAL NOT NULL, 
	  uf_sigla      varchar(2) NOT NULL UNIQUE, 
	  uf_descricao  varchar(50) NOT NULL UNIQUE, 
	  uf_codigo_ibge bigint NOT NULL UNIQUE, 
	  uf_pais_id     bigint NOT NULL, 
	  PRIMARY KEY (uf_id)
	);


	CREATE TABLE especificidade_social (
	  especificidade_social_id         BIGSERIAL NOT NULL, 
	  especificidade_social_descricao varchar(50) NOT NULL, 
	  especificidade_social_indigena  boolean NOT NULL, 
	  especificidade_social_povo_etnia varchar(50) NOT NULL,
	  PRIMARY KEY (especificidade_social_id)
	);

	CREATE TABLE forma_ingresso (
	  forma_ingresso_id 	BIGSERIAL NOT NULL,
	  forma_ingresso_descricao varchar(255) NOT NULL,
	  PRIMARY KEY(forma_ingresso_id)
	);

	CREATE TABLE grau_parentesco (
	  grau_parentesco_id         BIGSERIAL NOT NULL, 
	  grau_parentesco_codigo    bigint NOT NULL UNIQUE, 
	  grau_parentesco_descricao varchar(50) NOT NULL, 
	  PRIMARY KEY (grau_parentesco_id)
	);

	CREATE TABLE documento_providenciavel (
	  documento_providenciavel_id         BIGSERIAL NOT NULL, 
	  documento_providenciavel_codigo    varchar(10) NOT NULL UNIQUE, 
	  documento_providenciavel_descricao varchar(50) NOT NULL, 
	  PRIMARY KEY (documento_providenciavel_id)
	);

	CREATE TABLE beneficio_eventual (
		beneficio_eventual_id 			BIGSERIAL NOT NULL,
		beneficio_eventual_codigo 		varchar(10) NOT NULL UNIQUE,
		beneficio_eventual_descricao 	varchar(255) NOT NULL,
		PRIMARY KEY (beneficio_eventual_id)
	);

	CREATE TABLE escolaridade (
	  escolaridade_id         BIGSERIAL NOT NULL, 
	  escolaridade_codigo    varchar(3) NOT NULL UNIQUE, 
	  escolaridade_descricao varchar(50) NOT NULL, 
	  PRIMARY KEY (escolaridade_id)
	);


	CREATE TABLE condicao_ocupacao (
	  condicao_ocupacao_id         BIGSERIAL NOT NULL, 
	  condicao_ocupacao_codigo    smallint NOT NULL UNIQUE, 
	  condicao_ocupacao_descricao varchar(100) NOT NULL, 
	  PRIMARY KEY (condicao_ocupacao_id)
	);

	CREATE TABLE deficiencia (
	  deficiencia_id BIGSERIAL NOT NULL,
	  deficiencia_codigo smallint NOT NULL,
	  deficiencia_descricao varchar(100) NOT NULL,
	  PRIMARY KEY (deficiencia_id)
	);

	CREATE TABLE familia (
	  familia_id                       	BIGSERIAL NOT NULL, 
	  familia_unidade_atendimento_id 	bigint NOT NULL, 
	  familia_nome_pessoa_referencia varchar(255),
	  familia_forma_ingresso_id		bigint NOT NULL,
	  familia_detalhe_forma_ingresso_encaminhamento	varchar(255),
	  familia_observacao_forma_ingresso	varchar(1024),
	  familia_endereco_localizacao		smallint NOT NULL DEFAULT 0,
	  familia_endereco_abrigo           	bool NOT NULL DEFAULT FALSE,
	  familia_cep_endereco_id            	bigint NOT NULL, 
	  familia_logradouro_endereco       	varchar(255) NOT NULL,
	  familia_numero_endereco           	varchar(10) NOT NULL, 
	  familia_bairro_endereco           	varchar(100) NOT NULL, 
	  familia_ponto_referencia_endereco  	varchar(255), 
	  familia_especificidade_social_id 	bigint,
	  PRIMARY KEY (familia_id)
	);

	CREATE TABLE familia_membro (
	  familia_membro_id                 	BIGSERIAL NOT NULL, 
	  familia_membro_familia_id         	bigint NOT NULL, 
	  familia_membro_grau_parentesco_id 	bigint NOT NULL,
	  familia_membro_nome              	varchar(255) NOT NULL, 
	  familia_membro_sexo              	smallint NOT NULL, 
	  familia_membro_data_nascimento    	date NOT NULL, 
	  familia_membro_apelido 		varchar(100),
	  familia_membro_nome_mae 		varchar(100),
	  familia_membro_nis 			varchar(20),
	  familia_membro_cpf 			varchar(20),
	  familia_membro_rg 			varchar(20),
	  familia_membro_rg_orgao_expedidor 	varchar(10),
	  familia_membro_rg_uf_emissao 		varchar(2),
	  familia_membro_rg_data_emissao 	date,
	  familia_membro_escolaridade_id 	bigint NOT NULL,
	  familia_membro_sabe_ler_escrever 	boolean NOT NULL,
	  familia_membro_frequenta_escola_atualmente boolean NOT NULL,
	  familia_membro_possui_carteira_trabalho boolean NOT NULL,
	  familia_membro_condicao_ocupacao_id 	bigint NOT NULL,
	  familia_membro_possui_qualificacao_profissional boolean NOT NULL,
	  familia_membro_descricao_qualificacao_profissional varchar(300),
	  familia_membro_renda_mensal float NOT NULL,
	  familia_membro_deficiencia_id bigint,
	  familia_membro_necessita_cuidados_especiais boolean NOT NULL,
	  familia_membro_descricao_necessidade_cuidados_especiais varchar(300),
	  familia_membro_usuario_remedios_controlados boolean NOT NULL,
	  familia_membro_usuario_bebidas_alcoolicas boolean NOT NULL,
	  familia_membro_usuario_entorpecentes boolean NOT NULL,
	  familia_membro_gestante boolean NOT NULL,
	  familia_membro_meses_gestacao smallint,
	  familia_membro_iniciou_pre_natal boolean,
	  PRIMARY KEY (familia_membro_id)
	);

	CREATE OR REPLACE FUNCTION pessoa_referencia_reply() RETURNS trigger AS $BODY$
	  DECLARE	
		gPC bigint := NULL;
	  BEGIN
		SELECT grau_parentesco_codigo INTO gPC FROM grau_parentesco WHERE grau_parentesco_id = NEW.familia_membro_grau_parentesco_id;
		IF ( gPC = 1::bigint )
			THEN	
				UPDATE familia SET familia_nome_pessoa_referencia = NEW.familia_membro_nome WHERE familia_id = NEW.familia_membro_familia_id;
		END IF;

		RETURN NEW;
	  END;
	$BODY$ LANGUAGE plpgsql VOLATILE COST 100;

	CREATE TRIGGER pessoa_referencia_reply BEFORE INSERT OR UPDATE ON familia_membro FOR EACH ROW EXECUTE PROCEDURE pessoa_referencia_reply();
		

	CREATE TABLE familia_membro_documento_providenciavel (
	  familia_membro_documento_providenciavel_id				bigserial NOT NULL, 
	  familia_membro_documento_providenciavel_familia_membro_id		bigint NOT NULL, 
	  familia_membro_documento_providenciavel_documento_providenciavel_id 	bigint NOT NULL, 
	  PRIMARY KEY (familia_membro_documento_providenciavel_id), 
	  CONSTRAINT familia_membro_documento_providenciavel_uk 
		UNIQUE (familia_membro_documento_providenciavel_familia_membro_id, familia_membro_documento_providenciavel_documento_providenciavel_id)
	);

	CREATE TABLE familia_beneficio_eventual (
		familia_beneficio_eventual_id 		BIGSERIAL NOT NULL,
		familia_beneficio_eventual_beneficio_eventual_id	bigint NOT NULL,
		familia_beneficio_eventual_familia_id bigint NOT NULL,
		PRIMARY KEY (familia_beneficio_eventual_id),
		CONSTRAINT familia_beneficio_eventual_uk
			UNIQUE (familia_beneficio_eventual_familia_id, familia_beneficio_eventual_beneficio_eventual_id)
	);

	CREATE TABLE familia_membro_contato (
	  familia_membro_contato_id                        BIGSERIAL NOT NULL, 
	  familia_membro_contato_familia_membro_id 	   bigint NOT NULL, 
	  familia_membro_contato_tipo                      char(1) NOT NULL, 
	  familia_membro_contato_ddd                       varchar(2), 
	  familia_membro_contato_numero                    varchar(9),
	  PRIMARY KEY (familia_membro_contato_id)
	);

	CREATE TABLE familia_visita(
	  familia_visita_id 	BIGSERIAL NOT NULL,
	  familia_visita_unidade_atendimento_id bigint NOT NULL,
	  familia_visita_familia_id bigint NOT NULL,
	  familia_visita_usuario_id bigint NOT NULL,
	  familia_visita_inicio timestamp NOT NULL,
	  familia_visita_fim timestamp NOT NULL,
	  familia_visita_cor varchar(20) NOT NULL,
	  PRIMARY KEY (familia_visita_id)
	);

	ALTER TABLE uf ADD CONSTRAINT uf_pais_fk FOREIGN KEY (uf_pais_id) REFERENCES pais (pais_id);
	ALTER TABLE municipio ADD CONSTRAINT municipo_uf_fk FOREIGN KEY (municipio_uf_id) REFERENCES uf (uf_id);
	ALTER TABLE cep ADD CONSTRAINT cep_municipio_fk FOREIGN KEY (cep_municipio_id) REFERENCES municipio (municipio_id);
	ALTER TABLE usuario ADD CONSTRAINT usuario_unidade_atendimento_fk FOREIGN KEY (usuario_unidade_atendimento_id) REFERENCES unidade_atendimento (unidade_atendimento_id);
	ALTER TABLE unidade_atendimento ADD CONSTRAINT unidade_atendimento_cep_fk FOREIGN KEY (unidade_atendimento_cep_endereco_id) REFERENCES cep (cep_id);
	ALTER TABLE familia ADD CONSTRAINT familia_unidade_atendimento_fk FOREIGN KEY (familia_unidade_atendimento_id) REFERENCES unidade_atendimento (unidade_atendimento_id);
	ALTER TABLE familia ADD CONSTRAINT familia_forma_ingresso_fk FOREIGN KEY (familia_forma_ingresso_id) REFERENCES forma_ingresso (forma_ingresso_id);
	ALTER TABLE familia ADD CONSTRAINT familia_cep_fk FOREIGN KEY (familia_cep_endereco_id) REFERENCES cep (cep_id);
	ALTER TABLE familia ADD CONSTRAINT familia_especificidade_social_fk FOREIGN KEY (familia_especificidade_social_id) REFERENCES especificidade_social (especificidade_social_id);
	
	ALTER TABLE familia_beneficio_eventual ADD CONSTRAINT familia_beneficio_eventual_familia_fk FOREIGN KEY (familia_beneficio_eventual_familia_id) REFERENCES familia (familia_id) ON DELETE CASCADE;
	ALTER TABLE familia_beneficio_eventual ADD CONSTRAINT familia_beneficio_eventual_beneficio_eventual_fk FOREIGN KEY (familia_beneficio_eventual_beneficio_eventual_id) REFERENCES beneficio_eventual (beneficio_eventual_id) ON DELETE CASCADE;

	ALTER TABLE familia_membro ADD CONSTRAINT familia_membro_familia_fk FOREIGN KEY (familia_membro_familia_id) REFERENCES familia (familia_id);
	ALTER TABLE familia_membro ADD CONSTRAINT familia_membro_grau_parentesco_fk FOREIGN KEY (familia_membro_grau_parentesco_id) REFERENCES grau_parentesco (grau_parentesco_id);
	ALTER TABLE familia_membro ADD CONSTRAINT familia_membro_escolaridade_fk FOREIGN KEY (familia_membro_escolaridade_id) REFERENCES escolaridade (escolaridade_id);
	ALTER TABLE familia_membro ADD CONSTRAINT familia_membro_condicao_ocupacao_fk FOREIGN KEY (familia_membro_condicao_ocupacao_id) REFERENCES condicao_ocupacao (condicao_ocupacao_id);
	ALTER TABLE familia_membro ADD CONSTRAINT familia_membro_deficiencia_fk FOREIGN KEY (familia_membro_deficiencia_id) REFERENCES deficiencia (deficiencia_id);
	ALTER TABLE familia_membro_documento_providenciavel ADD CONSTRAINT familia_membro_documento_providenciavel_familia_membro_fk FOREIGN KEY (familia_membro_documento_providenciavel_familia_membro_id) REFERENCES familia_membro (familia_membro_id) ON DELETE CASCADE;
	ALTER TABLE familia_membro_documento_providenciavel ADD CONSTRAINT familia_membro_documento_providenciavel_documento_providenciavel_fk FOREIGN KEY (familia_membro_documento_providenciavel_documento_providenciavel_id) REFERENCES documento_providenciavel (documento_providenciavel_id) ON DELETE CASCADE;
	ALTER TABLE familia_membro_contato ADD CONSTRAINT familia_membro_contato_familia_membro_fk FOREIGN KEY (familia_membro_contato_familia_membro_id) REFERENCES familia_membro (familia_membro_id);
	ALTER TABLE usuario_seguranca ADD CONSTRAINT usuario_seguranca_usuario_fk FOREIGN KEY (usuario_seguranca_usuario_id) REFERENCES usuario (usuario_id);
	ALTER TABLE familia_visita ADD CONSTRAINT familia_visita_unidade_atendimento_fk FOREIGN KEY (familia_visita_unidade_atendimento_id) REFERENCES unidade_atendimento (unidade_atendimento_id);
	ALTER TABLE familia_visita ADD CONSTRAINT familia_visita_familia_fk FOREIGN KEY (familia_visita_familia_id) REFERENCES familia (familia_id);
	ALTER TABLE familia_visita ADD CONSTRAINT familia_visita_usuario_fk FOREIGN KEY (familia_visita_usuario_id) REFERENCES usuario (usuario_id);
