package modelo.herramientas;

import modelo.materiales.*;

import org.junit.Test;
import static org.junit.Assert.*;


public class PicoFinoTest {

    @Test
    public void test01PicoFinoSeCreaConDurabilidad1000() {
        PicoFino picoFino = new PicoFino();
        assertEquals(1000, picoFino.getDurabilidad(),0.0001);
    }

    @Test
    public void test02PicoFinoSeCreaConFuerza20() {
        PicoFino picoFino = new PicoFino();
        assertEquals(20, picoFino.getFuerza(),0.0001);
    }

    @Test
    public void test03PicoFinoSeDesgastaEnUnDiezPorcientoContraDiamante() {
        PicoFino picoFino = new PicoFino();
        float durabilidadInicial = picoFino.getDurabilidad();
        picoFino.usar(new Diamante());
        assertEquals(durabilidadInicial-(durabilidadInicial*(float)(0.1)), picoFino.getDurabilidad(),0.0001);
    }

    @Test
    public void test04PicoFinoNoSeDesgastaContraMaterialQueNoSeaDiamante() {
        PicoFino picoFino = new PicoFino();
        float durabilidadInicial = picoFino.getDurabilidad();
        picoFino.usar(new Metal());
        picoFino.usar(new Madera());
        picoFino.usar(new Piedra());
        assertEquals(durabilidadInicial, picoFino.getDurabilidad(),0.0001);
    }


}