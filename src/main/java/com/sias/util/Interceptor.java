package com.sias.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.sias.model.entity.mca.Usuario;
import com.sias.model.service.mca.interfaces.UsuarioService;

public class Interceptor implements HandlerInterceptor {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3) throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView modelAndView) throws Exception {

        String url = req.getRequestURL().toString();

        if (url.endsWith("/sias/home")) {
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

        if (url.contains("css") || url.contains("fonts") || url.contains("img") || url.contains("js") || url.contains("less")) {
            return true;
        }

        if (url.endsWith("/sias/home/loginError")) {
            return true;
        }

        if (url.endsWith("/sias")) {
            if (req.getSession().getAttribute("usuarioSessao") == null) {
                res.sendRedirect("/sias/home");
                return false;
            }
        }

        if (!url.endsWith("/sias/home") && !url.endsWith("/sias/home/verificaSeguranca")) {
            if (req.getSession().getAttribute("usuarioSessao") == null) {
                req.getSession().setAttribute("urlDesejada", url);
                res.sendRedirect("/sias");
                return false;
            }
        }

        if (req.getSession().getAttribute("usuarioSessao") != null) {
            Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioSessao");
            usuario = usuarioService.readById(usuario.getId());
            req.getSession().setAttribute("usuarioSessao", usuario);
            if (usuario.getTipo() == Usuario.TIPO_ADMINISTRATIVO) {
                if (url.contains("controleFamiliar")) {
                    res.sendRedirect("/sias/auth");
                    return false;
                }
                if (url.contains("controleAmbiente")) {
                    res.sendRedirect("/sias/auth");
                    return false;
                }
            }
            if (usuario.getTipo() == Usuario.TIPO_TECNICO) {
                if (url.contains("controleAmbiente")) {
                    res.sendRedirect("/sias/auth");
                    return false;
                }
            }
        }

        return true;
    }
}
