/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mca;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sias.model.entity.mca.Usuario;
import com.sias.model.entity.mca.UsuarioSeguranca;
import com.sias.model.service.mca.interfaces.UsuarioSegurancaService;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleAmbiente")
public class UsuarioSegurancaController {

    @Autowired
    private UsuarioSegurancaService usuarioSegurancaService;

    @RequestMapping(value = "/usuarioSeguranca/gerarCodigos", method = RequestMethod.POST)
    public @ResponseBody
    List<String> gerarCodigos() {

        List<String> codigoList = new ArrayList<String>();

        try {
            for (int indexCodigos = 0; indexCodigos < 10; indexCodigos++) {
                codigoList.add(usuarioSegurancaService.gerarCodigo());
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioSegurancaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return codigoList;
    }

    @RequestMapping(value = "/usuarioSeguranca/readByUsuarioId", method = RequestMethod.POST)
    public @ResponseBody
    List<UsuarioSeguranca> findByUsuarioId(Long usuarioId) {

        try {
            return usuarioSegurancaService.readByUsuarioId(usuarioId);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioSegurancaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @RequestMapping(value = "/usuarioSeguranca/imprimirCodigos", method = RequestMethod.POST)
    public @ResponseBody
    void imprimirCodigos(@RequestParam("id") Long id) {

        try {
            usuarioSegurancaService.readByUsuarioId(id);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioSegurancaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
