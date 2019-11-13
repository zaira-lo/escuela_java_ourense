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
    public Usuario crear(Usuario nuevoUsuario) throws Exception {
        listaUsuarios.add(nuevoUsuario);	
        return nuevoUsuario;
    }
    
    public Usuario crear (String nom, int edad) throws Exception{
        return crear(new Usuario(nom, edad));
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
    public Usuario modificar(int index, Usuario usuarioConDatos) throws Exception {
        Usuario usuarioAModificar = listaUsuarios.get(index);
        usuarioAModificar.setEdad(usuarioConDatos.getEdad());
        usuarioAModificar.setNombre(usuarioConDatos.getNombre());
        return usuarioAModificar;
    }

    @Override
    public void eliminar(int index) {
        this.listaUsuarios.remove(index);
    }

    @Override
    public void eliminar(Usuario objEliminar) {
       this.listaUsuarios.remove(objEliminar);
    }

}
