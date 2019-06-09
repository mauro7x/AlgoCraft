package modelo.objetos.herramientas;

import modelo.objetos.GuardableEnInventario;
import modelo.objetos.materiales.*;
import modelo.recursos.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class HachaTest {

    // Tests para material madera:
    @Test
    public void test01HachaDeMaderaSeCreaConDurabilidad100() {
        Hacha hachaDeMadera = new Hacha(new Madera());
        assertEquals(100, hachaDeMadera.getDurabilidad(),0.0001);
    }

    @Test
    public void test02HachaDeMaderaSeCreaConFuerza2() {
        Hacha hachaDeMadera = new Hacha(new Madera());
        assertEquals(2, hachaDeMadera.getFuerza(),0.0001);
    }

    @Test
    public void test03HachaDeMaderaSeDesgastaEnSuFuerzaContraCualquierMaterial() {
        Hacha hachaDeMadera = new Hacha(new Madera());
        float fuerza = hachaDeMadera.getFuerza();
        float durabilidadInicial = hachaDeMadera.getDurabilidad();
        hachaDeMadera.golpear(new BloqueMadera());
        assertEquals(durabilidadInicial-fuerza, hachaDeMadera.getDurabilidad(),0.0001);
    }

    // Tests para material piedra:
    @Test
    public void test01HachaDePiedraSeCreaConDurabilidad200() {
        Hacha hachaDePiedra = new Hacha(new Piedra());
        assertEquals(200, hachaDePiedra.getDurabilidad(),0.0001);
    }

    @Test
    public void test02HachaDePiedraSeCreaConFuerza5() {
        Hacha hachaDePiedra = new Hacha(new Piedra());
        assertEquals(5, hachaDePiedra.getFuerza(),0.0001);
    }

    @Test
    public void test03HachaDePiedraSeDesgastaEnSuFuerzaContraCualquierMaterial() {
        Hacha hachaDePiedra = new Hacha(new Piedra());
        float fuerza = hachaDePiedra.getFuerza();
        float durabilidadInicial = hachaDePiedra.getDurabilidad();
        hachaDePiedra.golpear(new BloqueMadera());
        assertEquals(durabilidadInicial-fuerza, hachaDePiedra.getDurabilidad(),0.0001);
    }

    // Tests para material metal:
    @Test
    public void test01HachaDeMetalSeCreaConDurabilidad400() {
        Hacha hachaDeMetal = new Hacha(new Metal());
        assertEquals(400, hachaDeMetal.getDurabilidad(),0.0001);
    }

    @Test
    public void test02HachaDeMetalSeCreaConFuerza10() {
        Hacha hachaDeMetal = new Hacha(new Metal());
        assertEquals(10, hachaDeMetal.getFuerza(),0.0001);
    }

    @Test
    public void test03HachaDeMetalSeDesgastaEnLaMitadDeSuFuerzaContraCualquierMaterial() {
        Hacha hachaDeMetal = new Hacha(new Metal());
        float fuerza = hachaDeMetal.getFuerza();
        float durabilidadInicial = hachaDeMetal.getDurabilidad();
        hachaDeMetal.golpear(new BloqueMadera());
        assertEquals(durabilidadInicial-(fuerza/2), hachaDeMetal.getDurabilidad(),0.0001);
    }

    //Test de id
    @Test
    public void test01CrearHachaIDEs11(){
        GuardableEnInventario hacha = new Hacha(new Madera());
        assertEquals(22,hacha.getId());
    }
}