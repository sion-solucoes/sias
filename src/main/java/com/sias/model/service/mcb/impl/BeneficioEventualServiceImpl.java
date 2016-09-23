/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcb.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcb.interfaces.BeneficioEventualDAO;
import com.sias.model.entity.mcb.BeneficioEventual;
import com.sias.model.service.mcb.interfaces.BeneficioEventualService;
import com.sias.util.Criteria;

/**
 *
 * @author jaderhenrique
 */
@Service
public class BeneficioEventualServiceImpl implements BeneficioEventualService{
    
    @Autowired
    private BeneficioEventualDAO beneficioEventualDAO;

    @Override
    public void create(BeneficioEventual beneficioEventual) throws Exception {
        beneficioEventualDAO.create(beneficioEventual);
    }

    @Override
    public List<BeneficioEventual> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BeneficioEventual readById(Long id) throws Exception {
        return beneficioEventualDAO.readById(id);
    }

    @Override
    public List<BeneficioEventual> readAll() throws Exception {
        return beneficioEventualDAO.readAll();
    }

    @Override
    public void update(BeneficioEventual beneficioEventual) throws Exception {
        beneficioEventualDAO.update(beneficioEventual);
    }

    @Override
    public void delete(Long id) throws Exception {
        beneficioEventualDAO.delete(id);
    }

    @Override
    public void validate(BeneficioEventual e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
