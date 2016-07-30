/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcb.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcb.interfaces.CEPDAO;
import com.sias.model.entity.mcb.CEP;
import com.sias.model.service.mcb.interfaces.CEPService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class CEPServiceImpl implements CEPService {

    @Autowired
    private CEPDAO cepDAO;

    @Override
    public void create(CEP cep) throws Exception {
        cepDAO.create(cep);
    }

    @Override
    public List<CEP> readByCriteria(List<Criteria> criteriaList) throws Exception {
        return cepDAO.readByCriteria(criteriaList);
    }

    @Override
    public CEP readById(Long id) throws Exception {
        return cepDAO.readById(id);
    }

    @Override
    public List<CEP> readAll() throws Exception {
        return cepDAO.readAll();
    }

    @Override
    public void update(CEP cep) throws Exception {
        cepDAO.update(cep);
    }

    @Override
    public void delete(Long id) throws Exception {
        cepDAO.delete(id);
    }

    @Override
    public void validate(CEP e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
