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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sias.model.entity.mcf.Escolaridade;
import com.sias.model.service.mcf.interfaces.EscolaridadeService;
import com.sias.util.GSONConverter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleFamiliar")
public class EscolaridadeController {

    @Autowired
    private EscolaridadeService escolaridadeService;

    @RequestMapping(value = "/escolaridade", method = RequestMethod.GET)
    public ModelAndView escolaridade() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("escolaridadeList");
        try {
            modelAndView.addObject("escolaridadeList", escolaridadeService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(EscolaridadeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }
    
    @RequestMapping(value = "/escolaridade/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("escolaridadeForm");
        try {
        } catch (Exception ex) {
            Logger.getLogger(DocumentoProvidenciavelController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/escolaridade/save", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> save (String json) {

        Map<String, Object> response = new HashMap<String, Object>();
        
        try {
            Escolaridade escolaridade = (Escolaridade) GSONConverter.convert(json, Escolaridade.class);
            escolaridadeService.create(escolaridade);
            response.put("success", true);
            response.put("msg", "Salvo com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(EscolaridadeController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", ex.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/escolaridade/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("escolaridadeForm");

        try {
            modelAndView.addObject("escolaridade", escolaridadeService.readById(id));
        } catch (Exception ex) {
            Logger.getLogger(EscolaridadeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/escolaridade/{id}/editar", method = RequestMethod.POST)
    public ModelAndView editar(@ModelAttribute Escolaridade escolaridade) {

        try {
            escolaridadeService.update(escolaridade);
        } catch (Exception ex) {
            Logger.getLogger(EscolaridadeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/escolaridade");
    }

    @RequestMapping(value = "/escolaridade/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            escolaridadeService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(EscolaridadeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/escolaridade");
    }
    
    @RequestMapping(value = "/escolaridade/readAll", method = RequestMethod.POST)
    public @ResponseBody
    List<Escolaridade> readAll() {
        try {
            return escolaridadeService.readAll();
        } catch (Exception ex) {
            Logger.getLogger(EscolaridadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
