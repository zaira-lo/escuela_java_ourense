/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.vehiculos;

import com.vn.introjava.poo.interfaces.Desplazable;
import com.vn.introjava.poo.interfaces.Electrico;
import com.vn.introjava.poo.vehiculos.TipoVehiculo;

/**Clase abstracta que no puede ser instanciada
 *Por falta de sentido
 * 
 * @author pc
 */
public abstract class Vehiculo
        extends Object
        implements Desplazable{
    
    protected TipoVehiculo tipo;

    public TipoVehiculo getTipo() {
        return tipo;
    }
    
    /**
     * método declarado e implementado
     * @param tipo 
     */
    public void setTipo(TipoVehiculo tipo) { // declaracion
        this.tipo = tipo;                   //implementacion
    }
    
    
    //al no tener implementacion tiene que ser abstract
    public abstract void avanzar(); 
    public void mostrarEstado(){
        System.out.println(toString());
    }
}
