/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author pc
 */
public class ArrayListHilos {

    static int contCompartido = 0;

    private ArrayList<Runnable> arrayListHilosAB = new ArrayList<>();
    private long numHilos;

    public ArrayListHilos(long numHilosAB) {
        this.numHilos = numHilosAB;
        for (int i = 0; numHilos < 10; i++) {
            arrayListHilosAB.add(new HiloA());
            arrayListHilosAB.add(new HiloB());
        }
    }

    class HiloA implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 243200; i++) {
                contCompartido++;
                if (i % 100 == 0) {
                    System.out.println("Instrucción A:   " + i
                            + " - contador = " + contCompartido);
                }
            }
        }
    }

    class HiloB implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 545300; i++) {
                contCompartido++;
                if (i % 100 == 0) {
                    System.out.println("->Ins B: " + i
                            + " - contador = " + contCompartido);
                }
            }
        }
    }

    public void ejecutarHilosStartABenParalelo() {
        System.out.println("\n****THREAD - START*****\n");
        ArrayList<Thread> arrayListThread = new ArrayList<>();
        boolean estaVivo = false;
        for (Runnable hilosAB : arrayListHilosAB) {
            arrayListThread.add(new Thread(hilosAB));
        }
        for (Thread threadHilosAB : arrayListThread) {
            threadHilosAB.start();
        }
        
        do {
            estaVivo=false;
            Iterator<Thread> it = arrayListThread.iterator();
            while ( it.hasNext()) {
                Thread threadHiloAB = it.next();
                estaVivo= estaVivo || threadHiloAB.isAlive();
            };
        } while (estaVivo);
        System.out.println("\n****FINN - START*****\n");
    }

    public void ejecutarHilosRunABenSerie() {
        System.out.println("\n----THREAD - RUN ----\n");
        for (Runnable hilosAB : arrayListHilosAB) {
            hilosAB.run();
        }
        System.out.println("\n----FINN - RUN ----\n");
    }

}
