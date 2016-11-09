/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcf;

import com.sias.model.constants.mca.UsuarioConstants;
import com.sias.model.constants.mcf.FamiliaConstants;
import com.sias.model.constants.mcf.FamiliaVisitaConstants;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.mca.Usuario;
import com.sias.model.entity.mcf.FamiliaVisita;
import com.sias.model.service.mca.interfaces.UsuarioService;
import com.sias.model.service.mcf.interfaces.FamiliaService;
import com.sias.model.service.mcf.interfaces.FamiliaVisitaService;
import com.sias.util.Constants;
import com.sias.util.Criteria;
import com.sias.util.GSONConverter;
import com.sias.util.ValidateException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Fernando
 */
@Controller
@RequestMapping("/controleFamiliar")
public class FamiliaVisitaController {

    @Autowired
    private FamiliaVisitaService familiaVisitaService;

    @Autowired
    private FamiliaService familiaService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/familiaVisita", method = RequestMethod.GET)
    public ModelAndView familiaVisita(HttpSession httpSession) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("familiaVisitaCalendar");

        try {
            UnidadeAtendimento unidadeAtendimento = (UnidadeAtendimento) httpSession.getAttribute("unidadeAtendimentoSessao");

            List<Criteria> familiaCriteriaList = new ArrayList<Criteria>();
            Criteria unidadeAtendimentoFamilia = new Criteria();
            unidadeAtendimentoFamilia.setAttribute(FamiliaConstants.UNIDADE_ATENDIMENTO_ID);
            unidadeAtendimentoFamilia.setOperation(Criteria.EQUALS);
            unidadeAtendimentoFamilia.setValue(unidadeAtendimento.getId());
            modelAndView.addObject("familiaList", familiaService.readByCriteria(familiaCriteriaList));

            List<Criteria> usuarioCriteriaList = new ArrayList<Criteria>();
            Criteria tipoUsuario = new Criteria();
            tipoUsuario.setAttribute(UsuarioConstants.TIPO);
            tipoUsuario.setOperation(Criteria.EQUALS);
            tipoUsuario.setValue(Usuario.TIPO_TECNICO);
            usuarioCriteriaList.add(tipoUsuario);

            Criteria unidadeAtendimentoUsuario = new Criteria();
            unidadeAtendimentoUsuario.setAttribute(UsuarioConstants.UNIDADE_ATENDIMENTO_ID);
            unidadeAtendimentoUsuario.setOperation(Criteria.EQUALS);
            unidadeAtendimentoUsuario.setValue(unidadeAtendimento.getId());
            usuarioCriteriaList.add(unidadeAtendimentoUsuario);

            modelAndView.addObject("usuarioList", usuarioService.readByCriteria(usuarioCriteriaList));
        } catch (Exception ex) {
            Logger.getLogger(FamiliaVisitaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/familiaVisita/save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> save(@RequestParam("json") String json, HttpSession httpSession) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            UnidadeAtendimento unidadeAtendimento = (UnidadeAtendimento) httpSession.getAttribute("unidadeAtendimentoSessao");
            FamiliaVisita familiaVisita = (FamiliaVisita) GSONConverter.convert(json, FamiliaVisita.class);
            familiaVisita.setUnidadeAtendimento(unidadeAtendimento);
            familiaVisitaService.create(familiaVisita);
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

    @RequestMapping(value = "/familiaVisita/find", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> find(@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm") @RequestParam("inicio") Date inicio, @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm") @RequestParam("fim") Date fim, HttpSession httpSession) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            List<Criteria> criteriaList = new ArrayList<Criteria>();

            Criteria criteriaDataInicio = new Criteria();
            criteriaDataInicio.setAttribute(FamiliaVisitaConstants.INICIO);
            criteriaDataInicio.setOperation(Criteria.BIGGER_OR_EQUALS_THEN);
            criteriaDataInicio.setValue(inicio);
            criteriaList.add(criteriaDataInicio);

            Criteria criteriaDataFim = new Criteria();
            criteriaDataFim.setAttribute(FamiliaVisitaConstants.FIM);
            criteriaDataFim.setOperation(Criteria.LESS_OR_EQUALS_THEN);
            criteriaDataFim.setValue(fim);
            criteriaList.add(criteriaDataFim);

            UnidadeAtendimento unidadeAtendimento = (UnidadeAtendimento) httpSession.getAttribute("unidadeAtendimentoSessao");
            Criteria criteriaUnidadeAtendimento = new Criteria();
            criteriaUnidadeAtendimento.setAttribute(FamiliaVisitaConstants.UNIDADE_ATENDIMENTO_ID);
            criteriaUnidadeAtendimento.setOperation(Criteria.EQUALS);
            criteriaUnidadeAtendimento.setValue(fim);
            criteriaUnidadeAtendimento.setValue(unidadeAtendimento.getId());
            criteriaList.add(criteriaUnidadeAtendimento);

            response.put("familiaVisitaList", familiaVisitaService.readByCriteria(criteriaList));
            response.put("success", true);
        } catch (Exception e) {
            Logger.getLogger(FamiliaVisitaController.class.getName()).log(Level.SEVERE, null, e);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_ERRO_INESPERADO);
        }

        return response;
    }

    @RequestMapping(value = "/familiaVisita/confirm", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> confirm(@RequestParam("id") Long id, HttpSession httpSession) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            familiaVisitaService.confirm(id);
            response.put("success", true);
        } catch (Exception e) {
            Logger.getLogger(FamiliaVisitaController.class.getName()).log(Level.SEVERE, null, e);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_ERRO_INESPERADO);
        }

        return response;
    }

    @RequestMapping(value = "/familiaVisita/disconfirm", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> disconfirm(@RequestParam("id") Long id, HttpSession httpSession) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            familiaVisitaService.confirm(id);
            response.put("success", true);
        } catch (Exception e) {
            Logger.getLogger(FamiliaVisitaController.class.getName()).log(Level.SEVERE, null, e);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_ERRO_INESPERADO);
        }

        return response;
    }

    @RequestMapping(value = "/familiaVisita/delete", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> delete(@RequestParam("id") Long id, HttpSession httpSession) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            familiaVisitaService.delete(id);
            response.put("success", true);
        } catch (Exception e) {
            Logger.getLogger(FamiliaVisitaController.class.getName()).log(Level.SEVERE, null, e);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_ERRO_INESPERADO);
        }

        return response;
    }

}
