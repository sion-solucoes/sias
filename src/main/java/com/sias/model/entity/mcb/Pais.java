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
public class Pais extends BaseEntity{
    
    private String sigla;
    
    private String descricao;
    
    private Short codigoBACEN;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Short getCodigoBACEN() {
        return codigoBACEN;
    }

    public void setCodigoBACEN(Short codigoBACEN) {
        this.codigoBACEN = codigoBACEN;
    }
    
}
