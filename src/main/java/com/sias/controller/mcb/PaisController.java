/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcb;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.sias.model.entity.mcb.Pais;
import com.sias.model.service.mcb.interfaces.PaisService;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/cadastrosBasicos")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @RequestMapping(value = "/pais", method = RequestMethod.GET)
    public ModelAndView pais() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("paisList");

        try {
            modelAndView.addObject("paisList", paisService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(PaisController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/pais/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("paisForm");

        return modelAndView;
    }

    @RequestMapping(value = "/pais/novo", method = RequestMethod.POST)
    public ModelAndView novo(@ModelAttribute Pais pais) {

        try {
            paisService.create(pais);
        } catch (Exception ex) {
            Logger.getLogger(PaisController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/cadastrosBasicos/pais");
    }

    @RequestMapping(value = "/pais/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("paisForm");

        try {
            modelAndView.addObject("pais", paisService.readById(id));
        } catch (Exception ex) {
            Logger.getLogger(PaisController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/pais/{id}/editar", method = RequestMethod.POST)
    public ModelAndView editar(@ModelAttribute Pais pais) {

        try {
            paisService.update(pais);
        } catch (Exception ex) {
            Logger.getLogger(PaisController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/cadastrosBasicos/pais");
    }

    @RequestMapping(value = "/pais/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            paisService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(PaisController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/cadastrosBasicos/pais");
    }

}
