/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.main.dao;

/**
 *
 * @author Equipo 13
 * @param <T>
 */
public interface IGenericDao<T> {
    public abstract T crear(T objetoNuevo) throws Exception;
    
    T obtenerPorIndice(int index);
    
    T modificar(int index, T objConDatosNuevo)throws Exception;
    
    void eliminar(int index);

    
}  
