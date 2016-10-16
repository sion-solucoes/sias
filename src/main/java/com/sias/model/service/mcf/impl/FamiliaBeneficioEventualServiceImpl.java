/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcf.impl;

import com.sias.model.dao.mcf.interfaces.FamiliaBeneficioEventualDAO;
import com.sias.model.entity.mcf.FamiliaBeneficioEventual;
import com.sias.model.service.mcf.interfaces.FamiliaBeneficioEventualService;
import com.sias.util.Criteria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jaderhenrique
 */
@Service
public class FamiliaBeneficioEventualServiceImpl implements FamiliaBeneficioEventualService{
    
    @Autowired
    private FamiliaBeneficioEventualDAO familiaBeneficioEventualDAO;

    @Override
    public void create(FamiliaBeneficioEventual familiaBeneficioEventual) throws Exception {
        familiaBeneficioEventualDAO.create(familiaBeneficioEventual);
    }

    @Override
    public List<FamiliaBeneficioEventual> readByCriteria(List<Criteria> criteriaList) throws Exception {
        return familiaBeneficioEventualDAO.readByCriteria(criteriaList);
    }

    @Override
    public FamiliaBeneficioEventual readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FamiliaBeneficioEventual> readAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(FamiliaBeneficioEventual e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) throws Exception {
        familiaBeneficioEventualDAO.delete(id);
    }

    @Override
    public void validate(FamiliaBeneficioEventual e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
