/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.dao;

import com.vn.introjava.dao.DaoCocheList;
import com.vn.introjava.dao.DaoCocheMap;
import com.vn.introjava.poo.interfaces.IDaoCoche;
import com.vn.introjava.poo.vehiculos.Coche;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestDaoCocheSimple {
    
   
     @Test
     public void testDaoCocheList() throws Exception {
          testInterfaceDaoCoche(new DaoCocheList());
     }
     
     @Test
     public void testDaoCocheMap() throws Exception{
         testInterfaceDaoCoche(new DaoCocheMap());
     }
     
     void testInterfaceDaoCoche(IDaoCoche daoCoche) throws Exception{     
         daoCoche.crear(new Coche("Coche A"));
         daoCoche.crear(new Coche("Coche B"));
         daoCoche.crear(new Coche("Coche C"));
         daoCoche.crear(new Coche("Coche D"));
        
         Coche cc = daoCoche.crear("Coche C");
         assertEquals( "Coche B", daoCoche.obtenerPorIndice(1).getMarca());
         assertEquals("Coche C", daoCoche.obtenerPorMarca("Coche C").getMarca());
         
        
         Coche modificar = new Coche("Coche B ahora X");
         daoCoche.modificar(1, modificar);
         assertEquals("Coche B ahora X", daoCoche.obtenerPorIndice(1).getMarca());
         assertEquals("Coche B ahora X", daoCoche.obtenerPorMarca("Coche B ahora X").getMarca());
         
         modificar= new Coche("Coche C");
         modificar.arrancar();
         daoCoche.modificar(2, modificar);
         assertEquals(modificar.isArrancado(), cc.isArrancado());
         
         daoCoche.eliminar(1);// Eliminar el B
         daoCoche.eliminar(daoCoche.obtenerPorMarca("Coche A"));
         
         assertNull(daoCoche.obtenerPorMarca("Coche A"));
         daoCoche.eliminar(new Coche("Coche A"));
         

         if(daoCoche instanceof DaoCocheList)
             assertEquals("Coche D", daoCoche.obtenerPorIndice(1).getMarca());
         else
             assertEquals("Coche C", daoCoche.obtenerPorIndice(2).getMarca());
         
     }
}
