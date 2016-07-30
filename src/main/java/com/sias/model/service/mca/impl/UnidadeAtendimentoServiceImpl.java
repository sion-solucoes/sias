/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mca.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mca.interfaces.UnidadeAtendimentoDAO;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.service.mca.interfaces.UnidadeAtendimentoService;
import com.sias.util.Criteria;
import com.sias.util.ValidateException;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class UnidadeAtendimentoServiceImpl implements UnidadeAtendimentoService {

    @Autowired
    private UnidadeAtendimentoDAO unidadeAtendimentoDAO;

    @Override
    public void create(UnidadeAtendimento unidadeAtendimento) throws Exception {
        validate(unidadeAtendimento);
        unidadeAtendimentoDAO.create(unidadeAtendimento);
    }

    @Override
    public List<UnidadeAtendimento> readByCriteria(List<Criteria> criteriaList) throws Exception {
        return unidadeAtendimentoDAO.readByCriteria(criteriaList);
    }

    @Override
    public UnidadeAtendimento readById(Long id) throws Exception {
        return unidadeAtendimentoDAO.readById(id);
    }

    @Override
    public List<UnidadeAtendimento> readAll() throws Exception {
        return unidadeAtendimentoDAO.readAll();
    }

    @Override
    public void update(UnidadeAtendimento unidadeAtendimento) throws Exception {
        validate(unidadeAtendimento);
        unidadeAtendimentoDAO.update(unidadeAtendimento);
    }

    @Override
    public void delete(Long id) throws Exception {
        unidadeAtendimentoDAO.delete(id);
    }

    @Override
    public void validate(UnidadeAtendimento unidadeAtendimento) throws Exception {

        if (unidadeAtendimento.getTipo() == null || unidadeAtendimento.getTipo() == 0) {
            throw new ValidateException("\"Tipo\" é um campo obrigatório!");
        }
        if (unidadeAtendimento.getCodigo() == null || unidadeAtendimento.getCodigo().trim().isEmpty()) {
            throw new ValidateException("\"Código\" é um campo obrigatório!");
        }
        if (unidadeAtendimento.getDescricao() == null || unidadeAtendimento.getDescricao().trim().isEmpty()) {
            throw new ValidateException("\"Descrição\" é um campo obrigatório!");
        }
        if (unidadeAtendimento.getCepEndereco() == null || unidadeAtendimento.getCepEndereco().getId() == null) {
            throw new ValidateException("\"CEP\" é um campo obrigatório!");
        }
        if (unidadeAtendimento.getLogradouroEndereco() == null || unidadeAtendimento.getLogradouroEndereco().trim().isEmpty()) {
            throw new ValidateException("\"Logradouro\" é um campo obrigatório!");
        }
        if (unidadeAtendimento.getNumeroEndereco() == null || unidadeAtendimento.getNumeroEndereco().trim().isEmpty()) {
            throw new ValidateException("\"Número\" é um campo obrigatório!");
        }
        if (unidadeAtendimento.getBairroEndereco() == null || unidadeAtendimento.getBairroEndereco().trim().isEmpty()) {
            throw new ValidateException("\"Bairro\" é um campo obrigatório!");
        }

    }

}
