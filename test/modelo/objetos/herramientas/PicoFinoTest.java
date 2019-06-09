package modelo.objetos.herramientas;

import modelo.objetos.GuardableEnInventario;
import modelo.recursos.*;
import modelo.objetos.materiales.*;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;


public class PicoFinoTest {

    @Test
    public void test01PicoFinoSeCreaConDurabilidad1000() {
        PicoFino picoFino = new PicoFino(new Piedra(), new Metal());
        assertEquals(1000, picoFino.getDurabilidad(),0.0001);
    }

    @Test
    public void test02PicoFinoSeCreaConFuerza20() {
        PicoFino picoFino = new PicoFino(new Piedra(), new Metal());
        assertEquals(20, picoFino.getFuerza(),0.0001);
    }

    @Test
    public void test03PicoFinoSeDesgastaEnUnDiezPorcientoContraDiamante() {
        PicoFino picoFino = new PicoFino(new Piedra(), new Metal());
        float durabilidadInicial = picoFino.getDurabilidad();
        picoFino.golpear(new BloqueDiamante());
        assertEquals(durabilidadInicial-(durabilidadInicial*(float)(0.1)), picoFino.getDurabilidad(),0.0001);
    }

    @Test
    public void test04PicoFinoNoSeDesgastaContraMaterialQueNoSeaDiamante() {
        PicoFino picoFino = new PicoFino(new Piedra(), new Metal());
        float durabilidadInicial = picoFino.getDurabilidad();
        picoFino.golpear(new BloqueMetal());
        picoFino.golpear(new BloqueMadera());
        picoFino.golpear(new BloquePiedra());
        assertEquals(durabilidadInicial, picoFino.getDurabilidad(),0.0001);
    }

    //Test de id
    @Test
    public void test01CrearPicoFinoIDEs13(){
        GuardableEnInventario pico = new PicoFino(new Piedra(),new Metal());
        assertEquals(21,pico.getId());
    }


}