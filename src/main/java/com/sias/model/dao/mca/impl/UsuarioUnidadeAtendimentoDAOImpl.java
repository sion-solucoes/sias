/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mca.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mca.UnidadeAtendimentoConstants;
import com.sias.model.constants.mca.UsuarioUnidadeAtendimentoConstants;
import com.sias.model.dao.mca.interfaces.UsuarioUnidadeAtendimentoDAO;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.mca.UsuarioUnidadeAtendimento;
import com.sias.model.rowmapper.mca.UnidadeAtendimentoRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class UsuarioUnidadeAtendimentoDAOImpl extends JDBCBaseDAO implements UsuarioUnidadeAtendimentoDAO {

    @Override
    public void create(UsuarioUnidadeAtendimento usuarioUnidadeAtendimento) throws Exception {

        String query = "INSERT INTO " + UsuarioUnidadeAtendimentoConstants.TABELA;
        query += "(";
        {
            query += UsuarioUnidadeAtendimentoConstants.USUARIO_ID + ", ";
            query += UsuarioUnidadeAtendimentoConstants.UNIDADE_ATENDIMENTO_ID;
        }
        query += ")";
        query += " VALUES(?, ?) ";

        Object args[] = {usuarioUnidadeAtendimento.getUsuario().getId(), usuarioUnidadeAtendimento.getUnidadeAtendimento().getId()};

        getTemplate().update(query, args);
    }

    @Override
    public List<UsuarioUnidadeAtendimento> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioUnidadeAtendimento readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioUnidadeAtendimento> readAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(UsuarioUnidadeAtendimento e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UnidadeAtendimento> readUnidadeAtendimentoByUsuario(Long usuarioId) throws Exception {

        String query = "SELECT * FROM " + UnidadeAtendimentoConstants.TABELA;
        query += " WHERE " + UnidadeAtendimentoConstants.ID;
        query += " IN";
        query += " (";
        {
            query += " SELECT " + UsuarioUnidadeAtendimentoConstants.UNIDADE_ATENDIMENTO_ID;
            query += " FROM " + UsuarioUnidadeAtendimentoConstants.TABELA;
            query += " WHERE " + UsuarioUnidadeAtendimentoConstants.USUARIO_ID + "=? ";
        }
        query += " )";

        Object args[] = {usuarioId};

        return getTemplate().query(query, args, new UnidadeAtendimentoRowMapper());

    }

    @Override
    public void deleteByUsuario(Long usuarioId) throws Exception {

        String query = "DELETE FROM " + UsuarioUnidadeAtendimentoConstants.TABELA;
        query += " WHERE " + UsuarioUnidadeAtendimentoConstants.USUARIO_ID + "=? ";

        Object args[] = {usuarioId};

        getTemplate().update(query, args);
    }

}
