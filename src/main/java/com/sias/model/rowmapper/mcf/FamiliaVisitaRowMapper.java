/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcf;

import com.sias.model.constants.mcf.FamiliaVisitaConstants;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.mca.Usuario;
import com.sias.model.entity.mcf.Familia;
import com.sias.model.entity.mcf.FamiliaVisita;
import com.sias.model.rowmapper.mca.UnidadeAtendimentoRowMapper;
import com.sias.model.rowmapper.mca.UsuarioRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Fernando
 */
public class FamiliaVisitaRowMapper implements RowMapper<FamiliaVisita> {

    @Override
    public FamiliaVisita mapRow(ResultSet rs, int i) throws SQLException {

        FamiliaVisita familiaVisita = new FamiliaVisita();

        familiaVisita.setId(rs.getLong(FamiliaVisitaConstants.ID));

        if (rs.getObject(FamiliaVisitaConstants.UNIDADE_ATENDIMENTO_ID) == null) {
            UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();
            unidadeAtendimento.setId(rs.getLong(FamiliaVisitaConstants.UNIDADE_ATENDIMENTO_ID));
            try {
                unidadeAtendimento = new UnidadeAtendimentoRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            familiaVisita.setUnidadeAtendimento(unidadeAtendimento);
        }

        if (rs.getObject(FamiliaVisitaConstants.FAMILIA_ID) != null) {
            Familia familia = new Familia();
            familia.setId(rs.getLong(FamiliaVisitaConstants.FAMILIA_ID));
            try {
                familia = new FamiliaRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            familiaVisita.setFamilia(familia);
        }

        if (rs.getObject(FamiliaVisitaConstants.USUARIO_ID) != null) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong(FamiliaVisitaConstants.USUARIO_ID));
            try {
                usuario = new UsuarioRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            familiaVisita.setUsuario(usuario);
        }

        familiaVisita.setInicio(rs.getTimestamp(FamiliaVisitaConstants.INICIO));
        familiaVisita.setFim(rs.getTimestamp(FamiliaVisitaConstants.FIM));
        familiaVisita.setCor(rs.getString(FamiliaVisitaConstants.COR));
        familiaVisita.setConfirmada(rs.getBoolean(FamiliaVisitaConstants.CONFIRMADA));

        return familiaVisita;
    }
}
