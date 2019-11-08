/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.herencia.animales;

/**
 *
 * @author pc
 */
public class Perro extends Animal{
    private String raza;

    public Perro(String raza) {
        super();
        this.raza = raza;
        this.edad = 3;
        this.nombre = "toby";
        this.habitat = Habitat.Terrestre;
        this.alimento = "pienso";
        this.peso = 4;
    }

    public Perro() {
      
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    @Override
    public void desplazar(){
        System.out.println(getNombre() + " corre contento");
    }
    
    public String ladrar(){
        return (getNombre() + " dice guau guau");
    }

    @Override
    public String toString() {
        return getNombre() + " es un perro de raza " 
                + raza + ", tiene "+ getEdad() 
                +" años, pesa "  + this.peso +" kg, y además es " + this.habitat +
                ". " + ladrar();
    }

    @Override
    public void alimentar() {
         System.out.println(getNombre() + " mastica y come " + getAlimento());
    }
    
    
    
}
