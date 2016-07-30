/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.impl;

import com.sias.model.constants.mcf.BeneficioEventualConstants;
import com.sias.model.dao.mcf.interfaces.BeneficioEventualDAO;
import com.sias.model.entity.mcf.BeneficioEventual;
import com.sias.model.rowmapper.mcf.BeneficioEventualRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaderhenrique
 */
@Repository
public class BeneficioEventualDAOImpl extends JDBCBaseDAO implements BeneficioEventualDAO{

    @Override
    public void create(BeneficioEventual beneficioEventual) throws Exception {
        
        String query = "INSERT INTO " + BeneficioEventualConstants.TABELA;
        query += "(";
        {
            query += BeneficioEventualConstants.CODIGO + ", ";
            query += BeneficioEventualConstants.DESCRICAO;
        }
        query += ")";
        query += " VALUES (?, ?)";
        query += " RETURNING " + BeneficioEventualConstants.ID;

        Object args[] = {beneficioEventual.getCodigo(), beneficioEventual.getDescricao()};

        beneficioEventual.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<BeneficioEventual> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BeneficioEventual readById(Long id) throws Exception {
        String query = "SELECT * FROM " + BeneficioEventualConstants.TABELA;
        query += " WHERE " + BeneficioEventualConstants.ID + "=?";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new BeneficioEventualRowMapper());
    }

    @Override
    public List<BeneficioEventual> readAll() throws Exception {
        String query = "SELECT * FROM " + BeneficioEventualConstants.TABELA;

        return getTemplate().query(query, new BeneficioEventualRowMapper());
    }

    @Override
    public void update(BeneficioEventual beneficioEventual) throws Exception {
        String query = "UPDATE " + BeneficioEventualConstants.TABELA;
        query += " SET ";
        query += BeneficioEventualConstants.CODIGO + "=?, ";
        query += BeneficioEventualConstants.DESCRICAO + "=? ";
        query += " WHERE ";
        query += BeneficioEventualConstants.ID + "=? ";

        Object args[] = {beneficioEventual.getCodigo(), beneficioEventual.getDescricao(), beneficioEventual.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {
        String query = "DELETE FROM " + BeneficioEventualConstants.TABELA;
        query += " WHERE " + BeneficioEventualConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }
    
}
