package modelo.jugador;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Madera;
import modelo.objetos.materiales.Metal;
import modelo.objetos.materiales.Piedra;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioHerramientasTest {

    final int cantidadDeSlots = 15;

    @Test
    public void test01InventarioHerramientasSeInicializaConLaCantidadDeSlotsCorrecta(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas(cantidadDeSlots);

        assertEquals(cantidadDeSlots, inventarioHerramientas.getCantidadSlotsDisponibles(), 0);
    }

    @Test
    public void test02InventarioHerramientasSeInicializaConNingunaHerramientaEnUso(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas(cantidadDeSlots);

        assertNull(inventarioHerramientas.getHerramientaEnUso());
    }

    @Test
    public void test03SeAgregaUnaHerramientaYSeModificanLosInvariantes(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas(cantidadDeSlots);
        int cantidadSlotsDisponiblesInicialmente = inventarioHerramientas.getCantidadSlotsDisponibles();
        Herramienta herramienta = new PicoFino(new Piedra(), new Metal());
        inventarioHerramientas.guardar(herramienta);
        assertEquals(cantidadSlotsDisponiblesInicialmente - 1, inventarioHerramientas.getCantidadSlotsDisponibles(), 0);
    }

    @Test
    public void test04SeEliminaUnaHerramientaYSeModificanLosInvariantes(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas(cantidadDeSlots);
        int cantidadSlotsDisponiblesInicialmente = inventarioHerramientas.getCantidadSlotsDisponibles();
        Herramienta herramienta = new PicoFino(new Piedra(), new Metal());
        inventarioHerramientas.guardar(herramienta);
        inventarioHerramientas.establecerHerramientaEnUso(0);
        inventarioHerramientas.eliminar(0);
        assertEquals(cantidadSlotsDisponiblesInicialmente, inventarioHerramientas.getCantidadSlotsDisponibles(), 0);
        assertNull(inventarioHerramientas.getHerramientaEnUso());
    }

    @Test
    public void test05SeAgregaUnaHerramientaYSeLaPuedeEstablecerComoHerramientaEnUso(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas(cantidadDeSlots);
        Herramienta herramienta = new PicoFino(new Piedra(), new Metal());

        inventarioHerramientas.guardar(herramienta);
        inventarioHerramientas.establecerHerramientaEnUso(0);

        assertEquals(herramienta, inventarioHerramientas.getHerramientaEnUso());
    }

    @Test
    public void test06SeAgreganDosHerramientasYSeLasPuedeEstablecerComoHerramientaEnUso(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas(cantidadDeSlots);
        Herramienta hachaMadera = new Hacha(new Madera());
        Herramienta hachaPiedra = new Hacha(new Piedra());

        inventarioHerramientas.guardar(hachaMadera);
        inventarioHerramientas.guardar(hachaPiedra);

        inventarioHerramientas.establecerHerramientaEnUso(0);

        assertEquals(hachaMadera, inventarioHerramientas.getHerramientaEnUso());

        inventarioHerramientas.establecerHerramientaEnUso(1);

        assertEquals(hachaPiedra, inventarioHerramientas.getHerramientaEnUso());
    }

    @Test
    public void test07NoSePuedeGuardarHerramientaCuandoNoHaySlotsDisponibles(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas(0);
        Herramienta herramienta = new Hacha(new Madera());

        assertFalse(inventarioHerramientas.guardar(herramienta));
    }

    @Test
    public void test08SePuedeGuardarHerramientaSiSeLiberaSlot(){
        InventarioHerramientas inventarioHerramientas = new InventarioHerramientas(1);
        Herramienta herramienta = new Hacha(new Madera());

        inventarioHerramientas.guardar(herramienta);

        assertFalse(inventarioHerramientas.guardar(herramienta));

        inventarioHerramientas.eliminar(0);

        assertTrue(inventarioHerramientas.guardar(herramienta));
    }
}