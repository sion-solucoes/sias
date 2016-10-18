/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcf;

import com.sias.model.constants.mcf.FamiliaConstants;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.mcf.FamiliaBeneficioEventual;
import com.sias.model.service.mcb.interfaces.BeneficioEventualService;
import com.sias.model.service.mcf.interfaces.FamiliaBeneficioEventualService;
import com.sias.model.service.mcf.interfaces.FamiliaService;
import com.sias.util.Constants;
import com.sias.util.Criteria;
import com.sias.util.GSONConverter;
import com.sias.util.ValidateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

/**
 *
 * @author jaderhenrique
 */
@Controller
@RequestMapping("/controleFamiliar")
public class FamiliaBeneficioEventualController {
    
    @Autowired
    private FamiliaService familiaService;
    
    @Autowired
    private BeneficioEventualService beneficioEventualService;
    
    @Autowired
    private FamiliaBeneficioEventualService familiaBeneficioEventualService;
    
    @RequestMapping(value = "/requisicaoBeneficio", method = RequestMethod.GET)
    public ModelAndView requsicicaoBeneficio (HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("familiaBeneficioEventualList");
        
        try {
            UnidadeAtendimento unidadeAtendimento = (UnidadeAtendimento) session.getAttribute("unidadeAtendimentoSessao");
            
            List<Criteria> familiaCriteriaList = new ArrayList<>();
            Criteria unidadeAtendimentoFamilia = new Criteria();
            unidadeAtendimentoFamilia.setAttribute(FamiliaConstants.UNIDADE_ATENDIMENTO_ID);
            unidadeAtendimentoFamilia.setOperation(Criteria.EQUALS);
            unidadeAtendimentoFamilia.setValue(unidadeAtendimento.getId());
            familiaCriteriaList.add(unidadeAtendimentoFamilia);
            mv.addObject("familiaBeneficioList", familiaBeneficioEventualService.readByCriteria(familiaCriteriaList));
        } catch (Exception e) {
            Logger.getLogger(FamiliaBeneficioEventualController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return mv;
    }
    
    @RequestMapping(value = "/requisicaoBeneficio/novo", method = RequestMethod.GET)
    public ModelAndView novo (HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("familiaRequisicaoBeneficioEventualForm");
        
        try {
            UnidadeAtendimento unidadeAtendimento = (UnidadeAtendimento) session.getAttribute("unidadeAtendimentoSessao");
            
            List<Criteria> familiaCriteriaList = new ArrayList<Criteria>();
            Criteria unidadeAtendimentoFamilia = new Criteria();
            unidadeAtendimentoFamilia.setAttribute(FamiliaConstants.UNIDADE_ATENDIMENTO_ID);
            unidadeAtendimentoFamilia.setOperation(Criteria.EQUALS);
            unidadeAtendimentoFamilia.setValue(unidadeAtendimento.getId());
            mv.addObject("familiaList", familiaService.readByCriteria(familiaCriteriaList));
           
            
            mv.addObject("beneficioEventualList", beneficioEventualService.readAll());
            
            
        } catch (Exception e) {
            Logger.getLogger(FamiliaBeneficioEventualController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return mv;
    }
    
    @RequestMapping(value = "/requisicaoBeneficio/save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> save (@RequestParam("json") String json, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            FamiliaBeneficioEventual familiaBeneficioEventual = (FamiliaBeneficioEventual) GSONConverter.convert(json, FamiliaBeneficioEventual.class);
            familiaBeneficioEventualService.create(familiaBeneficioEventual);
            response.put("success", true);
            response.put("msg", "Salvo com sucesso!");
        }catch (ValidateException e){
            response.put("success", false);
            response.put("msg", e.getMessage());
        }catch (Exception e) {
            Logger.getLogger(FamiliaController.class.getName()).log(Level.SEVERE, null, e);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_ERRO_INESPERADO);
        }
        
        return response;
    }
    
    @RequestMapping(value = "/requisicaoBeneficio/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir (@PathVariable Long id) {
        
        try {
            familiaBeneficioEventualService.delete(id);
        } catch (Exception e) {
            Logger.getLogger(FamiliaBeneficioEventualController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return new ModelAndView("redirect:/controleFamiliar/requisicaoBeneficio");
    }
    
}
