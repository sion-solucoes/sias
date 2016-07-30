/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcf;

import com.sias.model.entity.mcf.BeneficioEventual;
import com.sias.model.service.mcf.interfaces.BeneficioEventualService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jaderhenrique
 */
@Controller
@RequestMapping("/controleFamiliar")
public class BeneficioEventualController {
    
    @Autowired
    private BeneficioEventualService beneficioEventualService;
    
    @RequestMapping(value="/beneficioEventual", method = RequestMethod.GET)
    public ModelAndView beneficioEventual () {
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("beneficioEventualList");
        
        try {
            mv.addObject("beneficioEventualList", beneficioEventualService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(BeneficioEventualController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mv;
    }
    
    @RequestMapping(value = "/beneficioEventual/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("beneficioEventualForm");
        try {
        } catch (Exception ex) {
            Logger.getLogger(BeneficioEventualController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }
    
    @RequestMapping(value = "/beneficioEventual/novo", method = RequestMethod.POST)
    public ModelAndView novo(@ModelAttribute BeneficioEventual beneficioEventual) {

        try {
            beneficioEventualService.create(beneficioEventual);
        } catch (Exception ex) {
            Logger.getLogger(BeneficioEventualController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/beneficioEventual");
    }
    
    @RequestMapping(value = "/beneficioEventual/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("beneficioEventualForm");

        try {
            modelAndView.addObject("beneficioEventual", beneficioEventualService.readById(id));
        } catch (Exception ex) {
            Logger.getLogger(BeneficioEventualController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }
    
    @RequestMapping(value = "/beneficioEventual/{id}/editar", method = RequestMethod.POST)
    public ModelAndView editar(@ModelAttribute BeneficioEventual beneficioEventual) {

        try {
            beneficioEventualService.update(beneficioEventual);
        } catch (Exception ex) {
            Logger.getLogger(BeneficioEventualController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/beneficioEventual");
    }
    
    @RequestMapping(value = "/beneficioEventual/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            beneficioEventualService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(BeneficioEventualController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/beneficioEventual");
    }
    
    @RequestMapping(value = "/beneficioEventual/readAll", method = RequestMethod.POST)
    public @ResponseBody
    List<BeneficioEventual> readAll() {

        try {
            return beneficioEventualService.readAll();
        } catch (Exception ex) {
            Logger.getLogger(BeneficioEventualController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
}
