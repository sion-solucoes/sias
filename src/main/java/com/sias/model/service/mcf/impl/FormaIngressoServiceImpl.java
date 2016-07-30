/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcf.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcf.interfaces.FormaIngressoDAO;
import com.sias.model.entity.mcf.FormaIngresso;
import com.sias.model.service.mcf.interfaces.FormaIngressoService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class FormaIngressoServiceImpl implements FormaIngressoService {

    @Autowired
    private FormaIngressoDAO formaIngressoDAO;

    @Override
    public void create(FormaIngresso formaIngresso) throws Exception {
        formaIngressoDAO.create(formaIngresso);
    }

    @Override
    public List<FormaIngresso> readByCriteria(List<Criteria> criteriaList) throws Exception {
        return formaIngressoDAO.readByCriteria(criteriaList);
    }

    @Override
    public FormaIngresso readById(Long id) throws Exception {
        return formaIngressoDAO.readById(id);
    }

    @Override
    public List<FormaIngresso> readAll() throws Exception {
        return formaIngressoDAO.readAll();
    }

    @Override
    public void update(FormaIngresso formaIngresso) throws Exception {
        formaIngressoDAO.update(formaIngresso);
    }

    @Override
    public void delete(Long id) throws Exception {
        formaIngressoDAO.delete(id);
    }

    @Override
    public void validate(FormaIngresso e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
