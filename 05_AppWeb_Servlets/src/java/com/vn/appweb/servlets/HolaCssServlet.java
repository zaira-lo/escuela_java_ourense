/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
public class HolaCssServlet extends HolaHtmlServlet{
    
    @Override
    protected void doGet(HttpServletRequest peticionHttp, 
           HttpServletResponse respuestaHttp) throws IOException{
        respuestaHttp.setContentType("text/css");
        try (PrintWriter salida = respuestaHttp.getWriter()){
            salida.print(".color-rojo{color:red}");
            for (int i = 0; i < 10; i++) {
                salida.print(".li_"+i+"{font-size:"+i+"em }");
            }
       }
        
    }
    
}
