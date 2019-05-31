import org.junit.Test;

import static org.junit.Assert.*;

public class HachaDePruebaTest {

    @Test
    public void test01SeCreaConDurabilidad100() {
        HachaDePrueba hachaDePrueba = new HachaDePrueba();
        assertEquals(100, hachaDePrueba.getDurabilidad());
    }
}