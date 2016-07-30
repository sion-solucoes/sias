/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mca.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mca.UsuarioConstants;
import com.sias.model.dao.mca.interfaces.UsuarioDAO;
import com.sias.model.entity.mca.Usuario;
import com.sias.model.rowmapper.mca.UsuarioRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class UsuarioDAOImpl extends JDBCBaseDAO implements UsuarioDAO {

    @Override
    public void create(Usuario usuario) throws Exception {

        String query = "INSERT INTO " + UsuarioConstants.TABELA;
        query += "(";
        {
            query += UsuarioConstants.EMAIL + ", ";
            query += UsuarioConstants.SENHA + ", ";
            query += UsuarioConstants.TIPO + ", ";
            query += UsuarioConstants.NOME + ", ";
            query += UsuarioConstants.FOTO;
        }
        query += ")";
        query += " VALUES (?, MD5(?), ?, ?, ?)";
        query += " RETURNING " + UsuarioConstants.ID;

        Object args[] = {usuario.getEmail(), usuario.getSenha(), usuario.getTipo(), usuario.getNome(), usuario.getFoto()};

        usuario.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<Usuario> readByCriteria(List<Criteria> criteriaList) throws Exception {

        String query = "SELECT * FROM " + UsuarioConstants.TABELA;
        query += " WHERE TRUE ";

        Object args[] = new Object[criteriaList.size()];
        int index = 0;
        for (Criteria criteria : criteriaList) {
            query += " AND ";
            query += criteria.getAttribute() + " ";
            query += criteria.getOperation() + " ? ";
            args[index] = criteria.getValue();
        }

        return getTemplate().query(query, args, new UsuarioRowMapper());
    }

    @Override
    public Usuario readById(Long id) throws Exception {

        String query = "SELECT * FROM " + UsuarioConstants.TABELA;
        query += " WHERE " + UsuarioConstants.ID + " = " + id;

        return getTemplate().queryForObject(query, new UsuarioRowMapper());
    }

    @Override
    public List<Usuario> readAll() throws Exception {

        String query = " SELECT * FROM " + UsuarioConstants.TABELA;

        return getTemplate().query(query, new UsuarioRowMapper());
    }

    @Override
    public void update(Usuario usuario) throws Exception {

        String query = "UPDATE " + UsuarioConstants.TABELA;
        query += " SET ";
        query += UsuarioConstants.EMAIL + "=?, ";
        if (usuario.getSenha() != null && !usuario.getSenha().trim().isEmpty()) {
            query += UsuarioConstants.SENHA + "=MD5(?), ";
        }
        query += UsuarioConstants.TIPO + "=?, ";
        query += UsuarioConstants.NOME + "=?, ";
        query += UsuarioConstants.FOTO + "=? ";
        query += " WHERE " + UsuarioConstants.ID + "=? ";

        if (usuario.getSenha() != null && !usuario.getSenha().trim().isEmpty()) {
            Object args[] = {usuario.getEmail(), usuario.getSenha(), usuario.getTipo(), usuario.getNome(), usuario.getFoto(), usuario.getId()};
            getTemplate().update(query, args);
        } else {
            Object args[] = {usuario.getEmail(), usuario.getTipo(), usuario.getNome(), usuario.getFoto(), usuario.getId()};
            getTemplate().update(query, args);
        }

    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + UsuarioConstants.TABELA;
        query += " WHERE " + UsuarioConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

    @Override
    public Usuario readByEmailSenha(String email, String senha) throws Exception {

        String query = "SELECT * FROM ";
        query += UsuarioConstants.TABELA;
        query += " WHERE ";
        query += UsuarioConstants.EMAIL + "=? ";
        query += " AND ";
        query += UsuarioConstants.SENHA + "=MD5(?)";

        Object[] args = {email, senha};

        return getTemplate()
                .queryForObject(query, args, new UsuarioRowMapper());

    }

}
