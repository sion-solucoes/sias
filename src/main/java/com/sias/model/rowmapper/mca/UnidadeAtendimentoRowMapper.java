/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mca;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mca.UnidadeAtendimentoConstants;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.mcb.CEP;
import com.sias.model.rowmapper.mcb.CEPRowMapper;

/**
 *
 * @author Fernando Laranjo
 */
public class UnidadeAtendimentoRowMapper implements RowMapper<UnidadeAtendimento> {

    @Override
    public UnidadeAtendimento mapRow(ResultSet rs, int i) throws SQLException {

        UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();

        unidadeAtendimento.setId(rs.getLong(UnidadeAtendimentoConstants.ID));
        unidadeAtendimento.setCodigo(rs.getString(UnidadeAtendimentoConstants.CODIGO));
        unidadeAtendimento.setDescricao(rs.getString(UnidadeAtendimentoConstants.DESCRICAO));
        unidadeAtendimento.setTipo(rs.getShort(UnidadeAtendimentoConstants.TIPO));
        if ( rs.getObject(UnidadeAtendimentoConstants.CEP_ENDERECO_ID) != null ){
            CEP cep = new CEP();
            cep.setId(rs.getLong(UnidadeAtendimentoConstants.CEP_ENDERECO_ID));
            try{
                cep = new CEPRowMapper().mapRow(rs, i);
            } catch(Exception e){
            }
            unidadeAtendimento.setCepEndereco(cep);
        }
        unidadeAtendimento.setLogradouroEndereco(rs.getString(UnidadeAtendimentoConstants.LOGRADOURO_ENDERECO));
        unidadeAtendimento.setNumeroEndereco(rs.getString(UnidadeAtendimentoConstants.NUMERO_ENDERECO));
        unidadeAtendimento.setBairroEndereco(rs.getString(UnidadeAtendimentoConstants.BAIRRO_ENDERECO));
        
        return unidadeAtendimento;
    }
}
