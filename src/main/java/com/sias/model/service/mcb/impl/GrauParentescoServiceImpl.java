/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcb.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcb.interfaces.GrauParentescoDAO;
import com.sias.model.entity.mcb.GrauParentesco;
import com.sias.model.service.mcb.interfaces.GrauParentescoService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class GrauParentescoServiceImpl implements GrauParentescoService {

    @Autowired
    private GrauParentescoDAO grauParentescoDAO;

    @Override
    public void create(GrauParentesco grauParentesco) throws Exception {
        grauParentescoDAO.create(grauParentesco);
    }

    @Override
    public List<GrauParentesco> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrauParentesco readById(Long id) throws Exception {
        return grauParentescoDAO.readById(id);
    }

    @Override
    public List<GrauParentesco> readAll() throws Exception {
        return grauParentescoDAO.readAll();
    }

    @Override
    public void update(GrauParentesco grauParentesco) throws Exception {
        grauParentescoDAO.update(grauParentesco);
    }

    @Override
    public void delete(Long id) throws Exception {
        grauParentescoDAO.delete(id);
    }

    @Override
    public void validate(GrauParentesco e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
