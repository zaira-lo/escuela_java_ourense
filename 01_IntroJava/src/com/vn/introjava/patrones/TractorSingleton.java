/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.patrones;

import com.vn.introjava.poo.vehiculos.Tractor;
import java.util.Random;

/**
 *
 * @author pc
 */
public class TractorSingleton extends Tractor{
    private static TractorSingleton unicoTractorEsp;
    
    
    private TractorSingleton(){
        super();
    }

    
     public static TractorSingleton getInstancia(){
         if (TractorSingleton.unicoTractorEsp == null){
             TractorSingleton.unicoTractorEsp = new TractorSingleton();
             TractorSingleton.unicoTractorEsp.setColor("Tractor singleton " +
                     (new Random()).nextInt());
         }
          return TractorSingleton.unicoTractorEsp; 
     }
    
}
