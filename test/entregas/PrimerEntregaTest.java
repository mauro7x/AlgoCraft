import org.junit.Test;
import static org.junit.Assert.*;

import modelo.herramientas.*;
import modelo.materiales.*;

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

        hachaDeMadera.usar(new Madera());
        hachaDeMadera.usar(new Piedra());
        hachaDeMadera.usar(new Metal());
        hachaDeMadera.usar(new Diamante());

        hachaDeMetal.usar(new Madera());
        hachaDeMetal.usar(new Piedra());
        hachaDeMetal.usar(new Metal());
        hachaDeMetal.usar(new Diamante());

        hachaDePiedra.usar(new Madera());
        hachaDePiedra.usar(new Piedra());
        hachaDePiedra.usar(new Metal());
        hachaDePiedra.usar(new Diamante());

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

        picoDeMadera.usar(new Madera());
        picoDeMadera.usar(new Piedra());
        picoDeMadera.usar(new Metal());
        picoDeMadera.usar(new Diamante());

        picoDeMetal.usar(new Madera());
        picoDeMetal.usar(new Piedra());
        picoDeMetal.usar(new Metal());
        picoDeMetal.usar(new Diamante());

        picoDePiedra.usar(new Madera());
        picoDePiedra.usar(new Piedra());
        picoDePiedra.usar(new Metal());
        picoDePiedra.usar(new Diamante());

        assertEquals(durabilidadPicoMadera-4*(fuerzaPicoMadera), picoDeMadera.getDurabilidad(),0);
        assertEquals(durabilidadPicoMetal, picoDeMetal.getDurabilidad(),0);
        assertEquals(durabilidadPicoPiedra-4*((float)(fuerzaPicoPiedra/1.5)), picoDePiedra.getDurabilidad(),0.001);

        for(int i =0; i <= 6; i++){
            picoDeMetal.usar(new Madera());
        }
        assertEquals(0, picoDeMetal.getDurabilidad(),0);

    }

    @Test
    public void test08PicoFinoSeUsaContraDiamanteYReduceSuDurabilidadUn10PorCiento() {
        PicoFino picoFino = new PicoFino();
        float durabilidad = picoFino.getDurabilidad();
        picoFino.usar(new Diamante());
        assertEquals(durabilidad-(float)(durabilidad*0.1), picoFino.getDurabilidad(),0.0001);
    }

    @Test
    public void test09PicoFinoSeUsaContraMaterialQueNoSeaDiamanteYNoReduceDurabilidad() {
        PicoFino picoFino = new PicoFino();
        float durabilidadInicial = picoFino.getDurabilidad();
        picoFino.usar(new Metal());
        picoFino.usar(new Madera());
        picoFino.usar(new Piedra());
        assertEquals(durabilidadInicial, picoFino.getDurabilidad(),0.0001);

    }



    //Tests de jugador:

    @Test
    public void test01CorrectaCreacionEInicializacionDelJugador() {

    }


    //Tests de Material:

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
