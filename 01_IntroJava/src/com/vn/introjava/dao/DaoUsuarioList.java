/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.interfaces.IDaoUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class DaoUsuarioList implements IDaoUsuario{
    private List<Usuario> listaUsuarios;
    public DaoUsuarioList(){
        listaUsuarios = new ArrayList<>();
    }

    @Override
    public void crear(Usuario nuevoUsuario) {
        listaUsuarios.add(nuevoUsuario);
    }

    @Override
    public Usuario obtenerPorIndice(int edad) {
       return listaUsuarios.get(edad);
    }

    @Override
    public Usuario obtenerPorNombre(String nombre) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void modificar(int index, Usuario objExistente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
