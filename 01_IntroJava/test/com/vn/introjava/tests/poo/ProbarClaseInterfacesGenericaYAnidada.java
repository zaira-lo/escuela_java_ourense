/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbarClaseInterfacesGenericaYAnidada {
//<T> Para hacerlo genérico
    static class ClasePequePos<T> { //static para usarlo en cualquier parte

        T x, y;

        public ClasePequePos(T x, T y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(x = " + x.toString() + ", y = " + y.toString() + ")";
        }
    }

    @Test
    public void probarClaseAnidada() {
        ClasePequePos unPunto2D = new ClasePequePos(3f, 5f);
        System.out.println("PUNTO 2D: " + unPunto2D.toString());
        
    }
    
    @Test
    public void probarClaseGenerica(){
        ClasePequePos<String> unPunto2Dstr = new ClasePequePos<>("tres","cinco");
        System.out.println("PUNTO 2D str: " + unPunto2Dstr.toString());
    }
}
