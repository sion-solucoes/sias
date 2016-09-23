/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcb.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcb.FormaIngressoConstants;
import com.sias.model.dao.mcb.interfaces.FormaIngressoDAO;
import com.sias.model.entity.mcb.FormaIngresso;
import com.sias.model.rowmapper.mcb.FormaIngressoRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class FormaIngressoDAOImpl extends JDBCBaseDAO implements FormaIngressoDAO {

    @Override
    public void create(FormaIngresso formaIngresso) throws Exception {

        String query = "INSERT INTO " + FormaIngressoConstants.TABELA;
        query += "(";
        {
            query += FormaIngressoConstants.DESCRICAO;
        }
        query += ")";
        query += " VALUES (?) ";
        query += " RETURNING " + FormaIngressoConstants.ID;

        Object args[] = {formaIngresso.getDescricao()};

        formaIngresso.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<FormaIngresso> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FormaIngresso readById(Long id) throws Exception {

        String query = "SELECT * FROM " + FormaIngressoConstants.TABELA;
        query += " WHERE " + FormaIngressoConstants.ID + "=? ";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new FormaIngressoRowMapper());
    }

    @Override
    public List<FormaIngresso> readAll() throws Exception {

        String query = "SELECT * FROM " + FormaIngressoConstants.TABELA;

        return getTemplate().query(query, new FormaIngressoRowMapper());
    }

    @Override
    public void update(FormaIngresso formaIngresso) throws Exception {

        String query = "UPDATE " + FormaIngressoConstants.TABELA;
        query += " SET ";
        query += FormaIngressoConstants.DESCRICAO + "=? ";
        query += " WHERE " + FormaIngressoConstants.ID + "=? ";

        Object args[] = {formaIngresso.getDescricao(), formaIngresso.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + FormaIngressoConstants.TABELA;
        query += " WHERE " + FormaIngressoConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
