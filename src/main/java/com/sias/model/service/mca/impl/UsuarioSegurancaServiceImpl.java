/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mca.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mca.interfaces.UsuarioSegurancaDAO;
import com.sias.model.entity.mca.UsuarioSeguranca;
import com.sias.model.service.mca.interfaces.UsuarioSegurancaService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class UsuarioSegurancaServiceImpl implements UsuarioSegurancaService {

    @Autowired
    private UsuarioSegurancaDAO usuarioSegurancaDAO;

    @Override
    public void create(UsuarioSeguranca usuarioSeguranca) throws Exception {
        usuarioSegurancaDAO.create(usuarioSeguranca);
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
    public void validate(UsuarioSeguranca e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByUsuario(Long usuarioId) throws Exception {
        usuarioSegurancaDAO.deleteByUsuario(usuarioId);
    }

    @Override
    public String gerarCodigo() throws Exception {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0, 5).toUpperCase();
    }

    @Override
    public List<UsuarioSeguranca> readByUsuarioId(Long usuarioId) throws Exception {
        return usuarioSegurancaDAO.readByUsuarioId(usuarioId);
    }

}
