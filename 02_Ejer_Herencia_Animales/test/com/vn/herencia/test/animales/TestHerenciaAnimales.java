/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.herencia.test.animales;

import com.vn.herencia.animales.Animal;
import com.vn.herencia.animales.Percebe;
import com.vn.herencia.animales.Perro;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestHerenciaAnimales {
    
    public TestHerenciaAnimales() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

   
    @Test
    public void testClases() {
    
        Animal perrito = new Perro("Cocker", 3, "Toby", "pienso de cordero", 3.4f);
        Animal percebito = new Percebe(4, "Percebito", 0.2f, "pacton");
        
        assertEquals(((Perro)perrito).getRaza(), "Cocker");
        
        Animal [] misAnimales = new Animal []{
            perrito,
            percebito,
            new Perro ("Mastin", 5, "Niebla", "Cordero", 20.7f),
            new Percebe (1, "Percebeiso", 0.1f, "almejas")
        };
        
        System.out.println("***LISTA DE ANIMALES");
        for(Animal miAnimal : misAnimales){
            miAnimal.desplazar();
            miAnimal.alimentar(miAnimal.getAlimento());
            miAnimal.mostrarAnimal();
        }
        
        System.out.println("***FIN LISTA");
        
    }
}
