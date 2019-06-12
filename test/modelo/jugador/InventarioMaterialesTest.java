package modelo.jugador;

import modelo.objetos.GuardableEnInventario;
import modelo.objetos.materiales.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioMaterialesTest {

    final int cantidadMateriales = 4;

    @Test
    public void test01InventarioMaterialesSeInicializaCorrectamente(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales();

        for (int i=1; i<=cantidadMateriales; i++) {
            assertEquals(0, inventarioMateriales.getCantidadMateriales(i));
        }
    }

    @Test
    public void test02SeAgregaUnMaterialYSeActualizanLosInvariantesCorrespondientes(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales();
        GuardableEnInventario madera = new Madera();

        inventarioMateriales.guardar(madera);

        assertEquals(1, inventarioMateriales.getCantidadMateriales(madera.getId()), 0);
    }

    @Test
    public void test03SeObtieneUnMaterialYSeActualizanLosInvariantesCorrespondientes(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales();
        GuardableEnInventario madera = new Madera();
        int cantidadMaderaInicial = inventarioMateriales.getCantidadMateriales(madera.getId());

        inventarioMateriales.guardar(madera);

        assertTrue(inventarioMateriales.usarMaterial(new Madera()) instanceof Madera);
        
        assertEquals(cantidadMaderaInicial, inventarioMateriales.getCantidadMateriales(madera.getId()));
    }

    @Test
    public void test04SeObtieneMaterialSinQueLosHayaYDevuelveNull(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales();

        assertNull(inventarioMateriales.usarMaterial(new Madera()));
    }
}