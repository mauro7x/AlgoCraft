package modelo.jugador;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Madera;
import modelo.objetos.materiales.Metal;
import modelo.objetos.materiales.Piedra;
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
        Herramienta herramienta = new PicoFino(new Piedra(), new Metal());

        inventarioHerramientas.guardar(herramienta);

        assertEquals(cantidadHerramientasInicial + 1, inventarioHerramientas.getCantidadHerramientas(), 0);
    }

    @Test
    public void test04SeEliminaUnaHerramientaYSeModificanLosInvariantes(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        int cantidadHerramientasInicial = inventarioHerramientas.getCantidadHerramientas();
        Herramienta herramienta = new PicoFino(new Piedra(), new Metal());

        inventarioHerramientas.guardar(herramienta);
        inventarioHerramientas.eliminarHerramientaActual();

        assertEquals(cantidadHerramientasInicial, inventarioHerramientas.getCantidadHerramientas(), 0);
    }

    @Test
    public void test05SeAgregaUnaHerramientaSeEstableceAutomaticamenteComoHerramientaEnUso(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta herramienta = new PicoFino(new Piedra(), new Metal());

        inventarioHerramientas.guardar(herramienta);

        assertEquals(herramienta, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test06SeAgreganDosHerramientasYSePuedeCambiarHerramientaEnUsoAHerramientaSiguiente(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = new Hacha(new Madera());
        Herramienta hachaPiedra = new Hacha(new Piedra());

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaActual());

        inventarioHerramientas.cambiarAHerramientaSiguiente();

        assertEquals(hachaPiedra, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test07SeAgreganDosHerramientasYSePuedeCambiarHerramientaEnUsoAHerramientaAnterior(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = new Hacha(new Madera());
        Herramienta hachaPiedra = new Hacha(new Piedra());

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.cambiarAHerramientaSiguiente();
        inventarioHerramientas.cambiarAHerramientaAnterior();

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test08HerramientaEnUsoSigueSiendoloSiNoHayHerramientaSiguiente(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = new Hacha(new Madera());

        inventarioHerramientas.guardar(hachaMadera);

        inventarioHerramientas.cambiarAHerramientaSiguiente();

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test09HerramientaEnUsoSigueSiendoloSiNoHayHerramientaAnterior(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = new Hacha(new Madera());

        inventarioHerramientas.guardar(hachaMadera);

        inventarioHerramientas.cambiarAHerramientaAnterior();

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test10HerramientaEnUsoEsEliminadaYLaHerramientaEnUsoPasaASerLaSiguiente(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = new Hacha(new Madera());
        Herramienta hachaPiedra = new Hacha(new Piedra());

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.eliminarHerramientaActual();

        assertEquals(hachaPiedra, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test11HerramientaEnUsoEsLaUltimaAgregadaYAlCambiarALaProximaPasaASerLaPrimeraDeTodas(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = new Hacha(new Madera());
        Herramienta hachaPiedra = new Hacha(new Piedra());

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.cambiarAHerramientaSiguiente();
        inventarioHerramientas.cambiarAHerramientaSiguiente();

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test12HerramientaEnUsoEsLaPrimeraAgregadaYAlCambiarALaAnteriorPasaASerLaUltimaDeTodas(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        Herramienta hachaMadera = new Hacha(new Madera());
        Herramienta hachaPiedra = new Hacha(new Piedra());

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.cambiarAHerramientaAnterior();

        assertEquals(hachaPiedra, inventarioHerramientas.getHerramientaActual());
    }

    @Test
    public void test13HerramientaEnUsoEsEliminadaCuandoNoHayHerramientasYNoOcurreNada(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        inventarioHerramientas.eliminarHerramientaActual();
        int cantidadHerramientasInicial = inventarioHerramientas.getCantidadHerramientas();

        inventarioHerramientas.eliminarHerramientaActual();

        assertEquals(cantidadHerramientasInicial, inventarioHerramientas.getCantidadHerramientas(), 0);

    }
}