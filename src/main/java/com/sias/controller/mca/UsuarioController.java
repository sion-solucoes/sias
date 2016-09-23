/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mca;

import com.sias.controller.mcf.FamiliaMembroController;
import com.sias.model.constants.mca.UsuarioConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.sias.model.entity.mca.Usuario;
import com.sias.model.service.mca.interfaces.UnidadeAtendimentoService;
import com.sias.model.service.mca.interfaces.UsuarioSegurancaService;
import com.sias.model.service.mca.interfaces.UsuarioService;
import com.sias.util.Constants;
import com.sias.util.Criteria;
import com.sias.util.GSONConverter;
import com.sias.util.Relatorio;
import com.sias.util.ValidateException;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleAmbiente")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UnidadeAtendimentoService unidadeAtendimentoService;

    @Autowired
    private UsuarioSegurancaService usuarioSegurancaService;

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public ModelAndView unidadeAtendimento() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usuarioList");
        try {
            modelAndView.addObject("usuarioList", usuarioService.readAll());
            modelAndView.addObject("controleAmbiente", "active toggled");
            modelAndView.addObject("usuario", "active");
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/usuario/novo", method = RequestMethod.GET)
    public ModelAndView novo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usuarioForm");

        try {
            modelAndView.addObject("unidadeAtendimentoList", unidadeAtendimentoService.readAll());
            // modelAndView.addObject("controleAmbiente", "active toggled");
            //modelAndView.addObject("usuario", "active");
        } catch (Exception ex) {
            Logger.getLogger(UnidadeAtendimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/usuario/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usuarioForm");

        try {
            modelAndView.addObject("usuario", usuarioService.readById(id));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/usuario/save", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> save(@RequestParam("json") String json, HttpSession session) {

        Map<String, Object> response = new HashMap<String, Object>();

        try {
            Usuario usuario = (Usuario) GSONConverter.convert(json, Usuario.class);
            if (usuario.getId() == null) {
                usuarioService.create(usuario);
            } else {
                Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioSessao");
                if (usuario.getId() == usuarioSessao.getId()) {
                    session.setAttribute("usuarioSessao", usuario);
                }
                usuarioService.update(usuario);
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

    @RequestMapping(value = "/usuario/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView excluir(@PathVariable Long id) {

        try {
            unidadeAtendimentoService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("redirect:/controleAmbiente/usuario");
    }

    @RequestMapping(value = "/usuario/foto", method = RequestMethod.POST)
    public @ResponseBody
    String foto(@RequestParam("file") MultipartFile file) {

        String base64 = "";

        try {
            byte foto[] = file.getBytes();
            base64 = "data:";
            base64 += file.getContentType();
            base64 += ";base64,";
            BASE64Encoder base64Encoder = new BASE64Encoder();
            base64 += base64Encoder.encode(foto);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return base64;
    }

    @RequestMapping(value = "/usuario/readById", method = RequestMethod.POST)
    public @ResponseBody
    Usuario readById(@RequestParam("id") Long id) {

        try {
            return usuarioService.readById(id);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @RequestMapping(value = "/usuario/readByCriteria", method = RequestMethod.POST)
    public @ResponseBody
    List<Usuario> readByCriteria(String json) {

        try {
            Usuario usuario = (Usuario) GSONConverter.convert(json, Usuario.class);
            List<Criteria> criteriaList = new ArrayList<Criteria>();
            if (usuario != null) {
                Criteria nome = new Criteria();
                nome.setAttribute(UsuarioConstants.NOME);
                nome.setOperation("ILIKE");
                nome.setValue("%" + usuario.getNome() + "%");
                criteriaList.add(nome);
            }
            Criteria tipo = new Criteria();
            tipo.setAttribute(UsuarioConstants.TIPO);
            tipo.setOperation(" = ");
            tipo.setValue(Usuario.TIPO_TECNICO);
            criteriaList.add(tipo);

            return usuarioService.readByCriteria(criteriaList);
        } catch (Exception ex) {
            Logger.getLogger(FamiliaMembroController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @RequestMapping(value = "/usuario/imprimirCodigos", method = RequestMethod.POST)
    public @ResponseBody
    String imprimirCodigos(@RequestParam("json") String json, HttpSession session, HttpServletResponse httpServletResponse) {

        try {
            Usuario usuario = (Usuario) GSONConverter.convert(json, Usuario.class);
            List<Usuario> usuarioList = new ArrayList<Usuario>();
            usuarioList.add(usuario);
            Map<String, Object> parametros = new HashMap<String, Object>();
            String logo = session.getServletContext().getRealPath("/img/logo.png");
            parametros.put("logo", logo);
            InputStream jasper = session.getServletContext().getResourceAsStream("/relatorios/cartaoseguranca.jasper");
            byte relatorio[] = Relatorio.imprimir(jasper, parametros, new JRBeanCollectionDataSource(usuarioList));
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.getOutputStream().write(relatorio);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
