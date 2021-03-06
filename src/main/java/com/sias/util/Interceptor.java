package com.sias.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.sias.model.entity.mca.Usuario;
import com.sias.model.service.mca.interfaces.UsuarioService;
import org.springframework.web.bind.annotation.RequestMethod;

public class Interceptor implements HandlerInterceptor {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3) throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView modelAndView) throws Exception {

        String url = req.getRequestURL().toString();

        url = url.replace("/sias", "");

        if (url.endsWith("/home")) {
            if (req.getSession().getAttribute("usuarioSessao") != null) {
                String urlDesejada = (String) req.getSession().getAttribute("urlDesejada");
                if (urlDesejada != null) {
                    req.getSession().setAttribute("urlDesejada", null);
                    res.sendRedirect(urlDesejada);
                }
            }
        }

    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {

        String url = req.getRequestURL().toString();

        url = url.replace("/sias", "");

        System.out.println(url);

        if (url.contains("css") || url.contains("fonts") || url.contains("img") || url.contains("js") || url.contains("less")) {
            return true;
        }

        if (url.endsWith("/home/loginError")) {
            return true;
        }

        if ((url.endsWith("/home") || url.endsWith("/home/verificaSeguranca")) && req.getMethod().equals("POST")) {
            return true;
        }

        if (req.getSession().getAttribute("usuarioSessao") == null) {
            req.getSession().setAttribute("urlDesejada", url);
            res.sendRedirect("/");
            return false;
        } else {
            Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioSessao");
            usuario = usuarioService.readById(usuario.getId());
            req.getSession().setAttribute("usuarioSessao", usuario);
            if (usuario.getTipo() == Usuario.TIPO_ADMINISTRATIVO) {
                if (url.contains("controleFamiliar")) {
                    res.sendRedirect("/auth");
                    return false;
                }
                if (url.contains("controleAmbiente")) {
                    res.sendRedirect("/auth");
                    return false;
                }
            }
            if (usuario.getTipo() == Usuario.TIPO_TECNICO) {
                if (url.contains("controleAmbiente")) {
                    res.sendRedirect("/auth");
                    return false;
                }
            }
        }

        return true;
    }
}
