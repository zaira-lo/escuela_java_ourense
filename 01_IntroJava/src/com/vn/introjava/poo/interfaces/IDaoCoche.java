/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.interfaces;

import com.vn.introjava.dao.IGenericDao;
import com.vn.introjava.poo.vehiculos.Coche;

/**
 *
 * @author pc
 */
public interface IDaoCoche extends IGenericDao<Coche>{
    @Override
    void crear(Coche nuevoCoche) throws Exception;
    @Override
    Coche obtenerPorIndice(int index);
    Coche obtenerPorMarca(String marca);
    
}
