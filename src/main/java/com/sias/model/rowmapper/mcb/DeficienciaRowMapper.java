/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcb;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcb.DeficienciaConstants;
import com.sias.model.entity.mcb.Deficiencia;

/**
 *
 * @author Fernando Laranjo
 */
public class DeficienciaRowMapper implements RowMapper<Deficiencia> {

    @Override
    public Deficiencia mapRow(ResultSet rs, int i) throws SQLException {

        Deficiencia deficiencia = new Deficiencia();

        deficiencia.setId(rs.getLong(DeficienciaConstants.ID));
        deficiencia.setCodigo(rs.getShort(DeficienciaConstants.CODIGO));
        deficiencia.setDescricao(rs.getString(DeficienciaConstants.DESCRICAO));

        return deficiencia;
    }

}
