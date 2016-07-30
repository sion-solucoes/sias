/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcb;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcb.MunicipioConstants;
import com.sias.model.constants.mcb.UnidadeFederacaoConstants;
import com.sias.model.entity.mcb.Municipio;
import com.sias.model.entity.mcb.UnidadeFederacao;

/**
 *
 * @author Fernando Laranjo
 */
public class MunicipioRowMapper implements RowMapper<Municipio> {

    @Override
    public Municipio mapRow(ResultSet rs, int i) throws SQLException {

        Municipio municipio = new Municipio();

        municipio.setId(rs.getLong(MunicipioConstants.ID));
        municipio.setDescricao(rs.getString(MunicipioConstants.DESCRICAO));
        municipio.setCodigoIBGE(rs.getInt(MunicipioConstants.CODIGO_IBGE));

        if (rs.getObject(MunicipioConstants.UF_ID) != null) {
            UnidadeFederacao unidadeFederacao = new UnidadeFederacao();
            unidadeFederacao.setId(rs.getLong(MunicipioConstants.UF_ID));
            try {
                unidadeFederacao = new UnidadeFederacaoRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            municipio.setUnidadeFederacao(unidadeFederacao);
        }

        return municipio;
    }

}
