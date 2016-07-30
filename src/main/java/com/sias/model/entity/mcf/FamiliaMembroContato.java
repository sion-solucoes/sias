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
public class FamiliaMembroContato extends BaseEntity{
    
    private String ddd;
    
    private String numero;

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
