/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.entity.mcf;

import com.sias.model.entity.mcb.EspecificidadeSocial;
import com.sias.model.entity.mcb.FormaIngresso;
import java.util.List;
import com.sias.model.base.entity.BaseEntity;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.mcb.CEP;
import java.util.Date;

/**
 *
 * @author Fernando Laranjo
 */
public class Familia extends BaseEntity {

    public static final Short LOCALIZACAO_URBANA = 0;

    public static final Short LOCALIZACAO_RURAL = 1;

    private Date dataUltimaAlteracao;
    
    private UnidadeAtendimento unidadeAtendimento;

    private String nomePessoaReferencia;

    private FormaIngresso formaIngresso;

    private String detalheFormaIngressoEncaminhamento;

    private String observacaoFormaIngresso;

    private List<FamiliaMembro> familiaMembroList;

    private EspecificidadeSocial especificidadeSocial;

    private Short localizacaoEndereco;

    private Boolean enderecoAbrigo;

    private CEP cepEndereco;

    private String logradouroEndereco;

    private String numeroEndereco;

    private String bairroEndereco;

    private String pontoReferenciaEndereco;
    
    private String tipoResidencia;
    
    private String materialParedesExternas;
    
    private String acessoEnergiaEletrica;
    
    private String aguaCanalizada;
    
    private String formaAbastecimentoAgua;
    
    private String escoamentoSanitario;
    
    private String coletaLixo;
    
    private Integer numeroComodos;
    
    private Integer numeroDormitorios;
    
    private String acessibilidade;
    
    private String localizacaoAreaRisco;
    
    private String dificilAcessoGeografico;
    
    private String areaConflitoViolencia;
    
    private String observacoesCondicoesHabitacionais;

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public UnidadeAtendimento getUnidadeAtendimento() {
        return unidadeAtendimento;
    }

    public void setUnidadeAtendimento(UnidadeAtendimento unidadeAtendimento) {
        this.unidadeAtendimento = unidadeAtendimento;
    }

    public String getNomePessoaReferencia() {
        return nomePessoaReferencia;
    }

    public void setNomePessoaReferencia(String nomePessoaReferencia) {
        this.nomePessoaReferencia = nomePessoaReferencia;
    }

    public FormaIngresso getFormaIngresso() {
        return formaIngresso;
    }

    public void setFormaIngresso(FormaIngresso formaIngresso) {
        this.formaIngresso = formaIngresso;
    }

    public String getDetalheFormaIngressoEncaminhamento() {
        return detalheFormaIngressoEncaminhamento;
    }

    public void setDetalheFormaIngressoEncaminhamento(String detalheFormaIngressoEncaminhamento) {
        this.detalheFormaIngressoEncaminhamento = detalheFormaIngressoEncaminhamento;
    }

    public String getObservacaoFormaIngresso() {
        return observacaoFormaIngresso;
    }

    public void setObservacaoFormaIngresso(String observacaoFormaIngresso) {
        this.observacaoFormaIngresso = observacaoFormaIngresso;
    }

    public List<FamiliaMembro> getFamiliaMembroList() {
        return familiaMembroList;
    }

    public void setFamiliaMembroList(List<FamiliaMembro> familiaMembroList) {
        this.familiaMembroList = familiaMembroList;
    }

    public EspecificidadeSocial getEspecificidadeSocial() {
        return especificidadeSocial;
    }

    public void setEspecificidadeSocial(EspecificidadeSocial especificidadeSocial) {
        this.especificidadeSocial = especificidadeSocial;
    }

    public Short getLocalizacaoEndereco() {
        return localizacaoEndereco;
    }

    public void setLocalizacaoEndereco(Short localizacaoEndereco) {
        this.localizacaoEndereco = localizacaoEndereco;
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

    public String getPontoReferenciaEndereco() {
        return pontoReferenciaEndereco;
    }

    public void setPontoReferenciaEndereco(String pontoReferenciaEndereco) {
        this.pontoReferenciaEndereco = pontoReferenciaEndereco;
    }

    public Boolean getEnderecoAbrigo() {
        return enderecoAbrigo;
    }

    public void setEnderecoAbrigo(Boolean enderecoAbrigo) {
        this.enderecoAbrigo = enderecoAbrigo;
    }

    public String getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(String tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }

    public String getMaterialParedesExternas() {
        return materialParedesExternas;
    }

    public void setMaterialParedesExternas(String materialParedesExternas) {
        this.materialParedesExternas = materialParedesExternas;
    }

    public String getAcessoEnergiaEletrica() {
        return acessoEnergiaEletrica;
    }

    public void setAcessoEnergiaEletrica(String acessoEnergiaEletrica) {
        this.acessoEnergiaEletrica = acessoEnergiaEletrica;
    }

    public String getAguaCanalizada() {
        return aguaCanalizada;
    }

    public void setAguaCanalizada(String aguaCanalizada) {
        this.aguaCanalizada = aguaCanalizada;
    }

    public String getFormaAbastecimentoAgua() {
        return formaAbastecimentoAgua;
    }

    public void setFormaAbastecimentoAgua(String formaAbastecimentoAgua) {
        this.formaAbastecimentoAgua = formaAbastecimentoAgua;
    }

    public String getEscoamentoSanitario() {
        return escoamentoSanitario;
    }

    public void setEscoamentoSanitario(String escoamentoSanitario) {
        this.escoamentoSanitario = escoamentoSanitario;
    }

    public String getColetaLixo() {
        return coletaLixo;
    }

    public void setColetaLixo(String coletaLixo) {
        this.coletaLixo = coletaLixo;
    }

    public Integer getNumeroComodos() {
        return numeroComodos;
    }

    public void setNumeroComodos(Integer numeroComodos) {
        this.numeroComodos = numeroComodos;
    }

    public Integer getNumeroDormitorios() {
        return numeroDormitorios;
    }

    public void setNumeroDormitorios(Integer numeroDormitorios) {
        this.numeroDormitorios = numeroDormitorios;
    }

    public String getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(String acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public String getLocalizacaoAreaRisco() {
        return localizacaoAreaRisco;
    }

    public void setLocalizacaoAreaRisco(String localizacaoAreaRisco) {
        this.localizacaoAreaRisco = localizacaoAreaRisco;
    }

    public String getDificilAcessoGeografico() {
        return dificilAcessoGeografico;
    }

    public void setDificilAcessoGeografico(String dificilAcessoGeografico) {
        this.dificilAcessoGeografico = dificilAcessoGeografico;
    }

    public String getAreaConflitoViolencia() {
        return areaConflitoViolencia;
    }

    public void setAreaConflitoViolencia(String areaConflitoViolencia) {
        this.areaConflitoViolencia = areaConflitoViolencia;
    }

    public String getObservacoesCondicoesHabitacionais() {
        return observacoesCondicoesHabitacionais;
    }

    public void setObservacoesCondicoesHabitacionais(String observacoesCondicoesHabitacionais) {
        this.observacoesCondicoesHabitacionais = observacoesCondicoesHabitacionais;
    }

}
