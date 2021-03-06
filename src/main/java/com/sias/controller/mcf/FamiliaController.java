/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcf;

import com.sias.model.constants.mcf.FamiliaConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.mcf.Familia;
import com.sias.model.service.mcb.interfaces.DocumentoProvidenciavelService;
import com.sias.model.service.mcf.interfaces.FamiliaService;
import com.sias.util.Constants;
import com.sias.util.Criteria;
import com.sias.util.GSONConverter;
import com.sias.util.ValidateException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleFamiliar")
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @Autowired
    private DocumentoProvidenciavelService documentoProvidenciavelService;

    @RequestMapping(value = "/familia", method = RequestMethod.GET)
    public ModelAndView familia(HttpSession httpSession) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("familiaList");
        try {
            UnidadeAtendimento unidadeAtendimento = (UnidadeAtendimento) httpSession.getAttribute("unidadeAtendimentoSessao");
            List<Criteria> familiaCriteriaList = new ArrayList<Criteria>();
            Criteria unidadeAtendimentoFamilia = new Criteria();
            unidadeAtendimentoFamilia.setAttribute(FamiliaConstants.UNIDADE_ATENDIMENTO_ID);
            unidadeAtendimentoFamilia.setOperation(Criteria.EQUALS);
            unidadeAtendimentoFamilia.setValue(unidadeAtendimento.getId());
            modelAndView.addObject("familiaList", familiaService.readByCriteria(familiaCriteriaList));
        } catch (Exception ex) {
            Logger.getLogger(FamiliaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/familia/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("familiaForm");
        try {
            modelAndView.addObject("documentoProvidenciavelList", documentoProvidenciavelService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(FamiliaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/familia/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("familiaForm");

        try {
            modelAndView.addObject("familia", familiaService.readById(id));
            modelAndView.addObject("documentoProvidenciavelList", documentoProvidenciavelService.readAll());
        } catch (Exception ex) {
            Logger.getLogger(FamiliaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/familia/save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> save(@RequestParam("json") String json, HttpSession httpSession) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            UnidadeAtendimento unidadeAtendimento = (UnidadeAtendimento) httpSession.getAttribute("unidadeAtendimentoSessao");
            Familia familia = (Familia) GSONConverter.convert(json, Familia.class);

            familia.setUnidadeAtendimento(unidadeAtendimento);

            if (familia.getId() == null) {
                familiaService.create(familia);
            } else {
                familiaService.update(familia);
            }
            response.put("success", true);
            response.put("msg", "Salvo com sucesso!");
        } catch (ValidateException ex) {
            response.put("success", false);
            response.put("msg", ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(FamiliaController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_ERRO_INESPERADO);
        }

        return response;
    }

    @RequestMapping(value = "/familia/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            familiaService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(FamiliaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleFamiliar/familia");
    }

}
