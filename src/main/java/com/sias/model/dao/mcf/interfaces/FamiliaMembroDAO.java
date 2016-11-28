/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.dao.mcf.interfaces;

import java.util.List;
import com.sias.model.base.dao.BaseDAO;
import com.sias.model.entity.mcf.FamiliaMembro;

/**
 *
 * @author Fernando Laranjo
 */
public interface FamiliaMembroDAO extends BaseDAO<FamiliaMembro> {

    public List<FamiliaMembro> readFamiliaMembroByFamilia(Long familiaId) throws Exception;

    public void deleteByFamiliaNotInList(Long familiaId, List<Long> listId) throws Exception;

}
