package modelo.recursos;

import modelo.Juego;
import modelo.herramientas.FabricaHerramientas;
import modelo.herramientas.Herramienta;
import modelo.jugador.InventarioMateriales;

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
        Herramienta picoDePiedra = FabricaHerramientas.crearPicoDePiedra();
        float durabilidadInicialPiedra = metal.getDurabilidad();

        picoDePiedra.golpear(metal);

        assertEquals(durabilidadInicialPiedra - 4, metal.getDurabilidad(), 0);

    }

    @Test
    public void test03BloqueMetalSeGolpeaConUnHachaDeCualquierMaterialYNoSeReduceSuDurabilidad() {
        Recurso metal = new BloqueMetal();
        Herramienta hachaDeMadera = FabricaHerramientas.crearHachaDeMadera();
        Herramienta hachaDePiedra = FabricaHerramientas.crearHachaDePiedra();
        Herramienta hachaDeMetal = FabricaHerramientas.crearHachaDeMetal();
        float durabilidadInicialBloqueMetal = metal.getDurabilidad();

        hachaDeMadera.golpear(metal);
        hachaDePiedra.golpear(metal);
        hachaDeMetal.golpear(metal);

        assertEquals(durabilidadInicialBloqueMetal, metal.getDurabilidad(), 0);

    }

    @Test
    public void test04BloqueMetalSeGolpeaConUnPicoFinoYNoSeReduceSuDurabilidad() {
        Recurso metal = new BloqueMetal();
        Herramienta picoFino = FabricaHerramientas.crearPicoFino();
        float durabilidadInicialBloqueMetal = metal.getDurabilidad();

        picoFino.golpear(metal);

        assertEquals(durabilidadInicialBloqueMetal, metal.getDurabilidad(), 0);

    }

    @Test
    public void test05BloqueMetalSeGolpeaConUnPicoDeMaderaYNoSeReduceSuDurabilidad() {
        Recurso metal = new BloqueMetal();
        Herramienta picoDeMadera = FabricaHerramientas.crearPicoDeMadera();
        float durabilidadInicialBloqueMetal = metal.getDurabilidad();

        picoDeMadera.golpear(metal);

        assertEquals(durabilidadInicialBloqueMetal, metal.getDurabilidad(), 0);

    }

    @Test
    public void test06BloqueMetalSeGolpeaConUnPicoDeBloqueMetalYNoSeReduceSuDurabilidad() {
        Recurso metal = new BloqueMetal();
        Herramienta picoDeMetal = FabricaHerramientas.crearPicoDeMetal();
        float durabilidadInicialBloqueMetal = metal.getDurabilidad();

        picoDeMetal.golpear(metal);

        assertEquals(durabilidadInicialBloqueMetal, metal.getDurabilidad(), 0);

    }

    @Test
    public void test07BloqueMetalSeGolpeaHastaAgotarDurabilidadYSeAgregaUnMetalAlInventarioMaterialesDelJugador(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        InventarioMateriales inventarioMateriales = juego.getJugador().getInventarioMateriales();
        int cantidadInicialDeMetal = inventarioMateriales.cantidadMetal();
        Recurso metal = new BloqueMetal();
        Herramienta picoPiedra = FabricaHerramientas.crearPicoDePiedra();

        while (metal.getDurabilidad() > 0){ picoPiedra.golpear(metal); }

        assertEquals(cantidadInicialDeMetal + 1, inventarioMateriales.cantidadMetal());
    }




}
