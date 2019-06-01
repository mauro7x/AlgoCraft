import org.junit.Test;
import modelo.herramientas.*;

import static org.junit.Assert.*;

public class PicoFinoTest {

    @Test
    public void test01PicoFinoSeCreaConDurabilidad1000() {
        PicoFino picoFino = new PicoFino();
        assertEquals(1000, picoFino.getDurabilidad(), 0);
    }

    @Test
    public void test02PicoFinoSeCreaConFuerza20() {
        PicoFino picoFino = new PicoFino();
        assertEquals(20, picoFino.getFuerza(), 0);
    }

    @Test
    public void test03PicoFinoSeDesgastaEnUnDiezPorciento() {
        PicoFino picoFino = new PicoFino();
        float durabilidadInicial = picoFino.getDurabilidad();
        picoFino.usar();
        assertEquals(durabilidadInicial-(durabilidadInicial*(float)(0.1)), picoFino.getDurabilidad(), 0);
    }


}