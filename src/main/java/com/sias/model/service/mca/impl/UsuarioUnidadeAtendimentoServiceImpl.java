/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mca.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mca.interfaces.UsuarioUnidadeAtendimentoDAO;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.mca.UsuarioUnidadeAtendimento;
import com.sias.model.service.mca.interfaces.UsuarioUnidadeAtendimentoService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class UsuarioUnidadeAtendimentoServiceImpl implements UsuarioUnidadeAtendimentoService {

    @Autowired
    private UsuarioUnidadeAtendimentoDAO usuarioUnidadeAtendimentoDAO;

    @Override
    public void create(UsuarioUnidadeAtendimento usuarioUnidadeAtendimento) throws Exception {
        usuarioUnidadeAtendimentoDAO.create(usuarioUnidadeAtendimento);
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
    public void validate(UsuarioUnidadeAtendimento e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UnidadeAtendimento> readUnidadeAtendimentoByUsuario(Long usuarioId) throws Exception {
        return usuarioUnidadeAtendimentoDAO.readUnidadeAtendimentoByUsuario(usuarioId);
    }

    @Override
    public void deleteByUsuario(Long usuarioId) throws Exception {
        usuarioUnidadeAtendimentoDAO.deleteByUsuario(usuarioId);
    }

}
