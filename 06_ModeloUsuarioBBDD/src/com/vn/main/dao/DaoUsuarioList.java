/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.main.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo 13
 */
public class DaoUsuarioList implements IDaoUsuario{
    
    private List<Usuario> listaUsuario;
    
    public DaoUsuarioList () {
        listaUsuario = new ArrayList<>();
    }

    @Override
    public Usuario obtenerPorEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario crear(Usuario objetoNuevo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtenerPorIndice(int id) {
        return listaUsuario.get(id);
    }

    @Override
    public Usuario modificar(int index, Usuario objConDatosNuevo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Usuario objConDatosNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
