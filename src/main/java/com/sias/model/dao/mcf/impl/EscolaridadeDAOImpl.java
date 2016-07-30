/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.impl;

import com.sias.model.constants.mcf.CondicaoOcupacaoConstants;
import com.sias.model.constants.mcf.DeficienciaConstants;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcf.EscolaridadeConstants;
import com.sias.model.dao.mcf.interfaces.EscolaridadeDAO;
import com.sias.model.entity.mcf.Escolaridade;
import com.sias.model.rowmapper.mcf.EscolaridadeRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class EscolaridadeDAOImpl extends JDBCBaseDAO implements EscolaridadeDAO {

    @Override
    public void create(Escolaridade escolaridade) throws Exception {

        String query = "INSERT INTO " + EscolaridadeConstants.TABELA;
        query += "(";
        {
            query += EscolaridadeConstants.CODIGO + ", ";
            query += EscolaridadeConstants.DESCRICAO;
        }
        query += ")";
        query += " VALUES (?, ?)";
        query += " RETURNING " + EscolaridadeConstants.ID;

        Object args[] = {escolaridade.getCodigo(), escolaridade.getDescricao()};

        escolaridade.setId(getTemplate().queryForObject(query, args, Long.class));

    }

    @Override
    public List<Escolaridade> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Escolaridade readById(Long id) throws Exception {

        String query = "SELECT * FROM " + EscolaridadeConstants.TABELA;
        query += " WHERE " + EscolaridadeConstants.ID + "=?";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new EscolaridadeRowMapper());

    }

    @Override
    public List<Escolaridade> readAll() throws Exception {

        String query = "SELECT * FROM " + EscolaridadeConstants.TABELA;

        return getTemplate().query(query, new EscolaridadeRowMapper());
    }

    @Override
    public void update(Escolaridade escolaridade) throws Exception {

        String query = "UPDATE " + EscolaridadeConstants.TABELA;
        query += " SET ";
        query += EscolaridadeConstants.CODIGO + "=?, ";
        query += EscolaridadeConstants.DESCRICAO + "=?";
        query += " WHERE ";
        query += CondicaoOcupacaoConstants.ID + "=? ";

        Object args[] = {escolaridade.getCodigo(), escolaridade.getDescricao(), escolaridade.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + EscolaridadeConstants.TABELA;
        query += " WHERE " + EscolaridadeConstants.ID + "=?";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
