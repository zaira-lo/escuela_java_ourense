/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo;

/** Clase CocheRally para controlar otras caracteristicas
 * especificas de los rallies
 *
 * @author pc
 */
public class CocheRally extends Coche{
    
    private float rozamiento;

    public CocheRally() {
        super();
        rozamiento = 5f;
        tipo = TipoVehiculo.RALLY;
        
    }
    
    
    /**
     * Constructor con parametros
     * al implementar un constructor, el de por defecto
     * dejar de ser implementado por Java
     * @param marca 
     */

    public CocheRally(String marca) {
        super(marca);
        rozamiento = 5f;
        tipo = TipoVehiculo.TRACTOR;
    }

    public CocheRally(float rozamiento, String marca) {
        super(marca);
        this.rozamiento = rozamiento;
        tipo = TipoVehiculo.TRACTOR;
    }
    
    

    /**
     * Get the value of rozamiento
     *
     * @return the value of rozamiento
     */
    public float getRozamiento() {
        return rozamiento;
    }

    /**
     * Set the value of rozamiento
     *
     * @param rozamiento new value of rozamiento
     */
    public void setRozamiento(float rozamiento) {
        this.rozamiento = rozamiento;
    }

    @Override
    public boolean arrancar(String orden) {
        if (super.arrancar(orden))
            return super.arrancado;
        else if("arrancar".equalsIgnoreCase(orden))
                arrancado = true;
        else 
            this.arrancado = "encender".equals(orden.toLowerCase());
        return arrancado;
    }
    
    // Ejercicio: 
    // 1º Sobreescribir el metodo para mostrarEstado para que
    // tambien muestre el rozamiento
    
    //@Override
    public void mostrarEstadoAntiguo() {     
        super.mostrarEstado(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("- Rozamiento: " + getRozamiento());
    }
    
    
    // 2º el metodo anterior ya no vale, renombrar a mostrarEstadoAntiguo
    //que indique que es "Coche de Rally: <marca>, rozamiento, arrancado"
    @Override
    public void mostrarEstado() {
        System.out.println("Coche de Rally " + getMarca()
                            + ", rozam = " + rozamiento
                            + (isArrancado() ? " arrancado."
                                    : " apagado."));
    }
    
    
    

    
}
