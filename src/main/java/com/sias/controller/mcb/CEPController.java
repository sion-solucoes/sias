/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.sias.model.entity.mcb.CEP;
import com.sias.model.service.mcb.interfaces.CEPService;
import com.sias.model.service.mcb.interfaces.MunicipioService;
import com.sias.util.Constants;
import com.sias.util.GSONConverter;
import com.sias.util.ValidateException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.DuplicateKeyException;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/cadastrosBasicos")
public class CEPController {

    @Autowired
    private CEPService cepService;

    @Autowired
    private MunicipioService municipioService;

    @RequestMapping(value = "/cep", method = RequestMethod.GET)
    public ModelAndView cep() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("cepList");

        try {
            modelAndView.addObject("cepList", cepService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(CEPController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/cep/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cepForm");
        try {
            modelAndView.addObject("municipioList", municipioService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(CEPController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/cep/save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> save(String json) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            CEP cep = (CEP) GSONConverter.convert(json, CEP.class);
            if (cep.getId() == null) {
                cepService.create(cep);
            } else {
                cepService.update(cep);
            }
            response.put("success", true);
            response.put("msg", "Salvo com sucesso!");
        } catch (ValidateException ex) {
            Logger.getLogger(CEPController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", ex.getMessage());
        } catch (DuplicateKeyException ex) {
            Logger.getLogger(CEPController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_DUPLICATE_KEY_EXCEPTION);
        } catch (Exception ex) {
            Logger.getLogger(CEPController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_ERRO_INESPERADO);
        }

        return response;
    }

    @RequestMapping(value = "/cep/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cepForm");

        try {
            modelAndView.addObject("cep", cepService.readById(id));
            modelAndView.addObject("municipioList", municipioService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(CEPController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/cep/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            cepService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(CEPController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/cadastrosBasicos/cep");
    }

    @RequestMapping(value = "/cep/readById", method = RequestMethod.POST)
    public @ResponseBody
    CEP readById(@RequestParam("id") Long id) {

        try {
            return cepService.readById(id);
        } catch (Exception ex) {
            Logger.getLogger(CEPController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @RequestMapping(value = "/cep/readAll", method = RequestMethod.POST)
    public @ResponseBody
    List<CEP> readAll() {

        try {
            return cepService.readAll();
        } catch (Exception ex) {
            Logger.getLogger(CEPController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
