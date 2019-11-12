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
    
    @Override
    public void crear(Coche nuevoCoche) throws Exception{
        listaCoches.add(nuevoCoche);
    }
    
    @Override
    public Coche obtenerPorIndice (int index){
        return listaCoches.get(index);
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
    public void modificar(int index, Coche objExistente) throws Exception {
        listaCoches.get(index);
    }

}
