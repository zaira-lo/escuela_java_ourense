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
         daoCoche.crear(new Coche("Coche E"));
         assertEquals(daoCoche.obtenerPorIndice(1).getMarca(), "Coche B");
         assertEquals(daoCoche.obtenerPorMarca("Coche C").getMarca(), "Coche C");
     }
}
