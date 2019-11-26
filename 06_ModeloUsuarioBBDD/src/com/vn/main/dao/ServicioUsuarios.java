/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Equipo 13
 */
public class ServicioUsuarios {

    UsuariosDAO daoUsu;

    public ServicioUsuarios() {
        daoUsu = new UsuariosDAO();
    }

    /**
     * Función para validar usuarios: primero comprobar que ninguno de los
     * parámetros es nulo, segundo comprobar que tienen una longitud mínima
     * despues comprobar con expresiones regulares por ultimo comprobar que edad
     * sea mayor que 12
     *
     * @param email
     * @param password
     * @param nombre
     * @param edad
     * @return
     */
    public Usuario crearUsuarioValido(String email, String password, String nombre, String edad) {

        if (email != null && password != null && nombre != null && edad != null) {
            if (email.length() >= 3
                    && nombre.length() > 1
                    && 3 < password.length()
                    && !"".equals(edad)) {
                String regexEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
                Pattern patternEmail = Pattern.compile(regexEmail);

                Pattern patternNombre = Pattern
                        .compile("^[A-Z][a-z0-9]+ ?[A-Za-z0-9]*$");
                Matcher matherEmail = patternEmail.matcher(email);
                Matcher matherNombre = patternNombre.matcher(nombre);
                if (matherEmail.find() == false) {
                    System.out.println("Debe tener formato de correo electrónico");
                    return null;
                } else if (matherNombre.find() == false) {
                    System.out.println("El nombre solo admite caracteres alfabéticos");
                    return null;
                } else {
                    try {
                        int iEdad = Integer.parseInt(edad);
                        if (iEdad > 12) {
                            Usuario usuario = new Usuario(-1, email, password, nombre, iEdad);
                            return usuario;
                        } else {
                            return null;
                        }
                    } catch (Exception e) {
                        System.out.println("La edad no se puede parsear a int: " + edad);
                        return null;
                    }
                }
            } else {
                System.out.println("Hay un campo que no cumple la longitud");
                return null;
            }
        } else {
            System.out.println("No admite NULOS");
            return null;
        }
    }

    /**
     *
     * @param email
     * @param password
     * @param nombre
     * @param edad
     * @return
     * @throws Exception
     */
    public Usuario crear(String email, String password, String nombre, String edad) throws Exception {
        Usuario nuevoUsu = crearUsuarioValido(email, password, nombre, edad);
        if (nuevoUsu != null) {
            nuevoUsu = daoUsu.crear(nuevoUsu);
            return nuevoUsu;
        }
        return null;
    }

    public Usuario leerUno(int id) {
        return daoUsu.obtenerPorId(id);
    }

    public Usuario leerUno(String email) {
        return daoUsu.obtenerPorEmail(email);
    }
    
    public Usuario modificar(int id, String email, String password, String nombre, String edad) throws Exception{
        Usuario usuMod = crearUsuarioValido(email, password, nombre, edad);
        if (usuMod != null) {
            usuMod.setId(id);
            usuMod = daoUsu.modificar(usuMod);
            return usuMod;
        }
        return null;
    }
    
    public boolean eliminar(int id) {
        return daoUsu.eliminar(id);
    }
    
    public ArrayList<Usuario> leerTodos(){
        return daoUsu.obtenerTodos();
    }
    
    

}
