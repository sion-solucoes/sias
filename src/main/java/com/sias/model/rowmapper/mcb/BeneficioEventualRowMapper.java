/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcb;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcb.BeneficioEventualConstants;
import com.sias.model.entity.mcb.BeneficioEventual;


/**
 *
 * @author jaderhenrique
 */
public class BeneficioEventualRowMapper implements RowMapper<BeneficioEventual>{

    @Override
    public BeneficioEventual mapRow(ResultSet rs, int i) throws SQLException {
        
        BeneficioEventual beneficioEventual = new BeneficioEventual();
        beneficioEventual.setId(rs.getLong(BeneficioEventualConstants.ID));
        beneficioEventual.setCodigo(rs.getString(BeneficioEventualConstants.CODIGO));
        beneficioEventual.setDescricao(rs.getString(BeneficioEventualConstants.DESCRICAO));
        
        return beneficioEventual;
    }
    
}
