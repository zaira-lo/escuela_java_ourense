/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheRally;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.logging.Level;
import java.util.logging.Logger;
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
         
         try {
             // miCoche.marca = '...'; No compila
             miCoche.setMarca("Kia");
         } catch (Exception ex) {
             Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             miCocheFindes.setMarca("Hammer");
         } catch (Exception ex) {
             Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
         }
         System.out.println("miCoche.marca = " + miCoche.getMarca());
         System.out.println("miCocheFindes.marca = " + miCocheFindes.getMarca());
         
         assertEquals(miCoche.getMarca(), "Kia");
         
         miCocheFindes = miCoche;
         assertEquals(miCoche, miCocheFindes);
         try {
             miCoche.setMarca("Hammer Limusina");
         } catch (Exception ex) {
             Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
         }
         System.out.println("miCoche.marca = " + miCoche.getMarca());
         System.out.println("miCocheFindes.marca = " + miCocheFindes.getMarca());
        
         

//       Polimorfismo
         Object refAmiCoche = miCoche;
//         No podemos invocar getMarca(), 
//         pero si los métodos que tienen todos los objetos
//         System.out.println("miCocheFindes.marca = " + refAmiCoche.getMarca());
         assertTrue(refAmiCoche.equals(miCoche));
         
//         Coche cocheNuevo = (Coche) refAmiCoche;
//         cocheNuevo.setMarca("Ford");
//         System.out.println("cocheNuevo: " + cocheNuevo.getMarca());
         
         
     }
     
     @Test
     public void probandoSobrecarga(){
         Coche nuevoCoche = new Coche();
         assertTrue(nuevoCoche.arrancar());
         
         for(int i= 1; i <= 4; i++){
             if( i == 4){
                 assertTrue(nuevoCoche.arrancar(i));
             }else{
                 assertFalse(nuevoCoche.arrancar(i));
             }
         }         
     }
     
     
     @Test(expected = IllegalArgumentException.class)
     public void gestionExcepciones() throws Exception{
         Coche c = FabricaCoches.crear("");
     }
     
     @Test//(expected = IllegalArgumentException.class)
     public void gestionExcepciones_2(){
         try {
             Coche c = FabricaCoches.crear("c");
         } catch (Exception ex) {
             Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
             assertTrue(ex instanceof IllegalArgumentException);
         }
     }
     
     @Test
     public void usandoConstructoresSobrecargados(){
         Coche c = new Coche("Ferrari");
         assertEquals(c.getMarca(), "Ferrari");
     }
     
    
}
