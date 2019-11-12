/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.patrones;

import com.vn.introjava.patrones.CocheEspecialUnico;
import com.vn.introjava.patrones.TractorSingleton;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbandoUnicaInstancia {
    
    
     @Test
     public void intentarUnicaIns() throws Exception {
         CocheEspecialUnico miUnicoCoche = CocheEspecialUnico.getInstancia();
//         miUnicoCoche.setMarca("UNICOOO 1");
         miUnicoCoche.mostrarEstado();  
     }
     
     @Test
     public void intentarUnicaInsBis() throws Exception {
         CocheEspecialUnico miUnicoCoche = CocheEspecialUnico.getInstancia();

//         miUnicoCoche.setMarca("UNICOOO  2");
         miUnicoCoche.mostrarEstado();
         
     }
     
      @Test
     public void intentarUnicaInsTris() throws Exception {
         CocheEspecialUnico miUnicoCoche = CocheEspecialUnico.getInstancia();
//         miUnicoCoche.setMarca("UNICOOO  3");
         miUnicoCoche.mostrarEstado();
         
     }
     
       @Test
     public void intentarUnicaInsTrisTras() throws Exception {
         CocheEspecialUnico miUnicoCoche = CocheEspecialUnico.getInstancia();
//         CocheEspecialUnico.unicoCocheEsp = null;
//         miUnicoCoche.setMarca("UNICOOO  3");
         miUnicoCoche.mostrarEstado();
         
     }
     
     @Test
     public void pruebaTractorUno (){
         TractorSingleton miTractorSingleton = TractorSingleton.getInstancia();
         miTractorSingleton.mostrarEstado();
     }
     
    
}
