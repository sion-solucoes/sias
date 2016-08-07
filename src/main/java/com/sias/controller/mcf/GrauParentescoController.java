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
import com.sias.model.entity.mcf.GrauParentesco;
import com.sias.model.service.mcf.interfaces.GrauParentescoService;
import com.sias.util.GSONConverter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleFamiliar")
public class GrauParentescoController {

    @Autowired
    private GrauParentescoService grauParentescoService;

    @RequestMapping(value = "/grauParentesco", method = RequestMethod.GET)
    public ModelAndView grauParentesco() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("grauParentescoList");
        try {
            modelAndView.addObject("grauParentescoList", grauParentescoService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(GrauParentescoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/grauParentesco/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("grauParentescoForm");
        try {
        } catch (Exception ex) {
            Logger.getLogger(GrauParentescoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/grauParentesco/save", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> save (String json) {

        Map<String, Object> response = new HashMap<String, Object>();
        
        try {
            GrauParentesco grauParentesco = (GrauParentesco) GSONConverter.convert(json, GrauParentesco.class);
            grauParentescoService.create(grauParentesco);
            response.put("success", true);
            response.put("msg", "Salvo com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(GrauParentescoController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", ex.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/grauParentesco/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("grauParentescoForm");

        try {
            modelAndView.addObject("grauParentesco", grauParentescoService.readById(id));
        } catch (Exception ex) {
            Logger.getLogger(GrauParentescoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/grauParentesco/{id}/editar", method = RequestMethod.POST)
    public ModelAndView editar(@ModelAttribute GrauParentesco grauParentesco) {

        try {
            grauParentescoService.update(grauParentesco);
        } catch (Exception ex) {
            Logger.getLogger(GrauParentescoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/grauParentesco");
    }

    @RequestMapping(value = "/grauParentesco/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            grauParentescoService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(GrauParentescoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/grauParentesco");
    }

    @RequestMapping(value = "/grauParentesco/readAll", method = RequestMethod.POST)
    public @ResponseBody
    List<GrauParentesco> readAll() {
        try {
            return grauParentescoService.readAll();
        } catch (Exception ex) {
            Logger.getLogger(GrauParentescoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
