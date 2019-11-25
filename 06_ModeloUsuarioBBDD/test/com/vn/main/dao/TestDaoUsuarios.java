/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.main.dao;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestDaoUsuarios {
    
    public TestDaoUsuarios() {
    }
    

     @Test
     public void testUsuariosInvalidos() {
         
     }
     
     void crearUsuiariosInvalidos(IDaoUsuario daoUsuario) throws Exception{
         daoUsuario.crear(new Usuario("@zaira.es","1234", "Zaira", 28 ));
         daoUsuario.crear(new Usuario("zaira@zaira.es","", "Zaira", 28 ));
         daoUsuario.crear(new Usuario("zaira@zaira.es", "1234", "", 28 ));
         daoUsuario.crear(new Usuario("","1234", "Zaira", 28 ));
         daoUsuario.crear(new Usuario("@zaira.es","1234", "Zaira", 0 ));
     }
     
     void crearUsuiariosValidos(IDaoUsuario daoUsuario) throws Exception{
         daoUsuario.crear(new Usuario("zaira@zaira.es","1234", "Zaira", 28 ));
         daoUsuario.crear(new Usuario("aurea@aurea.es","1234", "Aurea", 26 ));
         daoUsuario.crear(new Usuario("alo@alo.es", "1234", "Álvaro", 28 ));
         daoUsuario.crear(new Usuario("martina@martina.es","1234", "Martina", 28 ));
         daoUsuario.crear(new Usuario("gregorio@gregorio.es","1234", "Gregorio", 83 ));
         
         //assertEquals("Nombre de Prueba", conSQL.leerTabla("Nombre de Prueba").get(0).getNombre());
     }
}
