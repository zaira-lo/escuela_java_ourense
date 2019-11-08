/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheRally;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbarColecciones {
    
    public ProbarColecciones() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    
     @Test
     public void testArrayListNoGenerica() {
         ArrayList lista = new ArrayList();
         lista.add(new Object());
         lista.add(new Coche("Coche"));
         lista.add("Un texto");
         lista.add(100);
         for (int i = 0; i < lista.size(); i++) {
             System.out.println("Elemen [" + i + "] = " + lista.get(i).toString());
         }
     }
     
     @Test
     public void testArrayListGenericoOK(){
         ArrayList<CocheRally> misCoches = new ArrayList<CocheRally>();
         misCoches.add(new CocheRally("Subaru Lunes"));
         misCoches.add(new CocheRally("Toyota Martes"));
         misCoches.add(new CocheRally("Hammer Fin de"));
         
         misCoches.get(2).arrancar("encender");
         misCoches.get(2).mostrarEstado();
         
         for (CocheRally miCoche : misCoches) {
             miCoche.avanzar();
         }
     }
     
     @Test
     public void testSetOk(){
         Set setCoche = new HashSet();
         setCoche.add(new Coche("Subaru Lunes"));
         setCoche.add(new Coche("Toyota Martes"));
         setCoche.add(new Coche("Hammer Fin de"));
         
         System.out.println(setCoche);
   
     }
     
    
}
