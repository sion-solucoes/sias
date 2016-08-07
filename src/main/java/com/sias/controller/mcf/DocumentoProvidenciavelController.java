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
import com.sias.model.entity.mcf.DocumentoProvidenciavel;
import com.sias.model.service.mcf.interfaces.DocumentoProvidenciavelService;
import com.sias.util.GSONConverter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleFamiliar")
public class DocumentoProvidenciavelController {

    @Autowired
    private DocumentoProvidenciavelService documentoProvidenciavelService;

    @RequestMapping(value = "/documentoProvidenciavel", method = RequestMethod.GET)
    public ModelAndView documentoProvidenciavel() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("documentoProvidenciavelList");
        try {
            modelAndView.addObject("documentoProvidenciavelList", documentoProvidenciavelService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(DocumentoProvidenciavelController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/documentoProvidenciavel/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("documentoProvidenciavelForm");
        try {
        } catch (Exception ex) {
            Logger.getLogger(DocumentoProvidenciavelController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/documentoProvidenciavel/save", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> save (String json) {

        Map<String, Object> response = new HashMap<String, Object>();
        
        try {
            DocumentoProvidenciavel documentoProvidenciavel = (DocumentoProvidenciavel) GSONConverter.convert(json, DocumentoProvidenciavel.class);
            documentoProvidenciavelService.create(documentoProvidenciavel);
            response.put("success", true);
            response.put("msg", "Salvo com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(DocumentoProvidenciavelController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", ex.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/documentoProvidenciavel/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("documentoProvidenciavelForm");

        try {
            modelAndView.addObject("documentoProvidenciavel", documentoProvidenciavelService.readById(id));
        } catch (Exception ex) {
            Logger.getLogger(DocumentoProvidenciavelController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/documentoProvidenciavel/{id}/editar", method = RequestMethod.POST)
    public ModelAndView editar(@ModelAttribute DocumentoProvidenciavel documentoProvidenciavel) {

        try {
            documentoProvidenciavelService.update(documentoProvidenciavel);
        } catch (Exception ex) {
            Logger.getLogger(DocumentoProvidenciavelController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/documentoProvidenciavel");
    }

    @RequestMapping(value = "/documentoProvidenciavel/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            documentoProvidenciavelService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(DocumentoProvidenciavelController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/documentoProvidenciavel");
    }

    @RequestMapping(value = "/documentoProvidenciavel/readAll", method = RequestMethod.POST)
    public @ResponseBody
    List<DocumentoProvidenciavel> readAll() {

        try {
            return documentoProvidenciavelService.readAll();
        } catch (Exception ex) {
            Logger.getLogger(DocumentoProvidenciavelController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
