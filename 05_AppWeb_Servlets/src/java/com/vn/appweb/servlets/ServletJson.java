/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appweb.servlets;

import com.google.gson.Gson;
import com.vn.appweb.modelo.DatosPersonales;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
public class ServletJson extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
       response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("{");
            out.println("\"nombre\": \"Zaira Lopez Arias\",");
            out.println("\"edad\": 28,");
            out.println("\"fibonacci\":[1,1,2,3,4,8] ");
            out.println("}");
            
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
         response.setContentType("application/json;charset=UTF-8");
         
         String nombre = request.getParameter("nombre");
         String email = request.getParameter("email");
         
        try (PrintWriter out = response.getWriter()) {
            DatosPersonales dper = new DatosPersonales();
            dper.setNombre("Nombre desde GSON: " + nombre.toUpperCase());
            dper.setEmail("Email: " + email);
            dper.setFibonacci(new int[]{1,1,2,3,5,8,13});
            
            Gson gson = new Gson();
            String datosJSON = gson.toJson(dper);
            out.println(datosJSON);
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
