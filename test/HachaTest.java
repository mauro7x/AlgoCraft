import org.junit.Test;

import static org.junit.Assert.*;

public class HachaTest {

    @Test
    public void test01SeCreaConDurabilidad100() {
        Hacha hacha = new Hacha();
        assertEquals(100, hacha.getDurabilidad());
    }
}