/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.entity.mcb;

import com.sias.model.base.entity.BaseEntity;

/**
 *
 * @author Fernando Laranjo
 */
public class Municipio extends BaseEntity{
    
    private String descricao;
    
    private Integer codigoIBGE;
    
    private UnidadeFederacao unidadeFederacao;
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(Integer codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public UnidadeFederacao getUnidadeFederacao() {
        return unidadeFederacao;
    }

    public void setUnidadeFederacao(UnidadeFederacao unidadeFederacao) {
        this.unidadeFederacao = unidadeFederacao;
    }
    
}

