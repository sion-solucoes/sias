/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mca.interfaces;

import java.util.List;
import com.sias.model.base.dao.BaseDAO;
import com.sias.model.entity.mca.UnidadeAtendimento;
import com.sias.model.entity.mca.UsuarioUnidadeAtendimento;

/**
 *
 * @author Fernando Laranjo
 */
public interface UsuarioUnidadeAtendimentoDAO extends BaseDAO<UsuarioUnidadeAtendimento> {

    public List<UnidadeAtendimento> readUnidadeAtendimentoByUsuario(Long usuarioId) throws Exception;

    public void deleteByUsuario(Long usuarioId) throws Exception;

}
