package modelo.jugador;

import modelo.objetos.GuardableEnInventario;
import modelo.objetos.materiales.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioMaterialesTest {

    final int cantidadMateriales = 4;

    @Test
    public void test01InventarioMaterialesSeInicializaCorrectamente(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales(cantidadMateriales);

        for (int i=1; i<=cantidadMateriales; i++) {
            assertEquals(0, inventarioMateriales.getCantidadMaterial(i));
        }
    }

    @Test
    public void test02SeAgregaUnMaterialYSeActualizanLosInvariantesCorrespondientes(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales(cantidadMateriales);
        GuardableEnInventario madera = new Madera();

        inventarioMateriales.guardar(madera);

        assertEquals(1, inventarioMateriales.getCantidadMaterial(madera.getId()), 0);
    }

    @Test
    public void test03SeObtieneUnMaterialYSeActualizanLosInvariantesCorrespondienteS(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales(cantidadMateriales);
        GuardableEnInventario madera = new Madera();
        int cantidadMaderaInicial = inventarioMateriales.getCantidadMaterial(madera.getId());

        inventarioMateriales.guardar(madera);

        assertTrue(inventarioMateriales.usarMaterial(new Madera()) instanceof Madera);
        
        assertEquals(cantidadMaderaInicial, inventarioMateriales.getCantidadMaterial(madera.getId()));
    }

}