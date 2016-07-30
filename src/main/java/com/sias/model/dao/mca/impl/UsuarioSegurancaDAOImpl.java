/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mca.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mca.UsuarioSegurancaConstants;
import com.sias.model.dao.mca.interfaces.UsuarioSegurancaDAO;
import com.sias.model.entity.mca.UsuarioSeguranca;
import com.sias.model.rowmapper.mca.UsuarioSegurancaRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class UsuarioSegurancaDAOImpl extends JDBCBaseDAO implements UsuarioSegurancaDAO {

    @Override
    public void create(UsuarioSeguranca usuarioSeguranca) throws Exception {

        String query = "INSERT INTO " + UsuarioSegurancaConstants.TABELA;
        query += " (";
        {
            query += UsuarioSegurancaConstants.USUARIO_ID + ", ";
            query += UsuarioSegurancaConstants.CODIGO;
        }
        query += " )";
        query += " VALUES (?, ?)";
        query += " RETURNING " + UsuarioSegurancaConstants.ID;

        Object args[] = {usuarioSeguranca.getUsuario().getId(), usuarioSeguranca.getCodigo()};

        usuarioSeguranca.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<UsuarioSeguranca> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioSeguranca readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioSeguranca> readAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(UsuarioSeguranca e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByUsuario(Long usuarioId) throws Exception {

        String query = "DELETE FROM " + UsuarioSegurancaConstants.TABELA;
        query += " WHERE " + UsuarioSegurancaConstants.USUARIO_ID + "=? ";

        Object args[] = {usuarioId};

        getTemplate().update(query, args);
    }

    @Override
    public List<UsuarioSeguranca> readByUsuarioId(Long usuarioId) throws Exception {

        String query = "SELECT * FROM " + UsuarioSegurancaConstants.TABELA;
        query += " WHERE " + UsuarioSegurancaConstants.USUARIO_ID + "=? ";
        query += " ORDER BY " + UsuarioSegurancaConstants.ID;
        
        Object args[] = {usuarioId};

        return getTemplate().query(query, args, new UsuarioSegurancaRowMapper());
    }

}
