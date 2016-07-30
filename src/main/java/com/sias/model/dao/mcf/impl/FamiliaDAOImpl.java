/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcb.CEPConstants;
import com.sias.model.constants.mcf.FamiliaConstants;
import com.sias.model.constants.mcf.FamiliaMembroConstants;
import com.sias.model.constants.mcf.FormaIngressoConstants;
import com.sias.model.dao.mcf.interfaces.FamiliaDAO;
import com.sias.model.entity.mcf.Familia;
import com.sias.model.rowmapper.mcf.FamiliaRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class FamiliaDAOImpl extends JDBCBaseDAO implements FamiliaDAO {

    @Override
    public void create(Familia familia) throws Exception {

        String query = "INSERT INTO " + FamiliaConstants.TABELA;
        query += "(";
        {
            query += FamiliaConstants.UNIDADE_ATENDIMENTO_ID + ", ";
            query += FamiliaConstants.FORMA_INGRESSO_ID + ", ";
            query += FamiliaConstants.DETALHE_FORMA_INGRESSO_ENCAMINHAMENTO + ", ";
            query += FamiliaConstants.OBSERVACAO_FORMA_INGRESSO + ", ";
            query += FamiliaConstants.ENDERECO_LOCALIZACAO + ", ";
            query += FamiliaConstants.ENDERECO_ABRIGO + ", ";
            query += FamiliaConstants.CEP_ENDERECO_ID + ", ";
            query += FamiliaConstants.LOGRADOURO_ENDERECO + ", ";
            query += FamiliaConstants.NUMERO_ENDERECO + ", ";
            query += FamiliaConstants.BAIRRO_ENDERECO + ", ";
            query += FamiliaConstants.PONTO_REFERENCIA_ENDERECO + ", ";
            query += FamiliaConstants.ESPECIFICIDADE_SOCIAL_ID;
        }
        query += ")";
        query += " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        query += " RETURNING " + FamiliaConstants.ID;

        Object args[] = {
            familia.getUnidadeAtendimento() != null ? familia.getUnidadeAtendimento().getId() : null,
            familia.getFormaIngresso() != null ? familia.getFormaIngresso().getId() : null,
            familia.getDetalheFormaIngressoEncaminhamento(),
            familia.getObservacaoFormaIngresso(), familia.getLocalizacaoEndereco(), familia.getEnderecoAbrigo(),
            familia.getCepEndereco() != null ? familia.getCepEndereco().getId() : null,
            familia.getLogradouroEndereco(), familia.getNumeroEndereco(), familia.getBairroEndereco(),
            familia.getPontoReferenciaEndereco(),
            familia.getEspecificidadeSocial() != null ? familia.getEspecificidadeSocial().getId() : null
        };

        familia.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<Familia> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Familia readById(Long id) throws Exception {

        String query = "SELECT * FROM " + FamiliaConstants.TABELA;
        query += " LEFT JOIN " + FormaIngressoConstants.TABELA;
        query += " ON " + FamiliaConstants.FORMA_INGRESSO_ID + " = " + FormaIngressoConstants.ID;
        query += " LEFT JOIN " + CEPConstants.TABELA;
        query += " ON " + FamiliaConstants.CEP_ENDERECO_ID + " = " + CEPConstants.ID;
        query += " WHERE " + FamiliaConstants.ID + "=? ";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new FamiliaRowMapper());
    }

    @Override
    public List<Familia> readAll() throws Exception {

        String query = "SELECT * FROM " + FamiliaConstants.TABELA;
        query += " LEFT JOIN " + FamiliaMembroConstants.TABELA;
        query += " ON " + FamiliaConstants.ID + " = " + FamiliaMembroConstants.FAMILIA_ID;
        query += " LEFT JOIN " + CEPConstants.TABELA;
        query += " ON " + FamiliaConstants.CEP_ENDERECO_ID + " = " + CEPConstants.ID;
        query += " ORDER BY " + FamiliaMembroConstants.ID + " LIMIT 1";

        return getTemplate().query(query, new FamiliaRowMapper());
    }

    @Override
    public void update(Familia familia) throws Exception {

        String query = "UPDATE " + FamiliaConstants.TABELA;
        query += " SET ";
        query += FamiliaConstants.UNIDADE_ATENDIMENTO_ID + "=?, ";
        query += FamiliaConstants.FORMA_INGRESSO_ID + "=?, ";
        query += FamiliaConstants.DETALHE_FORMA_INGRESSO_ENCAMINHAMENTO + "=?, ";
        query += FamiliaConstants.OBSERVACAO_FORMA_INGRESSO + "=?, ";
        query += FamiliaConstants.ENDERECO_LOCALIZACAO + "=?, ";
        query += FamiliaConstants.ENDERECO_ABRIGO + "=?, ";
        query += FamiliaConstants.CEP_ENDERECO_ID + "=?, ";
        query += FamiliaConstants.LOGRADOURO_ENDERECO + "=?, ";
        query += FamiliaConstants.NUMERO_ENDERECO + "=?, ";
        query += FamiliaConstants.BAIRRO_ENDERECO + "=?, ";
        query += FamiliaConstants.PONTO_REFERENCIA_ENDERECO + "=?, ";
        query += FamiliaConstants.ESPECIFICIDADE_SOCIAL_ID + "=?";
        query += " WHERE " + FamiliaConstants.ID + "=? ";

        Object args[] = {
            familia.getUnidadeAtendimento() != null ? familia.getUnidadeAtendimento().getId() : null,
            familia.getFormaIngresso() != null ? familia.getFormaIngresso().getId() : null,
            familia.getDetalheFormaIngressoEncaminhamento(),
            familia.getObservacaoFormaIngresso(), familia.getLocalizacaoEndereco(), familia.getEnderecoAbrigo(),
            familia.getCepEndereco() != null ? familia.getCepEndereco().getId() : null,
            familia.getLogradouroEndereco(), familia.getNumeroEndereco(), familia.getBairroEndereco(),
            familia.getPontoReferenciaEndereco(),
            familia.getEspecificidadeSocial() != null ? familia.getEspecificidadeSocial().getId() : null,
            familia.getId()
        };

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + FamiliaConstants.TABELA;
        query += " WHERE " + FamiliaConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
