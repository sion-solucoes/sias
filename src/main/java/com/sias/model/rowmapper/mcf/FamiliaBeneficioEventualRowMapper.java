/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcf;

import com.sias.model.constants.mcf.FamiliaBeneficioEventualConstants;
import com.sias.model.entity.mcb.BeneficioEventual;
import com.sias.model.entity.mcf.Familia;
import com.sias.model.entity.mcf.FamiliaBeneficioEventual;
import com.sias.model.rowmapper.mcb.BeneficioEventualRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jaderhenrique
 */
public class FamiliaBeneficioEventualRowMapper implements RowMapper<FamiliaBeneficioEventual>{

    @Override
    public FamiliaBeneficioEventual mapRow(ResultSet rs, int i) throws SQLException {
        
        FamiliaBeneficioEventual familiaBeneficioEventual = new FamiliaBeneficioEventual();
        
        familiaBeneficioEventual.setId(rs.getLong(FamiliaBeneficioEventualConstants.ID));
        
        if(rs.getObject(FamiliaBeneficioEventualConstants.BENEFICIO_EVENTUAL_ID) != null){
            BeneficioEventual beneficioEventual = new BeneficioEventual();
            beneficioEventual.setId(rs.getLong(FamiliaBeneficioEventualConstants.BENEFICIO_EVENTUAL_ID));
            try {
                beneficioEventual = new BeneficioEventualRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            familiaBeneficioEventual.setBeneficioEventual(beneficioEventual);
        }
        
        if (rs.getObject(FamiliaBeneficioEventualConstants.FAMILIA_ID) != null) {
            Familia familia = new Familia();
            familia.setId(rs.getLong(FamiliaBeneficioEventualConstants.FAMILIA_ID));
            try {
                familia = new FamiliaRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            familiaBeneficioEventual.setFamilia(familia);
        }
        
        familiaBeneficioEventual.setDataSolicitacao(rs.getTimestamp(FamiliaBeneficioEventualConstants.DATA_SOLICITACAO));
        familiaBeneficioEventual.setDataConcessao(rs.getTimestamp(FamiliaBeneficioEventualConstants.DATA_CONCESSAO));
        
        return familiaBeneficioEventual;
    }
    
}
