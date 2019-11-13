/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.interfaces.IDaoCoche;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import static javafx.scene.input.KeyCode.K;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author pc
 */
public class DaoCocheMap implements IDaoCoche{

    private HashMap<String, Coche> mapaStr;
    private HashMap<Integer, Coche> mapaInt;
    private int ultimoIndex;
    

    public DaoCocheMap() {
        mapaStr = new HashMap<>();
        mapaInt = new HashMap<>();
        ultimoIndex = 0;
    }

    public Coche crear(String marca) throws Exception{
        return crear(FabricaCoches.crear(marca));
    }
    
    @Override
    public Coche crear(Coche nuevoCoche) throws Exception {
        mapaStr.put(nuevoCoche.getMarca(), nuevoCoche);
        mapaInt.put(ultimoIndex, nuevoCoche);
        ultimoIndex++;
        return nuevoCoche;
    }

    @Override
    public Coche obtenerPorIndice(int index) {
        return mapaInt.get(index);
    }
    
    @Override
    public Coche obtenerPorMarca(String marca){
        return mapaStr.get(marca);
    }

    @Override
    public Coche modificar(int index, Coche cocheDatos) throws Exception {
        Coche c = obtenerPorIndice(index);
        mapaStr.remove(c.getMarca());
        mapaStr.put(cocheDatos.getMarca(), c);
        
        c.setMarca(cocheDatos.getMarca());
        c.setTipo(cocheDatos.getTipo());
        c.arrancar(cocheDatos.isArrancado() ? 4 : 1);
        return c;
    }


    @Override
    public void eliminar(Coche objEliminar) {
        String keyMarca = objEliminar.getMarca();
        mapaStr.remove(keyMarca);
        int keyIndex = -1;
        
        if(mapaInt.containsValue(objEliminar)){
            for (Map.Entry<Integer, Coche> parIndexYcoche : mapaInt.entrySet()) {
                if(parIndexYcoche.getValue()== objEliminar){
                    keyIndex = parIndexYcoche.getKey();
                }
            }
        }
        mapaInt.remove(keyIndex);
    }

    
    @Override
    public void eliminar(int index) {
        Coche c = mapaInt.get(index);
        mapaStr.remove(c.getMarca());
        mapaInt.remove(index);
    }

}
