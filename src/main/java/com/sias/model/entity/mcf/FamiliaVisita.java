/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.entity.mcf;

import com.sias.model.base.entity.BaseEntity;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.mca.Usuario;
import java.util.Date;

/**
 *
 * @author Fernando
 */
public class FamiliaVisita extends BaseEntity {

    private UnidadeAtendimento unidadeAtendimento;

    private Familia familia;

    private Usuario usuario;

    private Date inicio;

    private Date fim;
    
    private String cor;

    public UnidadeAtendimento getUnidadeAtendimento() {
        return unidadeAtendimento;
    }

    public void setUnidadeAtendimento(UnidadeAtendimento unidadeAtendimento) {
        this.unidadeAtendimento = unidadeAtendimento;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}
