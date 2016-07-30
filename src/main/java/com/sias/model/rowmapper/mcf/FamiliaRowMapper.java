/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcf;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcf.FamiliaConstants;
import com.sias.model.constants.mcf.FamiliaMembroConstants;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.mcb.CEP;
import com.sias.model.entity.mcf.Familia;
import com.sias.model.entity.mcf.FamiliaMembro;
import com.sias.model.entity.mcf.FormaIngresso;
import com.sias.model.rowmapper.mcb.CEPRowMapper;

/**
 *
 * @author Fernando Laranjo
 */
public class FamiliaRowMapper implements RowMapper<Familia> {

    @Override
    public Familia mapRow(ResultSet rs, int i) throws SQLException {

        Familia familia = new Familia();

        familia.setId(rs.getLong(FamiliaConstants.ID));

        if (rs.getObject(FamiliaConstants.UNIDADE_ATENDIMENTO_ID) != null) {
            UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();
            unidadeAtendimento.setId(rs.getLong(FamiliaConstants.UNIDADE_ATENDIMENTO_ID));
            familia.setUnidadeAtendimento(unidadeAtendimento);
        }

        if (rs.getObject(FamiliaConstants.FORMA_INGRESSO_ID) != null) {
            FormaIngresso formaIngresso = new FormaIngresso();
            formaIngresso.setId(rs.getLong(FamiliaConstants.FORMA_INGRESSO_ID));
            try {
                formaIngresso = new FormaIngressoRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            familia.setFormaIngresso(formaIngresso);
        }

        familia.setDetalheFormaIngressoEncaminhamento(rs.getString(FamiliaConstants.DETALHE_FORMA_INGRESSO_ENCAMINHAMENTO));
        familia.setObservacaoFormaIngresso(rs.getString(FamiliaConstants.OBSERVACAO_FORMA_INGRESSO));

        try {
            if (rs.getObject(FamiliaMembroConstants.FAMILIA_ID) != null) {
                List<FamiliaMembro> familiaMembroList = new ArrayList<FamiliaMembro>();
                try {
                    familiaMembroList.add(new FamiliaMembroRowMapper().mapRow(rs, i));
                } catch (Exception e) {
                }
                familia.setFamiliaMembroList(familiaMembroList);
            }
        } catch (Exception e) {
        }

        if (rs.getObject(FamiliaConstants.CEP_ENDERECO_ID) != null) {
            CEP cep = new CEP();
            cep.setId(rs.getLong(FamiliaConstants.CEP_ENDERECO_ID));
            try {
                cep = new CEPRowMapper().mapRow(rs, i);
            } catch (Exception e) {
            }
            familia.setCepEndereco(cep);
        }
        familia.setLogradouroEndereco(rs.getString(FamiliaConstants.LOGRADOURO_ENDERECO));
        familia.setNumeroEndereco(rs.getString(FamiliaConstants.NUMERO_ENDERECO));
        familia.setBairroEndereco(rs.getString(FamiliaConstants.BAIRRO_ENDERECO));
        familia.setPontoReferenciaEndereco(rs.getString(FamiliaConstants.PONTO_REFERENCIA_ENDERECO));

        return familia;
    }
}
