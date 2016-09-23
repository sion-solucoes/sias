/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcb;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcb.GrauParentescoConstants;
import com.sias.model.entity.mcb.GrauParentesco;

/**
 *
 * @author Fernando Laranjo
 */
public class GrauParentescoRowMapper implements RowMapper<GrauParentesco> {

    @Override
    public GrauParentesco mapRow(ResultSet rs, int i) throws SQLException {

        GrauParentesco grauParentesco = new GrauParentesco();

        grauParentesco.setId(rs.getLong(GrauParentescoConstants.ID));
        grauParentesco.setCodigo(rs.getShort(GrauParentescoConstants.CODIGO));
        grauParentesco.setDescricao(rs.getString(GrauParentescoConstants.DESCRICAO));

        return grauParentesco;
    }

}
