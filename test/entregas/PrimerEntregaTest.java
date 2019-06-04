package entregas;

import modelo.objetos.materiales.*;
import modelo.objetos.herramientas.*;
import modelo.recursos.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class PrimerEntregaTest {


    //Tests de Herramienta:

    @Test
    public void test01SeCreaHachaDeMaderaConDurabilidad100YFuerza2() {
        Hacha hachaDeMadera = new Hacha(new Madera());
        assertEquals(100, hachaDeMadera.getDurabilidad(),0.0001);
        assertEquals(2, hachaDeMadera.getFuerza(),0.0001);
    }

    @Test
    public void test02SeCreaPicoDeMaderaConDurabilidad100YFuerza2() {
        Pico picoDeMadera = new Pico(new Madera());
        assertEquals(100, picoDeMadera.getDurabilidad(),0.0001);
        assertEquals(2, picoDeMadera.getFuerza(),0.0001);

    }

    @Test
    public void test03SeCreaHachaDeMetalConDurabilidad400YFuerza10() {
        Hacha hachaDeMetal = new Hacha(new Metal());
        assertEquals(400, hachaDeMetal.getDurabilidad(),0.0001);
        assertEquals(10, hachaDeMetal.getFuerza(),0.0001);

    }

    @Test
    public void test04SeCreaPicoDeMetalConDurabilidad400YFuerza12() {
        Pico picoDeMetal = new Pico(new Metal());
        assertEquals(400, picoDeMetal.getDurabilidad(),0.0001);
        assertEquals(12, picoDeMetal.getFuerza(),0.0001);
    }

    @Test
    public void test05SeCreaPicoFinoConDurabilidad1000YFuerza20() {
        PicoFino picoFino = new PicoFino();
        assertEquals(1000, picoFino.getDurabilidad(),0.0001);
        assertEquals(20, picoFino.getFuerza(),0.0001);
    }

    @Test
    public void test06HachaSeUsaContraCadaMaterialYReduceSuDurabilidadSegunElMaterial() {
        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDeMetal = new Hacha(new Metal());
        Hacha hachaDePiedra = new Hacha(new Piedra());
        float durabilidadHachaMadera = hachaDeMadera.getDurabilidad();
        float durabilidadHachaMetal = hachaDeMetal.getDurabilidad();
        float durabilidadHachaPiedra = hachaDePiedra.getDurabilidad();
        float fuerzaHachaMadera = hachaDeMadera.getFuerza();
        float fuerzaHachaMetal = hachaDeMetal.getFuerza();
        float fuerzaHachaPiedra = hachaDePiedra.getFuerza();

        hachaDeMadera.golpear(new BloqueMadera());
        hachaDeMadera.golpear(new BloquePiedra());
        hachaDeMadera.golpear(new BloqueMetal());
        hachaDeMadera.golpear(new BloqueDiamante());

        hachaDeMetal.golpear(new BloqueMadera());
        hachaDeMetal.golpear(new BloquePiedra());
        hachaDeMetal.golpear(new BloqueMetal());
        hachaDeMetal.golpear(new BloqueDiamante());

        hachaDePiedra.golpear(new BloqueMadera());
        hachaDePiedra.golpear(new BloquePiedra());
        hachaDePiedra.golpear(new BloqueMetal());
        hachaDePiedra.golpear(new BloqueDiamante());

        assertEquals(durabilidadHachaMadera-4*(fuerzaHachaMadera), hachaDeMadera.getDurabilidad(),0);
        assertEquals(durabilidadHachaMetal-4*(fuerzaHachaMetal/2), hachaDeMetal.getDurabilidad(),0);
        assertEquals(durabilidadHachaPiedra-4*(fuerzaHachaPiedra), hachaDePiedra.getDurabilidad(),0);
    }

    @Test
    public void test07PicoSeUsaContraCadaMaterialYReduceSuDurabilidadSegunElMaterial() {
        Pico picoDeMadera = new Pico(new Madera());
        Pico picoDeMetal = new Pico(new Metal());
        Pico picoDePiedra = new Pico(new Piedra());
        float durabilidadPicoMadera = picoDeMadera.getDurabilidad();
        float durabilidadPicoMetal = picoDeMetal.getDurabilidad();
        float durabilidadPicoPiedra = picoDePiedra.getDurabilidad();
        float fuerzaPicoMadera = picoDeMadera.getFuerza();
        float fuerzaPicoPiedra = picoDePiedra.getFuerza();

        picoDeMadera.golpear(new BloqueMadera());
        picoDeMadera.golpear(new BloquePiedra());
        picoDeMadera.golpear(new BloqueMetal());
        picoDeMadera.golpear(new BloqueDiamante());

        picoDeMetal.golpear(new BloqueMadera());
        picoDeMetal.golpear(new BloquePiedra());
        picoDeMetal.golpear(new BloqueMetal());
        picoDeMetal.golpear(new BloqueDiamante());

        picoDePiedra.golpear(new BloqueMadera());
        picoDePiedra.golpear(new BloquePiedra());
        picoDePiedra.golpear(new BloqueMetal());
        picoDePiedra.golpear(new BloqueDiamante());

        assertEquals(durabilidadPicoMadera-4*(fuerzaPicoMadera), picoDeMadera.getDurabilidad(),0);
        assertEquals(durabilidadPicoMetal, picoDeMetal.getDurabilidad(),0);
        assertEquals(durabilidadPicoPiedra-4*((float)(fuerzaPicoPiedra/1.5)), picoDePiedra.getDurabilidad(),0.001);

        for(int i =0; i <= 6; i++){
            picoDeMetal.golpear(new BloqueMadera());
        }
        assertEquals(0, picoDeMetal.getDurabilidad(),0);

    }

    @Test
    public void test08PicoFinoSeUsaContraDiamanteYReduceSuDurabilidadUn10PorCiento() {
        PicoFino picoFino = new PicoFino();
        float durabilidad = picoFino.getDurabilidad();
        picoFino.golpear(new BloqueDiamante());
        assertEquals(durabilidad-(float)(durabilidad*0.1), picoFino.getDurabilidad(),0.0001);
    }

    @Test
    public void test09PicoFinoSeUsaContraMaterialQueNoSeaDiamanteYNoReduceDurabilidad() {
        PicoFino picoFino = new PicoFino();
        float durabilidadInicial = picoFino.getDurabilidad();
        picoFino.golpear(new BloqueMetal());
        picoFino.golpear(new BloqueMadera());
        picoFino.golpear(new BloquePiedra());
        assertEquals(durabilidadInicial, picoFino.getDurabilidad(),0.0001);

    }



    //Tests de jugador:

    @Test
    public void test01CorrectaCreacionEInicializacionDelJugador() {

    }


    //Tests de Recurso:

    @Test
    public void test01MaderaSeGolpeaConHachaDeMaderaYReduceDurabilidadEn2() {

    }

    @Test
    public void test02PiedraSeGolpeaConHachaYNoReduceDurabilidad() {

    }

    @Test
    public void test03MetalSeGolpeaConPicoDeMaderaYNoReduceDurabilidad() {

    }



    //eof
}
