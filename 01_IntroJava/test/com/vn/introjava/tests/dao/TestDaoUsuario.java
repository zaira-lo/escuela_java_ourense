/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.dao;

import com.vn.introjava.dao.DaoUsuarioList;
import com.vn.introjava.dao.Usuario;
import com.vn.introjava.poo.interfaces.IDaoUsuario;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestDaoUsuario {
    
   
     @Test
     public void testDaoUsuario() {
         IDaoUsuario daoUsuario = new DaoUsuarioList();
         daoUsuario.crear(new Usuario("Juan", 3));
         daoUsuario.crear(new Usuario("Marta", 4));
         daoUsuario.crear(new Usuario("Hildegart", 21));
         daoUsuario.crear(new Usuario("Dorian", 8));
         assertEquals("Marta", daoUsuario.obtenerPorIndice(1).getNombre());
         assertEquals(8, daoUsuario.obtenerPorNombre("Dorian").getEdad());
     }
     
}
