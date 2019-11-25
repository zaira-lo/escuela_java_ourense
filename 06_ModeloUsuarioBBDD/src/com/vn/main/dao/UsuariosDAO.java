/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class UsuariosDAO implements IGenericDao<Usuario>{

    @Override
    public Usuario crear(Usuario nuevoUsu) throws Exception {
        Connection conex = ConexionDerbyDB.obtenerConexion();
        try {

            String sqlQuery = "INSERT INTO usuario (email, password, nombre, edad) VALUES (?, ?, ?, ?)";
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, nuevoUsu.getEmail());
            sentenciaSQL.setString(2, nuevoUsu.getPassword());
            sentenciaSQL.setString(3, nuevoUsu.getNombre());
            sentenciaSQL.setInt(4, nuevoUsu.getEdad());
            sentenciaSQL.executeUpdate();
            
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            try {
                conex.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public Usuario obtenerPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Usuario obtenerPorEmail(String email) {
        
        try (Connection conex = ConexionDerbyDB.obtenerConexion()) {
            String sqlQuery = "SELECT id, email, password, nombre, edad  FROM usuario WHERE email = ? ";
            // Sentencia preparada para evitar SQL injection
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);  
            sentenciaSQL.setString(1, email);
            ResultSet resultado = sentenciaSQL.executeQuery();
            if (resultado.next()) {
                Usuario usu = new Usuario(
                        resultado.getInt(1), 
                        resultado.getString(2), 
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getInt(5));
                return usu;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Usuario obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario modificar(Usuario objConDatosNuevo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
