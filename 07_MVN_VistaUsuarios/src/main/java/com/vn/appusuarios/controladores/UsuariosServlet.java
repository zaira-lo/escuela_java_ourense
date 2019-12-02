/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.controladores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vn.appusuarios.modelo.Usuario;
import com.vn.appusuarios.modelo.logica.ServicioUsuarios;

/**
 *s�lo hay una instancia por aplicaci�n, que se ejecuta en su propio hilo
 *Todos los usuarios comparten el mismo servlet/jsp o derivados
 *
 * @author pc
 */
public class UsuariosServlet extends HttpServlet {
	
	private ServicioUsuarios srvUsu;
	
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		 this.srvUsu = new ServicioUsuarios();
	}

	/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        
        //En el objeto peiticion le pasamos nuestro servicio de usuarios(este servlet)
        request.setAttribute("servicioUsu", this.srvUsu);
        try {
           
            srvUsu.setChivatoListener((String mensaje) -> {
                
                request.getSession().setAttribute("mensajeError", 
                        "ERROR al crear: "+ mensaje);
            });

            if (request.getMethod() == "POST") {
                Usuario usuario = srvUsu.crear(email, password, nombre, edad);

                if (usuario != null && usuario.getId() >= 0) {
                    request.getSession().setAttribute("usuario", usuario);
                    request.getRequestDispatcher("registrado.jsp")
                            .forward(request, response);
                }else{
                    request.getRequestDispatcher("registrarse.jsp")
                            .forward(request, response);
                }
            }else if(request.getMethod()== "GET") {
            	Usuario usuario = srvUsu.leerUno(email);
            	request.getSession().setAttribute("usuario", usuario);
            }

        } catch (Exception ex) {
            Logger.getLogger(UsuariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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
        processRequest(request, response);

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

        processRequest(request, response);

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
