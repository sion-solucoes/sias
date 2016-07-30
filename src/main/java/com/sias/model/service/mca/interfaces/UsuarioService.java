/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mca.interfaces;

import com.sias.model.entity.mca.Usuario;
import com.sias.model.base.service.BaseService;

/**
 *
 * @author Fernando Laranjo
 */
public interface UsuarioService extends BaseService<Usuario>{

    public Usuario readByEmailAndSenha(String email, String senha) throws Exception;
    
}
