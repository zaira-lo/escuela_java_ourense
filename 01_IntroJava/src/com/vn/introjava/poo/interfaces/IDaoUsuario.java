/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.interfaces;

import com.vn.introjava.dao.IGenericDao;
import com.vn.introjava.dao.Usuario;

/**
 *
 * @author pc
 */
public interface IDaoUsuario extends IGenericDao<Usuario>{
    public Usuario obtenerPorNombre(String nombre);
    
}
