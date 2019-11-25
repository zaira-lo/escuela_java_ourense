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
public class ConexionDerbyDB {
    public static final String URL_CONEXION= "jdbc:derby://localhost:1527/db_usuarios";
    public static final String USUARIO_DB= "root";
    public static final String PASSWORD_DB = "root";
    private static boolean driversCargados = false;
    
    
     private static void cargarDrivers(){
         try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            } catch (Exception ex) {
                Logger.getLogger(ConexionDerbyDB.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No se ha cargado DerbyDB, excepcion: "+ ex);
            }
     }
     public static Connection obtenerConexion() {
        if (! driversCargados) {
            cargarDrivers();
            driversCargados = true;
        }
        try {
            return DriverManager.getConnection(
                    URL_CONEXION,
                    USUARIO_DB, PASSWORD_DB);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDerbyDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se ha podido conectar");
        }
        return null;
    }
      
    
}
