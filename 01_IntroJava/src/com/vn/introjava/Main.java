/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

import com.vn.introjava.excepciones.UsoNormalExcepciones;
import static com.vn.introjava.funcionesbasicas.Ordenamiento.*;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.dsig.TransformException;

/**
 * Clase principal del proyecto Ejemplos Java
 *
 * @author pc
 */
public class Main {

     public static void main(String[] args) {
         /*Error no capturado, se detiene el programa
         while(args.lenght >-1)
            ((Object) null).equals(args);
         */
         try{
             //Primer código con error
            System.out.println("Tipos de datos");
//            return;
//            Coche c = FabricaCoches.crear(null); IllegalArgumentException
            Coche c = FabricaCoches.crear("Un coche");
            c.mostrarEstado();
            
            //Segundo código con error
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
//            unObj.metodoPeligroso();

            throw new TransformException("Optimus prime se ha quedado sin bateria");
            
            
            //Tercer código con error, NullPointerException
//            Object objNulo = null;
//            System.out.println("Fallará: " + objNulo.toString());
            
         }// se pueden anidar los catch
         catch (IllegalArgumentException ex){
             //Captura cualquier IllegalArgumentException  
             System.out.println("ARGUMENTO INVÁLIDO. DECIRLE AL USUARIO: ");
             Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         }
         catch (RuntimeException ex){
             //Captura cualquier RuntimeException  
             System.out.println("Cualquier tipo de excepción RuntimeException");
             Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         }catch(Exception ex){ 
        //Captura cualquier excepción cuyo tipo sea indicado en el catch 
        //ó cualquiera de sus clases hijas (TODAS)
             System.out.println("Cualquier tipo de excepción");
             Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         } finally{//Siempre se ejecuta incluso antes de un return
             System.out.println(">>FIN DEL TRY CATCH<<");
         }
         System.out.println("**FIN DEL PROGRAMA**");
         
     }
    /**
     * Función que se ejecuta al arrancar el programa
     *
     * @param args the command line arguments
     */
    public static void mainTryCatchPorSeparado(String[] args) {

//        DatosBasicos.mostrarTiposDatos();
//        DatosBasicos.probarOperadores();
//        EstructurasControl.ejecutarBucles();
//        EstructurasControl.ejecutarCondiciones();
        try {
            System.out.println("Tipos de datos");
            ordenarArray(new int[]{4, 3, 2, 1});
            Coche c = FabricaCoches.crear("");
            c.mostrarEstado();
        } catch (Exception ex) {
            System.err.println(">>LOG: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
            unObj.metodoPeligroso();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Excepcion " + ex.getMessage());
            System.out.println("\n Pila de llamadas "
                    + Arrays.toString(ex.getStackTrace()));
        }
        
        try{
            Object objNulo = null;
            System.out.println("Fallará: " + objNulo.toString());
        } catch(NullPointerException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }

}
