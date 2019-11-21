/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Creando un formulario y recibiendo sus campos como parámetros
 * @author pc
 */
public class ParamServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // 
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Form y Param</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParamServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2>Formulario de registro</h2>");
            out.println("<form name='formDatos' action='formulario' method='post'>");
            out.println("<label>Nombre </label>");
            out.println("<input id='nombre' type='text'name='nombre'required/>");
            out.println("<label>Email </label>");
            out.println("<input id='email' type='email'name='email' required/>");
            out.println("<input type='submit' value='envia formulario'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Form y Param</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParamServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2>Formulario de registro</h2>");
            //Campos a recibir
            String valorNombre= request.getParameter("nombre");
            String valorEmail= request.getParameter("email");
            out.println("</form>");
            if(valorNombre == null||"".equals(valorNombre)|| valorEmail == null||"".equals(valorEmail)){
                out.println("<p style='color:red'>No se ha recibido el parámetro</p>");
            }else{
                out.println("<p style='color:green'>Nombre: "+valorNombre.toUpperCase()+"</p>");
                out.println("<p style='color:green'>Email: "+valorEmail.toLowerCase()+"</p>");
            }
            //Vamos a insertar los datos recibidos:
            //jdbc:derby://localhost:1527/db_prueba
            try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            } catch (Exception ex) {
                Logger.getLogger(ParamServlet.class.getName()).log(Level.SEVERE, null, ex);
                 out.println("<p style='color:red'>No se ha cargado DerbyDB</p>");
            }
            
            try(Connection con = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/db_prueba", 
                    "root", 
                    "1234")){
                
                String sqlyQuery ="INSERT INTO PERSONA (nombre, email) VALUES ('"+valorNombre+"', '"+valorEmail+"')";
                Statement sentenciaSQL= con.createStatement();
                sentenciaSQL.executeUpdate(sqlyQuery);
            } catch (SQLException ex) {
                Logger.getLogger(ParamServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.println("<p style='color:red'>Error sql:"+ ex.getMessage()+
                        "</p>");
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
        
    }
//<editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet que envia formulario y recibe los parámetros";
    }// </editor-fold>

}
