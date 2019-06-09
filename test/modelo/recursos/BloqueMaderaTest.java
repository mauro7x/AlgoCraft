package modelo.recursos;

import modelo.objetos.materiales.*;
import modelo.objetos.herramientas.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class BloqueMaderaTest {

    @Test
    public void test01BloqueMaderaSeInicializaConDurabilidad10() {
        Recurso madera = new BloqueMadera();
        assertEquals(10, madera.getDurabilidad(), 0);
    }

    @Test
    public void test02BloqueMaderaSeGolpeaConUnHachaDeBloqueMaderaYSeReduceSuDurabilidadEn2() {
        Recurso madera = new BloqueMadera();
        Hacha hachaDeMadera = new Hacha(new Madera());
        float durabilidadInicialBloqueMadera = madera.getDurabilidad();

        hachaDeMadera.golpear(madera);

        assertEquals(durabilidadInicialBloqueMadera - 2, madera.getDurabilidad(), 0);

    }

    @Test
    public void test03BloqueMaderaSeGolpeaConUnHachaDePiedraYSeReduceSuDurabilidadEn5() {
        Recurso madera = new BloqueMadera();
        Hacha hachaDePiedra = new Hacha(new Piedra());
        float durabilidadInicialBloqueMadera = madera.getDurabilidad();

        hachaDePiedra.golpear(madera);

        assertEquals(durabilidadInicialBloqueMadera - 5, madera.getDurabilidad(), 0);

    }

    @Test
    public void test04BloqueMaderaSeGolpeaConUnHachaDeMetalYSeReduceSuDurabilidadEn10() {
        Recurso madera = new BloqueMadera();
        Hacha hachaDeMetal = new Hacha(new Metal());
        float durabilidadInicialBloqueMadera = madera.getDurabilidad();

        hachaDeMetal.golpear(madera);

        assertEquals(durabilidadInicialBloqueMadera - 10, madera.getDurabilidad(), 0);

    }

    @Test
    public void test05BloqueMaderaSeGolpeaConUnPicoDeCualquierMaterialYNoSeReduceSuDurabilidad() {
        Recurso madera = new BloqueMadera();
        Pico picoDeMadera = new Pico(new Madera());
        Pico picoDePiedra = new Pico(new Piedra());
        Pico picoDeMetal = new Pico(new Metal());
        float durabilidadInicialBloqueMadera = madera.getDurabilidad();

        picoDeMadera.golpear(madera);
        picoDePiedra.golpear(madera);
        picoDeMetal.golpear(madera);

        assertEquals(durabilidadInicialBloqueMadera, madera.getDurabilidad(), 0);

    }

    @Test
    public void test06BloqueMaderaSeGolpeaConUnPicoFinoYNoSeReduceSuDurabilidad() {
        Recurso madera = new BloqueMadera();
        PicoFino picoFino = new PicoFino(new Piedra(), new Metal());
        float durabilidadInicialBloqueMadera = madera.getDurabilidad();

        picoFino.golpear(madera);

        assertEquals(durabilidadInicialBloqueMadera, madera.getDurabilidad(), 0);

    }

    /* DEFINIR COMPORTAMIENTO
    @Test
    public void test07BloqueMaderaSeGolpeaHastaAgotarDurabilidadY(){}
     */

}
