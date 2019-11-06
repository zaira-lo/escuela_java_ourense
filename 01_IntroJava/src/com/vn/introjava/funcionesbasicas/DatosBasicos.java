/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.funcionesbasicas;

/**
 *
 * @author pc
 */
public class DatosBasicos {
    public static void mostrarTiposDatos(){
        byte unByte = 127;
        int unEntero = 1000; // 4 bytes
        long enteroLargo = 3000000000000L; // 8 bytes
        float unDecimal = 3.32f; // 4 bytes
        double decimalDoblePrecision = 1.432453254325;//8 bytes
        boolean condicion = true; //1byte
        char unCaracter = 'A';// 2 bytes por el formato unicode
        char unChartEntero = 97;
        String unTexto = "Esto es un txt";
        
        System.out.println("- Byte: " + unByte);
        System.out.println("- Entero: " + unEntero);
        System.out.println("- Entero largo: " + enteroLargo);
        System.out.println("- Float: " + unDecimal);
        System.out.println("- Double: " + decimalDoblePrecision);
        System.out.println("- Boolean: " + condicion);
        System.out.println("- Caracter en nº: " + (int) unCaracter);
        System.out.println("- Caracter en char: " + unChartEntero);
        System.out.println("- String: " + unTexto);
        System.out.println("- En mayúsculas: " + unTexto.toUpperCase());
    }
    
    
    
    public static void probarOperadores(){
        //Operadores unarios
        System.out.println("Negación: " + !true);
        System.out.println("Negativo: " + -(10 + 5));
        //Conversión explícita
        System.out.println("Casting: " + (float)3.343434343 );
        
        int contador;
        contador = 10;
        //se suma después de sacar por pantalla
        System.out.println("Incremento: " + contador++);
        //se suma antes de sacar por pantalla, aparece el valor incrementado
        System.out.println("Incremento: " + ++contador);
        
        //Operadores binarios (dos operandos)
        System.out.println("Suma y mult: " + (5 + 5) * 2);
        System.out.println("Resto div entera: " + 11 % 3);
        
        //Operadores buleanos
        System.out.println("Es cierto: " + (true && true)); // Operador AND
        System.out.println("Es cierto: " + (true || true)); //Operador OR
        System.out.println("Es cierto: " + (5 == 5 || 5 > 9));//operador or
        System.out.println("Es cierto: " + (5 != 5 && 5 <= 9)); //operador distinto
        
        //Operadores bit a bit
         //00010101   = 21
         //00000111   = 7
         //00000101   = 5 AND
         //00010111   = 23 OR
         //00010010   = 18 XOR (OR exclusivo)
         System.out.println("Op. binario 21 AND 7 = " + (21 & 7));
         System.out.println("Op. binario 21 OR 7 = " + (21 | 7) );
         System.out.println("Op. binario 21 XOR 7 = " + (21 ^ 7) );
    }
    
}
