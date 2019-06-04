package modelo.recursos;

import modelo.objetos.materiales.*;
import modelo.objetos.herramientas.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class BloquePiedraTest {

    @Test
    public void test01BloquePiedraSeInicializaConDurabilidad30() {
        BloquePiedra piedra = new BloquePiedra();
        assertEquals(30, piedra.getDurabilidad(), 0);
    }

    @Test
    public void test02BloquePiedraSeGolpeaConUnPicoDeMaderaYSeReduceSuDurabilidadEn2() {
        BloquePiedra piedra = new BloquePiedra();
        Pico picoDeMadera = new Pico(new Madera());
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        picoDeMadera.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra - 2, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test03BloquePiedraSeGolpeaConUnPicoDeBloquePiedraYSeReduceSuDurabilidadEn4() {
        BloquePiedra piedra = new BloquePiedra();
        Pico picoDePiedra = new Pico(new Piedra());
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        picoDePiedra.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra - 4, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test04BloquePiedraSeGolpeaConUnPicoDeMetalYSeReduceSuDurabilidadEn12() {
        BloquePiedra piedra = new BloquePiedra();
        Pico picoDeMetal = new Pico(new Metal());
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        picoDeMetal.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra - 12, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test05BloquePiedraSeGolpeaConUnHachaDeCualquierMaterialYNoSeReduceSuDurabilidad() {
        BloquePiedra piedra = new BloquePiedra();
        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDePiedra = new Hacha(new Piedra());
        Hacha hachaDeMetal = new Hacha(new Metal());
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        hachaDeMadera.golpear(piedra);
        hachaDePiedra.golpear(piedra);
        hachaDeMetal.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test06BloquePiedraSeGolpeaConUnPicoFinoYNoSeReduceSuDurabilidad() {
        BloquePiedra piedra = new BloquePiedra();
        PicoFino picoFino = new PicoFino();
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        picoFino.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra, piedra.getDurabilidad(), 0);

    }
    
    /* DEFINIR COMPORTAMIENTO
    @Test
    public void test07BloquePiedraSeGolpeaHastaAgotarDurabilidadY(){}
     */

}
