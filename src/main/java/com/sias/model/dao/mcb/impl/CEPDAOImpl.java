/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcb.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.sias.model.constants.mcb.PaisConstants;
import com.sias.model.constants.mcb.CEPConstants;
import com.sias.model.constants.mcb.MunicipioConstants;
import com.sias.model.constants.mcb.UnidadeFederacaoConstants;
import com.sias.model.dao.mcb.interfaces.CEPDAO;
import com.sias.model.entity.mcb.CEP;
import com.sias.model.rowmapper.mcb.CEPRowMapper;
import com.sias.util.Criteria;
import com.sias.util.JDBCBaseDAO;

/**
 *
 * @author Fernando Laranjo
 */
@Repository
public class CEPDAOImpl extends JDBCBaseDAO implements CEPDAO {

    @Override
    public void create(CEP cep) throws Exception {

        String query = "INSERT INTO " + CEPConstants.TABELA;
        {
            query += "(";
            query += CEPConstants.CODIGO + ", ";
            query += CEPConstants.LOGRADOURO + ", ";
            query += CEPConstants.BAIRRO + ", ";
            query += CEPConstants.MUNICIPIO_ID;
            query += ")";
        }
        query += " VALUES (?, ?, ?, ?)";
        query += " RETURNING " + CEPConstants.ID;

        Object args[] = {cep.getCodigo(), cep.getLogradouro(), cep.getBairro(), cep.getMunicipio() != null ? cep.getMunicipio().getId() : null};

        cep.setId(getTemplate().queryForObject(query, args, Long.class));
    }

    @Override
    public List<CEP> readByCriteria(List<Criteria> criteriaList) throws Exception {

        String query = "SELECT * FROM ";
        query += CEPConstants.TABELA;
        query += " LEFT JOIN ";
        query += MunicipioConstants.TABELA;
        query += " ON " + CEPConstants.MUNICIPIO_ID + " = " + MunicipioConstants.ID;
        query += " LEFT JOIN ";
        query += UnidadeFederacaoConstants.TABELA;
        query += " ON " + MunicipioConstants.UF_ID + " = " + UnidadeFederacaoConstants.ID;
        query += " LEFT JOIN ";
        query += PaisConstants.TABELA;
        query += " ON " + UnidadeFederacaoConstants.PAIS_ID + " = " + PaisConstants.ID;
        query += " WHERE TRUE ";
        if (criteriaList != null) {
            for (Criteria criteria : criteriaList) {
                query += " AND ";
                query += criteria.getAttribute() + " ";
                query += criteria.getOperation() + " ";
                query += criteria.getValue() + " "; 
            }
        }

        return getTemplate().query(query, new CEPRowMapper());
    }

    @Override
    public CEP readById(Long id) throws Exception {

        String query = "SELECT * FROM ";
        query += CEPConstants.TABELA;
        query += " LEFT JOIN ";
        query += MunicipioConstants.TABELA;
        query += " ON " + CEPConstants.MUNICIPIO_ID + " = " + MunicipioConstants.ID;
        query += " LEFT JOIN ";
        query += UnidadeFederacaoConstants.TABELA;
        query += " ON " + MunicipioConstants.UF_ID + " = " + UnidadeFederacaoConstants.ID;
        query += " LEFT JOIN ";
        query += PaisConstants.TABELA;
        query += " ON " + UnidadeFederacaoConstants.PAIS_ID + " = " + PaisConstants.ID;
        query += " WHERE " + CEPConstants.ID + "=?";

        Object args[] = {id};

        return getTemplate().queryForObject(query, args, new CEPRowMapper());
    }

    @Override
    public List<CEP> readAll() throws Exception {

        String query = "SELECT * FROM ";
        query += CEPConstants.TABELA;
        query += " LEFT JOIN ";
        query += MunicipioConstants.TABELA;
        query += " ON " + CEPConstants.MUNICIPIO_ID + " = " + MunicipioConstants.ID;
        query += " LEFT JOIN ";
        query += UnidadeFederacaoConstants.TABELA;
        query += " ON " + MunicipioConstants.UF_ID + " = " + UnidadeFederacaoConstants.ID;
        query += " LEFT JOIN ";
        query += PaisConstants.TABELA;
        query += " ON " + UnidadeFederacaoConstants.PAIS_ID + " = " + PaisConstants.ID;

        return getTemplate().query(query, new CEPRowMapper());
    }

    @Override
    public void update(CEP cep) throws Exception {

        String query = "UPDATE " + CEPConstants.TABELA;
        query += " SET ";
        query += CEPConstants.CODIGO + "=?, ";
        query += CEPConstants.LOGRADOURO + "=?, ";
        query += CEPConstants.BAIRRO + "=?, ";
        query += CEPConstants.MUNICIPIO_ID + "=?";
        query += " WHERE " + CEPConstants.ID + "=?";

        Object args[] = {cep.getCodigo(), cep.getLogradouro(), cep.getBairro(), cep.getMunicipio() != null ? cep.getMunicipio().getId() : null, cep.getId()};

        getTemplate().update(query, args);
    }

    @Override
    public void delete(Long id) throws Exception {

        String query = "DELETE FROM " + CEPConstants.TABELA;
        query += " WHERE " + CEPConstants.ID + "=? ";

        Object args[] = {id};

        getTemplate().update(query, args);
    }

}
