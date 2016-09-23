/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcb.DocumentoProvidenciavelConstants;
import com.sias.model.constants.mcf.FamiliaMembroDocumentoProvidenciavelConstants;
import com.sias.model.dao.mcf.interfaces.FamiliaMembroDocumentoProvidenciavelDAO;
import com.sias.model.entity.mcb.DocumentoProvidenciavel;
import com.sias.model.entity.mcf.FamiliaMembroDocumentoProvidenciavel;
import com.sias.model.rowmapper.mcb.DocumentoProvidenciavelRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class FamiliaMembroDocumentoProvidenciavelDAOImpl extends JDBCBaseDAO implements FamiliaMembroDocumentoProvidenciavelDAO {

    @Override
    public void create(FamiliaMembroDocumentoProvidenciavel familiaMembroDocumentoProvidenciavel) throws Exception {

        String query = "INSERT INTO " + FamiliaMembroDocumentoProvidenciavelConstants.TABELA;
        query += "(";
        {
            query += FamiliaMembroDocumentoProvidenciavelConstants.FAMILIA_MEMBRO_ID + ", ";
            query += FamiliaMembroDocumentoProvidenciavelConstants.DOCUMENTO_PROVIDENCIAVEL_ID;
        }
        query += ")";
        query += " VALUES (?, ?)";
        query += " RETURNING " + FamiliaMembroDocumentoProvidenciavelConstants.ID;

        Object args[] = {familiaMembroDocumentoProvidenciavel.getFamiliaMembro() != null ? familiaMembroDocumentoProvidenciavel.getFamiliaMembro().getId() : null,
            familiaMembroDocumentoProvidenciavel.getDocumentoProvidenciavel() != null ? familiaMembroDocumentoProvidenciavel.getDocumentoProvidenciavel().getId() : null};

        familiaMembroDocumentoProvidenciavel.setId(getTemplate().queryForObject(query, args, Long.class));
        
    }

    @Override
    public List<FamiliaMembroDocumentoProvidenciavel> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FamiliaMembroDocumentoProvidenciavel readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FamiliaMembroDocumentoProvidenciavel> readAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(FamiliaMembroDocumentoProvidenciavel e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DocumentoProvidenciavel> readDocumentoProvidenciavelByFamiliaMembro(Long familiaMembroId) throws Exception {

        String query = "SELECT * FROM " + DocumentoProvidenciavelConstants.TABELA;
        query += " WHERE " + DocumentoProvidenciavelConstants.ID;
        query += " IN (";
        {
            query += " SELECT " + FamiliaMembroDocumentoProvidenciavelConstants.DOCUMENTO_PROVIDENCIAVEL_ID;
            query += " FROM " + FamiliaMembroDocumentoProvidenciavelConstants.TABELA;
            query += " WHERE " + FamiliaMembroDocumentoProvidenciavelConstants.FAMILIA_MEMBRO_ID + "=? ";
        }
        query += ")";

        Object args[] = {familiaMembroId};

        return getTemplate().query(query, args, new DocumentoProvidenciavelRowMapper());
    }

    @Override
    public void deleteByFamiliaMembro(Long familiaMembroId) throws Exception {

        String query = "DELETE FROM " + FamiliaMembroDocumentoProvidenciavelConstants.TABELA;
        query += " WHERE " + FamiliaMembroDocumentoProvidenciavelConstants.FAMILIA_MEMBRO_ID + "=? ";

        Object args[] = {familiaMembroId};

        getTemplate().update(query, args);
    }

}
