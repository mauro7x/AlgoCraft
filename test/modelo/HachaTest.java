import org.junit.Test;
import modelo.herramientas.*;
import modelo.materiales.*;


import static org.junit.Assert.*;

public class HachaTest {

    // Tests para material madera:
    @Test
    public void test01HachaDeMaderaSeCreaConDurabilidad100() {
        Hacha hachaDeMadera = new Hacha(new Madera());
        assertEquals(100, hachaDeMadera.getDurabilidad());
    }

    @Test
    public void test02HachaDeMaderaSeCreaConFuerza2() {
        Hacha hachaDeMadera = new Hacha(new Madera());
        assertEquals(2, hachaDeMadera.getFuerza());
    }

    @Test
    public void test03HachaDeMaderaSeDesgastaEnSuFuerza() {
        Hacha hachaDeMadera = new Hacha(new Madera());
        int fuerza = hachaDeMadera.getFuerza();
        int durabilidadInicial = hachaDeMadera.getDurabilidad();
        hachaDeMadera.usar();
        assertEquals(durabilidadInicial-fuerza, hachaDeMadera.getDurabilidad());
        hachaDeMadera.usar();
        assertEquals(durabilidadInicial-fuerza*2, hachaDeMadera.getDurabilidad());
        hachaDeMadera.usar();
        hachaDeMadera.usar();
        hachaDeMadera.usar();
        hachaDeMadera.usar();
        assertEquals(durabilidadInicial-fuerza*6, hachaDeMadera.getDurabilidad());
    }

    // Tests para material piedra:
    @Test
    public void test01HachaDePiedraSeCreaConDurabilidad200() {
        Hacha hachaDePiedra = new Hacha(new Piedra());
        assertEquals(200, hachaDePiedra.getDurabilidad());
    }

    @Test
    public void test02HachaDePiedraSeCreaConFuerza5() {
        Hacha hachaDePiedra = new Hacha(new Piedra());
        assertEquals(5, hachaDePiedra.getFuerza());
    }

    @Test
    public void test03HachaDePiedraSeDesgastaEnSuFuerza() {
        Hacha hachaDePiedra = new Hacha(new Piedra());
        int fuerza = hachaDePiedra.getFuerza();
        int durabilidadInicial = hachaDePiedra.getDurabilidad();
        hachaDePiedra.usar();
        assertEquals(durabilidadInicial-fuerza, hachaDePiedra.getDurabilidad());
        hachaDePiedra.usar();
        assertEquals(durabilidadInicial-fuerza*2, hachaDePiedra.getDurabilidad());
        hachaDePiedra.usar();
        hachaDePiedra.usar();
        hachaDePiedra.usar();
        hachaDePiedra.usar();
        assertEquals(durabilidadInicial-fuerza*6, hachaDePiedra.getDurabilidad());
    }

    // Tests para material metal:
    @Test
    public void test01HachaDeMetalSeCreaConDurabilidad400() {
        Hacha hachaDeMetal = new Hacha(new Metal());
        assertEquals(400, hachaDeMetal.getDurabilidad());
    }

    @Test
    public void test02HachaDeMetalSeCreaConFuerza10() {
        Hacha hachaDeMetal = new Hacha(new Metal());
        assertEquals(10, hachaDeMetal.getFuerza());
    }

    @Test
    public void test03HachaDeMetalSeDesgastaEnLaMitadDeSuFuerza() {
        Hacha hachaDeMetal = new Hacha(new Metal());
        int mitadFuerza = (hachaDeMetal.getFuerza())/2;
        int durabilidadInicial = hachaDeMetal.getDurabilidad();
        hachaDeMetal.usar();
        assertEquals(durabilidadInicial-mitadFuerza, hachaDeMetal.getDurabilidad());
        hachaDeMetal.usar();
        assertEquals(durabilidadInicial-mitadFuerza*2, hachaDeMetal.getDurabilidad());
        hachaDeMetal.usar();
        hachaDeMetal.usar();
        hachaDeMetal.usar();
        hachaDeMetal.usar();
        assertEquals(durabilidadInicial-mitadFuerza*6, hachaDeMetal.getDurabilidad());
    }
}