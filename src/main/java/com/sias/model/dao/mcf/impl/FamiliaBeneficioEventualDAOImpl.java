/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.impl;

import com.sias.model.constants.mcb.BeneficioEventualConstants;
import com.sias.model.constants.mcf.FamiliaBeneficioEventualConstants;
import com.sias.model.constants.mcf.FamiliaConstants;
import com.sias.model.dao.mcf.interfaces.FamiliaBeneficioEventualDAO;
import com.sias.model.entity.mcf.FamiliaBeneficioEventual;
import com.sias.model.rowmapper.mcf.FamiliaBeneficioEventualRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaderhenrique
 */
@Repository
public class FamiliaBeneficioEventualDAOImpl extends JDBCBaseDAO implements FamiliaBeneficioEventualDAO{

    @Override
    public void create(FamiliaBeneficioEventual familiaBeneficioEventual) throws Exception {
        
        String query = "INSERT INTO " + FamiliaBeneficioEventualConstants.TABELA;
        query += "(";
        {
            query += FamiliaBeneficioEventualConstants.BENEFICIO_EVENTUAL_ID + ", ";
            query += FamiliaBeneficioEventualConstants.FAMILIA_ID + ", ";
            query += FamiliaBeneficioEventualConstants.DATA_SOLICITACAO + ", ";
            query += FamiliaBeneficioEventualConstants.DATA_CONCESSAO;
        }
        query += ")";
        query += " VALUES (?, ?, ?, ?)";
        query += " RETURNING " + FamiliaBeneficioEventualConstants.ID;
        
        Object args[] = {
            familiaBeneficioEventual.getBeneficioEventual() != null ? familiaBeneficioEventual.getBeneficioEventual().getId() : null,
            familiaBeneficioEventual.getFamilia() != null ? familiaBeneficioEventual.getFamilia().getId() : null,
            familiaBeneficioEventual.getDataSolicitacao(),
            familiaBeneficioEventual.getDataConcessao()
        };
        
        familiaBeneficioEventual.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<FamiliaBeneficioEventual> readByCriteria(List<Criteria> criteriaList) throws Exception {
        String query = "SELECT * FROM " + FamiliaBeneficioEventualConstants.TABELA;
        query += " LEFT JOIN " + FamiliaConstants.TABELA;
        query += " ON " + FamiliaBeneficioEventualConstants.FAMILIA_ID + " = " + FamiliaConstants.ID;
        query += " LEFT JOIN " + BeneficioEventualConstants.TABELA;
        query += " ON " + FamiliaBeneficioEventualConstants.BENEFICIO_EVENTUAL_ID + " = " + BeneficioEventualConstants.ID;
        query += " WHERE TRUE ";
        
        List<Object> args = new ArrayList<>();
        if(criteriaList != null){
            for(Criteria criteria : criteriaList){
                query += " AND ";
                query += criteria.getAttribute() + " ";
                query += criteria.getOperation() + " ? ";
                args.add(criteria.getValue());
            }
        }
        
        query += " ORDER BY " + FamiliaConstants.ID;
        
        return getTemplate().query(query, args.toArray(), new FamiliaBeneficioEventualRowMapper());
    }

    @Override
    public FamiliaBeneficioEventual readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FamiliaBeneficioEventual> readAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(FamiliaBeneficioEventual e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) throws Exception {
        
        String query = "DELETE FROM " + FamiliaBeneficioEventualConstants.TABELA;
        query += " WHERE " + FamiliaBeneficioEventualConstants.ID + " = ?";
        Object args[] = {id};
        getTemplate().update(query, args);
    }
    
}
