/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcb.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcb.PaisConstants;
import com.sias.model.constants.mcb.MunicipioConstants;
import com.sias.model.constants.mcb.UnidadeFederacaoConstants;
import com.sias.model.dao.mcb.interfaces.MunicipioDAO;
import com.sias.model.entity.mcb.Municipio;
import com.sias.model.rowmapper.mcb.MunicipioRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class MunicipioDAOImpl extends JDBCBaseDAO implements MunicipioDAO {

    @Override
    public void create(Municipio municipio) throws Exception {

        String query = "INSERT INTO " + MunicipioConstants.TABELA;
        {
            query += "(";
            query += MunicipioConstants.DESCRICAO + ", ";
            query += MunicipioConstants.CODIGO_IBGE + ", ";
            query += MunicipioConstants.UF_ID;
            query += ")";
        }
        query += " VALUES (?, ?, ?)";
        query += " RETURNING " + MunicipioConstants.ID;

        Object args[] = {municipio.getDescricao(), municipio.getCodigoIBGE(), municipio.getUnidadeFederacao() != null ? municipio.getUnidadeFederacao().getId() : null};

        municipio.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<Municipio> readByCriteria(List<Criteria> criteriaList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Municipio readById(Long id) throws Exception {

        String query = "SELECT * FROM ";
        query += MunicipioConstants.TABELA;
        query += " LEFT JOIN ";
        query += UnidadeFederacaoConstants.TABELA;
        query += " ON " + MunicipioConstants.UF_ID + " = " + UnidadeFederacaoConstants.ID;
        query += " LEFT JOIN ";
        query += PaisConstants.TABELA;
        query += " ON " + UnidadeFederacaoConstants.PAIS_ID + " = " + PaisConstants.ID;
        query += " WHERE " + MunicipioConstants.ID + "=?";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new MunicipioRowMapper());
    }

    @Override
    public List<Municipio> readAll() throws Exception {

        String query = "SELECT * FROM ";
        query += MunicipioConstants.TABELA;
        query += " LEFT JOIN ";
        query += UnidadeFederacaoConstants.TABELA;
        query += " ON " + MunicipioConstants.UF_ID + " = " + UnidadeFederacaoConstants.ID;
        query += " LEFT JOIN ";
        query += PaisConstants.TABELA;
        query += " ON " + UnidadeFederacaoConstants.PAIS_ID + " = " + PaisConstants.ID;

        return getTemplate().query(query, new MunicipioRowMapper());
    }

    @Override
    public void update(Municipio municipio) throws Exception {

        String query = "UPDATE " + MunicipioConstants.TABELA;
        query += " SET ";
        query += MunicipioConstants.DESCRICAO + "=?, ";
        query += MunicipioConstants.CODIGO_IBGE + "=?, ";
        query += MunicipioConstants.UF_ID + "=? ";
        query += " WHERE " + MunicipioConstants.ID + "=?";

        Object args[] = {municipio.getDescricao(), municipio.getCodigoIBGE(), municipio.getUnidadeFederacao() != null ? municipio.getUnidadeFederacao().getId() : null, municipio.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + MunicipioConstants.TABELA;
        query += " WHERE " + MunicipioConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
