/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.interfaces.IDaoCoche;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class DaoCocheList implements IDaoCoche{
    private List<Coche> listaCoches;
    public DaoCocheList(){
        listaCoches = new ArrayList<>();
    }
    
    public Coche crear (String marca) throws Exception{
        return crear(FabricaCoches.crear(marca));
    }
    
    @Override
    public Coche crear(Coche nuevoCoche) throws Exception{      
       listaCoches.add(nuevoCoche);
        return  nuevoCoche;
    }
    
    @Override
    public Coche obtenerPorIndice (int index){
        if(index < listaCoches.size()){
            return listaCoches.get(index);
        }else{
            return null;
        }
    }
    
    @Override
    public Coche obtenerPorMarca (String marca){
        for (Coche coche : listaCoches) {
            if (coche.getMarca().equals(marca)) {
                return coche;
            }
        }
        return null;
    }

    @Override
    public Coche modificar(int index, Coche cocheConDatos) throws Exception {
        Coche cocheAModificar = listaCoches.get(index);
        cocheAModificar.setMarca(cocheConDatos.getMarca());
        cocheAModificar.setTipo(cocheConDatos.getTipo());
        cocheAModificar.arrancar(cocheConDatos.isArrancado() ? 4 : 1);
        return cocheAModificar;
    }

    @Override
    public void eliminar(int index) {
        this.listaCoches.remove(index);
    }

    @Override
    public void eliminar(Coche objEliminar) {
        this.listaCoches.remove(objEliminar);
    }

}
