package com.vn.concurrencia.sincronia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * El sistema de bloqueo lo tiene que gestionar
 * el recurso compartido
 */

public class Contenedor {
    // Normalmente será un array, lista, bb.dd., 
    // mapa, fichero, DAO, servicio web, cualquier recurso compartido...
    int dato;
    //Semáforo: false, no se puede usar el recurso
    //          true, sí se puede usar
    
    boolean hayDato = false;
    //synchronized prepara el método para el bloqueo
    public synchronized int get() {
        while(!hayDato){        // esperamos a que se produzca algún dato
            try {
                this.wait();    // le decimos al hilo que espere
                                // hasta que el productor produzca el dato
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        hayDato = false;        //Marcamos para bloquear el recurso
        System.out.println("    contenedor. al FINAL del get(): " +dato);
        this.notifyAll();       //Indicar al hilo que avise a los otros hilos
                                //  de que el recurso ha sido consumido
        return dato;            //Devolver el dato

    }
    
    
    public synchronized void put(int valor) {        
        while(hayDato){
            //mientras hay dato, nadie lo ha consumido
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dato = valor;           //almacenar el dato
        hayDato=true;           //Marcamos para liberar el recurso
        this.notifyAll();
    }
}
