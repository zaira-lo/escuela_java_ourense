/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.Coche;
import com.vn.introjava.poo.CocheRally;
import com.vn.introjava.poo.TipoVehiculo;
import com.vn.introjava.poo.Tractor;
import com.vn.introjava.poo.Vehiculo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class OperacionesConHerencia {

    static CocheRally supra;
    static Coche turismo;

    public OperacionesConHerencia() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        supra = new CocheRally();
        supra.setMarca("Toyota");
    }

    @Before
    public void setUp() {
    }

    @Test
    public void sobreEscrituraMetodos() throws Exception {
        supra.setRozamiento(7f);
        assertTrue(supra.getRozamiento() == 7f);

        assertTrue(supra.arrancar("arrancar"));
        //Usando T.D.D.
        assertTrue(supra.arrancar("ARRANCar"));
        assertTrue(supra.arrancar("Encender"));
        supra.mostrarEstado();
    }

    @Test
    public void testPolimorfismo() {
        supra.setRozamiento(15f);
        turismo = supra;
//        En java todos los métodos son virtuales
//        Si un hijo tiene un metodo, se invoca al del hijo
        turismo.mostrarEstado();
    }
    
    @Test
    public void testEnumerado(){
        supra.setTipo(TipoVehiculo.RALLY);
        //Un enumerado es un int, limitado a lista de valores indicados
        System.out.println("Tipo: " + supra.getTipo().toString());
        System.out.println("Valor tipo: " + supra.getTipo().ordinal());
        
        Tractor miTractorAmarillo = new Tractor();
        miTractorAmarillo.setTipo((TipoVehiculo.valueOf("TRACTOR")));
        System.out.println("Tipo desde string: " + miTractorAmarillo.getTipo());
        
        
//        Este es el más recomendado para utilizar
        miTractorAmarillo.setTipo((TipoVehiculo.values()[1]));
        System.out.println("Tipo desde int: " + miTractorAmarillo.getTipo());
        
    }
    
    @Test
    public void testClasesAbstractas(){
//       este no se puede utilizar porque es abstracta
//       Vehiculo vehDesc = new Vehiculo();

//        se instanciaria este
        Vehiculo vehDesc = new Coche("Dacia");
        Vehiculo subaru = new CocheRally("Subaru");
        Vehiculo miTrac = new Tractor();
        vehDesc.avanzar();
        miTrac.avanzar();
//        Mediante un casting explicito podemos invocar a sus metodos
        assertEquals(((CocheRally)subaru).getMarca(), "Subaru");
        
        Vehiculo [] misVehiculos = new Vehiculo[]{
            vehDesc,
            miTrac,
            new Coche("Electrico"),
            subaru
        };
        for (Vehiculo miVehiculo : misVehiculos) {
            System.out.println(" - " + miVehiculo.getTipo());
            miVehiculo.avanzar();
            miVehiculo.mostrarEstado();
        }
        
        
    }

}
