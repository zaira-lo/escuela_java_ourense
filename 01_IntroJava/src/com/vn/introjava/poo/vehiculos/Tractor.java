/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.vehiculos;

import com.vn.introjava.poo.vehiculos.TipoVehiculo;


/**
 *
 * @author pc
 */
public class Tractor extends Vehiculo {

    public Tractor() {
        super();
        tipo = TipoVehiculo.TRACTOR;
    }

    
    @Override
    public void avanzar() {
        System.out.println("Ruedo y siego.");
    }

    
    @Override
    public String toString(){
        return tipo.toString();
        
    }

    @Override
    public void mover(float metros) {
        avanzar();
        System.out.println(metros + " metros");
    }

    @Override
    public void cargarBateria(double voltios) {
        System.out.println("El coche tiene " + voltios);
    }
    
   

    
    
    
}
