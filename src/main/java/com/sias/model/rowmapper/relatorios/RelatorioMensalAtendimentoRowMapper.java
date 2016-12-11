/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.relatorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.entity.relatorios.RelatorioMensalAtendimento;
import com.sias.util.StringUtils;

/**
 *
 * @author Fernando Laranjo
 */
public class RelatorioMensalAtendimentoRowMapper implements RowMapper<RelatorioMensalAtendimento> {

    @Override
    public RelatorioMensalAtendimento mapRow(ResultSet rs, int i) throws SQLException {

        RelatorioMensalAtendimento relatorioMensalAtendimento = new RelatorioMensalAtendimento();

        relatorioMensalAtendimento.setQuantidadeTotalFamilias(rs.getInt(StringUtils.substringToQuery("total_familias")));
        relatorioMensalAtendimento.setQuantidadeTotalIndividuos(rs.getInt(StringUtils.substringToQuery("total_individuos")));

        relatorioMensalAtendimento.setQuantidadeNovasFamilias(rs.getInt(StringUtils.substringToQuery("novas_familias")));
        relatorioMensalAtendimento.setQuantidadeNovosIndividuos(rs.getInt(StringUtils.substringToQuery("novos_individuos")));

        relatorioMensalAtendimento.setQuantidadeFamiliasTrabalhoInfantil(rs.getInt(StringUtils.substringToQuery("familia_trabalho_infantil")));

        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimadas(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimadas")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimadasMasculino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimadas_masculino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimadasMasculino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimadas_masculino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimadasMasculino18A59Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimadas_masculino_18_a_59_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimadasMasculino60AnosOuMais(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimadas_masculino_60_anos_ou_mais")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimadasFeminino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimadas_feminino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimadasFeminino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimadas_feminino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimadasFeminino18A59Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimadas_feminino_18_a_59_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimadasFeminino60AnosOuMais(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimadas_masculino_60_anos_ou_mais")));

        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasViolenciaIntrafamiliar(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_violencia_intrafamiliar")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasViolenciaIntrafamiliarMasculino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_violencia_intrafamiliar_masculino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasViolenciaIntrafamiliarMasculino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_violencia_intrafamiliar_masculino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasViolenciaIntrafamiliarFeminino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_violencia_intrafamiliar_feminino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasViolenciaIntrafamiliarFeminino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_violencia_intrafamiliar_feminino_13_a_17_anos")));

        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasExploracaoSexual(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_exploracao_sexual")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasExploracaoSexualMasculino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_exploracao_sexual_masculino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasExploracaoSexualMasculino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_exploracao_sexual_masculino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasExploracaoSexualFeminino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_exploracao_sexual_feminino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasExploracaoSexualFeminino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_exploracao_sexual_feminino_13_a_17_anos")));

        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasAbusoSexual(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_abuso_sexual")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasAbusoSexualMasculino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_abuso_sexual_masculino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasAbusoSexualMasculino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_abuso_sexual_masculino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasAbusoSexualFeminino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_abuso_sexual_feminino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasAbusoSexualFeminino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_abuso_sexual_feminino_13_a_17_anos")));

        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasNegligenciaAbandono(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_negligencia_abandono")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasNegligenciaAbandonoMasculino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_negligencia_abandono_masculino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasNegligenciaAbandonoMasculino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_negligencia_abandono_masculino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasNegligenciaAbandonoFeminino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_negligencia_abandono_feminino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasNegligenciaAbandonoFeminino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_negligencia_abandono_feminino_13_a_17_anos")));

        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasTrabalhoInfantil(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_trabalho_infantil")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasTrabalhoInfantilMasculino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_trabalho_infantil_masculino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasTrabalhoInfantilMasculino13A15Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_trabalho_infantil_masculino_13_a_15_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasTrabalhoInfantilFeminino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_trabalho_infantil_feminino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasCriancasVitimasTrabalhoInfantilFeminino13A15Anos(rs.getInt(StringUtils.substringToQuery("novas_criancas_vitimas_trabalho_infantil_feminino_13_a_15_anos")));

        relatorioMensalAtendimento.setQuantidadeNovosIdososVitimasViolenciaIntrafamiliar(rs.getInt(StringUtils.substringToQuery("novos_idosos_vitimas_violencia_intrafamiliar")));
        relatorioMensalAtendimento.setQuantidadeNovosIdososVitimasViolenciaIntraFamiliarMasculino(rs.getInt(StringUtils.substringToQuery("novos_idosos_vitimas_violencia_intrafamiliar_masculino")));
        relatorioMensalAtendimento.setQuantidadeNovosIdososVitimasViolenciaIntraFamiliarFeminino(rs.getInt(StringUtils.substringToQuery("novos_idosos_vitimas_violencia_intrafamiliar_feminino")));

        relatorioMensalAtendimento.setQuantidadeNovosIdososVitimasNegligenciaAbandono(rs.getInt(StringUtils.substringToQuery("novos_idosos_vitimas_negligencia_abandono")));
        relatorioMensalAtendimento.setQuantidadeNovosIdososVitimasNegligenciaAbandonoMasculino(rs.getInt(StringUtils.substringToQuery("novos_idosos_vitimas_negligencia_abandono_masculino")));
        relatorioMensalAtendimento.setQuantidadeNovosIdososVitimasNegligenciaAbandonoFeminino(rs.getInt(StringUtils.substringToQuery("novos_idosos_vitimas_negligencia_abandono_feminino")));

        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasViolenciaIntrafamiliar(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_violencia_intrafamiliar")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasViolenciaIntrafamiliarMasculino0A12Anos(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_violencia_intrafamiliar_masculino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasViolenciaIntrafamiliarMasculino13A17Anos(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_violencia_intrafamiliar_masculino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasViolenciaIntrafamiliarMasculino18A59Anos(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_violencia_intrafamiliar_masculino_18_a_59_anos")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasViolenciaIntrafamiliarMasculino60AnosOuMais(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_violencia_intrafamiliar_masculino_60_anos_ou_mais")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasViolenciaIntrafamiliarFeminino0A12Anos(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_violencia_intrafamiliar_feminino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasViolenciaIntrafamiliarFeminino13A17Anos(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_violencia_intrafamiliar_feminino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasViolenciaIntrafamiliarFeminino18A59Anos(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_violencia_intrafamiliar_feminino_18_a_59_anos")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasViolenciaIntrafamiliarFeminino60AnosOuMais(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_violencia_intrafamiliar_feminino_60_anos_ou_mais")));

        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasNegligenciaAbandono(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_negligencia_abandono")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasNegligenciaAbandonoMasculino0A12Anos(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_negligencia_abandono_masculino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasNegligenciaAbandonoMasculino13A17Anos(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_negligencia_abandono_masculino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasNegligenciaAbandonoMasculino18A59Anos(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_negligencia_abandono_masculino_18_a_59_anos")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasNegligenciaAbandonoMasculino60AnosOuMais(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_negligencia_abandono_masculino_60_anos_ou_mais")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasNegligenciaAbandonoFeminino0A12Anos(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_negligencia_abandono_feminino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasNegligenciaAbandonoFeminino13A17Anos(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_negligencia_abandono_feminino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasNegligenciaAbandonoFeminino18A59Anos(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_negligencia_abandono_feminino_18_a_59_anos")));
        relatorioMensalAtendimento.setQuantidadeNovosDeficientesVitimasNegligenciaAbandonoFeminino60AnosOuMais(rs.getInt(StringUtils.substringToQuery("novos_deficientes_vitimas_negligencia_abandono_feminino_60_anos_ou_mais")));

        relatorioMensalAtendimento.setQuantidadeNovosAdultosVitimasViolenciaIntrafamiliar(rs.getInt(StringUtils.substringToQuery("novos_adultos_vitimas_violencia_intrafamiliar")));
        relatorioMensalAtendimento.setQuantidadeNovosAdultosVitimasViolenciaIntrafamiliarMasculino(rs.getInt(StringUtils.substringToQuery("novos_adultos_vitimas_violencia_intrafamiliar_masculino")));
        relatorioMensalAtendimento.setQuantidadeNovosAdultosVitimasViolenciaIntrafamiliarFeminino(rs.getInt(StringUtils.substringToQuery("novos_adultos_vitimas_violencia_intrafamiliar_feminino")));

        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasSituacaoRua(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trajetoria_rua")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasSituacaoRuaMasculino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trajetoria_rua_masculino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasSituacaoRuaMasculino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trajetoria_rua_masculino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasSituacaoRuaMasculino18A59Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trajetoria_rua_masculino_18_a_59_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasSituacaoRuaMasculino60AnosOuMais(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trajetoria_rua_masculino_60_anos_ou_mais")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasSituacaoRuaFeminino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trajetoria_rua_feminino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasSituacaoRuaFeminino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trajetoria_rua_feminino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasSituacaoRuaFeminino18A59Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trajetoria_rua_feminino_18_a_59_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasSituacaoRuaFeminino60AnosOuMais(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trajetoria_rua_feminino_60_anos_ou_mais")));

        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasTrafico(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trafico")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasTraficoMasculino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trafico_masculino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasTraficoMasculino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trafico_masculino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasTraficoMasculino18A59Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trafico_masculino_18_a_59_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasTraficoMasculino60AnosOuMais(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trafico_masculino_60_anos_ou_mais")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasTraficoFeminino0A12Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trafico_feminino_0_a_12_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasTraficoFeminino13A17Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trafico_feminino_13_a_17_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasTraficoFeminino18A59Anos(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trafico_feminino_18_a_59_anos")));
        relatorioMensalAtendimento.setQuantidadeNovasPessoasVitimasTraficoFeminino60AnosOuMais(rs.getInt(StringUtils.substringToQuery("novas_pessoas_vitimas_trafico_feminino_60_anos_ou_mais")));

        return relatorioMensalAtendimento;
    }
}
