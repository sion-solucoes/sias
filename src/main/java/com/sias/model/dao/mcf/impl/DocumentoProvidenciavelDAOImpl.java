/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcf.DocumentoProvidenciavelConstants;
import com.sias.model.dao.mcf.interfaces.DocumentoProvidenciavelDAO;
import com.sias.model.entity.mcf.DocumentoProvidenciavel;
import com.sias.model.rowmapper.mcf.DocumentoProvidenciavelRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class DocumentoProvidenciavelDAOImpl extends JDBCBaseDAO implements DocumentoProvidenciavelDAO {

    @Override
    public void create(DocumentoProvidenciavel documentoProvidenciavel) throws Exception {

        String query = "INSERT INTO " + DocumentoProvidenciavelConstants.TABELA;
        query += "(";
        {
            query += DocumentoProvidenciavelConstants.CODIGO + ", ";
            query += DocumentoProvidenciavelConstants.DESCRICAO;
        }
        query += ")";
        query += " VALUES (?, ?)";
        query += " RETURNING " + DocumentoProvidenciavelConstants.ID;

        Object args[] = {documentoProvidenciavel.getCodigo(), documentoProvidenciavel.getDescricao()};

        documentoProvidenciavel.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<DocumentoProvidenciavel> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DocumentoProvidenciavel readById(Long id) throws Exception {

        String query = "SELECT * FROM " + DocumentoProvidenciavelConstants.TABELA;
        query += " WHERE " + DocumentoProvidenciavelConstants.ID + "=?";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new DocumentoProvidenciavelRowMapper());
    }

    @Override
    public List<DocumentoProvidenciavel> readAll() throws Exception {

        String query = "SELECT * FROM " + DocumentoProvidenciavelConstants.TABELA;

        return getTemplate().query(query, new DocumentoProvidenciavelRowMapper());
    }

    @Override
    public void update(DocumentoProvidenciavel documentoProvidenciavel) throws Exception {

        String query = "UPDATE " + DocumentoProvidenciavelConstants.TABELA;
        query += " SET ";
        query += DocumentoProvidenciavelConstants.CODIGO + "=?, ";
        query += DocumentoProvidenciavelConstants.DESCRICAO + "=? ";
        query += " WHERE ";
        query += DocumentoProvidenciavelConstants.ID + "=? ";

        Object args[] = {documentoProvidenciavel.getCodigo(), documentoProvidenciavel.getDescricao(), documentoProvidenciavel.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + DocumentoProvidenciavelConstants.TABELA;
        query += " WHERE " + DocumentoProvidenciavelConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
