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
public class Ordenamiento {

    public static int[] ordenarArray(int[] arrayInt) {
        //Declarar array enteros
        //Programar todo lo que haga falta para ordenarlo
        //int[] arrayInt = {3, 2, 1, 9, 12,  8, 20};
        if (arrayInt == null) {
            return null;
        }

        for (int i = 0; i < arrayInt.length; i++) {
            for (int j = i + 1; j < arrayInt.length; j++) {
                if (arrayInt[i] > arrayInt[j]) {
                    int segundoNumero = arrayInt[i];
                    arrayInt[i] = arrayInt[j];
                    arrayInt[j] = segundoNumero;

                }
            }
        }

        for (int i = 0; i < arrayInt.length; i++) {
            System.out.println(arrayInt[i]);
        }

        return arrayInt;
    }

    public static int[] insercionDirecta(int A[]) {
        int p, j;
        int aux;
        if (A == null) {
            return null;
        }
        for (p = 1; p < A.length; p++) { // desde el segundo elemento hasta
            aux = A[p]; // el final, guardamos el elemento y
            j = p - 1; // empezamos a comprobar con el anterior
            while ((j >= 0) && (aux < A[j])) { // mientras queden posiciones y el
                // valor de aux sea menor que los
                A[j + 1] = A[j];       // de la izquierda, se desplaza a
                j--;                   // la derecha
            }
            A[j + 1] = aux; // colocamos aux en su sitio
        }
        return A;
    }

}
