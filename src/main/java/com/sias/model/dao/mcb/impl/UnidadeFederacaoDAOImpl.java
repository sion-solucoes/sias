/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcb.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcb.PaisConstants;
import com.sias.model.constants.mcb.UnidadeFederacaoConstants;
import com.sias.model.dao.mcb.interfaces.UnidadeFederacaoDAO;
import com.sias.model.entity.mcb.UnidadeFederacao;
import com.sias.model.rowmapper.mcb.UnidadeFederacaoRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class UnidadeFederacaoDAOImpl extends JDBCBaseDAO implements UnidadeFederacaoDAO {

    @Override
    public void create(UnidadeFederacao unidadeFederacao) throws Exception {

        String query = "INSERT INTO " + UnidadeFederacaoConstants.TABELA;
        {
            query += "(";
            query += UnidadeFederacaoConstants.SIGLA + ", ";
            query += UnidadeFederacaoConstants.DESCRICAO + ", ";
            query += UnidadeFederacaoConstants.CODIGO_IBGE + ", ";
            query += UnidadeFederacaoConstants.PAIS_ID;
            query += ")";
        }
        query += " VALUES (?, ?, ?, ?)";
        query += " RETURNING " + UnidadeFederacaoConstants.ID;

        Object args[] = {unidadeFederacao.getSigla(), unidadeFederacao.getDescricao(), unidadeFederacao.getCodigoIBGE(), unidadeFederacao.getPais() != null ? unidadeFederacao.getPais().getId() : null};

        unidadeFederacao.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<UnidadeFederacao> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnidadeFederacao readById(Long id) throws Exception {

        String query = "SELECT * FROM ";
        query += UnidadeFederacaoConstants.TABELA;
        query += " LEFT JOIN ";
        query += PaisConstants.TABELA;
        query += " ON " + UnidadeFederacaoConstants.PAIS_ID + " = " + PaisConstants.ID;
        query += " WHERE " + UnidadeFederacaoConstants.ID + "=?";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new UnidadeFederacaoRowMapper());
    }

    @Override
    public List<UnidadeFederacao> readAll() throws Exception {

        String query = "SELECT * FROM ";
        query += UnidadeFederacaoConstants.TABELA;
        query += " LEFT JOIN ";
        query += PaisConstants.TABELA;
        query += " ON ";
        query += UnidadeFederacaoConstants.PAIS_ID;
        query += " = ";
        query += PaisConstants.ID;

        return getTemplate().query(query, new UnidadeFederacaoRowMapper());
    }

    @Override
    public void update(UnidadeFederacao unidadeFederacao) throws Exception {

        String query = "UPDATE " + UnidadeFederacaoConstants.TABELA;
        query += " SET ";
        query += UnidadeFederacaoConstants.SIGLA + "=?, ";
        query += UnidadeFederacaoConstants.DESCRICAO + "=?, ";
        query += UnidadeFederacaoConstants.CODIGO_IBGE + "=?, ";
        query += UnidadeFederacaoConstants.PAIS_ID + "=? ";
        query += " WHERE " + UnidadeFederacaoConstants.ID + "=?";

        Object args[] = {unidadeFederacao.getSigla(), unidadeFederacao.getDescricao(), unidadeFederacao.getCodigoIBGE(), unidadeFederacao.getPais() != null ? unidadeFederacao.getPais().getId() : null, unidadeFederacao.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + UnidadeFederacaoConstants.TABELA;
        query += " WHERE " + UnidadeFederacaoConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
