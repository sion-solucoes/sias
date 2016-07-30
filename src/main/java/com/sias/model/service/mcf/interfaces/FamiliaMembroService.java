/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.service.mcf.interfaces;

import java.util.List;
import com.sias.model.base.service.BaseService;
import com.sias.model.entity.mcf.FamiliaMembro;

/**
 *
 * @author Fernando Laranjo
 */
public interface FamiliaMembroService extends BaseService<FamiliaMembro> {

    public List<FamiliaMembro> readFamiliaMembroByFamilia(Long familiaId) throws Exception;

    public void deleteByFamilia(Long familiaId) throws Exception;

}
