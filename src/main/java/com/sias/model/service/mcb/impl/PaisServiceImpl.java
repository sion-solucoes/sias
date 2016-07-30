/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcb.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcb.interfaces.PaisDAO;
import com.sias.model.entity.mcb.Pais;
import com.sias.model.service.mcb.interfaces.PaisService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class PaisServiceImpl implements PaisService{

    @Autowired
    private PaisDAO paisDAO;
    
    @Override
    public void create(Pais pais) throws Exception {
        paisDAO.create(pais);
    }

    @Override
    public List<Pais> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pais readById(Long id) throws Exception {
        return paisDAO.readById(id);
    }

    @Override
    public List<Pais> readAll() throws Exception {
        return paisDAO.readAll();
    }

    @Override
    public void update(Pais pais) throws Exception {
        paisDAO.update(pais);
    }

    @Override
    public void delete(Long id) throws Exception {
        paisDAO.delete(id);
    }

    @Override
    public void validate(Pais e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
