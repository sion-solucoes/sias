/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcf.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sias.model.dao.mcf.interfaces.FamiliaMembroDAO;
import com.sias.model.entity.mcf.FamiliaMembro;
import com.sias.model.entity.mcf.FamiliaMembroDocumentoProvidenciavel;
import com.sias.model.service.mcf.interfaces.FamiliaMembroDocumentoProvidenciavelService;
import com.sias.model.service.mcf.interfaces.FamiliaMembroService;
import com.sias.util.Criteria;
import com.sias.util.ValidateException;

/**
 *
 * @author Fernando Laranjo
 */
@Service
public class FamiliaMembroServiceImpl implements FamiliaMembroService {

    @Autowired
    private FamiliaMembroDocumentoProvidenciavelService familiaMembroDocumentoProvidenciavelService;

    @Autowired
    private FamiliaMembroDAO familiaMembroDAO;

    @Override
    public void create(FamiliaMembro familiaMembro) throws Exception {

        validate(familiaMembro);

        familiaMembroDAO.create(familiaMembro);

        familiaMembroDocumentoProvidenciavelService.deleteByFamiliaMembro(familiaMembro.getId());
            if (familiaMembro.getFamiliaMembroDocumentoProvidenciavelList() != null) {
            for (FamiliaMembroDocumentoProvidenciavel familiaMembroDocumentoProvidenciavel : familiaMembro.getFamiliaMembroDocumentoProvidenciavelList()) {
                familiaMembroDocumentoProvidenciavel.setFamiliaMembro(familiaMembro);
                familiaMembroDocumentoProvidenciavelService.create(familiaMembroDocumentoProvidenciavel);
            }
        }
    }

    @Override
    public List<FamiliaMembro> readByCriteria(List<Criteria> criteriaList) throws Exception {
        return familiaMembroDAO.readByCriteria(criteriaList);
    }

    @Override
    public FamiliaMembro readById(Long id) throws Exception {
        return familiaMembroDAO.readById(id);
    }

    @Override
    public List<FamiliaMembro> readAll() throws Exception {
        return familiaMembroDAO.readAll();
    }

    @Override
    public void update(FamiliaMembro familiaMembro) throws Exception {

        validate(familiaMembro);

        familiaMembroDAO.update(familiaMembro);

        familiaMembroDocumentoProvidenciavelService.deleteByFamiliaMembro(familiaMembro.getId());
        if (familiaMembro.getFamiliaMembroDocumentoProvidenciavelList() != null) {
            for (FamiliaMembroDocumentoProvidenciavel familiaMembroDocumentoProvidenciavel : familiaMembro.getFamiliaMembroDocumentoProvidenciavelList()) {
                familiaMembroDocumentoProvidenciavel.setFamiliaMembro(familiaMembro);
                familiaMembroDocumentoProvidenciavelService.create(familiaMembroDocumentoProvidenciavel);
            }
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        familiaMembroDocumentoProvidenciavelService.deleteByFamiliaMembro(id);
        familiaMembroDAO.delete(id);
    }

    @Override
    public void validate(FamiliaMembro familiaMembro) throws Exception {

        if (familiaMembro.getFamilia() == null || familiaMembro.getFamilia().getId() == null) {
            throw new ValidateException("\"Família\" é um campo obrigatório");
        }

        if (familiaMembro.getGrauParentesco() == null || familiaMembro.getGrauParentesco().getId() == null) {
            throw new ValidateException("\"Grau de Parentesco\" é um campo obrigatório!");
        }

        if (familiaMembro.getNome() == null || familiaMembro.getNome().trim().isEmpty()) {
            throw new ValidateException("\"Nome\" é um campo de preenchimento obrigatório!");
        }

        if (familiaMembro.getDataNascimento() == null) {
            throw new ValidateException("\"Data de Nascimento\" é um campo de preenchimento obrigatório!");
        }

        if (familiaMembro.getEscolaridade() == null || familiaMembro.getEscolaridade().getId() == null) {
            throw new ValidateException("\"Escolaridade\" é um campo de preenchimento obrigatório!");
        }

        if (familiaMembro.getCondicaoOcupacao() == null || familiaMembro.getCondicaoOcupacao().getId() == null) {
            throw new ValidateException("\"Condição de Ocupação\" é um campo de preenchimento obrigatório!");
        }

        if (familiaMembro.isPossuiQualificacaoProfissional()) {
            if (familiaMembro.getDescricaoQualificacaoProfissional() == null || familiaMembro.getDescricaoQualificacaoProfissional().trim().isEmpty()) {
                throw new ValidateException("\"Descrição da Qualificação Profissional\" é um campo de preenchimento obrigatório!");
            }
        }

        if (familiaMembro.isNecessitaCuidadosConstantes()) {
            if (familiaMembro.getDescricaoNecessidadeCuidadosConstantes() == null || familiaMembro.getDescricaoNecessidadeCuidadosConstantes().trim().isEmpty()) {
                throw new ValidateException("\"Descrição da Necessidade de Cuidados Constantes\" é um campo de preenchimento obrigatório!");
            }
        }

    }

    @Override
    public List<FamiliaMembro> readFamiliaMembroByFamilia(Long familiaId) throws Exception {

        List<FamiliaMembro> familiaMembroList = familiaMembroDAO.readFamiliaMembroByFamilia(familiaId);
        if (familiaMembroList != null) {
            for (FamiliaMembro familiaMembro : familiaMembroList) {
                familiaMembro.setFamiliaMembroDocumentoProvidenciavelList(familiaMembroDocumentoProvidenciavelService.readDocumentoProvidenciavelByFamiliaMembro(familiaMembro.getId()));
            }
        }

        return familiaMembroList;
    }

    @Override
    public void deleteByFamiliaNotInList(Long familiaId, List<Long> listId) throws Exception {
        familiaMembroDAO.deleteByFamiliaNotInList(familiaId, listId);
    }

}
