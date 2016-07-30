/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mca.interfaces;

import com.sias.model.base.dao.BaseDAO;
import com.sias.model.entity.mca.Usuario;

/**
 *
 * @author Fernando Laranjo
 */
public interface UsuarioDAO extends BaseDAO<Usuario>{

    public Usuario readByEmailSenha(String email, String senha) throws Exception;
    
}
