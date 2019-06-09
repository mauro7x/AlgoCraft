package modelo.recursos;

import modelo.objetos.materiales.*;
import modelo.objetos.herramientas.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class BloqueDiamanteTest {

    @Test
    public void test01BloqueDiamanteSeInicializaConDurabilidad100() {
        Recurso diamante = new BloqueDiamante();
        assertEquals(100, diamante.getDurabilidad(), 0);
    }

    @Test
    public void test02BloqueDiamanteSeGolpeaConUnPicoFinoYSeReduceSuDurabilidadEn20() {
        Recurso diamante = new BloqueDiamante();
        PicoFino picoFino = new PicoFino(new Piedra(), new Metal());
        float durabilidadInicialBloqueDiamante = diamante.getDurabilidad();

        picoFino.golpear(diamante);

        assertEquals(durabilidadInicialBloqueDiamante - 20, diamante.getDurabilidad(), 0);

    }

    @Test
    public void test03BloqueDiamanteSeGolpeaConUnHachaDeCualquierMaterialYNoSeReduceSuDurabilidad() {
        Recurso diamante = new BloqueDiamante();
        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDePiedra = new Hacha(new Piedra());
        Hacha hachaDeMetal = new Hacha(new Metal());
        float durabilidadInicialBloqueDiamante = diamante.getDurabilidad();

        hachaDeMadera.golpear(diamante);
        hachaDePiedra.golpear(diamante);
        hachaDeMetal.golpear(diamante);

        assertEquals(durabilidadInicialBloqueDiamante, diamante.getDurabilidad(), 0);

    }

    @Test
    public void test04BloqueDiamanteSeGolpeaConUnPicoDeCualquierMaterialYNoSeReduceSuDurabilidad() {
        Recurso diamante = new BloqueDiamante();
        Pico picoDeMadera = new Pico(new Madera());
        Pico picoDePiedra = new Pico(new Piedra());
        Pico picoDeMetal = new Pico(new Metal());
        float durabilidadInicialBloqueDiamante = diamante.getDurabilidad();

        picoDeMadera.golpear(diamante);
        picoDePiedra.golpear(diamante);
        picoDeMetal.golpear(diamante);

        assertEquals(durabilidadInicialBloqueDiamante, diamante.getDurabilidad(), 0);

    }

    /* DEFINIR COMPORTAMIENTO
    @Test
    public void test05MaderaSeGolpeaHastaAgotarDurabilidadY(){}
     */

}
