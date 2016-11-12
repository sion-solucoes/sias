/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcb;

import com.sias.model.entity.mcb.Deficiencia;
import com.sias.model.service.mcb.interfaces.DeficienciaService;
import com.sias.util.Constants;
import com.sias.util.GSONConverter;
import com.sias.util.ValidateException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/cadastrosBasicos")
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

    @RequestMapping(value = "/deficiencia/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deficienciaForm");
        try {
        } catch (Exception ex) {
            Logger.getLogger(DocumentoProvidenciavelController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/deficiencia/save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> save(String json) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            Deficiencia deficiencia = (Deficiencia) GSONConverter.convert(json, Deficiencia.class);
            if (deficiencia.getId() == null) {
                deficienciaService.create(deficiencia);
            } else {
                deficienciaService.update(deficiencia);
            }
            response.put("success", true);
            response.put("msg", "Salvo com sucesso!");
        } catch (ValidateException ex) {
            Logger.getLogger(DeficienciaController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", ex.getMessage());
        } catch (DuplicateKeyException ex) {
            Logger.getLogger(DeficienciaController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_DUPLICATE_KEY_EXCEPTION);
        } catch (Exception ex) {
            Logger.getLogger(DeficienciaController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_ERRO_INESPERADO);
        }

        return response;
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

    @RequestMapping(value = "/deficiencia/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            deficienciaService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(DeficienciaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/cadastrosBasicos/deficiencia");
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
