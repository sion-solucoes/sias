/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.rowmapper.mcf;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sias.model.constants.mcf.DocumentoProvidenciavelConstants;
import com.sias.model.entity.mcf.DocumentoProvidenciavel;

/**
 *
 * @author Fernando Laranjo
 */
public class DocumentoProvidenciavelRowMapper implements RowMapper<DocumentoProvidenciavel> {

    @Override
    public DocumentoProvidenciavel mapRow(ResultSet rs, int i) throws SQLException {

        DocumentoProvidenciavel documentoProvidenciavel = new DocumentoProvidenciavel();

        documentoProvidenciavel.setId(rs.getLong(DocumentoProvidenciavelConstants.ID));
        documentoProvidenciavel.setCodigo(rs.getString(DocumentoProvidenciavelConstants.CODIGO));
        documentoProvidenciavel.setDescricao(rs.getString(DocumentoProvidenciavelConstants.DESCRICAO));

        return documentoProvidenciavel;
    }

}
