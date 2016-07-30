/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mca.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sias.model.dao.mca.interfaces.UsuarioDAO;
import com.sias.model.entity.mca.Usuario;
import com.sias.model.entity.mca.UsuarioSeguranca;
import com.sias.model.entity.mca.UsuarioUnidadeAtendimento;
import com.sias.model.service.mca.interfaces.UsuarioSegurancaService;
import com.sias.model.service.mca.interfaces.UsuarioService;
import com.sias.model.service.mca.interfaces.UsuarioUnidadeAtendimentoService;
import com.sias.util.Criteria;
import com.sias.util.ValidateException;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private UsuarioSegurancaService usuarioSegurancaService;

    @Autowired
    private UsuarioUnidadeAtendimentoService usuarioUnidadeAtendimentoService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Usuario usuario) throws Exception {
        validate(usuario);
        usuarioDAO.create(usuario);
        usuarioSegurancaService.deleteByUsuario(usuario.getId());
        for (UsuarioSeguranca usuarioSeguranca : usuario.getUsuarioSegurancaList()) {
            usuarioSeguranca.setUsuario(usuario);
            usuarioSegurancaService.create(usuarioSeguranca);
        }
        usuarioUnidadeAtendimentoService.deleteByUsuario(usuario.getId());
        for (UsuarioUnidadeAtendimento usuarioUnidadeAtendimento : usuario.getUsuarioUnidadeAtendimentoList()) {
            usuarioUnidadeAtendimento.setUsuario(usuario);
            usuarioUnidadeAtendimentoService.create(usuarioUnidadeAtendimento);
        }
    }

    @Override
    public List<Usuario> readByCriteria(List<Criteria> criteriaList) throws Exception {
        return usuarioDAO.readByCriteria(criteriaList);
    }

    @Override
    public Usuario readById(Long id) throws Exception {
        return usuarioDAO.readById(id);
    }

    @Override
    public List<Usuario> readAll() throws Exception {
        return usuarioDAO.readAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Usuario usuario) throws Exception {
        validate(usuario);
        usuarioDAO.update(usuario);
        usuarioSegurancaService.deleteByUsuario(usuario.getId());
        for (UsuarioSeguranca usuarioSeguranca : usuario.getUsuarioSegurancaList()) {
            usuarioSeguranca.setUsuario(usuario);
            usuarioSegurancaService.create(usuarioSeguranca);
        }
        usuarioUnidadeAtendimentoService.deleteByUsuario(usuario.getId());
        for (UsuarioUnidadeAtendimento usuarioUnidadeAtendimento : usuario.getUsuarioUnidadeAtendimentoList()) {
            usuarioUnidadeAtendimento.setUsuario(usuario);
            usuarioUnidadeAtendimentoService.create(usuarioUnidadeAtendimento);
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        usuarioDAO.delete(id);
    }

    @Override
    public void validate(Usuario usuario) throws Exception {

        if (usuario.getTipo() == null || usuario.getTipo() == 0) {
            throw new ValidateException("\"Tipo\" é um campo obrigatório");
        }
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new ValidateException("\"E-mail\" é um campo obrigatório");
        }
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new ValidateException("\"Nome\" é um campo obrigatório");
        }
        if (usuario.getUsuarioUnidadeAtendimentoList() == null || usuario.getUsuarioUnidadeAtendimentoList().isEmpty()) {
            throw new ValidateException("\"Unidade de Atendimento\" é um campo obrigatório");
        }
        if (usuario.getUsuarioSegurancaList() == null || usuario.getUsuarioSegurancaList().isEmpty()) {
            throw new ValidateException("\"Códigos de Segurança\" é um campo obrigatório!");
        }

    }

    @Override
    public Usuario readByEmailAndSenha(String email, String senha) throws Exception {
        return usuarioDAO.readByEmailSenha(email, senha);
    }

}
