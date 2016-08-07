/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcf;

import com.sias.model.entity.mcf.CondicaoOcupacao;
import com.sias.model.service.mcf.interfaces.CondicaoOcupacaoService;
import com.sias.util.GSONConverter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class CondicaoOcupacaoController {

    @Autowired
    private CondicaoOcupacaoService condicaoOcupacaoService;

    @RequestMapping(value = "/condicaoOcupacao", method = RequestMethod.GET)
    public ModelAndView condicaoOcupacao() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("condicaoOcupacaoList");
        try {
            modelAndView.addObject("condicaoOcupacaoList", condicaoOcupacaoService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(CondicaoOcupacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }
    
    @RequestMapping(value = "/condicaoOcupacao/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("condicaoOcupacaoForm");
        try {
        } catch (Exception ex) {
            Logger.getLogger(DocumentoProvidenciavelController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/condicaoOcupacao/save", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> save (String json) {

        Map<String, Object> response = new HashMap<String, Object>();
        
        try {
            CondicaoOcupacao condicaoOcupacao = (CondicaoOcupacao) GSONConverter.convert(json, CondicaoOcupacao.class);
            condicaoOcupacaoService.create(condicaoOcupacao);
            response.put("success", true);
            response.put("msg", "Salvo com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(CondicaoOcupacaoController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", ex.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/condicaoOcupacao/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("condicaoOcupacaoForm");

        try {
            modelAndView.addObject("condicaoOcupacao", condicaoOcupacaoService.readById(id));
        } catch (Exception ex) {
            Logger.getLogger(CondicaoOcupacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/condicaoOcupacao/{id}/editar", method = RequestMethod.POST)
    public ModelAndView editar(@ModelAttribute CondicaoOcupacao condicaoOcupacao) {

        try {
            condicaoOcupacaoService.update(condicaoOcupacao);
        } catch (Exception ex) {
            Logger.getLogger(CondicaoOcupacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/condicaoOcupacao");
    }

    @RequestMapping(value = "/condicaoOcupacao/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            condicaoOcupacaoService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(CondicaoOcupacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/condicaoOcupacao");
    }

    @RequestMapping(value = "/condicaoOcupacao/readAll", method = RequestMethod.POST)
    public @ResponseBody
    List<CondicaoOcupacao> readAll() {
        try {
            return condicaoOcupacaoService.readAll();
        } catch (Exception ex) {
            Logger.getLogger(CondicaoOcupacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
