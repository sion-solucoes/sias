/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcf;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcf.FormaIngressoConstants;
import com.sias.model.entity.mcb.CEP;
import com.sias.model.entity.mcf.FormaIngresso;
import com.sias.model.rowmapper.mcb.CEPRowMapper;

/**
 *
 * @author Fernando Laranjo
 */
public class FormaIngressoRowMapper implements RowMapper<FormaIngresso> {

    @Override
    public FormaIngresso mapRow(ResultSet rs, int i) throws SQLException {
        
        FormaIngresso formaIngresso = new FormaIngresso();

        formaIngresso.setId(rs.getLong(FormaIngressoConstants.ID));
        formaIngresso.setDescricao(rs.getString(FormaIngressoConstants.DESCRICAO));
        
        return formaIngresso;
    }
}   
