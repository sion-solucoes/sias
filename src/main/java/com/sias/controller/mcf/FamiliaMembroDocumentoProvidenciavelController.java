/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcf;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sias.controller.mca.UnidadeAtendimentoController;
import com.sias.model.entity.mcf.DocumentoProvidenciavel;
import com.sias.model.service.mcf.interfaces.FamiliaMembroDocumentoProvidenciavelService;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleFamiliar")
public class FamiliaMembroDocumentoProvidenciavelController {

    @Autowired
    private FamiliaMembroDocumentoProvidenciavelService familiaMembroDocumentoProvidenciavelService;

    @RequestMapping(value = "/familiaMembroDocumentoProvidenciavel/readDocumentoProvidenciavelByFamiliaMembro", method = RequestMethod.POST)
    public @ResponseBody
    List<DocumentoProvidenciavel> readByUsuarioIdId(Long familiaMembroId) {

        try {
            return familiaMembroDocumentoProvidenciavelService.readDocumentoProvidenciavelByFamiliaMembro(familiaMembroId);
        } catch (Exception ex) {
            Logger.getLogger(UnidadeAtendimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    

}
