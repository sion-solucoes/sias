/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mca;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.service.mca.interfaces.UsuarioUnidadeAtendimentoService;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleAmbiente")
public class UsuarioUnidadeAtendimentoController {

    @Autowired
    private UsuarioUnidadeAtendimentoService usuarioUnidadeAtendimentoService;

    @RequestMapping(value = "/usuarioUnidadeAtendimento/readUnidadeAtendimentoByUsuario", method = RequestMethod.POST)
    public @ResponseBody
    List<UnidadeAtendimento> readByUsuarioIdId(Long usuarioId) {

        try {
            return usuarioUnidadeAtendimentoService.readUnidadeAtendimentoByUsuario(usuarioId);
        } catch (Exception ex) {
            Logger.getLogger(UnidadeAtendimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
