/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.main.dao;

import java.util.ArrayList;

/**
 *
 * @author Equipo 13
 * @param <T>
 */
public interface IGenericDao<T> {
    public abstract T crear(T objetoNuevo) throws Exception;
    
    T obtenerPorId(int id);
    ArrayList<T> obtenerTodos();
    
    T modificar( T objConDatosNuevo)throws Exception;
    
    boolean eliminar(int id);

    
}  
