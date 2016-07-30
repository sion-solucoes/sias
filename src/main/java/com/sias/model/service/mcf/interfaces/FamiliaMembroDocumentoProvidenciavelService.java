/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcf.interfaces;

import java.util.List;
import com.sias.model.base.service.BaseService;
import com.sias.model.entity.mcf.DocumentoProvidenciavel;
import com.sias.model.entity.mcf.FamiliaMembroDocumentoProvidenciavel;

/**
 *
 * @author Fernando Laranjo
 */
public interface FamiliaMembroDocumentoProvidenciavelService extends BaseService<FamiliaMembroDocumentoProvidenciavel> {

    public List<DocumentoProvidenciavel> readDocumentoProvidenciavelByFamiliaMembro(Long familiaMembroId) throws Exception;
    
    public void deleteByFamiliaMembro(Long familiaMembroId) throws Exception;
    
}
