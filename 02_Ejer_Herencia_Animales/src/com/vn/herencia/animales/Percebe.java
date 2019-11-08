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

    public Percebe(int edad, String nombre, float peso, String alimento) {
        super(); //Con esto consigo las propiedades del padre(Animal)
        this.habitat = Habitat.Acuatico;
        this.edad = edad;
        this.nombre = nombre;
        this.peso = peso; 
        this.alimento = alimento;
    }


    @Override
    public void desplazar() {
        System.out.println(getNombre() + " no se desplazan, están adheridos a una roca.");    
    }
    
    @Override
    public void alimentar(String alimento){
        System.out.println(getNombre() + " se nutre de " + this.alimento);
    }

    @Override
    public String toString() {
        return getNombre() + " es de tipo " + this.habitat
                + " tiene " + this.edad + " años y pesa "
                + this.peso +  " kg";
    }
    
    
    
    
    
    
}
