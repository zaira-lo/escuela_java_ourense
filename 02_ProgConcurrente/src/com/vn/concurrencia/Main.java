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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HilosSencillos hs = new HilosSencillos();
        long timeIni = System.currentTimeMillis();
        hs.ejecutarHilosRunABenSerie();
        
        String m1 = mostrarTiempo(timeIni, "Run en Serie ha tardado: ");
        timeIni = System.currentTimeMillis();
        hs.ejecutarHilosStartABenParalelo();
        mostrarTiempo(timeIni, "Start en paralelo ha tardado: ");
        System.out.println(m1);
        
    }
    static String mostrarTiempo(  long timeInicial, String mensaje){
        double tiempoTotal = (double)(System.currentTimeMillis() - timeInicial)/ 1000.0;
        String mensajeRet = mensaje + tiempoTotal;
        System.out.println(mensajeRet);
         return mensajeRet;
    }
}
