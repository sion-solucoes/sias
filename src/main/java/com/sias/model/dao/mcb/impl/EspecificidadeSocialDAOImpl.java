/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcb.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcb.EspecificidadeSocialConstants;
import com.sias.model.dao.mcb.interfaces.EspecificidadeSocialDAO;
import com.sias.model.entity.mcb.EspecificidadeSocial;
import com.sias.model.rowmapper.mcb.EspecificidadeSocialRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class EspecificidadeSocialDAOImpl extends JDBCBaseDAO implements EspecificidadeSocialDAO {

    @Override
    public void create(EspecificidadeSocial especificidadeSocial) throws Exception {

        String query = "INSERT INTO " + EspecificidadeSocialConstants.TABELA;
        query += "(";
        {
            query += EspecificidadeSocialConstants.DESCRICAO + ", ";
            query += EspecificidadeSocialConstants.INDIGENA + ", ";
            query += EspecificidadeSocialConstants.POVO_ETNIA;
        }
        query += ")";
        query += " VALUES (?, ?, ?)";
        query += " RETURNING " + EspecificidadeSocialConstants.ID;

        Object args[] = {especificidadeSocial.getDescricao(), especificidadeSocial.getIndigena(), especificidadeSocial.getPovoEtnia()};

        especificidadeSocial.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<EspecificidadeSocial> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EspecificidadeSocial readById(Long id) throws Exception {

        String query = "SELECT * FROM " + EspecificidadeSocialConstants.TABELA;
        query += " WHERE " + EspecificidadeSocialConstants.ID + "=?";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new EspecificidadeSocialRowMapper());
    }

    @Override
    public List<EspecificidadeSocial> readAll() throws Exception {

        String query = "SELECT * FROM " + EspecificidadeSocialConstants.TABELA;

        return getTemplate().query(query, new EspecificidadeSocialRowMapper());
    }

    @Override
    public void update(EspecificidadeSocial especificidadeSocial) throws Exception {

        String query = "UPDATE " + EspecificidadeSocialConstants.TABELA;
        query += " SET ";
        query += EspecificidadeSocialConstants.DESCRICAO + "=?, ";
        query += EspecificidadeSocialConstants.INDIGENA + "=?, ";
        query += EspecificidadeSocialConstants.POVO_ETNIA + "=? ";
        query += " WHERE ";
        query += EspecificidadeSocialConstants.ID + "=? ";

        Object args[] = {especificidadeSocial.getDescricao(), especificidadeSocial.getIndigena(), especificidadeSocial.getPovoEtnia(), especificidadeSocial.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + EspecificidadeSocialConstants.TABELA;
        query += " WHERE " + EspecificidadeSocialConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
