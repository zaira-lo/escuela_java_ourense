/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

/**
 *
 * @author pc
 */
public class EstructurasControl {
    public static void ejecutarBucles(){
        char arrayChar[] = {'a', 'B', '8', '*'};
        int index = 0;
        
        while (index < arrayChar.length){
            System.out.println("Index = " + index + ", chart " + arrayChar[index]);
            index++;
        }
        
        for(int i=0; i< arrayChar.length; i++)
            System.out.println("Bucle for " + arrayChar[i]);
        
        
//        do{
//            System.out.println("Index = " + index + ", chart " + arrayChar[index]);
//            index++;
//        }while(index < arrayChar.length);
//        
        for(char caracter : arrayChar){
            System.out.println("char = " + caracter);
        }
    }
    
    public static void ejecutarCondiciones(){
        if("Palabra".length() > 5){
            System.out.println("Palabra larga");
        }
        
        if("Texto".length() > 5){
            //por aqui no entra
        }else{
            System.out.println("Palabra corta");
        }
        
        if("En un lugar de la mancha".contains("LUGAR")){
            System.out.println("Tiene LUGAR");
        }else if("En un lugar de la mancha".contains("MANCHA")){
            System.out.println("Tiene MANCHA");
        }else if("En un lugar de la mancha".contains("OTRO")){
            System.out.println("Tiene OTRO");
        }else{
            System.out.println("No tiene ninguno porque están en mayúsculas");
        }
        
        int numeroPeq =0;
        switch(numeroPeq){
            case 0:
                System.out.println("Numero peq vale cero.");
                break;
            case 1:
                System.out.println("Numero peq vale 1");
                break;
            case 2:
            case 3:
            case 4:
                if(numeroPeq ==2)
                    System.out.println("Numero peq vale 2");
                else
                    System.out.println("Numero peq vale 3 o 4");
                break;
            default:
                System.out.println("Es otro número");
        }
    }
}
