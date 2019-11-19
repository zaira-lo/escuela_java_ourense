/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn;

import com.vn.liboperaarrays.OperarArrays;
import com.vn.liboperaarrays.OperarArrays.FunCallbackOperarArrays;
import java.io.PrintStream;

/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] array_A= {2,3,4,5,6};
        double[] array_B = {1,1,2,3,4};
        double[] arraySumaAB= 
                OperarArrays.operarArrays(array_A, array_B, Main::suma);
        arrayEnTabla(System.out, arraySumaAB);
        FunCallbackOperarArrays divide= (double x, double y)-> {return x/y;};
        double[] arrayDivAB=
                 OperarArrays.operarArrays(array_A, array_B, divide);
        arrayEnTabla(System.out, arrayDivAB);
        
        double[] arrayRestaAB =
                OperarArrays.operarArrays(array_A, array_B, 
                        (double x, double y)->{return x-y;});
        arrayEnTabla(System.out, arrayRestaAB);
        for (int i = 0; i < array_A.length; i++) {
            System.out.println(hacerPunto(array_A[i], array_B[i]));           
        }
    
    }

    public static double suma(double x, double y){
        return x + y;
    }
    
    public static void arrayEnTabla(PrintStream salida, double[] array){
        String tabla = "<table border=2><tr>\n";
        for (int i = 0; i < array.length; i++) {
            final double element = array[i];
            tabla+= "<td>&nbsp;"+ element + "&nbsp;</td>\n";
            
        }
        salida.println(tabla+ "</tr></table>");
    }
    
    public static Object hacerPunto(double x, double y){
        Object varDoubleX = new Double(x);
        Object varDoubleY = new Double(y);
        Object varStringXY = new String("(" + varDoubleX.toString()+", "+ varDoubleY.toString()+ ")");
        return varStringXY.toString();
    }
    
    
    
}
