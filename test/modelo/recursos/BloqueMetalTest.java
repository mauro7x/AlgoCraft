package modelo.recursos;

import modelo.Juego;
import modelo.jugador.InventarioMateriales;
import modelo.objetos.materiales.*;
import modelo.objetos.herramientas.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class BloqueMetalTest {

    @Test
    public void test01BloqueMetalSeInicializaConDurabilidad50() {
        Recurso metal = new BloqueMetal();
        assertEquals(50, metal.getDurabilidad(), 0);
    }

    @Test
    public void test02BloqueMetalSeGolpeaConUnPicoDePiedraYSeReduceSuDurabilidadEn4() {
        Recurso metal = new BloqueMetal();
        Pico picoDePiedra = new Pico(new Piedra());
        float durabilidadInicialPiedra = metal.getDurabilidad();

        picoDePiedra.golpear(metal);

        assertEquals(durabilidadInicialPiedra - 4, metal.getDurabilidad(), 0);

    }

    @Test
    public void test03BloqueMetalSeGolpeaConUnHachaDeCualquierMaterialYNoSeReduceSuDurabilidad() {
        Recurso metal = new BloqueMetal();
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
        Recurso metal = new BloqueMetal();
        PicoFino picoFino = new PicoFino(new Piedra(), new Metal());
        float durabilidadInicialBloqueMetal = metal.getDurabilidad();

        picoFino.golpear(metal);

        assertEquals(durabilidadInicialBloqueMetal, metal.getDurabilidad(), 0);

    }

    @Test
    public void test05BloqueMetalSeGolpeaConUnPicoDeMaderaYNoSeReduceSuDurabilidad() {
        Recurso metal = new BloqueMetal();
        Pico picoDeMadera = new Pico(new Madera());
        float durabilidadInicialBloqueMetal = metal.getDurabilidad();

        picoDeMadera.golpear(metal);

        assertEquals(durabilidadInicialBloqueMetal, metal.getDurabilidad(), 0);

    }

    @Test
    public void test06BloqueMetalSeGolpeaConUnPicoDeBloqueMetalYNoSeReduceSuDurabilidad() {
        Recurso metal = new BloqueMetal();
        Pico picoDeMetal = new Pico(new Metal());
        float durabilidadInicialBloqueMetal = metal.getDurabilidad();

        picoDeMetal.golpear(metal);

        assertEquals(durabilidadInicialBloqueMetal, metal.getDurabilidad(), 0);

    }

    @Test
    public void test07BloqueMetalSeGolpeaHastaAgotarDurabilidadYSeAgregaUnMetalAlInventarioMaterialesDelJugador(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        InventarioMateriales inventarioMateriales = juego.getJugador().getInventarioMateriales();
        int cantidadInicialDeMetal = inventarioMateriales.getCantidadMateriales((new Metal()).getId());
        Recurso metal = new BloqueMetal();
        Pico picoPiedra = new Pico(new Piedra());

        while (metal.getDurabilidad() > 0){ picoPiedra.golpear(metal); }

        assertEquals(cantidadInicialDeMetal + 1, inventarioMateriales.getCantidadMateriales((new Metal().getId())));
    }




}
