/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.impl;

import com.sias.model.constants.mcf.FamiliaConstants;
import com.sias.model.constants.mcf.FamiliaVisitaConstants;
import com.sias.model.dao.mcf.interfaces.FamiliaVisitaDAO;
import com.sias.model.entity.mcf.FamiliaVisita;
import com.sias.model.rowmapper.mcf.FamiliaVisitaRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fernando
 */
@Repository
public class FamiliaVisitaDAOImpl extends JDBCBaseDAO implements FamiliaVisitaDAO {

    @Override
    public void create(FamiliaVisita familiaVisita) throws Exception {

        String query = "INSERT INTO " + FamiliaVisitaConstants.TABELA;
        query += "(";
        {
            query += FamiliaVisitaConstants.UNIDADE_ATENDIMENTO_ID + ", ";
            query += FamiliaVisitaConstants.FAMILIA_ID + ", ";
            query += FamiliaVisitaConstants.USUARIO_ID + ", ";
            query += FamiliaVisitaConstants.INICIO + ", ";
            query += FamiliaVisitaConstants.FIM + ", ";
            query += FamiliaVisitaConstants.COR;
        }
        query += ")";
        query += " VALUES (?, ?, ?, ?, ?, ?)";
        query += " RETURNING " + FamiliaVisitaConstants.ID;

        Object args[] = {
            familiaVisita.getUnidadeAtendimento() != null ? familiaVisita.getUnidadeAtendimento().getId() : null,
            familiaVisita.getFamilia() != null ? familiaVisita.getFamilia().getId() : null,
            familiaVisita.getUsuario() != null ? familiaVisita.getUsuario().getId() : null,
            familiaVisita.getInicio(),
            familiaVisita.getFim(),
            familiaVisita.getCor()};

        familiaVisita.setId(getTemplate().queryForObject(query, args, Long.class));

    }

    @Override
    public List<FamiliaVisita> readByCriteria(List<Criteria> criteriaList) throws Exception {

        String query = "SELECT * FROM " + FamiliaVisitaConstants.TABELA;
        query += " LEFT JOIN " + FamiliaConstants.TABELA;
        query += " ON " + FamiliaVisitaConstants.FAMILIA_ID + " = " + FamiliaConstants.ID;
        query += " WHERE TRUE ";
        List<Object> args = new ArrayList<Object>();
        if (criteriaList != null) {
            for (Criteria criteria : criteriaList) {
                query += " AND ";
                query += criteria.getAttribute() + " ";
                query += criteria.getOperation() + " ? ";
                args.add(criteria.getValue());
            }
        }

        return getTemplate().query(query, args.toArray(), new FamiliaVisitaRowMapper());
    }

    @Override
    public FamiliaVisita readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FamiliaVisita> readAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(FamiliaVisita e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + FamiliaVisitaConstants.TABELA;
        query += " WHERE " + FamiliaVisitaConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

    @Override
    public void confirm(Long id) throws Exception {

        String query = "UPDATE " + FamiliaVisitaConstants.TABELA;
        query += " SET ";
        query += FamiliaVisitaConstants.CONFIRMADA + "=TRUE ";
        query += " WHERE ";
        query += FamiliaVisitaConstants.ID + "=?";

        Object args[] = {id};

        getTemplate().update(query, args);
    }
    
    @Override
    public void disconfirm(Long id) throws Exception {

        String query = "UPDATE " + FamiliaVisitaConstants.TABELA;
        query += " SET ";
        query += FamiliaVisitaConstants.CONFIRMADA + "=FALSE ";
        query += " WHERE ";
        query += FamiliaVisitaConstants.ID + "=?";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
