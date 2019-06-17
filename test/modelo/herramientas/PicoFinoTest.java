package modelo.herramientas;

import modelo.recursos.*;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


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

    //Test de id
    @Test
    public void test01CrearPicoFinoIDEs16(){
        Herramienta pico = FabricaHerramientas.crearPicoFino();
        assertEquals(16,pico.getId());
    }


}