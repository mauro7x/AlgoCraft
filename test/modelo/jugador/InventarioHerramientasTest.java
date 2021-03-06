package modelo.jugador;

import modelo.herramientas.FabricaHerramientas;
import modelo.herramientas.Herramienta;
import modelo.recursos.BloqueMadera;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioHerramientasTest {

    @Test
    public void test01InventarioHerramientasSeInicializaConLaCorrectaCantidadDeHerramientas(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();

        assertEquals(1, inventarioHerramientas.getCantidadHerramientas(), 0);
    }

    @Test
    public void test02InventarioHerramientasSeInicializaConHachaDeMadera(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        Herramienta herramientaInicial = inventarioHerramientas.getHerramientaActual();
        BloqueMadera bloqueMadera = new BloqueMadera();
        float durabilidadInicialBloqueMadera = bloqueMadera.getDurabilidad();

        herramientaInicial.golpear(bloqueMadera);

        assertEquals(durabilidadInicialBloqueMadera - 2, bloqueMadera.getDurabilidad(), 0);
    }

    @Test
    public void test03SeAgregaUnaHerramientaYSeModificanLosInvariantes(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        int cantidadHerramientasInicial = inventarioHerramientas.getCantidadHerramientas();
        Herramienta herramienta = FabricaHerramientas.crearPicoFino();

        inventarioHerramientas.guardar(herramienta);

        assertEquals(cantidadHerramientasInicial + 1, inventarioHerramientas.getCantidadHerramientas(), 0);
    }

    @Test
    public void test04SeEliminaUnaHerramientaYSeModificanLosInvariantes(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        int cantidadHerramientasInicial = inventarioHerramientas.getCantidadHerramientas();
        Herramienta herramienta = FabricaHerramientas.crearPicoFino();

        inventarioHerramientas.guardar(herramienta);
        inventarioHerramientas.eliminarHerramientaActual();

        assertEquals(cantidadHerramientasInicial, inventarioHerramientas.getCantidadHerramientas(), 0);
    }

    @Test
    public void test05SeAgregaUnaHerramientaSeEstableceAutomaticamenteComoHerramientaActual(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta herramienta = FabricaHerramientas.crearPicoFino();

        inventarioHerramientas.guardar(herramienta);

        assertEquals(herramienta, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test06SeAgreganDosHerramientasYSePuedeCambiarHerramientaActualAHerramientaSiguiente(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = FabricaHerramientas.crearHachaDeMadera();
        Herramienta hachaPiedra = FabricaHerramientas.crearHachaDePiedra();

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaActual());

        inventarioHerramientas.cambiarAHerramientaSiguiente();

        assertEquals(hachaPiedra, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test07SeAgreganDosHerramientasYSePuedeCambiarHerramientaActualAHerramientaAnterior(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = FabricaHerramientas.crearHachaDeMadera();
        Herramienta hachaPiedra = FabricaHerramientas.crearHachaDePiedra();

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.cambiarAHerramientaSiguiente();
        inventarioHerramientas.cambiarAHerramientaAnterior();

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test08HerramientaActualSigueSiendoloSiNoHayHerramientaSiguiente(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = FabricaHerramientas.crearHachaDeMadera();

        inventarioHerramientas.guardar(hachaMadera);

        inventarioHerramientas.cambiarAHerramientaSiguiente();

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test09HerramientaActualSigueSiendoloSiNoHayHerramientaAnterior(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = FabricaHerramientas.crearHachaDeMadera();

        inventarioHerramientas.guardar(hachaMadera);

        inventarioHerramientas.cambiarAHerramientaAnterior();

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test10HerramientaActualEsEliminadaYLaHerramientaActualPasaASerLaSiguiente(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = FabricaHerramientas.crearHachaDeMadera();
        Herramienta hachaPiedra = FabricaHerramientas.crearHachaDePiedra();

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.eliminarHerramientaActual();

        assertEquals(hachaPiedra, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test11HerramientaActualEsLaUltimaAgregadaYAlCambiarALaProximaPasaASerLaPrimeraDeTodas(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = FabricaHerramientas.crearHachaDeMadera();
        Herramienta hachaPiedra = FabricaHerramientas.crearHachaDePiedra();

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.cambiarAHerramientaSiguiente();
        inventarioHerramientas.cambiarAHerramientaSiguiente();

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test12HerramientaActualEsLaPrimeraAgregadaYAlCambiarALaAnteriorPasaASerLaUltimaDeTodas(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = FabricaHerramientas.crearHachaDeMadera();
        Herramienta hachaPiedra = FabricaHerramientas.crearHachaDePiedra();

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.cambiarAHerramientaAnterior();

        assertEquals(hachaPiedra, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test13HerramientaActualEsEliminadaCuandoNoHayHerramientasYNoOcurreNada(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        int cantidadHerramientasInicial = inventarioHerramientas.getCantidadHerramientas();

        inventarioHerramientas.eliminarHerramientaActual();

        assertEquals(cantidadHerramientasInicial, inventarioHerramientas.getCantidadHerramientas(), 0);
    }

    @Test
    public void test14HerramientaActualEsObtenidaCuandoNoHayHerramientasYDevuelveNull(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();

        assertNull(inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test15HerramientaActualEsNullCambiarAHerramientaAnteriorCuandoNoHayHerramientas(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        inventarioHerramientas.cambiarAHerramientaAnterior();
        assertNull(inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test16CuandoNoHayHerramientasElInventarioNoTieneHerramientas(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();

        assertTrue(inventarioHerramientas.noTieneHerramientas());
    }

    @Test
    public void test17CuandoHayHerramientasElInventarioTieneHerramientas(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        assertFalse(inventarioHerramientas.noTieneHerramientas());
    }




}