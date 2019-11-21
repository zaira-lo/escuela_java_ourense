/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appweb.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *Servlet que genera una respuesta en formato HTML
 * 
 * @author pc
 */
public class HolaHtmlServlet extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest peticionHttp, 
           HttpServletResponse respuestaHttp) throws IOException{
       //definimos el tipo de contenido según los tipos MIME
       // Formatos conocidos de ficheros para email
       respuestaHttp.setContentType("text/html;charset=UTF-8");
       respuestaHttp.getWriter().print("Hola que pasa");
       //el caso del try sin catch
       //try se encarga de cerrar salida por lo que no hace falta poner salida.close()
       try (PrintWriter salida = respuestaHttp.getWriter()){
            salida.print("<html>");
            salida.print("<head>");
            salida.print("<link rel='stylesheet' href='/AppWebServlts/style.css' type='text/css' media='all'/>");
            salida.print("<title>Web HTML desde Servlet</title>");
            salida.print("</head>");
            salida.print("<body>");
            salida.print("<h1>Web HTML desde Servlet</h1>"+
                         "<h2 class= 'color-rojo'>Hola que pasa</h2>"+
                           "<ul>");
            for (int i = 0; i < 10; i++) {
               salida.print("<li class= 'li_"+i+"'>Iteración " + i + "</li>");
           }
            salida.print("</ul>");
            salida.print("Ruta: " + peticionHttp.getContextPath());
            salida.print("<br>Metodo " + peticionHttp.getMethod());
            salida.print("</body>");
            salida.print("</html>");
       }
   }
    
}
