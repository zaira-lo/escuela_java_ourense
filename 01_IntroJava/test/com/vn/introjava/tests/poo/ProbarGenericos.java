/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbarGenericos {
    
    public ProbarGenericos() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testearClaseAnidada(){
        ProbarClaseInterfacesGenericaYAnidada.ClasePequePos c;
        c = new ProbarClaseInterfacesGenericaYAnidada.ClasePequePos(1f, 2f);
    }
    
     @Test
     public void testearMetodosGenericos() {
         ArrayList<Integer> listInt = new ArrayList<>();
         int cinco = 5;
         int tres = 3;
         insertarDuplicado(listInt, tres);
         insertarDuplicado(listInt, cinco);
         
         
         //Inferir : deduce el tipo por su declaracion
         ArrayList<String> listString = new ArrayList<>();
         insertarDuplicado(listString, "tres");
         insertarDuplicado(listString, "cinco");
         for (String unString : listString) {
             System.out.println("**" + unString);
         }
         
         ArrayList<Coche> listCoche = new ArrayList<>();
         insertarDuplicado(listCoche, new Coche("Ford"));
         insertarDuplicado(listCoche, new Coche("Seat"));
         System.out.println("**INICIO ARRAYLIST COCHES");
         for (Coche miCoche : listCoche) {
             System.out.println("**" + miCoche);
         }
         System.out.println("FIN ARRAYLIST**");
         Coche ultCoche = mostrarYdevolverUltimo(listCoche);
         String ultStr = mostrarYdevolverUltimo(listString);
         int ultInt = mostrarYdevolverUltimo(listInt);
         
         assertEquals(ultInt, 5);
         assertEquals(ultStr, "cinco");
         assertEquals(ultCoche.getMarca(), "Seat");
        
     }
     
    
     // Entre < y > poner el nombre del tipo genérico. 
     //Esto convierte el método en genérico
     static <Tipo> void insertarDuplicado(ArrayList<Tipo> listaGenerica, Tipo objeto){
         listaGenerica.add(objeto);
         listaGenerica.add(objeto);
         System.out.println(objeto + " añadido 2 veces");
         
         if(objeto instanceof Integer){
             Integer i = (Integer) objeto;
             i = i + 2;
         }
     }
     
     static <T> T mostrarYdevolverUltimo(ArrayList<T> lista){
         for (T infusion : lista) {
             System.out.println(">>" + infusion.toString());
         }
         if( lista.size() >0){
             return lista.get(lista.size()-1);
         }else
             return null;
           
     }
     
      /*Métodos no genéricos
     
     
     static void insertarDuplicado(ArrayList<Integer> listaGenerica, int objeto){
         listaGenerica.add(objeto);
         listaGenerica.add(objeto);
         System.out.println(objeto + " añadido 2 veces");
     }
     
     static void insertarDuplicado(ArrayList<String> listaString, String str){
         listaString.add(str);
         listaString.add(str);
         System.out.println(str + " añadido 2 veces");
     }
*/
}
