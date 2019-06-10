package modelo.jugador;

import modelo.objetos.materiasPrimas.MaderaInventariable;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioMaterialesTest {

    final int cantidadMateriales = 4;

    @Test
    public void test01InventarioMaterialesSeInicializaCorrectamente(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales(cantidadMateriales);

        for (int i=1; i<=cantidadMateriales; i++) {
            assertEquals(0, inventarioMateriales.obtenerCantidad(i));
        }
    }

    @Test
    public void test02SeAgregaUnMaterialYSeActualizanLosInvariantesCorrespondientes(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales(cantidadMateriales);
        MaderaInventariable madera = new MaderaInventariable();

        inventarioMateriales.guardar(madera);

        assertEquals(1, inventarioMateriales.obtenerCantidad(madera.getId()), 0);
    }


}