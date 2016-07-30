/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcb.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcb.interfaces.UnidadeFederacaoDAO;
import com.sias.model.entity.mcb.UnidadeFederacao;
import com.sias.model.service.mcb.interfaces.UnidadeFederacaoService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class UnidadeFederacaoServiceImpl implements UnidadeFederacaoService {

    @Autowired
    private UnidadeFederacaoDAO unidadeFederacaoDAO;

    @Override
    public void create(UnidadeFederacao unidadeFederacao) throws Exception {
        unidadeFederacaoDAO.create(unidadeFederacao);
    }

    @Override
    public List<UnidadeFederacao> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnidadeFederacao readById(Long id) throws Exception {
        return unidadeFederacaoDAO.readById(id);
    }

    @Override
    public List<UnidadeFederacao> readAll() throws Exception {
        return unidadeFederacaoDAO.readAll();
    }

    @Override
    public void update(UnidadeFederacao unidadeFederacao) throws Exception {
        unidadeFederacaoDAO.update(unidadeFederacao);
    }

    @Override
    public void delete(Long id) throws Exception {
        unidadeFederacaoDAO.delete(id);
    }

    @Override
    public void validate(UnidadeFederacao e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
