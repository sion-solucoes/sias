/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcf;

import com.sias.model.rowmapper.mcb.CondicaoOcupacaoRowMapper;
import com.sias.model.rowmapper.mcb.DeficienciaRowMapper;
import com.sias.model.rowmapper.mcb.GrauParentescoRowMapper;
import com.sias.model.rowmapper.mcb.EscolaridadeRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcf.FamiliaMembroConstants;
import com.sias.model.entity.mcb.CondicaoOcupacao;
import com.sias.model.entity.mcb.Deficiencia;
import com.sias.model.entity.mcb.Escolaridade;
import com.sias.model.entity.mcf.Familia;
import com.sias.model.entity.mcf.FamiliaMembro;
import com.sias.model.entity.mcb.GrauParentesco;

/**
 *
 * @author Fernando Laranjo
 */
public class FamiliaMembroRowMapper implements RowMapper<FamiliaMembro> {

    @Override
    public FamiliaMembro mapRow(ResultSet rs, int i) throws SQLException {

        FamiliaMembro familiaMembro = new FamiliaMembro();

        familiaMembro.setId(rs.getLong(FamiliaMembroConstants.ID));
        if (rs.getObject(FamiliaMembroConstants.FAMILIA_ID) != null) {
            Familia familia = new Familia();
            familia.setId(rs.getLong(FamiliaMembroConstants.FAMILIA_ID));
            familiaMembro.setFamilia(familia);
        }
        if (rs.getObject(FamiliaMembroConstants.GRAU_PARENTESCO_ID) != null) {
            GrauParentesco grauParentesco = new GrauParentesco();
            grauParentesco.setId(rs.getLong(FamiliaMembroConstants.GRAU_PARENTESCO_ID));
            try {
                grauParentesco = new GrauParentescoRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            familiaMembro.setGrauParentesco(grauParentesco);
        }
        familiaMembro.setNome(rs.getString(FamiliaMembroConstants.NOME));
        familiaMembro.setSexo(rs.getShort(FamiliaMembroConstants.SEXO));
        familiaMembro.setDataNascimento(rs.getDate(FamiliaMembroConstants.DATA_NASCIMENTO));
        familiaMembro.setNomeMae(rs.getString(FamiliaMembroConstants.NOME_MAE));
        familiaMembro.setApelido(rs.getString(FamiliaMembroConstants.APELIDO));
        familiaMembro.setNis(rs.getString(FamiliaMembroConstants.NIS));
        familiaMembro.setCpf(rs.getString(FamiliaMembroConstants.CPF));
        familiaMembro.setRg(rs.getString(FamiliaMembroConstants.RG));
        familiaMembro.setRgOrgaoExpedidor(rs.getString(FamiliaMembroConstants.RG_ORGAO_EXPEDIDOR));
        familiaMembro.setRgUFEmissao(rs.getString(FamiliaMembroConstants.RG_UF_EMISSAO));
        familiaMembro.setRgDataEmissao(rs.getDate(FamiliaMembroConstants.RG_DATA_EMISSAO));

        if (rs.getObject(FamiliaMembroConstants.ESCOLARIDADE_ID) != null) {
            Escolaridade escolaridade = new Escolaridade();
            escolaridade.setId(rs.getLong(FamiliaMembroConstants.ESCOLARIDADE_ID));
            try {
                escolaridade = new EscolaridadeRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            familiaMembro.setEscolaridade(escolaridade);
        }
        familiaMembro.setSabeLerEscrever(rs.getBoolean(FamiliaMembroConstants.SABE_LER_ESCREVER));
        familiaMembro.setFrequentaEscolaAtualmente(rs.getBoolean(FamiliaMembroConstants.FREQUENTA_ESCOLA_ATUALMENTE));

        familiaMembro.setPossuiCarteiraTrabalho(rs.getBoolean(FamiliaMembroConstants.POSSUI_CARTEIRA_TRABALHO));
        if (rs.getObject(FamiliaMembroConstants.CONDICAO_OCUPACAO_ID) != null) {
            CondicaoOcupacao condicaoOcupacao = new CondicaoOcupacao();
            condicaoOcupacao.setId(rs.getLong(FamiliaMembroConstants.CONDICAO_OCUPACAO_ID));
            try {
                condicaoOcupacao = new CondicaoOcupacaoRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            familiaMembro.setCondicaoOcupacao(condicaoOcupacao);
        }
        familiaMembro.setPossuiQualificacaoProfissional(rs.getBoolean(FamiliaMembroConstants.POSSUI_QUALIFICACAO_PROFISSIONAL));
        familiaMembro.setDescricaoQualificacaoProfissional(rs.getString(FamiliaMembroConstants.DESCRICAO_QUALIFICACAO_PROFISSIONAL));
        familiaMembro.setRendaMensal(rs.getDouble(FamiliaMembroConstants.RENDA_MENSAL));

        if (rs.getObject(FamiliaMembroConstants.DEFICIENCIA_ID) != null) {
            Deficiencia deficiencia = new Deficiencia();
            deficiencia.setId(rs.getLong(FamiliaMembroConstants.DEFICIENCIA_ID));
            try {
                deficiencia = new DeficienciaRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            familiaMembro.setDeficiencia(deficiencia);
        }
        familiaMembro.setNecessitaCuidadosConstantes(rs.getBoolean(FamiliaMembroConstants.NECESSITA_CUIDADOS_ESPECIAIS));
        familiaMembro.setDescricaoNecessidadeCuidadosConstantes(rs.getString(FamiliaMembroConstants.DESCRICAO_NECESSIDADE_CUIDADOS_ESPECIAIS));
        familiaMembro.setUsuarioRemediosControlados(rs.getBoolean(FamiliaMembroConstants.USUARIO_REMEDIOS_CONTROLADOS));
        familiaMembro.setUsuarioBebidasAlcoolicas(rs.getBoolean(FamiliaMembroConstants.USUARIO_BEDIDAS_ALCOOLICAS));
        familiaMembro.setUsuarioEntorpecentes(rs.getBoolean(FamiliaMembroConstants.USUARIO_ENTORPECENTES));
        familiaMembro.setGestante(rs.getBoolean(FamiliaMembroConstants.GESTANTE));
        familiaMembro.setMesesGestacao(rs.getShort(FamiliaMembroConstants.MESES_GESTACAO));
        familiaMembro.setIniciouPreNatal(rs.getBoolean(FamiliaMembroConstants.INICIOU_PRE_NATAL));

        familiaMembro.setVitimaAmeacasDiscriminacao(rs.getBoolean(FamiliaMembroConstants.VITIMA_AMEACAS_DISCRIMINACAO));
        familiaMembro.setParticipaGruposReligiosos(rs.getBoolean(FamiliaMembroConstants.PARTICIPA_GRUPOS_RELIOSOS));
        familiaMembro.setParticipaMovimentosSociais(rs.getBoolean(FamiliaMembroConstants.PARTICIPA_MOVIMENTOS_SOCIAIS));
        familiaMembro.setAcessoLazer(rs.getBoolean(FamiliaMembroConstants.ACESSO_LAZER));
        familiaMembro.setCompanhiaAdulto(rs.getBoolean(FamiliaMembroConstants.COMPANHIA_ADULTO));

        familiaMembro.setViolenciaFisica(rs.getBoolean(FamiliaMembroConstants.VIOLENCIA_FISICA));
        familiaMembro.setViolenciaPsicologica(rs.getBoolean(FamiliaMembroConstants.VIOLENCIA_PSICOLOGICA));
        familiaMembro.setExploracaoSexual(rs.getBoolean(FamiliaMembroConstants.EXPLORACAO_SEXUAL));
        familiaMembro.setAbusoViolenciaSexual(rs.getBoolean(FamiliaMembroConstants.ABUSO_VIOLENCIA_SEXUAL));
        familiaMembro.setNegligenciaAbandono(rs.getBoolean(FamiliaMembroConstants.NEGLIGENCIA_ABANDONO));
        familiaMembro.setTrabalhoInfantil(rs.getBoolean(FamiliaMembroConstants.TRABALHO_INFANTIL));
        familiaMembro.setTrajetoriaRua(rs.getBoolean(FamiliaMembroConstants.TRAJETORIA_RUA));
        familiaMembro.setTraficoPessoas(rs.getBoolean(FamiliaMembroConstants.TRAFICO_PESSOAS));
        familiaMembro.setDiscriminacaoOrientacaoSexual(rs.getBoolean(FamiliaMembroConstants.DISCRIMINACAO_ORIENTACAO_SEXUAL));
        familiaMembro.setViolenciaIdosoPCD(rs.getBoolean(FamiliaMembroConstants.VIOLENCIA_IDOSO_PCD));

        familiaMembro.setAcompanhamento(rs.getString(FamiliaMembroConstants.ACOMPANHAMENTO));

        return familiaMembro;
    }
}
