/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcf.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcf.interfaces.FamiliaDAO;
import com.sias.model.entity.mcf.Familia;
import com.sias.model.entity.mcf.FamiliaMembro;
import com.sias.model.service.mcf.interfaces.FamiliaMembroService;
import com.sias.model.service.mcf.interfaces.FamiliaService;
import com.sias.util.Criteria;
import com.sias.util.ValidateException;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class FamiliaServiceImpl implements FamiliaService {

    @Autowired
    private FamiliaDAO familiaDAO;

    @Autowired
    private FamiliaMembroService familiaMembroService;

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void create(Familia familia) throws Exception {

        validate(familia);

        familiaDAO.create(familia);

        if (familia.getFamiliaMembroList() != null) {
            for (FamiliaMembro familiaMembro : familia.getFamiliaMembroList()) {
                familiaMembro.setFamilia(familia);
                familiaMembroService.create(familiaMembro);
            }
        }

    }

    @Override
    public List<Familia> readByCriteria(List<Criteria> criteriaList) throws Exception {
        return familiaDAO.readByCriteria(criteriaList);
    }

    @Override
    public Familia readById(Long id) throws Exception {
        return familiaDAO.readById(id);
    }

    @Override
    public List<Familia> readAll() throws Exception {
        return familiaDAO.readAll();
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void update(Familia familia) throws Exception {

        validate(familia);

        familiaDAO.update(familia);

        List<Long> listId = new ArrayList<Long>();
        if (familia.getFamiliaMembroList() != null) {
            for (FamiliaMembro familiaMembro : familia.getFamiliaMembroList()) {
                familiaMembro.setFamilia(familia);
                if (familiaMembro.getId() == null) {
                    familiaMembroService.create(familiaMembro);
                } else {
                    familiaMembroService.update(familiaMembro);
                }
                listId.add(familiaMembro.getId());
            }
        }
        familiaMembroService.deleteByFamiliaNotInList(familia.getId(), listId);

    }

    @Override
    public void delete(Long id) throws Exception {
        familiaMembroService.deleteByFamiliaNotInList(id, null);
        familiaDAO.delete(id);
    }

    @Override
    public void validate(Familia familia) throws Exception {

        if (familia.getUnidadeAtendimento() == null || familia.getUnidadeAtendimento().getId() == null) {
            throw new ValidateException("\"Unidade de Atendimento\" é um campo obrigatório!");
        }

        if (familia.getFormaIngresso() == null || familia.getFormaIngresso().getId() == null) {
            throw new ValidateException("\"Forma de Ingresso\" é um campo obrigatório!");
        }

        if (familia.getObservacaoFormaIngresso() == null || familia.getObservacaoFormaIngresso().trim().isEmpty()) {
            throw new ValidateException("\"Observação da Forma de Ingresso\" é um campo obrigatório!");
        }

        if (familia.getFamiliaMembroList() == null || familia.getFamiliaMembroList().isEmpty()) {
            throw new ValidateException("É obrigatório que a família seja composta de pelo menos um membro!");
        }

        if (familia.getCepEndereco() == null || familia.getCepEndereco().getId() == null) {
            throw new ValidateException("\"CEP do Endereço\" é um campo obrigatório!");
        }

        if (familia.getLogradouroEndereco() == null || familia.getLogradouroEndereco().trim().isEmpty()) {
            throw new ValidateException("\"Logradouro do Endereço\" é um campo obrigatório!");
        }

        if (familia.getNumeroEndereco() == null || familia.getNumeroEndereco().trim().isEmpty()) {
            throw new ValidateException("\"Número do Endereço\" é um campo obrigatório!");
        }

        if (familia.getBairroEndereco() == null || familia.getBairroEndereco().trim().isEmpty()) {
            throw new ValidateException("\"Bairro do Endereço\" é um campo obrigatório!");
        }

    }

}
