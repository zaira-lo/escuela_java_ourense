/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.dao;

/**
 *
 * @author Equipo 13
 */
public interface IGenericDao<T> {
    public abstract T crear(T objetoNuevo) throws Exception;
    
}
