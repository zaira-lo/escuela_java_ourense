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

    public void crear(String marca) throws Exception{
        crear(FabricaCoches.crear(marca));
    }
    
    @Override
    public void crear(Coche nuevoCoche) throws Exception {
        mapaStr.put(nuevoCoche.getMarca(), nuevoCoche);
        mapaInt.put(ultimoIndex, mapaStr.get(nuevoCoche.getMarca()));
        ultimoIndex++;
               
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
    public void modificar(int index, Coche objExistente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
