package modelo.jugador;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Madera;
import modelo.objetos.materiales.Metal;
import modelo.objetos.materiales.Piedra;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioHerramientasTest {

    @Test
    public void test01InventarioHerramientasSeInicializaConLaCorrecta(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();

        assertEquals(0, inventarioHerramientas.getCantidadHerramientas(), 0);
    }

    @Test
    public void test02InventarioHerramientasSeInicializaConNingunaHerramientaEnUso(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();

        assertNull(inventarioHerramientas.getHerramientaEnUso());
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
        inventarioHerramientas.eliminarHerramientaEnUso();

        assertEquals(cantidadHerramientasInicial, inventarioHerramientas.getCantidadHerramientas(), 0);
        assertNull(inventarioHerramientas.getHerramientaEnUso());
    }

    @Test
    public void test05SeAgregaUnaHerramientaSeEstableceAutomaticamenteComoHerramientaEnUso(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        Herramienta herramienta = new PicoFino(new Piedra(), new Metal());

        inventarioHerramientas.guardar(herramienta);

        assertEquals(herramienta, inventarioHerramientas.getHerramientaEnUso());
    }

    @Test
    public void test06SeAgreganDosHerramientasYSePuedeCambiarHerramientaEnUsoAHerramientaSiguiente(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        Herramienta hachaMadera = new Hacha(new Madera());
        Herramienta hachaPiedra = new Hacha(new Piedra());

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaEnUso());

        inventarioHerramientas.cambiarAHerramientaSiguiente();

        assertEquals(hachaPiedra, inventarioHerramientas.getHerramientaEnUso());
    }

    @Test
    public void test07SeAgreganDosHerramientasYSePuedeCambiarHerramientaEnUsoAHerramientaAnterior(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        Herramienta hachaMadera = new Hacha(new Madera());
        Herramienta hachaPiedra = new Hacha(new Piedra());

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.cambiarAHerramientaSiguiente();
        inventarioHerramientas.cambiarAHerramientaAnterior();

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaEnUso());
    }

    @Test
    public void test08HerramientaEnUsoSigueSiendoloSiNoHayHerramientaSiguiente(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        Herramienta hachaMadera = new Hacha(new Madera());

        inventarioHerramientas.guardar(hachaMadera);

        inventarioHerramientas.cambiarAHerramientaSiguiente();

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaEnUso());
    }

    @Test
    public void test09HerramientaEnUsoSigueSiendoloSiNoHayHerramientaAnterior(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        Herramienta hachaMadera = new Hacha(new Madera());

        inventarioHerramientas.guardar(hachaMadera);

        inventarioHerramientas.cambiarAHerramientaAnterior();

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaEnUso());
    }

    @Test
    public void test10HerramientaEnUsoEsEliminadaYLaHerramientaEnUsoPasaASerLaSiguiente(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        Herramienta hachaMadera = new Hacha(new Madera());
        Herramienta hachaPiedra = new Hacha(new Piedra());

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.eliminarHerramientaEnUso();

        assertEquals(hachaPiedra, inventarioHerramientas.getHerramientaEnUso());
    }

    @Test
    public void test11HerramientaEnUsoEsLaUltimaAgregadaYAlCambiarALaProximaPasaASerLaPrimeraDeTodas(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        Herramienta hachaMadera = new Hacha(new Madera());
        Herramienta hachaPiedra = new Hacha(new Piedra());

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.cambiarAHerramientaSiguiente();
        inventarioHerramientas.cambiarAHerramientaSiguiente();

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaEnUso());
    }

    @Test
    public void test12HerramientaEnUsoEsLaPrimeraAgregadaYAlCambiarALaAnteriorPasaASerLaUltimaDeTodas(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas();
        Herramienta hachaMadera = new Hacha(new Madera());
        Herramienta hachaPiedra = new Hacha(new Piedra());

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.cambiarAHerramientaAnterior();

        assertEquals(hachaPiedra, inventarioHerramientas.getHerramientaEnUso());
    }
}