/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.main.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public Usuario crear(String email, String password, String nombre, int edad) throws Exception {
        Pattern patternEmail = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Pattern patternNombre = Pattern
                .compile("\"^[A-Z][a-z]+$\"");
        if (email != null && password.length() > 4 && nombre != null && edad > 12) {
            Matcher matherEmail = patternEmail.matcher(email);
            Matcher matherNombre = patternNombre.matcher(nombre);
            for (Usuario usuario : listaUsuario) {
                if (email == usuario.getEmail()) {
                    return null;
                } else {
                    if (matherEmail.find() == false) {
                        return null;
                    } else if (matherNombre.find() == false) {
                        return null;
                    } else {
                        crear(new Usuario(email, password, nombre, edad));
                    }
                }
            }
        }
        return null;
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
