/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcb.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcb.interfaces.DocumentoProvidenciavelDAO;
import com.sias.model.entity.mcb.DocumentoProvidenciavel;
import com.sias.model.service.mcb.interfaces.DocumentoProvidenciavelService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class DocumentoProvidenciavelServiceImpl implements DocumentoProvidenciavelService {

    @Autowired
    private DocumentoProvidenciavelDAO documentoProvidenciavelDAO;

    @Override
    public void create(DocumentoProvidenciavel documentoProvidenciavel) throws Exception {
        documentoProvidenciavelDAO.create(documentoProvidenciavel);
    }

    @Override
    public List<DocumentoProvidenciavel> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DocumentoProvidenciavel readById(Long id) throws Exception {
        return documentoProvidenciavelDAO.readById(id);
    }

    @Override
    public List<DocumentoProvidenciavel> readAll() throws Exception {
        return documentoProvidenciavelDAO.readAll();
    }

    @Override
    public void update(DocumentoProvidenciavel documentoProvidenciavel) throws Exception {
        documentoProvidenciavelDAO.update(documentoProvidenciavel);
    }

    @Override
    public void delete(Long id) throws Exception {
        documentoProvidenciavelDAO.delete(id);
    }

    @Override
    public void validate(DocumentoProvidenciavel e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
