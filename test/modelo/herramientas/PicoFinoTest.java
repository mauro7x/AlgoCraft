package modelo.herramientas;

import modelo.Juego;
import modelo.jugador.InventarioHerramientas;
import modelo.recursos.*;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class PicoFinoTest {

    @Test
    public void test01PicoFinoSeCreaConDurabilidad1000() {
        Herramienta picoFino = FabricaHerramientas.crearPicoFino(); 
        assertEquals(1000, picoFino.getDurabilidad(),0.0001);
    }

    @Test
    public void test02PicoFinoSeCreaConFuerza20() {
        Herramienta picoFino = FabricaHerramientas.crearPicoFino(); 
        assertEquals(20, picoFino.getFuerza(),0.0001);
    }

    @Test
    public void test03PicoFinoSeDesgastaEnUnDiezPorcientoContraDiamante() {
        Herramienta picoFino = FabricaHerramientas.crearPicoFino(); 
        float durabilidadInicial = picoFino.getDurabilidad();
        picoFino.golpear(new BloqueDiamante());
        assertEquals(durabilidadInicial-(durabilidadInicial*(float)(0.1)), picoFino.getDurabilidad(),0.0001);
    }

    @Test
    public void test04PicoFinoNoSeDesgastaContraMaterialQueNoSeaDiamante() {
        Herramienta picoFino = FabricaHerramientas.crearPicoFino(); 
        float durabilidadInicial = picoFino.getDurabilidad();
        picoFino.golpear(new BloqueMetal());
        picoFino.golpear(new BloqueMadera());
        picoFino.golpear(new BloquePiedra());
        assertEquals(durabilidadInicial, picoFino.getDurabilidad(),0.0001);
    }

    @Test
    public void test05PicoFinoSeRompeCuandoSuDurabilidadEsMenorA1() {
        Juego.getJuego().resetear();
        Herramienta picoFino = FabricaHerramientas.crearPicoFino();

        while(picoFino.getDurabilidad()>1){
            picoFino.gastar();
        }
        assertEquals(0, picoFino.getDurabilidad(), 0.0001);
    }

    //Test de id
    @Test
    public void test01CrearPicoFinoIDEs16(){
        Herramienta pico = FabricaHerramientas.crearPicoFino();
        assertEquals(16,pico.getId());
    }

    //Tests de imagen

    @Test
    public void test01PicoFinoDevuelveSuImagen(){
        Herramienta picoFino = FabricaHerramientas.crearPicoFino();
        assertEquals("picoFino.png",picoFino.obtenerImagen());
    }

}