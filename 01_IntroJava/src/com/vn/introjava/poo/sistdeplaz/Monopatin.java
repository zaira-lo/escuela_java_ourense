/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.sistdeplaz;

import com.vn.introjava.poo.interfaces.Desplazable;
import com.vn.introjava.poo.interfaces.Electrico;

/**
 *
 * @author pc
 */
public class Monopatin implements Desplazable{

    @Override
    public void mover(float metros) {
        rodar(metros);
    }
    
    public void rodar(float metros){
        System.out.println("Monopatin rueda rueda " + metros + "!");
    }

    
    
}
