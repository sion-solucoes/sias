/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.model.base.service;

import java.util.List;
import com.sias.util.Criteria;

/**
 *
 * @author Fernando Laranjo
 */
public interface BaseService<E> {
    
    public void create(E e) throws Exception;
    
    public List<E> readByCriteria(List<Criteria> criteriaList) throws Exception;
    
    public E readById(Long id) throws Exception;
    
    public List<E> readAll() throws Exception;
    
    public void update(E e) throws Exception;
    
    public void delete(Long id) throws Exception;
    
    public void validate(E e) throws Exception;
}
