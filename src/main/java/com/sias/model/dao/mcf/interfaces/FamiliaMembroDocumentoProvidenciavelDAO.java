/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.interfaces;

import java.util.List;
import com.sias.model.base.dao.BaseDAO;
import com.sias.model.entity.mcf.FamiliaMembroDocumentoProvidenciavel;

/**
 *
 * @author Fernando Laranjo
 */
public interface FamiliaMembroDocumentoProvidenciavelDAO extends BaseDAO<FamiliaMembroDocumentoProvidenciavel> {

    public List<FamiliaMembroDocumentoProvidenciavel> readDocumentoProvidenciavelByFamiliaMembro(Long familiaMembroId) throws Exception;

    public void deleteByFamiliaMembro(Long familiaMembroId) throws Exception;

}
