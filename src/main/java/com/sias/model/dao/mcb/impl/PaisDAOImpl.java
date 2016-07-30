/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcb.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcb.PaisConstants;
import com.sias.model.dao.mcb.interfaces.PaisDAO;
import com.sias.model.entity.mcb.Pais;
import com.sias.model.rowmapper.mcb.PaisRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class PaisDAOImpl extends JDBCBaseDAO implements PaisDAO {

    @Override
    public void create(Pais pais) throws Exception {

        String query = "INSERT INTO " + PaisConstants.TABELA;
        {
            query += "(";
            query += PaisConstants.SIGLA + ", ";
            query += PaisConstants.DESCRICAO + ", ";
            query += PaisConstants.CODIGO_BACEN;
            query += ")";
        }
        query += " VALUES (?, ?, ?)";
        query += " RETURNING " + PaisConstants.ID;

        Object args[] = {pais.getSigla(), pais.getDescricao(), pais.getCodigoBACEN()};

        pais.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<Pais> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pais readById(Long id) throws Exception {

        String query = "SELECT * FROM ";
        query += PaisConstants.TABELA;
        query += " WHERE " + PaisConstants.ID + "=? ";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new PaisRowMapper());
    }

    @Override
    public List<Pais> readAll() throws Exception {

        String query = "SELECT * FROM ";
        query += PaisConstants.TABELA;

        return getTemplate().query(query, new PaisRowMapper());
    }

    @Override
    public void update(Pais pais) throws Exception {

        String query = "UPDATE " + PaisConstants.TABELA;
        query += " SET ";
        {
            query += PaisConstants.SIGLA + "=?, ";
            query += PaisConstants.DESCRICAO + "=?, ";
            query += PaisConstants.CODIGO_BACEN + "=? ";
        }
        query += " WHERE " + PaisConstants.ID + "=? ";

        Object args[] = {pais.getSigla(), pais.getDescricao(), pais.getCodigoBACEN(), pais.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM ";
        query += PaisConstants.TABELA;
        query += " WHERE " + PaisConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
