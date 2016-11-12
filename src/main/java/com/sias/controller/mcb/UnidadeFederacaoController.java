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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.sias.model.entity.mcb.UnidadeFederacao;
import com.sias.model.service.mcb.interfaces.PaisService;
import com.sias.model.service.mcb.interfaces.UnidadeFederacaoService;
import com.sias.util.Constants;
import com.sias.util.GSONConverter;
import com.sias.util.ValidateException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/cadastrosBasicos")
public class UnidadeFederacaoController {

    @Autowired
    private UnidadeFederacaoService unidadeFederacaoService;

    @Autowired
    private PaisService paisService;

    @RequestMapping(value = "/unidadeFederacao", method = RequestMethod.GET)
    public ModelAndView unidadeFederacao() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("unidadeFederacaoList");

        try {
            modelAndView.addObject("unidadeFederacaoList", unidadeFederacaoService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(UnidadeFederacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/unidadeFederacao/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("unidadeFederacaoForm");
        try {
            modelAndView.addObject("paisList", paisService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(UnidadeFederacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/unidadeFederacao/save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> save(String json) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            UnidadeFederacao unidadeFederacao = (UnidadeFederacao) GSONConverter.convert(json, UnidadeFederacao.class);
            if (unidadeFederacao.getId() == null) {
                unidadeFederacaoService.create(unidadeFederacao);
            } else {
                unidadeFederacaoService.update(unidadeFederacao);
            }
            response.put("success", true);
            response.put("msg", "Salvo com sucesso!");
        } catch (ValidateException ex) {
            Logger.getLogger(UnidadeFederacaoController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", ex.getMessage());
        } catch (DuplicateKeyException ex) {
            Logger.getLogger(UnidadeFederacaoController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_DUPLICATE_KEY_EXCEPTION);
        } catch (Exception ex) {
            Logger.getLogger(UnidadeFederacaoController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_ERRO_INESPERADO);
        }

        return response;
    }

    @RequestMapping(value = "/unidadeFederacao/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("unidadeFederacaoForm");

        try {
            modelAndView.addObject("unidadeFederacao", unidadeFederacaoService.readById(id));
            modelAndView.addObject("paisList", paisService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(UnidadeFederacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/unidadeFederacao/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            unidadeFederacaoService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(UnidadeFederacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/cadastrosBasicos/unidadeFederacao");
    }
}
