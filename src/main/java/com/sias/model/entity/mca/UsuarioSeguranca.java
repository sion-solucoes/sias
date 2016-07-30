/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.entity.mca;

import com.sias.model.base.entity.BaseEntity;

/**
 *
 * @author Fernando Laranjo
 */
public class UsuarioSeguranca extends BaseEntity{
    
    private String codigo;
    
    private Usuario usuario;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
