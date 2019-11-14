package com.vn.concurrencia.sincronia;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread{

    private Contenedor contenedor;

    public Consumidor(Contenedor c) {
        contenedor = c;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            int value = 0;
            System.out.println("    Consumidor. ANTES DEL GET: " + value);
            value = contenedor.get();
            System.out.println("<<<<<Consumidor. DESPUES DEL GET: " + value);
            try {
                Thread.sleep((int)(Math.random()*3000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
