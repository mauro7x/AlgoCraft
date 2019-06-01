import org.junit.Test;

public class PicoTest {

    // Tests para material madera:
    @Test
    public void test01PicoDeMaderaSeCreaConDurabilidad100() {
        Pico picoDeMadera = new Pico(new Madera());
        assertEquals(100, picoDeMadera.getDurabilidad());
    }

    @Test
    public void test02PicoDeMaderaSeCreaConFuerza2() {
        Pico picoDeMadera = new Pico(new Madera());
        assertEquals(2, picoDeMadera.getFuerza());
    }

    @Test
    public void test03PicoDeMaderaSeDesgastaEnSuFuerza() {
        Pico picoDeMadera = new Pico(new Madera());
        int fuerza = picoDeMadera.getFuerza();
        int durabilidadInicial = picoDeMadera.getDurabildiad();
        picoDeMadera.usar();
        assertEquals(durabilidadInicial-fuerza, picoDeMadera.getDurabilidad());
        picoDeMadera.usar();
        assertEquals(durabilidadInicial-fuerza*2, picoDeMadera.getDurabilidad());
        picoDeMadera.usar();
        picoDeMadera.usar();
        picoDeMadera.usar();
        picoDeMadera.usar();
        assertEquals(durabilidadInicial-fuerza*6, picoDeMadera.getDurabilidad());
    }

    // Tests para material piedra:
    @Test
    public void test01PicoDePiedraSeCreaConDurabilidad200() {
        Pico picoDePiedra = new Pico(new Piedra());
        assertEquals(200, picoDePiedra.getDurabilidad());
    }

    @Test
    public void test02PicoDePiedraSeCreaConFuerza4() {
        Pico picoDePiedra = new Pico(new Piedra());
        assertEquals(4, picoDePiedra.getFuerza());
    }

    @Test
    public void test03PicoDePiedraSeDesgastaEnSuFuerzaSobreTresMedios() {
        Pico picoDePiedra = new Pico(new Piedra());
        int fuerzaSobreTresMedios = (picoDePiedra.getFuerza())/1.5;
        int durabilidadInicial = picoDePiedra.getDurabildiad();
        picoDePiedra.usar();
        assertEquals(durabilidadInicial-fuerzaSobreTresMedios, picoDePiedra.getDurabilidad());
        picoDePiedra.usar();
        assertEquals(durabilidadInicial-fuerzaSobreTresMedios*2, picoDePiedra.getDurabilidad());
        picoDePiedra.usar();
        picoDePiedra.usar();
        picoDePiedra.usar();
        picoDePiedra.usar();
        assertEquals(durabilidadInicial-fuerzaSobreTresMedios*6, picoDePiedra.getDurabilidad());
    }

    // Tests para material metal:
    @Test
    public void test01PicoDeMetalSeCreaConDurabilidad400() {
        Pico picoDeMetal = new Pico(new Metal());
        assertEquals(400, picoDeMetal.getDurabilidad());
    }

    @Test
    public void test02PicoDeMetalSeCreaConFuerza12() {
        Pico picoDeMetal = new Pico(new Metal());
        assertEquals(12, picoDeMetal.getFuerza());
    }

    @Test
    public void test03PicoDeMetalNoSeDesgasta() {
        Pico picoDeMetal = new Pico(new Metal());
        int durabilidadInicial = picoDeMetal.getDurabildiad();
        picoDeMetal.usar();
        assertEquals(durabilidadInicial, picoDeMetal.getDurabilidad());
    }

    @Test
    public void test04PicoDeMetalSeRompeAlDecimoGolpe() {
        Pico picoDeMetal = new Pico(new Metal());
        for(int i = 0; i <= 9; i++){
            picoDeMetal.usar();
        }
        assertEquals(0, picoDeMetal.getDurabilidad());
    }


}