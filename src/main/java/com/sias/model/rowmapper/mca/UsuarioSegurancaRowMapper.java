/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mca;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mca.UsuarioSegurancaConstants;
import com.sias.model.entity.mca.UsuarioSeguranca;

/**
 *
 * @author Fernando Laranjo
 */
public class UsuarioSegurancaRowMapper implements RowMapper<UsuarioSeguranca> {

    @Override
    public UsuarioSeguranca mapRow(ResultSet rs, int i) throws SQLException {

        UsuarioSeguranca usuarioSeguranca = new UsuarioSeguranca();

        usuarioSeguranca.setId(rs.getLong(UsuarioSegurancaConstants.ID));
        usuarioSeguranca.setCodigo(rs.getString(UsuarioSegurancaConstants.CODIGO));

        return usuarioSeguranca;
    }

}
