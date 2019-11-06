/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.Coche;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class OperacionesBasicasObjetos {
    
    
     @Test
     public void creandoObjetos() {
         Coche miCoche = null;
         miCoche = new Coche();
         System.out.println("Texto de coche: " + miCoche.toString());
         
         Coche miCocheFindes = new Coche();
         assertNotNull(miCoche);
         assertNotNull(miCocheFindes);
         assertNotEquals(miCoche, miCocheFindes);
         
         // miCoche.marca = '...'; No compila
         miCoche.setMarca("Kia");
         miCocheFindes.setMarca("Hammer");
         System.out.println("miCoche.marca = " + miCoche.getMarca());
         System.out.println("miCocheFindes.marca = " + miCocheFindes.getMarca());
         
         assertEquals(miCoche.getMarca(), "Kia");
         
         miCocheFindes = miCoche;
         assertEquals(miCoche, miCocheFindes);
         miCoche.setMarca("Hammer Limusina");
         System.out.println("miCoche.marca = " + miCoche.getMarca());
         System.out.println("miCocheFindes.marca = " + miCocheFindes.getMarca());
         

//       Polimorfismo
         Object refAmiCoche = miCoche;
//         No podemos invocar getMarca(), 
//          pero si los métodos que tienen todos los objetos
//         System.out.println("miCocheFindes.marca = " + refAmiCoche.getMarca());
         assertTrue(refAmiCoche.equals(miCoche));
         
         Coche cocheNuevo = (Coche) refAmiCoche;
         cocheNuevo.setMarca("Ford");
         System.out.println("cocheNuevo: " + cocheNuevo.getMarca());
         
         
     }
}
