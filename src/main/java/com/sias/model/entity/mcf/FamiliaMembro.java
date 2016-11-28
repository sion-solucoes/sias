/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.entity.mcf;

import com.sias.model.entity.mcb.GrauParentesco;
import com.sias.model.entity.mcb.Deficiencia;
import com.sias.model.entity.mcb.Escolaridade;
import com.sias.model.entity.mcb.CondicaoOcupacao;
import java.util.Date;
import java.util.List;
import com.sias.model.base.entity.BaseEntity;

/**
 *
 * @author Fernando Laranjo
 */
public class FamiliaMembro extends BaseEntity {

    public static final short SEXO_MASCULINO = 0;

    public static final short SEXO_FEMININO = 1;

    private Familia familia;

    private GrauParentesco grauParentesco;

    private String nome;

    private short sexo;

    private String apelido;

    private Date dataNascimento;

    private String nomeMae;

    private String nis;

    private String cpf;

    private String rg;

    private String rgOrgaoExpedidor;

    private String rgUFEmissao;

    private Date rgDataEmissao;

    private List<FamiliaMembroDocumentoProvidenciavel> familiaMembroDocumentoProvidenciavelList;

    private Escolaridade escolaridade;

    private boolean sabeLerEscrever;

    private boolean frequentaEscolaAtualmente;

    private boolean possuiCarteiraTrabalho;

    private CondicaoOcupacao condicaoOcupacao;

    private boolean possuiQualificacaoProfissional;

    private String descricaoQualificacaoProfissional;

    private double rendaMensal;

    private Deficiencia deficiencia;

    private boolean necessitaCuidadosConstantes;

    private String descricaoNecessidadeCuidadosConstantes;

    private boolean usuarioRemediosControlados;

    private boolean usuarioBebidasAlcoolicas;

    private boolean usuarioEntorpecentes;

    private boolean gestante;

    private int mesesGestacao;

    private boolean iniciouPreNatal;

    private boolean vitimaAmeacasDiscriminacao;

    private boolean participaGruposReligiosos;

    private boolean participaMovimentosSociais;

    private boolean acessoLazer;

    private boolean companhiaAdulto;

    private boolean violenciaFisica;

    private boolean violenciaPsicologica;

    private boolean exploracaoSexual;

    private boolean abusoViolenciaSexual;

    private boolean negligenciaAbandono;

    private boolean trabalhoInfantil;

    private boolean trajetoriaRua;

    private boolean traficoPessoas;

    private boolean discriminacaoOrientacaoSexual;

    private boolean violenciaIdosoPCD;

    private String acompanhamento;

    private List<FamiliaMembroContato> familiaMembroContatoList;

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public GrauParentesco getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(GrauParentesco grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public short getSexo() {
        return sexo;
    }

    public void setSexo(short sexo) {
        this.sexo = sexo;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRgOrgaoExpedidor() {
        return rgOrgaoExpedidor;
    }

    public void setRgOrgaoExpedidor(String rgOrgaoExpedidor) {
        this.rgOrgaoExpedidor = rgOrgaoExpedidor;
    }

    public String getRgUFEmissao() {
        return rgUFEmissao;
    }

    public void setRgUFEmissao(String rgUFEmissao) {
        this.rgUFEmissao = rgUFEmissao;
    }

    public Date getRgDataEmissao() {
        return rgDataEmissao;
    }

    public void setRgDataEmissao(Date rgDataEmissao) {
        this.rgDataEmissao = rgDataEmissao;
    }

    public List<FamiliaMembroDocumentoProvidenciavel> getFamiliaMembroDocumentoProvidenciavelList() {
        return familiaMembroDocumentoProvidenciavelList;
    }

    public void setFamiliaMembroDocumentoProvidenciavelList(List<FamiliaMembroDocumentoProvidenciavel> familiaMembroDocumentoProvidenciavelList) {
        this.familiaMembroDocumentoProvidenciavelList = familiaMembroDocumentoProvidenciavelList;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public boolean isSabeLerEscrever() {
        return sabeLerEscrever;
    }

    public void setSabeLerEscrever(boolean sabeLerEscrever) {
        this.sabeLerEscrever = sabeLerEscrever;
    }

    public boolean isFrequentaEscolaAtualmente() {
        return frequentaEscolaAtualmente;
    }

    public void setFrequentaEscolaAtualmente(boolean frequentaEscolaAtualmente) {
        this.frequentaEscolaAtualmente = frequentaEscolaAtualmente;
    }

    public boolean isPossuiCarteiraTrabalho() {
        return possuiCarteiraTrabalho;
    }

    public void setPossuiCarteiraTrabalho(boolean possuiCarteiraTrabalho) {
        this.possuiCarteiraTrabalho = possuiCarteiraTrabalho;
    }

    public CondicaoOcupacao getCondicaoOcupacao() {
        return condicaoOcupacao;
    }

    public void setCondicaoOcupacao(CondicaoOcupacao condicaoOcupacao) {
        this.condicaoOcupacao = condicaoOcupacao;
    }

    public boolean isPossuiQualificacaoProfissional() {
        return possuiQualificacaoProfissional;
    }

    public void setPossuiQualificacaoProfissional(boolean possuiQualificacaoProfissional) {
        this.possuiQualificacaoProfissional = possuiQualificacaoProfissional;
    }

    public String getDescricaoQualificacaoProfissional() {
        return descricaoQualificacaoProfissional;
    }

    public void setDescricaoQualificacaoProfissional(String descricaoQualificacaoProfissional) {
        this.descricaoQualificacaoProfissional = descricaoQualificacaoProfissional;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public Deficiencia getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(Deficiencia deficiencia) {
        this.deficiencia = deficiencia;
    }

    public boolean isNecessitaCuidadosConstantes() {
        return necessitaCuidadosConstantes;
    }

    public void setNecessitaCuidadosConstantes(boolean necessitaCuidadosConstantes) {
        this.necessitaCuidadosConstantes = necessitaCuidadosConstantes;
    }

    public String getDescricaoNecessidadeCuidadosConstantes() {
        return descricaoNecessidadeCuidadosConstantes;
    }

    public void setDescricaoNecessidadeCuidadosConstantes(String descricaoNecessidadeCuidadosConstantes) {
        this.descricaoNecessidadeCuidadosConstantes = descricaoNecessidadeCuidadosConstantes;
    }

    public boolean isUsuarioRemediosControlados() {
        return usuarioRemediosControlados;
    }

    public void setUsuarioRemediosControlados(boolean usuarioRemediosControlados) {
        this.usuarioRemediosControlados = usuarioRemediosControlados;
    }

    public boolean isUsuarioBebidasAlcoolicas() {
        return usuarioBebidasAlcoolicas;
    }

    public void setUsuarioBebidasAlcoolicas(boolean usuarioBebidasAlcoolicas) {
        this.usuarioBebidasAlcoolicas = usuarioBebidasAlcoolicas;
    }

    public boolean isUsuarioEntorpecentes() {
        return usuarioEntorpecentes;
    }

    public void setUsuarioEntorpecentes(boolean usuarioEntorpecentes) {
        this.usuarioEntorpecentes = usuarioEntorpecentes;
    }

    public boolean isGestante() {
        return gestante;
    }

    public void setGestante(boolean gestante) {
        this.gestante = gestante;
    }

    public int getMesesGestacao() {
        return mesesGestacao;
    }

    public void setMesesGestacao(int mesesGestacao) {
        this.mesesGestacao = mesesGestacao;
    }

    public boolean isIniciouPreNatal() {
        return iniciouPreNatal;
    }

    public void setIniciouPreNatal(boolean iniciouPreNatal) {
        this.iniciouPreNatal = iniciouPreNatal;
    }

    public boolean isVitimaAmeacasDiscriminacao() {
        return vitimaAmeacasDiscriminacao;
    }

    public void setVitimaAmeacasDiscriminacao(boolean vitimaAmeacasDiscriminacao) {
        this.vitimaAmeacasDiscriminacao = vitimaAmeacasDiscriminacao;
    }

    public boolean isParticipaGruposReligiosos() {
        return participaGruposReligiosos;
    }

    public void setParticipaGruposReligiosos(boolean participaGruposReligiosos) {
        this.participaGruposReligiosos = participaGruposReligiosos;
    }

    public boolean isParticipaMovimentosSociais() {
        return participaMovimentosSociais;
    }

    public void setParticipaMovimentosSociais(boolean participaMovimentosSociais) {
        this.participaMovimentosSociais = participaMovimentosSociais;
    }

    public boolean isAcessoLazer() {
        return acessoLazer;
    }

    public void setAcessoLazer(boolean acessoLazer) {
        this.acessoLazer = acessoLazer;
    }

    public boolean isCompanhiaAdulto() {
        return companhiaAdulto;
    }

    public void setCompanhiaAdulto(boolean companhiaAdulto) {
        this.companhiaAdulto = companhiaAdulto;
    }

    public boolean isViolenciaFisica() {
        return violenciaFisica;
    }

    public void setViolenciaFisica(boolean violenciaFisica) {
        this.violenciaFisica = violenciaFisica;
    }

    public boolean isViolenciaPsicologica() {
        return violenciaPsicologica;
    }

    public void setViolenciaPsicologica(boolean violenciaPsicologica) {
        this.violenciaPsicologica = violenciaPsicologica;
    }

    public boolean isExploracaoSexual() {
        return exploracaoSexual;
    }

    public void setExploracaoSexual(boolean exploracaoSexual) {
        this.exploracaoSexual = exploracaoSexual;
    }

    public boolean isAbusoViolenciaSexual() {
        return abusoViolenciaSexual;
    }

    public void setAbusoViolenciaSexual(boolean abusoViolenciaSexual) {
        this.abusoViolenciaSexual = abusoViolenciaSexual;
    }

    public boolean isNegligenciaAbandono() {
        return negligenciaAbandono;
    }

    public void setNegligenciaAbandono(boolean negligenciaAbandono) {
        this.negligenciaAbandono = negligenciaAbandono;
    }

    public boolean isTrabalhoInfantil() {
        return trabalhoInfantil;
    }

    public void setTrabalhoInfantil(boolean trabalhoInfantil) {
        this.trabalhoInfantil = trabalhoInfantil;
    }

    public boolean isTrajetoriaRua() {
        return trajetoriaRua;
    }

    public void setTrajetoriaRua(boolean trajetoriaRua) {
        this.trajetoriaRua = trajetoriaRua;
    }

    public boolean isTraficoPessoas() {
        return traficoPessoas;
    }

    public void setTraficoPessoas(boolean traficoPessoas) {
        this.traficoPessoas = traficoPessoas;
    }

    public boolean isDiscriminacaoOrientacaoSexual() {
        return discriminacaoOrientacaoSexual;
    }

    public void setDiscriminacaoOrientacaoSexual(boolean discriminacaoOrientacaoSexual) {
        this.discriminacaoOrientacaoSexual = discriminacaoOrientacaoSexual;
    }

    public boolean isViolenciaIdosoPCD() {
        return violenciaIdosoPCD;
    }

    public void setViolenciaIdosoPCD(boolean violenciaIdosoPCD) {
        this.violenciaIdosoPCD = violenciaIdosoPCD;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public List<FamiliaMembroContato> getFamiliaMembroContatoList() {
        return familiaMembroContatoList;
    }

    public void setFamiliaMembroContatoList(List<FamiliaMembroContato> familiaMembroContatoList) {
        this.familiaMembroContatoList = familiaMembroContatoList;
    }

}
