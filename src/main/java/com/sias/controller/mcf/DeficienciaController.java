/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcf;

import com.sias.model.entity.mcf.Deficiencia;
import com.sias.model.service.mcf.interfaces.DeficienciaService;
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
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleFamiliar")
public class DeficienciaController {

    @Autowired
    private DeficienciaService deficienciaService;

    @RequestMapping(value = "/deficiencia", method = RequestMethod.GET)
    public ModelAndView familia() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deficienciaList");
        try {
            modelAndView.addObject("deficienciaList", deficienciaService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(DeficienciaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/deficiencia/novo", method = RequestMethod.POST)
    public ModelAndView novo(@ModelAttribute Deficiencia deficiencia) {

        try {
            deficienciaService.create(deficiencia);
        } catch (Exception ex) {
            Logger.getLogger(DeficienciaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/deficiencia");
    }

    @RequestMapping(value = "/deficiencia/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deficienciaForm");

        try {
            modelAndView.addObject("deficiencia", deficienciaService.readById(id));
        } catch (Exception ex) {
            Logger.getLogger(DeficienciaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/deficiencia/{id}/editar", method = RequestMethod.POST)
    public ModelAndView editar(@ModelAttribute Deficiencia deficiencia) {

        try {
            deficienciaService.update(deficiencia);
        } catch (Exception ex) {
            Logger.getLogger(DeficienciaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/deficiencia");
    }

    @RequestMapping(value = "/deficiencia/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            deficienciaService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(DeficienciaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/deficiencia");
    }

    @RequestMapping(value = "/deficiencia/readAll", method = RequestMethod.POST)
    public @ResponseBody
    List<Deficiencia> readAll() {
        try {
            return deficienciaService.readAll();
        } catch (Exception ex) {
            Logger.getLogger(DeficienciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
