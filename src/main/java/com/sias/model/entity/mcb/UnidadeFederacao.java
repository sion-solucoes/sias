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
public class UnidadeFederacao extends BaseEntity{
    
    private String sigla;
    
    private String descricao;
    
    private Short codigoIBGE;
    
    private Pais pais;

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

    public Short getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(Short codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
}
