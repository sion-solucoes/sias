/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcb.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcb.interfaces.MunicipioDAO;
import com.sias.model.entity.mcb.Municipio;
import com.sias.model.service.mcb.interfaces.MunicipioService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class MunicipioServiceImpl implements MunicipioService {

    @Autowired
    private MunicipioDAO municipioDAO;

    @Override
    public void create(Municipio municipio) throws Exception {
        municipioDAO.create(municipio);
    }

    @Override
    public List<Municipio> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Municipio readById(Long id) throws Exception {
        return municipioDAO.readById(id);
    }

    @Override
    public List<Municipio> readAll() throws Exception {
        return municipioDAO.readAll();
    }

    @Override
    public void update(Municipio municipio) throws Exception {
        municipioDAO.update(municipio);
    }

    @Override
    public void delete(Long id) throws Exception {
        municipioDAO.delete(id);
    }

    @Override
    public void validate(Municipio e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
