/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.interfaces;

import com.vn.introjava.dao.IGenericDao;
import com.vn.introjava.poo.vehiculos.Coche;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author pc
 */
public interface IDaoCoche extends IGenericDao<Coche>{
    @Override
    Coche crear(Coche nuevoCoche) throws Exception;
    Coche crear(String marca) throws Exception;
    @Override
    Coche obtenerPorIndice(int index);
    Coche obtenerPorMarca(String marca);
    @Override
    Coche modificar (int index, Coche objExistente) throws Exception;
    @Override
    void eliminar(int index);
    
}
