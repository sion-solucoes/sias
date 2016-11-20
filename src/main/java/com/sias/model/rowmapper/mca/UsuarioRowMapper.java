/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mca;

import com.sias.model.constants.mca.UnidadeAtendimentoConstants;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mca.UsuarioConstants;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.mca.Usuario;

/**
 *
 * @author Fernando Laranjo
 */
public class UsuarioRowMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet rs, int i) throws SQLException {

        Usuario usuario = new Usuario();

        usuario.setId(rs.getLong(UsuarioConstants.ID));
        usuario.setEmail(rs.getString(UsuarioConstants.EMAIL));
        usuario.setNome(rs.getString(UsuarioConstants.NOME));
        usuario.setSobrenome(rs.getString(UsuarioConstants.SOBRENOME));
        usuario.setTipo(rs.getShort(UsuarioConstants.TIPO));
        usuario.setFoto(rs.getString(UsuarioConstants.FOTO));

        if (rs.getObject(UsuarioConstants.UNIDADE_ATENDIMENTO_ID) != null) {
            UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();
            unidadeAtendimento.setId(rs.getLong(UsuarioConstants.UNIDADE_ATENDIMENTO_ID));
            try {
                unidadeAtendimento = new UnidadeAtendimentoRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            usuario.setUnidadeAtendimento(unidadeAtendimento);
        }

        return usuario;
    }

}
