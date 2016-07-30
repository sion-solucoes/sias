/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.entity.mca;

import java.util.List;
import com.sias.model.base.entity.BaseEntity;
import com.sias.model.entity.mcb.CEP;

/**
 *
 * @author Fernando Laranjo
 */
public class UnidadeAtendimento extends BaseEntity {

    public static final Short TIPO_CRAS = 1;
    
    public static final Short TIPO_CREAS = 2;
    
    private String codigo;

    private String descricao;

    private Short tipo;

    private CEP cepEndereco;

    private String logradouroEndereco;

    private String numeroEndereco;

    private String bairroEndereco;

    private List<Usuario> usuarioList;
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }

    public CEP getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(CEP cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
    
}
