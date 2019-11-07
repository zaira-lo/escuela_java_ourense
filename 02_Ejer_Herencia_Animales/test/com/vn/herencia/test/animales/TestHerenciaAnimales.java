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
    public void hello() {
    
        Animal perrito = new Perro("Cocker");
        Animal percebito = new Percebe();
        
    }
}
