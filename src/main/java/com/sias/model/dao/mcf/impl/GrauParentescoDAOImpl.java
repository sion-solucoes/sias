/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcf.GrauParentescoConstants;
import com.sias.model.dao.mcf.interfaces.GrauParentescoDAO;
import com.sias.model.entity.mcf.GrauParentesco;
import com.sias.model.rowmapper.mcf.GrauParentescoRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class GrauParentescoDAOImpl extends JDBCBaseDAO implements GrauParentescoDAO {

    @Override
    public void create(GrauParentesco grauParentesco) throws Exception {

        String query = "INSERT INTO " + GrauParentescoConstants.TABELA;
        query += "(";
        {
            query += GrauParentescoConstants.CODIGO + ", ";
            query += GrauParentescoConstants.DESCRICAO;
        }
        query += ")";
        query += " VALUES (?, ?)";
        query += " RETURNING " + GrauParentescoConstants.ID;

        Object args[] = {grauParentesco.getCodigo(), grauParentesco.getDescricao()};

        grauParentesco.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<GrauParentesco> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrauParentesco readById(Long id) throws Exception {

        String query = "SELECT * FROM " + GrauParentescoConstants.TABELA;
        query += " WHERE " + GrauParentescoConstants.ID + "=?";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new GrauParentescoRowMapper());
    }

    @Override
    public List<GrauParentesco> readAll() throws Exception {

        String query = "SELECT * FROM " + GrauParentescoConstants.TABELA;
        query += " ORDER BY " + GrauParentescoConstants.ID;

        return getTemplate().query(query, new GrauParentescoRowMapper());
    }

    @Override
    public void update(GrauParentesco grauParentesco) throws Exception {

        String query = "UPDATE " + GrauParentescoConstants.TABELA;
        query += " SET ";
        query += GrauParentescoConstants.CODIGO + "=?, ";
        query += GrauParentescoConstants.DESCRICAO + "=?";
        query += " WHERE ";
        query += GrauParentescoConstants.ID + "=? ";

        Object args[] = {grauParentesco.getCodigo(), grauParentesco.getDescricao(), grauParentesco.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + GrauParentescoConstants.TABELA;
        query += " WHERE " + GrauParentescoConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
