/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo.logica;

import com.vn.appusuarios.modelo.Usuario;
import com.vn.appusuarios.modelo.Usuario;
import com.vn.appusuarios.modelo.dao.UsuariosDAO;
import com.vn.appusuarios.modelo.logica.ChivatoServicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Equipo 13
 */
public class ServicioUsuarios {

    UsuariosDAO daoUsu;
    ChivatoServicios chivato;

    public ServicioUsuarios() {
        daoUsu = new UsuariosDAO(); 
    }
    
    public void setChivatoListener(ChivatoServicios chivato){
        this.chivato = chivato;
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
                    notificarError("crear: Debe tener formato de correo electrónico");
                    return null;
                } else if (matherNombre.find() == false) {
                    notificarError("crear: El nombre solo admite caracteres alfabéticos");
                    return null;
                } else {
                    try {
                        int iEdad = Integer.parseInt(edad);
                        if (iEdad >= 12) {
                            Usuario usuario = new Usuario(-1, email, password, nombre, iEdad);
                            return usuario;
                        } else {
                             notificarError("crear: La edad no puede ser menor de 12: " + edad);
                            return null;
                        }
                    } catch (NumberFormatException e) {
                        notificarError("crear: La edad no se puede parsear a int: " + edad
                        + " error: " + e.getMessage());
                        return null;
                    }
                }
            } else {
                notificarError("crear: Hay un campo que no cumple la longitud");
                return null;
            }
        } else {
            notificarError("crear: No admite NULOS");
            return null;
        }
    }
    
    void notificarError(String mensajeError){
        System.out.println("Error ServicioUsuario: "+ mensajeError);
        if(chivato != null){
            chivato.notificarError(mensajeError);
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
    public Usuario crear(String email, String password, String nombre, String edad){
        Usuario nuevoUsu = crearUsuarioValido(email, password, nombre, edad);
        if (nuevoUsu != null) {
            try {
                nuevoUsu = daoUsu.crear(nuevoUsu);
            } catch (Exception ex) {
                Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                notificarError("crear: " +ex.getMessage());
            }
            return nuevoUsu;
        }
        return null;
    }

    public Usuario leerUno(int id) {
        try {
            return daoUsu.obtenerPorId(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("leerUno id: " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("leerUno id: " + ex.getMessage());
        }
        return null;
    }

    public Usuario leerUno(String email) {
        try {
            return daoUsu.obtenerPorEmail(email);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("leerUno email: " +ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("leerUno email: " +ex.getMessage());
        }
        return null;
    }
    
    public Usuario modificar(int id, String email, String password, String nombre, String edad) {
        Usuario usuMod = crearUsuarioValido(email, password, nombre, edad);
        if (usuMod != null) {
            usuMod.setId(id);
            try {
                usuMod = daoUsu.modificar(usuMod);
            } catch (Exception ex) {
                Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                notificarError("Modificar: "+ ex.getMessage());
            }
            return usuMod;
        }
        return null;
    }
    
    public boolean eliminar(int id) {
        try {
            return daoUsu.eliminar(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("eliminar: " +ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("eliminar: " +ex.getMessage());
        }
        return false;
    }
    
    public ArrayList<Usuario> leerTodos(){
        try {
            return daoUsu.obtenerTodos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("leerTodos: " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            notificarError("leerTodos: " + ex.getMessage());
        }
        return null;
    }
    
    

}
