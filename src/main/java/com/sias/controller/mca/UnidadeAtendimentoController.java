/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.service.mca.interfaces.UnidadeAtendimentoService;
import com.sias.model.service.mcb.interfaces.CEPService;
import com.sias.util.Constants;
import com.sias.util.GSONConverter;
import com.sias.util.ValidateException;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleAmbiente")
public class UnidadeAtendimentoController {

    @Autowired
    private UnidadeAtendimentoService unidadeAtendimentoService;

    @Autowired
    private CEPService cepService;

    @RequestMapping(value = "/unidadeAtendimento", method = RequestMethod.GET)
    public ModelAndView unidadeAtendimento() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("unidadeAtendimentoList");
        try {
            modelAndView.addObject("unidadeAtendimentoList", unidadeAtendimentoService.readAll());
            modelAndView.addObject("controleAmbiente", "active toggled");
            modelAndView.addObject("unidadeAtendimento", "active");
        } catch (Exception ex) {
            Logger.getLogger(UnidadeAtendimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/unidadeAtendimento/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("unidadeAtendimentoForm");
        try {
            modelAndView.addObject("cepList", cepService.readAll());

        } catch (Exception ex) {
            Logger.getLogger(UnidadeAtendimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/unidadeAtendimento/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("unidadeAtendimentoForm");

        try {
            modelAndView.addObject("unidadeAtendimento", unidadeAtendimentoService.readById(id));
        } catch (Exception ex) {
            Logger.getLogger(UnidadeAtendimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/unidadeAtendimento/save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> save(@RequestParam("json") String json) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            UnidadeAtendimento unidadeAtendimento = (UnidadeAtendimento) GSONConverter.convert(json, UnidadeAtendimento.class);
            if (unidadeAtendimento.getId() == null) {
                unidadeAtendimentoService.create(unidadeAtendimento);
            } else {
                unidadeAtendimentoService.update(unidadeAtendimento);
            }
            response.put("success", true);
            response.put("msg", "Salvo com sucesso!");
        } catch (ValidateException ex) {
            response.put("success", false);
            response.put("msg", ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            response.put("success", false);
            response.put("msg", Constants.MENSAGEM_ERRO_INESPERADO);
        }

        return response;
    }

    @RequestMapping(value = "/unidadeAtendimento/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            unidadeAtendimentoService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(UnidadeAtendimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleAmbiente/unidadeAtendimento");
    }

    @RequestMapping(value = "/unidadeAtendimento/readAll", method = RequestMethod.POST)
    public @ResponseBody
    List<UnidadeAtendimento> readAll() {

        try {
            return unidadeAtendimentoService.readAll();
        } catch (Exception ex) {
            Logger.getLogger(UnidadeAtendimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
