/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcf.impl;

import com.sias.model.dao.mcf.interfaces.CondicaoOcupacaoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.entity.mcf.CondicaoOcupacao;
import com.sias.model.service.mcf.interfaces.CondicaoOcupacaoService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class CondicaoOcupacaoServiceImpl implements CondicaoOcupacaoService {

    @Autowired
    private CondicaoOcupacaoDAO condicaoOcupacaoDAO;

    @Override
    public void create(CondicaoOcupacao condicaoOcupacao) throws Exception {
        condicaoOcupacaoDAO.create(condicaoOcupacao);
    }

    @Override
    public List<CondicaoOcupacao> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CondicaoOcupacao readById(Long id) throws Exception {
        return condicaoOcupacaoDAO.readById(id);
    }

    @Override
    public List<CondicaoOcupacao> readAll() throws Exception {
        return condicaoOcupacaoDAO.readAll();
    }

    @Override
    public void update(CondicaoOcupacao condicaoOcupacao) throws Exception {
        condicaoOcupacaoDAO.update(condicaoOcupacao);
    }

    @Override
    public void delete(Long id) throws Exception {
        condicaoOcupacaoDAO.delete(id);
    }

    @Override
    public void validate(CondicaoOcupacao e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
