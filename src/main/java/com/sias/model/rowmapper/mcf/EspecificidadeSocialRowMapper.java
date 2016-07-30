/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcf;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcf.EspecificidadeSocialConstants;
import com.sias.model.entity.mcf.EspecificidadeSocial;

/**
 *
 * @author Fernando Laranjo
 */
public class EspecificidadeSocialRowMapper implements RowMapper<EspecificidadeSocial> {
    
    @Override
    public EspecificidadeSocial mapRow(ResultSet rs, int i) throws SQLException {
        
        EspecificidadeSocial especificidadeSocial = new EspecificidadeSocial();
        
        especificidadeSocial.setId(rs.getLong(EspecificidadeSocialConstants.ID));
        especificidadeSocial.setDescricao(rs.getString(EspecificidadeSocialConstants.DESCRICAO));
        especificidadeSocial.setIndigena(rs.getBoolean(EspecificidadeSocialConstants.INDIGENA));
        especificidadeSocial.setPovoEtnia(rs.getString(EspecificidadeSocialConstants.POVO_ETNIA));
        
        return especificidadeSocial;
    }
    
}
