/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcb;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcb.EscolaridadeConstants;
import com.sias.model.entity.mcb.Escolaridade;

/**
 *
 * @author Fernando Laranjo
 */
public class EscolaridadeRowMapper implements RowMapper<Escolaridade> {

    @Override
    public Escolaridade mapRow(ResultSet rs, int i) throws SQLException {

        Escolaridade escolaridade = new Escolaridade();

        escolaridade.setId(rs.getLong(EscolaridadeConstants.ID));
        escolaridade.setCodigo(rs.getString(EscolaridadeConstants.CODIGO));
        escolaridade.setDescricao(rs.getString(EscolaridadeConstants.DESCRICAO));

        return escolaridade;
    }

}
