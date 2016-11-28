/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.relatorios;

import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.service.mca.interfaces.UnidadeAtendimentoService;
import com.sias.model.service.relatorios.interfaces.RelatorioMensalAtendimentoService;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/relatorios")
public class RelatorioMensalAtendimentoController {

    @Autowired
    private RelatorioMensalAtendimentoService relatorioMensalAtendimentoService;

    @Autowired
    private UnidadeAtendimentoService unidadeAtendimentoService;

    @RequestMapping(value = "/mensal", method = RequestMethod.GET)
    public ModelAndView relatorioMensalAtendimentoService(HttpSession httpSession) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("relatorioMensalAtendimentoForm");

        try {
            UnidadeAtendimento unidadeAtendimento = (UnidadeAtendimento) httpSession.getAttribute("unidadeAtendimentoSessao");
            unidadeAtendimento = unidadeAtendimentoService.readById(unidadeAtendimento.getId());
            Calendar dataInicial = Calendar.getInstance();
            dataInicial.set(Calendar.DAY_OF_MONTH, 1);
            Calendar dataFinal = Calendar.getInstance();
            dataFinal.set(Calendar.DAY_OF_MONTH, dataFinal.getMaximum(Calendar.DAY_OF_MONTH));
            modelAndView.addObject("relatorioMensalAtendimento", relatorioMensalAtendimentoService.getRelatorioMensalAtendimento(unidadeAtendimento, dataInicial.getTime(), dataFinal.getTime()));
        } catch (Exception ex) {
            Logger.getLogger(RelatorioMensalAtendimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

}
