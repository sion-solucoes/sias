/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.relatorios.impl;

import com.sias.model.dao.relatorios.interfaces.RelatorioMensalAtendimentoDAO;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.relatorios.RelatorioMensalAtendimento;
import com.sias.model.service.relatorios.interfaces.RelatorioMensalAtendimentoService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fernando
 */
@Service
public class RelatorioMensalAtendimentoServiceImpl implements RelatorioMensalAtendimentoService {

    @Autowired
    private RelatorioMensalAtendimentoDAO relatorioMensalAtendimentoDAO;

    @Override
    public RelatorioMensalAtendimento getRelatorioMensalAtendimento(UnidadeAtendimento unidadeAtendimento, Date dataInicial, Date dataFinal) throws Exception {
        return relatorioMensalAtendimentoDAO.getRelatorioMensalAtendimento(unidadeAtendimento, dataInicial, dataFinal);
    }

}
