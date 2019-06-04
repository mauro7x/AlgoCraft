package modelo.recursos;

import modelo.objetos.materiales.*;
import modelo.objetos.herramientas.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class BloqueMetalTest {

    @Test
    public void test01BloqueMetalSeInicializaConDurabilidad50() {
        BloqueMetal metal = new BloqueMetal();
        assertEquals(50, metal.getDurabilidad(), 0);
    }

    @Test
    public void test02BloqueMetalSeGolpeaConUnPicoDePiedraYSeReduceSuDurabilidadEn4() {
        BloqueMetal metal = new BloqueMetal();
        Pico picoDePiedra = new Pico(new Piedra());
        float durabilidadInicialPiedra = metal.getDurabilidad();

        picoDePiedra.golpear(metal);

        assertEquals(durabilidadInicialPiedra - 4, metal.getDurabilidad(), 0);

    }

    @Test
    public void test03BloqueMetalSeGolpeaConUnHachaDeCualquierMaterialYNoSeReduceSuDurabilidad() {
        BloqueMetal metal = new BloqueMetal();
        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDePiedra = new Hacha(new Piedra());
        Hacha hachaDeMetal = new Hacha(new Metal());
        float durabilidadInicialBloqueMetal = metal.getDurabilidad();

        hachaDeMadera.golpear(metal);
        hachaDePiedra.golpear(metal);
        hachaDeMetal.golpear(metal);

        assertEquals(durabilidadInicialBloqueMetal, metal.getDurabilidad(), 0);

    }

    @Test
    public void test04BloqueMetalSeGolpeaConUnPicoFinoYNoSeReduceSuDurabilidad() {
        BloqueMetal metal = new BloqueMetal();
        PicoFino picoFino = new PicoFino();
        float durabilidadInicialBloqueMetal = metal.getDurabilidad();

        picoFino.golpear(metal);

        assertEquals(durabilidadInicialBloqueMetal, metal.getDurabilidad(), 0);

    }

    @Test
    public void test05BloqueMetalSeGolpeaConUnPicoDeMaderaYNoSeReduceSuDurabilidad() {
        BloqueMetal metal = new BloqueMetal();
        Pico picoDeMadera = new Pico(new Madera());
        float durabilidadInicialBloqueMetal = metal.getDurabilidad();

        picoDeMadera.golpear(metal);

        assertEquals(durabilidadInicialBloqueMetal, metal.getDurabilidad(), 0);

    }

    @Test
    public void test06BloqueMetalSeGolpeaConUnPicoDeBloqueMetalYNoSeReduceSuDurabilidad() {
        BloqueMetal metal = new BloqueMetal();
        Pico picoDeMetal = new Pico(new Metal());
        float durabilidadInicialBloqueMetal = metal.getDurabilidad();

        picoDeMetal.golpear(metal);

        assertEquals(durabilidadInicialBloqueMetal, metal.getDurabilidad(), 0);

    }
    
    /* DEFINIR COMPORTAMIENTO
    @Test
    public void test07BloqueMetalSeGolpeaHastaAgotarDurabilidadY(){}
     */

}
