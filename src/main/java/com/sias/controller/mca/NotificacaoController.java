/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.controller.mca;

import com.sias.model.constants.mcf.FamiliaVisitaConstants;
import com.sias.model.entity.mca.Notificacao;
import com.sias.model.entity.mca.Usuario;
import com.sias.model.entity.mcf.FamiliaVisita;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sias.model.service.mcf.interfaces.FamiliaVisitaService;
import com.sias.util.Criteria;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fernando Laranjo
 */
@Controller
@RequestMapping("/notificacao")
public class NotificacaoController {

    @Autowired
    private FamiliaVisitaService familiaVisitaService;

    @RequestMapping(value = "/verificaNotificacao", method = RequestMethod.POST)
    public @ResponseBody
    List<Notificacao> verificaNotificacao(HttpSession httpSession) {

        List<Notificacao> notificacaoList = new ArrayList<Notificacao>();

        try {
            Usuario usuarioSessao = (Usuario) httpSession.getAttribute("usuarioSessao");
            if (usuarioSessao != null) {
                if (usuarioSessao.getTipo() == Usuario.TIPO_TECNICO) {
                    List<Criteria> criteriaList = new ArrayList<Criteria>();
                    Criteria criteriaTecnico = new Criteria();
                    criteriaTecnico.setAttribute(FamiliaVisitaConstants.USUARIO_ID);
                    criteriaTecnico.setOperation(" = ");
                    criteriaTecnico.setValue(usuarioSessao.getId());
                    criteriaList.add(criteriaTecnico);
                    Criteria criteriaConfirmacao = new Criteria();
                    criteriaConfirmacao.setAttribute(FamiliaVisitaConstants.CONFIRMADA);
                    criteriaConfirmacao.setOperation(" = ");
                    criteriaConfirmacao.setValue(false);
                    criteriaList.add(criteriaConfirmacao);
                    List<FamiliaVisita> familiaVisitaList = familiaVisitaService.readByCriteria(criteriaList);
                    if (familiaVisitaList != null) {
                        for (FamiliaVisita familiaVisita : familiaVisitaList) {
                            Notificacao notificacao = new Notificacao();
                            notificacao.setTitulo("<span class='" + familiaVisita.getCor() + "' style='color: white'>Visita " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(familiaVisita.getInicio()) + "</span>");
                            notificacao.setConteudo("Nova visita para <b>" + familiaVisita.getFamilia().getNomePessoaReferencia() + "</b>.");
                            notificacao.setHref("/controleFamiliar/familiaVisita");
                            notificacaoList.add(notificacao);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return notificacaoList;
    }

}
