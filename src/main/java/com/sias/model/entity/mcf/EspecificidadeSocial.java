/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.entity.mcf;

import com.sias.model.base.entity.BaseEntity;

/**
 *
 * @author Fernando Laranjo
 */
public class EspecificidadeSocial extends BaseEntity {

    private String descricao;

    private boolean indigena;

    private String povoEtnia;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getIndigena() {
        return indigena;
    }

    public void setIndigena(boolean indigena) {
        this.indigena = indigena;
    }

    public String getPovoEtnia() {
        return povoEtnia;
    }

    public void setPovoEtnia(String povoEtnia) {
        this.povoEtnia = povoEtnia;
    }

}
