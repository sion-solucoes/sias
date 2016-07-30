/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mca;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mca.UsuarioConstants;
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
        usuario.setTipo(rs.getShort(UsuarioConstants.TIPO));
        usuario.setFoto(rs.getString(UsuarioConstants.FOTO));

        return usuario;
    }

}
