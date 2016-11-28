/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.entity.mca;

import java.util.List;
import com.sias.model.base.entity.BaseEntity;

/**
 *
 * @author Fernando Laranjo
 */
public class Usuario extends BaseEntity {

    public static final short TIPO_MASTER = 1;

    public static final short TIPO_TECNICO = 2;

    public static final short TIPO_ADMINISTRATIVO = 3;

    private UnidadeAtendimento unidadeAtendimento;
    
    private short tipo;
    
    private String email;

    private String senha;

    private String nome;

    private String sobrenome;

    private String foto;

    private List<UsuarioSeguranca> usuarioSegurancaList;

    public UnidadeAtendimento getUnidadeAtendimento() {
        return unidadeAtendimento;
    }

    public void setUnidadeAtendimento(UnidadeAtendimento unidadeAtendimento) {
        this.unidadeAtendimento = unidadeAtendimento;
    }

    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<UsuarioSeguranca> getUsuarioSegurancaList() {
        return usuarioSegurancaList;
    }

    public void setUsuarioSegurancaList(List<UsuarioSeguranca> usuarioSegurancaList) {
        this.usuarioSegurancaList = usuarioSegurancaList;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

}
