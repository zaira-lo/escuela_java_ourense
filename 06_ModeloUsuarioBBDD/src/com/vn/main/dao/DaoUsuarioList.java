/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.main.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo 13
 */
public class DaoUsuarioList implements IDaoUsuario {

    private List<Usuario> listaUsuario;

    public DaoUsuarioList() {
        listaUsuario = new ArrayList<>();
    }

    @Override
    public Usuario crear(Usuario nuevoUsuario) throws Exception {
        listaUsuario.add(nuevoUsuario);
        return nuevoUsuario;
    }

    public Usuario crear(int id, String email, String password, String nombre, int edad) throws Exception {
        return crear(new Usuario(id, email, password, nombre, edad));
    }

    @Override
    public Usuario obtenerPorIndice(int id) {
        return listaUsuario.get(id);
    }

    @Override
    public Usuario obtenerPorEmail(String email) {
        for (Usuario usuario : listaUsuario) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario obtenerTodos(int id, String email, String password, String nombre, int edad) {
        for (Usuario usuario : listaUsuario) {
            return usuario;
        }
        return null;
    }

    @Override
    public Usuario modificar(int id, Usuario usuarioDatosNuevo) throws Exception {
        Usuario usuarioAmodificar = listaUsuario.get(id);
        usuarioAmodificar.setEdad(usuarioDatosNuevo.getEdad());
        usuarioAmodificar.setEmail(usuarioDatosNuevo.getEmail());
        usuarioAmodificar.setNombre(usuarioDatosNuevo.getNombre());
        usuarioAmodificar.setPassword(usuarioDatosNuevo.getPassword());
        return usuarioAmodificar;
    }

    @Override
    public void eliminar(int id) {
        this.listaUsuario.remove(id);
    }

    public void eliminar(String email) {
        this.listaUsuario.remove(email);
    }


}
