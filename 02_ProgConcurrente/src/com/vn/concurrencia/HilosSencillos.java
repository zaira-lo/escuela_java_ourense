/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

/**
 *
 * @author pc
 */
public class HilosSencillos {
    static int contCompartido=0;
    HiloA hiloA1, hiloA2;
    HiloB hiloB1, hiloB2;
     
     public HilosSencillos(){
        this.hiloA1 = new HiloA();
        this.hiloA2 = new HiloA();
        this.hiloB1 = new HiloB();
        this.hiloB2 = new HiloB();
     }
    class HiloA implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 243200; i++) {
                contCompartido++;
                if(i%100 ==0){
                    System.out.println("Instrucción A:   " + i
                        + " - contador = " + contCompartido);
                }
            }
        }
    }
    
    class HiloB implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 545300; i++) {
                contCompartido++;
                if(i%100 ==0){
                    System.out.println("->Ins B: " + i
                        + " - contador = " + contCompartido);
                }
            }
        }
    }
    
    public void ejecutarHilosStartABenParalelo(){   
        System.out.println("\n****THREAD - START*****\n");
        Thread threadHiloB1 = new Thread(hiloB1);
        Thread threadHiloA1 = new Thread(hiloA1);
        Thread threadHiloB2 = new Thread(hiloB2);
        Thread threadHiloA2 = new Thread(hiloA2);
        threadHiloA1.start();
        threadHiloB1.start();
        threadHiloA2.start();
        threadHiloB2.start();
        while (threadHiloA1.isAlive() || threadHiloB1.isAlive() 
                || threadHiloA2.isAlive() || threadHiloB2.isAlive());
         System.out.println("\n****FINN - START*****\n");
    }
    
    public void ejecutarHilosRunABenSerie(){
        System.out.println("\n----THREAD - RUN ----\n");
        hiloA1.run();
        hiloB1.run();
        hiloA2.run();
        hiloB2.run();
        System.out.println("\n----FINN - RUN ----\n");
    }
}
