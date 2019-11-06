/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests;

import com.vn.introjava.Ordenamiento;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestInsercion {

    private int[] arrayOrdPorFuncion;
    
    public TestInsercion() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    private void probarOrdenamientoSistemaHunano(int[] array, int[] arrayOk) {
      arrayOrdPorFuncion = Ordenamiento.insercionDirecta(array);
      assertArrayEquals(arrayOrdPorFuncion, arrayOk);
    }
    
     @Test
    public void probarOrdenaSist_AlReves() {
        probarOrdenamientoSistemaHunano(
            new int[] {4,3,2,1},
            new int[] {1,2,3,4});     
    }
    
    
    @Test
    public void probarOrdenaSist_UnValor() {
        probarOrdenamientoSistemaHunano(
            new int[] {4},
            new int[] {4});     
    }
    
    @Test
    public void probarOrdenaSist_DosValores() {
        probarOrdenamientoSistemaHunano(
            new int[] {4,1},
            new int[] {1,4});     
    }
    
     @Test
    public void probarOrdenaSist_Maxim() {
        probarOrdenamientoSistemaHunano(
            new int[] {4,3,2,1, Integer.MAX_VALUE},
            new int[] {1,2,3,4, Integer.MAX_VALUE});     
    }
    
      @Test
    public void probarOrdenaSist_Minm() {
        probarOrdenamientoSistemaHunano(
            new int[] {4,3,2,1, Integer.MIN_VALUE},
            new int[] {Integer.MIN_VALUE, 1,2,3,4});     
    }
    
    @Test
    public void probarOrdenaSist_Null() {
        probarOrdenamientoSistemaHunano(
            null, null);     
    }
    
    @Test
    public void probarOrdenaSist_ConNegativos() {
        probarOrdenamientoSistemaHunano(
            new int[] {4,-3,2,1, 3},
            new int[] {-3,1,2,3,4});     
    }
    @Test
    public void probarOrdenaSist_Repetidos() {
        probarOrdenamientoSistemaHunano(
            new int[] {4,3,2,1, 4,1},
            new int[] {1,1,2,3,4,4});     
    }
    
    @Test
    public void probarOrdenaSist_Ordenado() {
        probarOrdenamientoSistemaHunano(
            new int[] {1,2,3,4},
            new int[] {1,2,3,4});     
    }
    
    @Test
    public void probarOrdenaSist_Vacio() {
        probarOrdenamientoSistemaHunano(
            new int[] {},
            new int[] {});     
    }
    
 
    
    
}
