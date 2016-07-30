/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcf.impl;

import com.sias.model.dao.mcf.interfaces.DeficienciaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.entity.mcf.Deficiencia;
import com.sias.model.service.mcf.interfaces.DeficienciaService;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class DeficienciaServiceImpl implements DeficienciaService {

    @Autowired
    private DeficienciaDAO deficienciaDAO;

    @Override
    public void create(Deficiencia deficiencia) throws Exception {
        deficienciaDAO.create(deficiencia);
    }

    @Override
    public List<Deficiencia> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Deficiencia readById(Long id) throws Exception {
        return deficienciaDAO.readById(id);
    }

    @Override
    public List<Deficiencia> readAll() throws Exception {
        return deficienciaDAO.readAll();
    }

    @Override
    public void update(Deficiencia deficiencia) throws Exception {
        deficienciaDAO.update(deficiencia);
    }

    @Override
    public void delete(Long id) throws Exception {
        deficienciaDAO.delete(id);
    }

    @Override
    public void validate(Deficiencia e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
