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
import com.sias.model.entity.mcb.Municipio;
import com.sias.model.service.mcb.interfaces.MunicipioService;
import com.sias.model.service.mcb.interfaces.UnidadeFederacaoService;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/cadastrosBasicos")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;
    
    @Autowired
    private UnidadeFederacaoService unidadeFederacaoService;
    
    @RequestMapping(value = "/municipio", method = RequestMethod.GET)
    public ModelAndView unidadeFederacao() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("municipioList");

        try {
            modelAndView.addObject("municipioList", municipioService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(MunicipioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/municipio/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("municipioForm");
        try {
            modelAndView.addObject("unidadeFederacaoList", unidadeFederacaoService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(MunicipioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return modelAndView;
    }

    @RequestMapping(value = "/municipio/novo", method = RequestMethod.POST)
    public ModelAndView novo(@ModelAttribute Municipio municipio) {

        try {
            municipioService.create(municipio);
        } catch (Exception ex) {
            Logger.getLogger(MunicipioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/cadastrosBasicos/municipio");
    }

    @RequestMapping(value = "/municipio/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("municipioForm");

        try {
            modelAndView.addObject("municipio", municipioService.readById(id));
            modelAndView.addObject("unidadeFederacaoList", unidadeFederacaoService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(MunicipioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/municipio/{id}/editar", method = RequestMethod.POST)
    public ModelAndView editar(@ModelAttribute Municipio municipio) {

        try {
            municipioService.update(municipio);
        } catch (Exception ex) {
            Logger.getLogger(MunicipioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/cadastrosBasicos/municipio");
    }

    @RequestMapping(value = "/municipio/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            municipioService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(MunicipioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/cadastrosBasicos/municipio");
    }
}
