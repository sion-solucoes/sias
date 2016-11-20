/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcf;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcf.FamiliaMembroDocumentoProvidenciavelConstants;
import com.sias.model.entity.mcb.DocumentoProvidenciavel;
import com.sias.model.entity.mcf.FamiliaMembro;
import com.sias.model.entity.mcf.FamiliaMembroDocumentoProvidenciavel;
import com.sias.model.rowmapper.mcb.DocumentoProvidenciavelRowMapper;

/**
 *
 * @author Fernando Laranjo
 */
public class FamiliaMembroDocumentoProvidenciavelRowMapper implements RowMapper<FamiliaMembroDocumentoProvidenciavel> {

    @Override
    public FamiliaMembroDocumentoProvidenciavel mapRow(ResultSet rs, int i) throws SQLException {

        FamiliaMembroDocumentoProvidenciavel familiaMembroDocumentoProvidenciavel = new FamiliaMembroDocumentoProvidenciavel();

        try {
            familiaMembroDocumentoProvidenciavel.setFamiliaMembro(new FamiliaMembroRowMapper().mapRow(rs, i));
        } catch (Exception e) {
            FamiliaMembro familiaMembro = new FamiliaMembro();
            familiaMembro.setId(rs.getLong(FamiliaMembroDocumentoProvidenciavelConstants.FAMILIA_MEMBRO_ID));
            familiaMembroDocumentoProvidenciavel.setFamiliaMembro(familiaMembro);
        }

        try {
            familiaMembroDocumentoProvidenciavel.setDocumentoProvidenciavel(new DocumentoProvidenciavelRowMapper().mapRow(rs, i));
        } catch (Exception e) {
            DocumentoProvidenciavel documentoProvidenciavel = new DocumentoProvidenciavel();
            documentoProvidenciavel.setId(rs.getLong(FamiliaMembroDocumentoProvidenciavelConstants.DOCUMENTO_PROVIDENCIAVEL_ID));
            familiaMembroDocumentoProvidenciavel.setDocumentoProvidenciavel(documentoProvidenciavel);
        }

        return familiaMembroDocumentoProvidenciavel;
    }
}
