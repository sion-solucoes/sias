/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mca;

import com.sias.model.constants.mcf.FamiliaConstants;
import com.sias.model.constants.mcf.FamiliaVisitaConstants;
import com.sias.model.entity.mca.UnidadeAtendimento;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.sias.model.entity.mca.Usuario;
import com.sias.model.entity.mca.UsuarioSeguranca;
import com.sias.model.entity.mcf.FamiliaBeneficioEventual;
import com.sias.model.entity.mcf.FamiliaVisita;
import com.sias.model.service.mca.interfaces.UsuarioSegurancaService;
import com.sias.model.service.mca.interfaces.UsuarioService;
import com.sias.model.service.mcf.interfaces.FamiliaBeneficioEventualService;
import com.sias.model.service.mcf.interfaces.FamiliaVisitaService;
import com.sias.util.Criteria;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
public class HomeController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioSegurancaService usuarioSegurancaService;
    
    @Autowired
    private FamiliaBeneficioEventualService familiaBeneficioEventualService;
    
    @Autowired
    private FamiliaVisitaService familiaVisitaService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView base(HttpSession httpSession) {
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView index(HttpSession httpSession) {
        return null;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> home(@RequestParam("email") String email, @RequestParam("senha") String senha, HttpSession httpSession) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            Usuario usuario = usuarioService.readByEmailAndSenha(email, senha);
            Integer numeroSeguranca = new Random().nextInt(10);
            while (numeroSeguranca <= 0 || numeroSeguranca > 10) {
                numeroSeguranca = new Random().nextInt(10);
            }
            response.put("numeroSeguranca", numeroSeguranca);
            response.put("success", true);
        } catch (Exception e) {
            response.put("success", false);
        }

        return response;
    }

    @RequestMapping(value = "/home/verificaSeguranca", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> home(@RequestParam("email") String email, @RequestParam("senha") String senha, @RequestParam("numeroSeguranca") Integer numeroSeguranca, @RequestParam("codigoSeguranca") String codigoSeguranca, HttpSession httpSession) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            Usuario usuario = usuarioService.readByEmailAndSenha(email, senha);
            List<UsuarioSeguranca> usuarioSegurancaList = usuarioSegurancaService.readByUsuarioId(usuario.getId());
            UsuarioSeguranca usuarioSeguranca = usuarioSegurancaList.get(numeroSeguranca - 1);
            if (usuarioSeguranca.getCodigo().equals(codigoSeguranca)) {
                response.put("success", true);
                httpSession.setAttribute("usuarioSessao", usuario);
                httpSession.setAttribute("unidadeAtendimentoSessao", usuario.getUnidadeAtendimento());
            } else {
                response.put("success", false);
            }
        } catch (Exception e) {
            response.put("success", false);
        }

        return response;
    }

    @RequestMapping(value = "/home/loginError", method = RequestMethod.GET)
    public ModelAndView loginError(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginError");
        return modelAndView;
    }

    @RequestMapping(value = "/home/alterarSenha", method = RequestMethod.GET)
    public ModelAndView alterarSenha(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/home/deslogar", method = RequestMethod.GET)
    public ModelAndView deslogar(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        httpSession.invalidate();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ModelAndView auth(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authError");
        return modelAndView;
    }
    
    @RequestMapping(value = "/home/loadBeneficioEventualDataChart", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Long> carregaFamiliaBeneficioEventualGrafico (HttpSession session, Long mesAtual) {
        Map<String, Long> dados = new HashMap<String, Long>();
        Calendar c = Calendar.getInstance();
        UnidadeAtendimento unidadeAtendimento = (UnidadeAtendimento) session.getAttribute("unidadeAtendimentoSessao");
        long qtdeAuxilioNatalidade = 0;
        long qtdeAuxilioFuneral = 0;
        long qtdeSituacoesEmergencia = 0;
        long qtdeCestaBasica = 0;
        long qtdeAluguel = 0;
        long qtdeOutros = 0;
        
        try {
            List<Criteria> familiaCriteriaList = new ArrayList<>();
            Criteria unidadeAtendimentoFamilia = new Criteria();
            unidadeAtendimentoFamilia.setAttribute(FamiliaConstants.UNIDADE_ATENDIMENTO_ID);
            unidadeAtendimentoFamilia.setOperation(Criteria.EQUALS);
            unidadeAtendimentoFamilia.setValue(unidadeAtendimento.getId());
            familiaCriteriaList.add(unidadeAtendimentoFamilia);
            
            List<FamiliaBeneficioEventual> beneficioEventualList = familiaBeneficioEventualService.readByCriteria(familiaCriteriaList);
            for (FamiliaBeneficioEventual familiaBeneficioEventual : beneficioEventualList) {
                c.setTime(familiaBeneficioEventual.getDataConcessao());
                int mes = c.get(Calendar.MONTH) + 1;
                if(mesAtual == mes){
                    if(familiaBeneficioEventual.getId() == 1){
                        qtdeAuxilioNatalidade++;
                    }else if(familiaBeneficioEventual.getId() == 2){
                        qtdeAuxilioFuneral++;
                    }else if(familiaBeneficioEventual.getId() == 3){
                        qtdeSituacoesEmergencia++;
                    }else if(familiaBeneficioEventual.getId() == 4){
                        qtdeCestaBasica++;
                    }else if(familiaBeneficioEventual.getId() == 5){        
                        qtdeAluguel++;
                    }else if(familiaBeneficioEventual.getId() == 6){
                        qtdeOutros++;
                    }
                }
            }
        
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dados.put("auxilioNatalidade", qtdeAuxilioNatalidade);
        dados.put("auxilioFuneral", qtdeAuxilioFuneral);
        dados.put("situacoesEmergencia", qtdeSituacoesEmergencia);
        dados.put("cestaBasica", qtdeCestaBasica);
        dados.put("aluguel", qtdeAluguel);
        dados.put("outros", qtdeOutros);
        
        return dados;
    }

    @RequestMapping(value = "/home/loadFamiliaVisitaDataChart", method = RequestMethod.POST)
    public @ResponseBody
    Integer[] carregaDadosFamiliaVisita (HttpSession session, Long mesAtual) {
        Integer [] visitas = {0, 0, 0, 0, 0, 0, 
                              0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 
                              0, 0, 0, 0, 0, 0, 
                              0, 0, 0, 0, 0, 0, 0, 0};
        UnidadeAtendimento unidadeAtendimento = (UnidadeAtendimento) session.getAttribute("unidadeAtendimentoSessao");
        Calendar c = Calendar.getInstance();
        List<FamiliaVisita> familiaVisitaList = new ArrayList<FamiliaVisita>();
        
        try {
            List<Criteria> criteriaList = new ArrayList<Criteria>();
            Criteria criteriaUnidadeAtendimento = new Criteria();
            criteriaUnidadeAtendimento.setAttribute(FamiliaVisitaConstants.UNIDADE_ATENDIMENTO_ID);
            criteriaUnidadeAtendimento.setOperation(Criteria.EQUALS);
            criteriaUnidadeAtendimento.setValue(unidadeAtendimento.getId());
            criteriaList.add(criteriaUnidadeAtendimento);

            familiaVisitaList = familiaVisitaService.readByCriteria(criteriaList);
            for (FamiliaVisita familiaVisita : familiaVisitaList) {
                c.setTime(familiaVisita.getInicio());
                int mes = c.get(Calendar.MONTH) + 1;
                if(mesAtual == mes){
                    visitas[c.get(Calendar.DAY_OF_MONTH)] = visitas[c.get(Calendar.DAY_OF_MONTH)] + 1;
                }
            }
        } catch (Exception e) {
        }
        return visitas;
    } 
}
