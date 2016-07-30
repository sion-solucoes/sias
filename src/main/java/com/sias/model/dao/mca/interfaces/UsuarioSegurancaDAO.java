/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mca.interfaces;

import java.util.List;
import com.sias.model.base.dao.BaseDAO;
import com.sias.model.entity.mca.UsuarioSeguranca;

/**
 *
 * @author Fernando Laranjo
 */
public interface UsuarioSegurancaDAO extends BaseDAO<UsuarioSeguranca>{

    public void deleteByUsuario(Long usuarioId) throws Exception;

    public List<UsuarioSeguranca> readByUsuarioId(Long usuarioId) throws Exception;
    
}
