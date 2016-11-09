/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcf.impl;

import com.sias.model.dao.mcf.interfaces.FamiliaVisitaDAO;
import com.sias.model.entity.mcf.FamiliaVisita;
import com.sias.model.service.mcf.interfaces.FamiliaVisitaService;
import com.sias.util.Criteria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fernando
 */
@Service
public class FamiliaVisitaServiceImpl implements FamiliaVisitaService {

    @Autowired
    private FamiliaVisitaDAO familiaVisitaDAO;

    @Override
    public void create(FamiliaVisita familiaVisita) throws Exception {
        familiaVisitaDAO.create(familiaVisita);
    }

    @Override
    public List<FamiliaVisita> readByCriteria(List<Criteria> criteriaList) throws Exception {
        return familiaVisitaDAO.readByCriteria(criteriaList);
    }

    @Override
    public FamiliaVisita readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FamiliaVisita> readAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(FamiliaVisita e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) throws Exception {
        familiaVisitaDAO.delete(id);
    }

    @Override
    public void validate(FamiliaVisita e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void confirm(Long id) throws Exception {
        familiaVisitaDAO.confirm(id);
    }
    
    @Override
    public void disconfirm(Long id) throws Exception {
        familiaVisitaDAO.disconfirm(id);
    }

}
