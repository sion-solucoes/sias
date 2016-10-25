/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcf;

import com.sias.model.constants.mcf.FamiliaMembroConstants;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sias.model.entity.mcf.FamiliaMembro;
import com.sias.model.service.mcf.interfaces.FamiliaMembroService;
import com.sias.model.service.mcf.interfaces.FamiliaService;
import com.sias.util.Criteria;
import com.sias.util.GSONConverter;
import java.util.ArrayList;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleFamiliar")
public class FamiliaMembroController {

    @Autowired
    private FamiliaService familiaService;

    @Autowired
    private FamiliaMembroService familiaMembroService;

    @RequestMapping(value = "/familiaMembro/readFamiliaMembroByFamilia", method = RequestMethod.POST)
    public @ResponseBody
    List<FamiliaMembro> readFamiliaMembroByFamilia(Long familiaId) {

        try {
            return familiaMembroService.readFamiliaMembroByFamilia(familiaId);
        } catch (Exception ex) {
            Logger.getLogger(FamiliaMembroController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @RequestMapping(value = "/familiaMembro/readAll", method = RequestMethod.POST)
    public @ResponseBody
    List<FamiliaMembro> readAll() {

        try {
            return familiaMembroService.readAll();
        } catch (Exception ex) {
            Logger.getLogger(FamiliaMembroController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @RequestMapping(value = "/familiaMembro/readByCriteria", method = RequestMethod.POST)
    public @ResponseBody
    List<FamiliaMembro> readByCriteria(String json) {

        try {
//            FamiliaMembro familiaMembro = (FamiliaMembro) GSONConverter.convert(json, FamiliaMembro.class);
            FamiliaMembro familiaMembro = new FamiliaMembro();
            familiaMembro.setNome(json);
            List<Criteria> criteriaList = new ArrayList<Criteria>();
            if (familiaMembro != null) {
                Criteria criteria = new Criteria();
                criteria.setAttribute(FamiliaMembroConstants.NOME);
                criteria.setOperation("ILIKE");
                criteria.setValue("%" + familiaMembro.getNome() + "%");
                criteriaList.add(criteria);
            }

            return familiaMembroService.readByCriteria(criteriaList);
        } catch (Exception ex) {
            Logger.getLogger(FamiliaMembroController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
