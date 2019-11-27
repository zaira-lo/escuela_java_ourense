/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo.dao;

import com.vn.appusuarios.modelo.Usuario;
import com.vn.appusuarios.modelo.dao.IGenericDao;
import com.vn.appusuarios.modelo.dao.ConexionDerbyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author pc
 */
public class UsuariosDAO implements IGenericDao<Usuario>{

    @Override
    public Usuario crear(Usuario nuevoUsu) throws Exception {
        try(Connection conex = ConexionMySqlDB.obtenerConexion()){  
       
            String sqlQuery = "INSERT INTO usuario (email, password, nombre, edad) VALUES (?, ?, ?, ?)";
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, nuevoUsu.getEmail());
            sentenciaSQL.setString(2, nuevoUsu.getPassword());
            sentenciaSQL.setString(3, nuevoUsu.getNombre());
            sentenciaSQL.setInt(4, nuevoUsu.getEdad());
            sentenciaSQL.executeUpdate();
                      
            nuevoUsu.setId(obtenerPorEmail(nuevoUsu.getEmail()).getId());
            return nuevoUsu;
        }   
    }

    @Override
    public Usuario obtenerPorId(int id) throws Exception {
        try (Connection conex = ConexionMySqlDB.obtenerConexion()) {
            String sqlQuery = "SELECT id, email, password, nombre, edad  FROM usuario WHERE id = ? ";
            
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);
            sentenciaSQL.setInt(1, id);
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
        } 
        return null;
    }    
    
    public Usuario obtenerPorEmail(String email) throws Exception{
        
        try (Connection conex = ConexionMySqlDB.obtenerConexion()) {
            String sqlQuery = "SELECT id, email, password, nombre, edad  FROM usuario WHERE email = ? ";
            
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
        } 
        return null;
    }
    
    @Override
    public ArrayList<Usuario> obtenerTodos() throws Exception {
         
        try (Connection conex = ConexionMySqlDB.obtenerConexion()) {
            String sqlQuery = "SELECT id, email, password, nombre, edad  FROM usuario  ";
            
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);  
            ResultSet resultado = sentenciaSQL.executeQuery();
            ArrayList<Usuario> lista = new ArrayList<>();
            while (resultado.next()) {
                Usuario usu = new Usuario(
                        resultado.getInt(1), 
                        resultado.getString(2), 
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getInt(5));
                lista.add(usu);
            }
            return lista;
        } 

    }

    @Override
    public Usuario modificar(Usuario usuMod) throws Exception {
        try(Connection conex = ConexionMySqlDB.obtenerConexion()){
            
            String sqlQuery = "UPDATE usuario SET email=?, password=?, nombre=?, edad=? WHERE id=?";
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, usuMod.getEmail());
            sentenciaSQL.setString(2, usuMod.getPassword());
            sentenciaSQL.setString(3, usuMod.getNombre());
            sentenciaSQL.setInt(4, usuMod.getEdad());
            sentenciaSQL.setInt(5, usuMod.getId());
            sentenciaSQL.executeUpdate();
        } 
        return null;
    }

    @Override
    public boolean eliminar(int id) throws Exception {
        try (Connection conex = ConexionMySqlDB.obtenerConexion()) {
            String sqlQuery = "DELETE FROM usuario WHERE id=?";
            PreparedStatement sentenciaSQL = conex.prepareStatement(sqlQuery);
            sentenciaSQL.setInt(1, id);
            sentenciaSQL.executeUpdate();
            return true;
        } 
  
    }
    
}
