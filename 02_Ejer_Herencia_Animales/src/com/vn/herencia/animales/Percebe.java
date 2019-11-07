/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.herencia.animales;

/**Clase percebe para controlar 
 *
 * @author pc
 */
public class Percebe extends Animal {
    
    private String alimento;

    public Percebe() {
        super(); //Con esto consigo las propiedades del padre(Animal)
        this.habitat = Habitat.Acuatico;
        this.edad = 3;
        this.nombre = "Percebe";
        this.peso = 1; 
        this.alimento = "placton";
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }


    @Override
    public void desplazar() {
        System.out.println(getNombre() + "No se desplazan, están adheridos a una roca.");    
    }
    
    @Override
    public void alimentar(){
        System.out.println(getNombre() + " se nutre de " + getAlimento());
    }
    
    
    
    
}
