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
public abstract class Animal {
    protected String nombre;
    protected int edad;
    
    /**
     * Se tienen que validar los valores (no acepta numeros negativos
     *se mide en kg con precision en gramos
     * 
     */
    protected float peso;

    /**
     *Es un enum para especificar el habitat del animal
     * puede ser no_definido, acuatico, terrestre o anfibio
     * 
     */
    protected Habitat habitat;
    protected String alimento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    /**
     *Indica la forma de desplazamiento del animal por un String
     * 
     */
    public abstract void desplazar();

    public void mostrarAnimal() {
        System.out.println(toString());
    }
    
    /**
     *
     * @param alimento
     * 
     * Indica la manera de alimentar del animal 
     * pasando el alimento por parámentros
     */
    public abstract void alimentar(String alimento);
    
           
    
    
}
