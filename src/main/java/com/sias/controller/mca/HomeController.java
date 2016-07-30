/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mca;

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
import com.sias.model.service.mca.interfaces.UsuarioSegurancaService;
import com.sias.model.service.mca.interfaces.UsuarioService;

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

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView base(HttpSession httpSession) {
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView index(HttpSession httpSession) {
        return null;
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

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
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

    @RequestMapping(value = "/controleFamiliar", method = RequestMethod.GET)
    public ModelAndView controleFamiliar() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("controleFamiliar");
        return modelAndView;
    }

    @RequestMapping(value = "/controleAmbiente", method = RequestMethod.GET)
    public ModelAndView controleAmbiente() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("controleAmbiente");
        return modelAndView;
    }

    @RequestMapping(value = "/cadastrosBasicos", method = RequestMethod.GET)
    public ModelAndView cadastrosBasicos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cadastrosBasicos");
        return modelAndView;
    }

}
