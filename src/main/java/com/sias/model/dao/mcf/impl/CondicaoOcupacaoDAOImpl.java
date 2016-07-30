/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcf.CondicaoOcupacaoConstants;
import com.sias.model.constants.mcf.GrauParentescoConstants;
import com.sias.model.dao.mcf.interfaces.CondicaoOcupacaoDAO;
import com.sias.model.entity.mcf.CondicaoOcupacao;
import com.sias.model.rowmapper.mcf.CondicaoOcupacaoRowMapper;
import com.sias.model.rowmapper.mcf.GrauParentescoRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class CondicaoOcupacaoDAOImpl extends JDBCBaseDAO implements CondicaoOcupacaoDAO {

    @Override
    public void create(CondicaoOcupacao condicaoOcupacao) throws Exception {

        String query = "INSERT INTO " + CondicaoOcupacaoConstants.TABELA;
        query += "(";
        {
            query += CondicaoOcupacaoConstants.CODIGO + ", ";
            query += CondicaoOcupacaoConstants.DESCRICAO;
        }
        query += ")";
        query += " VALUES (?, ?)";
        query += " RETURNING " + CondicaoOcupacaoConstants.ID;

        Object args[] = {condicaoOcupacao.getCodigo(), condicaoOcupacao.getDescricao()};

        condicaoOcupacao.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<CondicaoOcupacao> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CondicaoOcupacao readById(Long id) throws Exception {

        String query = "SELECT * FROM " + CondicaoOcupacaoConstants.TABELA;
        query += " WHERE " + CondicaoOcupacaoConstants.ID + "=?";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new CondicaoOcupacaoRowMapper());
    }

    @Override
    public List<CondicaoOcupacao> readAll() throws Exception {

        String query = "SELECT * FROM " + CondicaoOcupacaoConstants.TABELA;

        return getTemplate().query(query, new CondicaoOcupacaoRowMapper());
    }

    @Override
    public void update(CondicaoOcupacao condicaoOcupacao) throws Exception {

        String query = "UPDATE " + CondicaoOcupacaoConstants.TABELA;
        query += " SET ";
        query += CondicaoOcupacaoConstants.CODIGO + "=?, ";
        query += CondicaoOcupacaoConstants.DESCRICAO + "=?";
        query += " WHERE ";
        query += CondicaoOcupacaoConstants.ID + "=? ";

        Object args[] = {condicaoOcupacao.getCodigo(), condicaoOcupacao.getDescricao(), condicaoOcupacao.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + CondicaoOcupacaoConstants.TABELA;
        query += " WHERE " + CondicaoOcupacaoConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
