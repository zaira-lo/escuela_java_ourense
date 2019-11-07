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
public class Coche extends Vehiculo {

    private String marca;
    private int numRuedas = 4;
    protected boolean arrancado;
    
//    En el momento en que creamos un constructor, el por defecto
//    deja de ser implementado por java
    public Coche(){
        numRuedas = 4;
        marca = "Sin marca";
        this.arrancado = true;
        tipo = TipoVehiculo.TURISMO;
    }
    
     public Coche(String marca) {
        this.marca = marca;
        this.arrancado = false;
        tipo = TipoVehiculo.TURISMO;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca) throws Exception{
//        avisamos a quien invoca
//        que puede aparecer una excepcion
        if(marca != null && ! "".equals(marca)){
            this.marca = marca;
        }else{
            throw new IllegalArgumentException("Debes asignar una marca");
        }
    }
    
    public int getNumRuedas(){
        return numRuedas;
    }
    
    
    public boolean isArrancado() {
        return arrancado;
    }

    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }
    
    public boolean arrancar(){
        System.out.println(this.marca + " ha arrancado.");
        arrancado = true;
        return arrancado;
    }
    
    // Sobrecarga de método arrancar()
    /**
     * Si la posicion de la llave es 4, el coche arranca
     * sino no arranca.
     * @param posicionLlave puede ser un nº del 1 al 4
     * @return              si se ha arrancado devuelve true
     */
    public boolean arrancar(int posicionLlave){
        if (posicionLlave < 1 || posicionLlave > 4) 
            throw new IllegalArgumentException("La llave ha de valer de 1 a 4");
        arrancado = posicionLlave == 4 /*? true : false;*/;
//        ? true : false; está comentado porque es redundante y no es necesario
//      if (posicionLlave == 4) arrancado = true; else arrancado = false;
        System.out.println(this.marca
                + (arrancado ? " ha arrancado."
                        : " fallo al arrancar"));  
        return arrancado;
    }
     
//    CLEAN CODE: una funcion no puede tener mas de 20 lineas 
    
    /**
     * 
     * @param orden
     * @return 
     */
    public boolean arrancar(String orden){// 4 pos, la 4 es la que arranca
        arrancado = "arrancar".equals(orden);
        return arrancado;
    }
    
    /**
     *Simplemente muestra la marca y si está arrancadp
     *
     */


    @Override
    public void avanzar() {
        System.out.println("Ruedo un poco");
    }
    
    @Override
    public String toString(){
        return tipo + ": " + getMarca()
                            + (isArrancado() ? " arrancado."
                                    : " apagado.");
        
    }

    
    
}
