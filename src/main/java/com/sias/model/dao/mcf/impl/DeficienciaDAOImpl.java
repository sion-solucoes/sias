/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcf.DeficienciaConstants;
import com.sias.model.dao.mcf.interfaces.DeficienciaDAO;
import com.sias.model.entity.mcf.Deficiencia;
import com.sias.model.rowmapper.mcf.DeficienciaRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class DeficienciaDAOImpl extends JDBCBaseDAO implements DeficienciaDAO {

    @Override
    public void create(Deficiencia deficiencia) throws Exception {

        String query = "INSERT INTO " + DeficienciaConstants.TABELA;
        query += "(";
        {
            query += DeficienciaConstants.CODIGO + ", ";
            query += DeficienciaConstants.DESCRICAO;
        }
        query += ")";
        query += " VALUES (?, ?)";
        query += " RETURNING " + DeficienciaConstants.ID;

        Object args[] = {deficiencia.getCodigo(), deficiencia.getDescricao()};

        deficiencia.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<Deficiencia> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Deficiencia readById(Long id) throws Exception {

        String query = "SELECT * FROM " + DeficienciaConstants.TABELA;
        query += " WHERE " + DeficienciaConstants.ID + "=?";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new DeficienciaRowMapper());
    }

    @Override
    public List<Deficiencia> readAll() throws Exception {

        String query = "SELECT * FROM " + DeficienciaConstants.TABELA;

        return getTemplate().query(query, new DeficienciaRowMapper());
    }

    @Override
    public void update(Deficiencia deficiencia) throws Exception {

        String query = "UPDATE " + DeficienciaConstants.TABELA;
        query += " SET ";
        query += DeficienciaConstants.CODIGO + "=?, ";
        query += DeficienciaConstants.DESCRICAO + "=?";
        query += " WHERE ";
        query += DeficienciaConstants.ID + "=? ";

        Object args[] = {deficiencia.getCodigo(), deficiencia.getDescricao(), deficiencia.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + DeficienciaConstants.TABELA;
        query += " WHERE " + DeficienciaConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
