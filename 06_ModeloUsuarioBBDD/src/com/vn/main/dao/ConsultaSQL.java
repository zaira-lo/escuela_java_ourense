/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class ConsultaSQL {
     public ConsultaSQL(){
         try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            } catch (Exception ex) {
                System.out.println("No se ha cargado DerbyDB");
            }
     }
       
        public List<Usuario> leerTabla(String busq){ 
        ArrayList<Usuario> datos = new ArrayList<>();
        busq= busq==null ? "": busq;
        try(Connection con = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/db_usuarios", 
                    "root", "1234")){
              
                String sqlyQuery ="SELECT nombre, email FROM persona WHERE UPPER(TRIM(nombre)) LIKE ? ESCAPE '!'";
                //sentencia preparada para evitar SQL injection
                PreparedStatement sentenciaSQL = con.prepareStatement(sqlyQuery);
                busq= busq.toUpperCase().trim();
                busq= busq.replace("!", "!!");
                busq= busq.replace("%", "!%");
                busq= busq.replace("_", "!_");
                busq= busq.replace("[", "![");
                sentenciaSQL.setString(1, "%" + busq + "%"); //sustituir el primer interrogante por (contenido del nombre)
                ResultSet resultado = sentenciaSQL.executeQuery();
                while (resultado.next()) {
                    String nombre = resultado.getString("nombre");//1
                    String email = resultado.getString("email");//2
                    String password = resultado.getString("password");
                    int edad = resultado.getInt("edad");
                    int id = resultado.getInt("id");
                    Usuario us = new Usuario(id, nombre, email, password, edad);
                    us.setEdad(edad);
                    us.setEmail(email);
                    us.setNombre(nombre);
                    us.setPassword(password);
                }
                return datos;
            } catch (SQLException ex) {
                 System.out.println("No se ha cargado DerbyDB: " + ex);
            }
        return null;
    }
    
    
}
