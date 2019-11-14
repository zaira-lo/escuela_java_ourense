/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia.sincronia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class Productor extends Thread{

    private Contenedor contenedor;

    public Productor(Contenedor c) {
        contenedor = c;
    }

    @Override
    public void run() {
       
        for (int i = 10; i >= 1; i--) {
            int value= i*5;
            System.out.println("    Productor. PUT: " + value);
            contenedor.put(value);
            System.out.println(">>>>Productor. PUT: " + value);
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        

    }
}
