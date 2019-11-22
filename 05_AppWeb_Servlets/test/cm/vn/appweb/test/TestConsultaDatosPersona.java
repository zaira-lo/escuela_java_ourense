package cm.vn.appweb.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.vn.appweb.modelo.ConsultaSQL;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestConsultaDatosPersona {
    
    public TestConsultaDatosPersona() {
    }

     @Test
     public void testSelectSQL() {
         ConsultaSQL conSQL = new ConsultaSQL();
         assertEquals(0, conSQL.leerTabla("Nomb****eba").size());
         assertEquals("Nombre de Prueba", conSQL.leerTabla("Nombre de Prueba").get(0).getNombre());
     }
}
