/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcb;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcb.PaisConstants;
import com.sias.model.entity.mcb.Pais;

/**
 *
 * @author Fernando Laranjo
 */
public class PaisRowMapper implements RowMapper<Pais>{

    @Override
    public Pais mapRow(ResultSet rs, int i) throws SQLException {
      
        Pais pais = new Pais();
        
        pais.setId(rs.getLong(PaisConstants.ID));
        pais.setSigla(rs.getString(PaisConstants.SIGLA));
        pais.setDescricao(rs.getString(PaisConstants.DESCRICAO));
        pais.setCodigoBACEN(rs.getShort(PaisConstants.CODIGO_BACEN));
        
        return pais;
    }
    
    
}
