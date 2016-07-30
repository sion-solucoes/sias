/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcf;

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
import com.sias.controller.mcb.CEPController;
import com.sias.model.entity.mcf.FormaIngresso;
import com.sias.model.service.mcf.interfaces.FormaIngressoService;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleFamiliar")
public class FormaIngressoController {

    @Autowired
    private FormaIngressoService formaIngressoService;

    @RequestMapping(value = "/formaIngresso", method = RequestMethod.GET)
    public ModelAndView formaIngresso() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("formaIngressoList");
        try {
            modelAndView.addObject("formaIngressoList", formaIngressoService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(FormaIngressoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/formaIngresso/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("formaIngressoForm");
        try {
        } catch (Exception ex) {
            Logger.getLogger(FormaIngressoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/formaIngresso/novo", method = RequestMethod.POST)
    public ModelAndView novo(@ModelAttribute FormaIngresso formaIngresso) {

        try {
            formaIngressoService.create(formaIngresso);
        } catch (Exception ex) {
            Logger.getLogger(FormaIngressoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/formaIngresso");
    }

    @RequestMapping(value = "/formaIngresso/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("formaIngressoForm");

        try {
            modelAndView.addObject("formaIngresso", formaIngressoService.readById(id));
        } catch (Exception ex) {
            Logger.getLogger(FormaIngressoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/formaIngresso/{id}/editar", method = RequestMethod.POST)
    public ModelAndView editar(@ModelAttribute FormaIngresso formaIngresso) {

        try {
            formaIngressoService.update(formaIngresso);
        } catch (Exception ex) {
            Logger.getLogger(FormaIngressoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/formaIngresso");
    }

    @RequestMapping(value = "/formaIngresso/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            formaIngressoService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(FormaIngressoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/formaIngresso");
    }

    @RequestMapping(value = "/formaIngresso/readAll", method = RequestMethod.POST)
    public @ResponseBody
    List<FormaIngresso> readAll() {

        try {
            return formaIngressoService.readAll();
        } catch (Exception ex) {
            Logger.getLogger(FormaIngressoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
