/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcb;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcb.CEPConstants;
import com.sias.model.entity.mcb.CEP;
import com.sias.model.entity.mcb.Municipio;

/**
 *
 * @author Fernando Laranjo
 */
public class CEPRowMapper implements RowMapper<CEP> {

    @Override
    public CEP mapRow(ResultSet rs, int i) throws SQLException {

        CEP cep = new CEP();

        cep.setId(rs.getLong(CEPConstants.ID));
        cep.setCodigo(rs.getString(CEPConstants.CODIGO));
        cep.setLogradouro(rs.getString(CEPConstants.LOGRADOURO));
        cep.setBairro(rs.getString(CEPConstants.BAIRRO));

        if (rs.getObject(CEPConstants.MUNICIPIO_ID) != null) {
            Municipio municipio = new Municipio();
            municipio.setId(rs.getLong(CEPConstants.MUNICIPIO_ID));
            try {
                municipio = new MunicipioRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            cep.setMunicipio(municipio);
        }

        return cep;
    }

}
