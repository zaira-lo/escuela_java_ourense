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
    
    public void ladrar(){
        System.out.println(getNombre() + " dice guau guau");
    }

    @Override
    public String toString() {
        return getNombre() + "Es un perro" 
                +  " que tiene " + raza + 
                " raza, tiene "+ getEdad() 
                +" y además es " + this.habitat;
    }

    @Override
    public void alimentar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
