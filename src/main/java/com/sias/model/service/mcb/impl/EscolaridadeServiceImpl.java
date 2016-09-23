/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcb.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcb.interfaces.EscolaridadeDAO;
import com.sias.model.entity.mcb.Escolaridade;
import com.sias.model.service.mcb.interfaces.EscolaridadeService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class EscolaridadeServiceImpl implements EscolaridadeService {

    @Autowired
    private EscolaridadeDAO escolaridadeDAO;

    @Override
    public void create(Escolaridade escolaridade) throws Exception {
        escolaridadeDAO.create(escolaridade);
    }

    @Override
    public List<Escolaridade> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Escolaridade readById(Long id) throws Exception {
        return escolaridadeDAO.readById(id);
    }

    @Override
    public List<Escolaridade> readAll() throws Exception {
        return escolaridadeDAO.readAll();
    }

    @Override
    public void update(Escolaridade escolaridade) throws Exception {
        escolaridadeDAO.update(escolaridade);
    }

    @Override
    public void delete(Long id) throws Exception {
        escolaridadeDAO.delete(id);
    }

    @Override
    public void validate(Escolaridade e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
