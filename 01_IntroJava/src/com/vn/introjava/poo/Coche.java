/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo;

/**
 *
 * @author pc
 */
public class Coche {
//    public Coche (){
//        //constructor por defecto
//    }
    
    private String marca;
    private int numRuedas = 4;
    
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca){
        
        this.marca = marca;
    }
    
    public int getRuedas(){
        return numRuedas;
    }
    
    public void setRuedas(int numRuedas){
        
        this.numRuedas = numRuedas;
    }
    
}
