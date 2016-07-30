/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.entity.mca;

/**
 *
 * @author Fernando Laranjo
 */
public class UsuarioUnidadeAtendimento {
    
    private Usuario usuario;
    
    private UnidadeAtendimento unidadeAtendimento;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UnidadeAtendimento getUnidadeAtendimento() {
        return unidadeAtendimento;
    }

    public void setUnidadeAtendimento(UnidadeAtendimento unidadeAtendimento) {
        this.unidadeAtendimento = unidadeAtendimento;
    }
    
}
