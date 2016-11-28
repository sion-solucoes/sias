/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.relatorios.interfaces;

import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.relatorios.RelatorioMensalAtendimento;
import java.util.Date;

/**
 *
 * @author Fernando
 */
public interface RelatorioMensalAtendimentoService {
    
    public RelatorioMensalAtendimento getRelatorioMensalAtendimento(UnidadeAtendimento unidadeAtendimento, Date dataInicial, Date dataFinal) throws Exception;
    
    
}
