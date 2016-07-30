/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcb;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcb.UnidadeFederacaoConstants;
import com.sias.model.entity.mcb.Pais;
import com.sias.model.entity.mcb.UnidadeFederacao;

/**
 *
 * @author Fernando Laranjo
 */
public class UnidadeFederacaoRowMapper implements RowMapper<UnidadeFederacao> {

    @Override
    public UnidadeFederacao mapRow(ResultSet rs, int i) throws SQLException {

        UnidadeFederacao unidadeFederacao = new UnidadeFederacao();

        unidadeFederacao.setId(rs.getLong(UnidadeFederacaoConstants.ID));
        unidadeFederacao.setSigla(rs.getString(UnidadeFederacaoConstants.SIGLA));
        unidadeFederacao.setDescricao(rs.getString(UnidadeFederacaoConstants.DESCRICAO));
        unidadeFederacao.setCodigoIBGE(rs.getShort(UnidadeFederacaoConstants.CODIGO_IBGE));

        if (rs.getObject(UnidadeFederacaoConstants.PAIS_ID) != null) {
            Pais pais = new Pais();
            pais.setId(rs.getLong(UnidadeFederacaoConstants.PAIS_ID));
            try {
                pais = new PaisRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            unidadeFederacao.setPais(pais);
        }

        return unidadeFederacao;
    }

}
