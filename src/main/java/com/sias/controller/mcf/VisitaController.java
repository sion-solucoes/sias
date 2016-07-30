/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mcf;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/controleFamiliar")
public class VisitaController {

    @RequestMapping(value = "/visita", method = RequestMethod.GET)
    public ModelAndView familia() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("visitaCalendar");
        try {
        } catch (Exception ex) {
            Logger.getLogger(VisitaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelAndView;
    }

}
