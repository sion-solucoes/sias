/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.relatorios.impl;

import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.relatorios.RelatorioMensalAtendimento;
import com.sias.model.service.relatorios.interfaces.RelatorioMensalAtendimentoService;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fernando
 */
@Service
public class RelatorioMensalAtendimentoServiceImpl implements RelatorioMensalAtendimentoService {

    @Override
    public RelatorioMensalAtendimento getRelatorioMensalAtendimento(UnidadeAtendimento unidadeAtendimento, Date dataInicial, Date dataFinal) throws Exception {

        RelatorioMensalAtendimento relatorioMensalAtendimento = new RelatorioMensalAtendimento();
        relatorioMensalAtendimento.setUnidadeAtendimento(unidadeAtendimento);
        relatorioMensalAtendimento.setDataInicial(dataInicial);
        relatorioMensalAtendimento.setDataFinal(dataFinal);
        
        return relatorioMensalAtendimento;
    }

}
