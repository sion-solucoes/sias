/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcf.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcf.interfaces.FamiliaMembroDocumentoProvidenciavelDAO;
import com.sias.model.entity.mcb.DocumentoProvidenciavel;
import com.sias.model.entity.mcf.FamiliaMembroDocumentoProvidenciavel;
import com.sias.model.service.mcf.interfaces.FamiliaMembroDocumentoProvidenciavelService;
import com.sias.util.Criteria;
import com.sias.util.ValidateException;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class FamiliaMembroDocumentoProvidenciavelServiceImpl implements FamiliaMembroDocumentoProvidenciavelService {

    @Autowired
    private FamiliaMembroDocumentoProvidenciavelDAO familiaMembroDocumentoProvidenciavelDAO;

    @Override
    public void create(FamiliaMembroDocumentoProvidenciavel familiaMembroDocumentoProvidenciavel) throws Exception {
        familiaMembroDocumentoProvidenciavelDAO.create(familiaMembroDocumentoProvidenciavel);
    }

    @Override
    public List<FamiliaMembroDocumentoProvidenciavel> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FamiliaMembroDocumentoProvidenciavel readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FamiliaMembroDocumentoProvidenciavel> readAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(FamiliaMembroDocumentoProvidenciavel familiaMembroDocumentoProvidenciavel) throws Exception {
        familiaMembroDocumentoProvidenciavelDAO.update(familiaMembroDocumentoProvidenciavel);
    }

    @Override
    public void delete(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validate(FamiliaMembroDocumentoProvidenciavel familiaMembroDocumentoProvidenciavel) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DocumentoProvidenciavel> readDocumentoProvidenciavelByFamiliaMembro(Long familiaMembroId) throws Exception {
        return familiaMembroDocumentoProvidenciavelDAO.readDocumentoProvidenciavelByFamiliaMembro(familiaMembroId);
    }

    @Override
    public void deleteByFamiliaMembro(Long familiaMembroId) throws Exception {
        familiaMembroDocumentoProvidenciavelDAO.deleteByFamiliaMembro(familiaMembroId);
    }

}
