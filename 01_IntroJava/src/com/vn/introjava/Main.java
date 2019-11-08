/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

import static com.vn.introjava.funcionesbasicas.Ordenamiento.*;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal del proyecto Ejemplos Java
 *
 * @author pc
 */
public class Main {

    /**
     * Función que se ejecuta al arrancar el programa
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        DatosBasicos.mostrarTiposDatos();
//        DatosBasicos.probarOperadores();
//        EstructurasControl.ejecutarBucles();
//        EstructurasControl.ejecutarCondiciones();
        try {
            System.out.println("Tipos de datos");
            ordenarArray(new int[]{4, 3, 2, 1});
            Coche c = FabricaCoches.crear("");
            c.mostrarEstado();
        } catch (Exception ex) {
            System.err.println(">>LOG: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
