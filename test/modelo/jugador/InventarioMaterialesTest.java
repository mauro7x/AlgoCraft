package modelo.jugador;

import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioMaterialesTest {

    final int cantidadMateriales = 4;

    @Test
    public void test01InventarioMaterialesSeInicializaCorrectamente(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales();

        assertEquals(0, inventarioMateriales.cantidadMadera());
        assertEquals(0, inventarioMateriales.cantidadPiedra());
        assertEquals(0, inventarioMateriales.cantidadMetal());
        assertEquals(0, inventarioMateriales.cantidadDiamante());
    }

    @Test
    public void test02SeAgregaUnMaterialYSeActualizanLosInvariantesCorrespondientes(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales();
        inventarioMateriales.agregarMadera();
        assertEquals(1, inventarioMateriales.cantidadMadera());
    }

    @Test
    public void test03SeObtieneUnMaterialYSeActualizanLosInvariantesCorrespondientes(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales();
        int cantidadMaderaInicial = inventarioMateriales.cantidadMadera();
        inventarioMateriales.agregarMadera();

        assertEquals(1, inventarioMateriales.getMadera());
        assertEquals(cantidadMaderaInicial, inventarioMateriales.cantidadMadera());
    }

    @Test
    public void test04SeObtieneMaterialSinQueLosHayaYDevuelve0(){
        InventarioMateriales inventarioMateriales = new InventarioMateriales();
        assertEquals(0, inventarioMateriales.getMadera());
        assertEquals(0, inventarioMateriales.getPiedra());
        assertEquals(0, inventarioMateriales.getMetal());
        assertEquals(0, inventarioMateriales.getDiamante());
    }
}