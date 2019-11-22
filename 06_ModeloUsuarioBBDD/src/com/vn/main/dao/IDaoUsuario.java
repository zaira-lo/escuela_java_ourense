/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.main.dao;

/**
 *
 * @author Equipo 13
 */
public interface IDaoUsuario extends IGenericDao<Usuario>{
    
    public Usuario obtenerPorEmail(String email);
}
