/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.impl;

import com.sias.model.constants.mcf.CondicaoOcupacaoConstants;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcf.EscolaridadeConstants;
import com.sias.model.constants.mcf.FamiliaConstants;
import com.sias.model.constants.mcf.FamiliaMembroConstants;
import com.sias.model.constants.mcf.GrauParentescoConstants;
import com.sias.model.dao.mcf.interfaces.FamiliaMembroDAO;
import com.sias.model.entity.mcf.FamiliaMembro;
import com.sias.model.rowmapper.mcf.FamiliaMembroRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class FamiliaMembroDAOImpl extends JDBCBaseDAO implements FamiliaMembroDAO {

    @Override
    public void create(FamiliaMembro familiaMembro) throws Exception {

        String query = "INSERT INTO " + FamiliaMembroConstants.TABELA;
        query += "(";
        {
            query += FamiliaMembroConstants.FAMILIA_ID + ", ";
            query += FamiliaMembroConstants.GRAU_PARENTESCO_ID + ", ";
            query += FamiliaMembroConstants.NOME + ", ";
            query += FamiliaMembroConstants.SEXO + ", ";
            query += FamiliaMembroConstants.APELIDO + ", ";
            query += FamiliaMembroConstants.DATA_NASCIMENTO + ", ";
            query += FamiliaMembroConstants.NOME_MAE + ", ";
            query += FamiliaMembroConstants.NIS + ", ";
            query += FamiliaMembroConstants.CPF + ", ";
            query += FamiliaMembroConstants.RG + ", ";
            query += FamiliaMembroConstants.RG_ORGAO_EXPEDIDOR + ", ";
            query += FamiliaMembroConstants.RG_UF_EMISSAO + ", ";
            query += FamiliaMembroConstants.RG_DATA_EMISSAO + ", ";
            query += FamiliaMembroConstants.ESCOLARIDADE_ID + ", ";
            query += FamiliaMembroConstants.SABE_LER_ESCREVER + ", ";
            query += FamiliaMembroConstants.FREQUENTA_ESCOLA_ATUALMENTE + ", ";
            query += FamiliaMembroConstants.POSSUI_CARTEIRA_TRABALHO + ", ";
            query += FamiliaMembroConstants.CONDICAO_OCUPACAO_ID + ", ";
            query += FamiliaMembroConstants.POSSUI_QUALIFICACAO_PROFISSIONAL + ", ";
            query += FamiliaMembroConstants.DESCRICAO_QUALIFICACAO_PROFISSIONAL + ", ";
            query += FamiliaMembroConstants.RENDA_MENSAL + ", ";
            query += FamiliaMembroConstants.DEFICIENCIA_ID + ", ";
            query += FamiliaMembroConstants.NECESSITA_CUIDADOS_ESPECIAIS + ", ";
            query += FamiliaMembroConstants.DESCRICAO_NECESSIDADE_CUIDADOS_ESPECIAIS + ", ";
            query += FamiliaMembroConstants.USUARIO_REMEDIOS_CONTROLADOS + ", ";
            query += FamiliaMembroConstants.USUARIO_BEDIDAS_ALCOOLICAS + ", ";
            query += FamiliaMembroConstants.USUARIO_ENTORPECENTES + ", ";
            query += FamiliaMembroConstants.GESTANTE + ", ";
            query += FamiliaMembroConstants.MESES_GESTACAO + ", ";
            query += FamiliaMembroConstants.INICIOU_PRE_NATAL;

        }
        query += ")";
        query += " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        query += " RETURNING " + FamiliaMembroConstants.ID;

        Object args[] = {familiaMembro.getFamilia() != null ? familiaMembro.getFamilia().getId() : null,
            familiaMembro.getGrauParentesco() != null ? familiaMembro.getGrauParentesco().getId() : null,
            familiaMembro.getNome(), familiaMembro.getSexo(), familiaMembro.getApelido(), familiaMembro.getDataNascimento(),
            familiaMembro.getNomeMae(), familiaMembro.getNis(), familiaMembro.getCpf(), familiaMembro.getRg(),
            familiaMembro.getRgOrgaoExpedidor(), familiaMembro.getRgUFEmissao(), familiaMembro.getRgDataEmissao(),
            familiaMembro.getEscolaridade() != null ? familiaMembro.getEscolaridade().getId() : null,
            familiaMembro.isSabeLerEscrever(), familiaMembro.isFrequentaEscolaAtualmente(), familiaMembro.isPossuiCarteiraTrabalho(), familiaMembro.getCondicaoOcupacao() != null ? familiaMembro.getCondicaoOcupacao().getId() : null,
            familiaMembro.isPossuiQualificacaoProfissional(), familiaMembro.getDescricaoQualificacaoProfissional(), familiaMembro.getRendaMensal(),
            familiaMembro.getDeficiencia() != null ? familiaMembro.getDeficiencia().getId() : null, familiaMembro.isNecessitaCuidadosConstantes(),
            familiaMembro.getDescricaoNecessidadeCuidadosConstantes(), familiaMembro.isUsuarioRemediosControlados(), familiaMembro.isUsuarioBebidasAlcoolicas(),
            familiaMembro.isUsuarioEntorpecentes(), familiaMembro.isGestante(), familiaMembro.getMesesGestacao(), familiaMembro.isIniciouPreNatal()
        };

        familiaMembro.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<FamiliaMembro> readByCriteria(List<Criteria> criteriaList) throws Exception {

        String query = "SELECT * FROM " + FamiliaMembroConstants.TABELA;
        query += " LEFT JOIN " + FamiliaConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.FAMILIA_ID + " = " + FamiliaConstants.ID;
        query += " LEFT JOIN " + GrauParentescoConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.GRAU_PARENTESCO_ID + " = " + GrauParentescoConstants.ID;
        query += " LEFT JOIN " + EscolaridadeConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.ESCOLARIDADE_ID + " = " + EscolaridadeConstants.ID;
        query += " WHERE TRUE ";

        Object args[] = new Object[criteriaList.size()];
        int index = 0;
        for (Criteria criteria : criteriaList) {
            query += " AND ";
            query += criteria.getAttribute() + " ";
            query += criteria.getOperation() + " ? ";
            args[index] = criteria.getValue();
        }

        return getTemplate().query(query, args, new FamiliaMembroRowMapper());

    }

    @Override
    public FamiliaMembro readById(Long id) throws Exception {

        String query = "SELECT * FROM " + FamiliaMembroConstants.TABELA;
        query += " LEFT JOIN " + FamiliaConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.FAMILIA_ID + " = " + FamiliaConstants.ID;
        query += " LEFT JOIN " + GrauParentescoConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.GRAU_PARENTESCO_ID + " = " + GrauParentescoConstants.ID;
        query += " LEFT JOIN " + EscolaridadeConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.ESCOLARIDADE_ID + " = " + EscolaridadeConstants.ID;
        query += " WHERE " + FamiliaMembroConstants.ID + "=? ";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new FamiliaMembroRowMapper());
    }

    @Override
    public List<FamiliaMembro> readAll() throws Exception {

        String query = "SELECT * FROM " + FamiliaMembroConstants.TABELA;
        query += " LEFT JOIN " + FamiliaConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.FAMILIA_ID + " = " + FamiliaConstants.ID;
        query += " LEFT JOIN " + GrauParentescoConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.GRAU_PARENTESCO_ID + " = " + GrauParentescoConstants.ID;
        query += " LEFT JOIN " + EscolaridadeConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.ESCOLARIDADE_ID + " = " + EscolaridadeConstants.ID;
        query += " WHERE " + FamiliaMembroConstants.GRAU_PARENTESCO_ID + " IS NOT NULL ";
        query += " AND " + FamiliaMembroConstants.NOME + " NOT LIKE ''";

        return getTemplate().query(query, new FamiliaMembroRowMapper());
    }

    @Override
    public void update(FamiliaMembro familiaMembro) throws Exception {

        String query = "UPDATE " + FamiliaMembroConstants.TABELA;
        query += " SET ";
        query += FamiliaMembroConstants.FAMILIA_ID + "=?, ";
        query += FamiliaMembroConstants.GRAU_PARENTESCO_ID + "=?, ";
        query += FamiliaMembroConstants.NOME + "=?, ";
        query += FamiliaMembroConstants.SEXO + "=?, ";
        query += FamiliaMembroConstants.APELIDO + "=?, ";
        query += FamiliaMembroConstants.DATA_NASCIMENTO + "=?, ";
        query += FamiliaMembroConstants.NOME_MAE + "=?, ";
        query += FamiliaMembroConstants.NIS + "=?, ";
        query += FamiliaMembroConstants.CPF + "=?, ";
        query += FamiliaMembroConstants.RG + "=?, ";
        query += FamiliaMembroConstants.RG_ORGAO_EXPEDIDOR + "=?, ";
        query += FamiliaMembroConstants.RG_UF_EMISSAO + "=?, ";
        query += FamiliaMembroConstants.RG_DATA_EMISSAO + "=?, ";
        query += FamiliaMembroConstants.ESCOLARIDADE_ID + "=?, ";
        query += FamiliaMembroConstants.SABE_LER_ESCREVER + "=?, ";
        query += FamiliaMembroConstants.FREQUENTA_ESCOLA_ATUALMENTE + "=? ";
        query += " WHERE " + FamiliaMembroConstants.ID + "=? ";

        Object args[] = {familiaMembro.getFamilia() != null ? familiaMembro.getFamilia().getId() : null,
            familiaMembro.getGrauParentesco() != null ? familiaMembro.getGrauParentesco().getId() : null,
            familiaMembro.getNome(), familiaMembro.getSexo(), familiaMembro.getApelido(), familiaMembro.getDataNascimento(),
            familiaMembro.getNomeMae(), familiaMembro.getNis(), familiaMembro.getCpf(), familiaMembro.getRg(),
            familiaMembro.getRgOrgaoExpedidor(), familiaMembro.getRgUFEmissao(), familiaMembro.getRgDataEmissao(),
            familiaMembro.getEscolaridade() != null ? familiaMembro.getEscolaridade().getId() : null,
            familiaMembro.isSabeLerEscrever(), familiaMembro.isFrequentaEscolaAtualmente(),
            familiaMembro.getId()
        };

        getTemplate()
                .update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + FamiliaMembroConstants.TABELA;
        query += " WHERE " + FamiliaMembroConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

    @Override
    public List<FamiliaMembro> readFamiliaMembroByFamilia(Long familiaId) throws Exception {

        String query = "SELECT * FROM " + FamiliaMembroConstants.TABELA;
        query += " LEFT JOIN " + FamiliaConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.FAMILIA_ID + " = " + FamiliaConstants.ID;
        query += " LEFT JOIN " + GrauParentescoConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.GRAU_PARENTESCO_ID + " = " + GrauParentescoConstants.ID;
        query += " LEFT JOIN " + EscolaridadeConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.ESCOLARIDADE_ID + " = " + EscolaridadeConstants.ID;
        query += " LEFT JOIN " + CondicaoOcupacaoConstants.TABELA;
        query += " ON " + FamiliaMembroConstants.CONDICAO_OCUPACAO_ID + " = " + CondicaoOcupacaoConstants.ID;
        query += " WHERE " + FamiliaMembroConstants.GRAU_PARENTESCO_ID + " IS NOT NULL ";
        query += " AND " + FamiliaMembroConstants.NOME + " NOT LIKE ''";
        query += " AND " + FamiliaMembroConstants.FAMILIA_ID + "=? ";

        Object args[] = {familiaId};

        return getTemplate().query(query, args, new FamiliaMembroRowMapper());
    }

    @Override
    public void deleteByFamilia(Long familiaId) throws Exception {

        String query = "DELETE FROM " + FamiliaMembroConstants.TABELA;
        query += " WHERE " + FamiliaMembroConstants.FAMILIA_ID + "=? ";

        Object args[] = {familiaId};

        getTemplate().update(query, args);
    }

}
