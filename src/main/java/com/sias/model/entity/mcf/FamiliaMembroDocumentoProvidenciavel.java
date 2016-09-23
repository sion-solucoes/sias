/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.entity.mcf;

import com.sias.model.entity.mcb.DocumentoProvidenciavel;
import com.sias.model.base.entity.BaseEntity;

/**
 *
 * @author Fernando Laranjo
 */
public class FamiliaMembroDocumentoProvidenciavel extends BaseEntity {

    private FamiliaMembro familiaMembro;

    private DocumentoProvidenciavel documentoProvidenciavel;

    public FamiliaMembro getFamiliaMembro() {
        return familiaMembro;
    }

    public void setFamiliaMembro(FamiliaMembro familiaMembro) {
        this.familiaMembro = familiaMembro;
    }

    public DocumentoProvidenciavel getDocumentoProvidenciavel() {
        return documentoProvidenciavel;
    }

    public void setDocumentoProvidenciavel(DocumentoProvidenciavel documentoProvidenciavel) {
        this.documentoProvidenciavel = documentoProvidenciavel;
    }

}
