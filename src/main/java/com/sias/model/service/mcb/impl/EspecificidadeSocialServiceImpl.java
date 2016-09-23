/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcb.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcb.interfaces.EspecificidadeSocialDAO;
import com.sias.model.entity.mcb.EspecificidadeSocial;
import com.sias.model.service.mcb.interfaces.EspecificidadeSocialService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class EspecificidadeSocialServiceImpl implements EspecificidadeSocialService {

    @Autowired
    private EspecificidadeSocialDAO especificidadeSocialDAO;

    @Override
    public void create(EspecificidadeSocial especificidadeSocial) throws Exception {
        especificidadeSocialDAO.create(especificidadeSocial);
    }

    @Override
    public List<EspecificidadeSocial> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EspecificidadeSocial readById(Long id) throws Exception {
        return especificidadeSocialDAO.readById(id);
    }

    @Override
    public List<EspecificidadeSocial> readAll() throws Exception {
        return especificidadeSocialDAO.readAll();
    }

    @Override
    public void update(EspecificidadeSocial especificidadeSocial) throws Exception {
        especificidadeSocialDAO.update(especificidadeSocial);
    }

    @Override
    public void delete(Long id) throws Exception {
        especificidadeSocialDAO.delete(id);
    }

    @Override
    public void validate(EspecificidadeSocial e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
