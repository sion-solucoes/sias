/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mca.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mca.UnidadeAtendimentoConstants;
import com.sias.model.constants.mcb.CEPConstants;
import com.sias.model.constants.mcb.MunicipioConstants;
import com.sias.model.constants.mcb.PaisConstants;
import com.sias.model.constants.mcb.UnidadeFederacaoConstants;
import com.sias.model.dao.mca.interfaces.UnidadeAtendimentoDAO;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.rowmapper.mca.UnidadeAtendimentoRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class UnidadeAtendimentoDAOImpl extends JDBCBaseDAO implements UnidadeAtendimentoDAO {

    @Override
    public void create(UnidadeAtendimento unidadeAtendimento) throws Exception {

        String query = "INSERT INTO " + UnidadeAtendimentoConstants.TABELA;
        query += "(";
        {
            query += UnidadeAtendimentoConstants.CODIGO + ", ";
            query += UnidadeAtendimentoConstants.DESCRICAO + ", ";
            query += UnidadeAtendimentoConstants.TIPO + ", ";
            query += UnidadeAtendimentoConstants.CEP_ENDERECO_ID + ", ";
            query += UnidadeAtendimentoConstants.LOGRADOURO_ENDERECO + ", ";
            query += UnidadeAtendimentoConstants.NUMERO_ENDERECO + ", ";
            query += UnidadeAtendimentoConstants.BAIRRO_ENDERECO;
        }
        query += ")";
        query += " VALUES (?, ?, ?, ?, ?, ?, ?) ";
        query += " RETURNING " + UnidadeAtendimentoConstants.ID;

        Object args[] = {unidadeAtendimento.getCodigo(), unidadeAtendimento.getDescricao(), unidadeAtendimento.getTipo(),
            unidadeAtendimento.getCepEndereco().getId(), unidadeAtendimento.getLogradouroEndereco(), unidadeAtendimento.getNumeroEndereco(), unidadeAtendimento.getBairroEndereco()};

        unidadeAtendimento.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<UnidadeAtendimento> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnidadeAtendimento readById(Long id) throws Exception {

        String query = "SELECT * FROM " + UnidadeAtendimentoConstants.TABELA;
        query += " LEFT JOIN " + CEPConstants.TABELA;
        query += " ON " + UnidadeAtendimentoConstants.CEP_ENDERECO_ID + " = " + CEPConstants.ID;
        query += " LEFT JOIN " + MunicipioConstants.TABELA;
        query += " ON " + CEPConstants.MUNICIPIO_ID + " = " + MunicipioConstants.ID;
        query += " LEFT JOIN " + UnidadeFederacaoConstants.TABELA;
        query += " ON " + MunicipioConstants.UF_ID + " = " + UnidadeFederacaoConstants.ID;
        query += " LEFT JOIN " + PaisConstants.TABELA;
        query += " ON " + UnidadeFederacaoConstants.PAIS_ID + " = " + PaisConstants.ID;
        query += " WHERE " + UnidadeAtendimentoConstants.ID + "=? ";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new UnidadeAtendimentoRowMapper());
    }

    @Override
    public List<UnidadeAtendimento> readAll() throws Exception {

        String query = "SELECT * FROM " + UnidadeAtendimentoConstants.TABELA;
        query += " LEFT JOIN " + CEPConstants.TABELA;
        query += " ON " + UnidadeAtendimentoConstants.CEP_ENDERECO_ID + " = " + CEPConstants.ID;
        query += " LEFT JOIN " + MunicipioConstants.TABELA;
        query += " ON " + CEPConstants.MUNICIPIO_ID + " = " + MunicipioConstants.ID;
        query += " LEFT JOIN " + UnidadeFederacaoConstants.TABELA;
        query += " ON " + MunicipioConstants.UF_ID + " = " + UnidadeFederacaoConstants.ID;
        query += " LEFT JOIN " + PaisConstants.TABELA;
        query += " ON " + UnidadeFederacaoConstants.PAIS_ID + " = " + PaisConstants.ID;

        return getTemplate().query(query, new UnidadeAtendimentoRowMapper());
    }

    @Override
    public void update(UnidadeAtendimento unidadeAtendimento) throws Exception {

        String query = "UPDATE " + UnidadeAtendimentoConstants.TABELA;
        query += " SET ";
        query += UnidadeAtendimentoConstants.CODIGO + "=?, ";
        query += UnidadeAtendimentoConstants.DESCRICAO + "=?, ";
        query += UnidadeAtendimentoConstants.TIPO + "=?, ";
        query += UnidadeAtendimentoConstants.CEP_ENDERECO_ID + "=?, ";
        query += UnidadeAtendimentoConstants.LOGRADOURO_ENDERECO + "=?, ";
        query += UnidadeAtendimentoConstants.NUMERO_ENDERECO + "=?, ";
        query += UnidadeAtendimentoConstants.BAIRRO_ENDERECO + "=? ";
        query += " WHERE " + UnidadeAtendimentoConstants.ID + "=? ";

        Object args[] = {unidadeAtendimento.getCodigo(), unidadeAtendimento.getDescricao(), unidadeAtendimento.getTipo(), unidadeAtendimento.getCepEndereco().getId(), unidadeAtendimento.getLogradouroEndereco(), unidadeAtendimento.getNumeroEndereco(), unidadeAtendimento.getBairroEndereco(), unidadeAtendimento.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + UnidadeAtendimentoConstants.TABELA;
        query += " WHERE " + UnidadeAtendimentoConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
