package modelo.recursos;

import modelo.Juego;
import modelo.herramientas.FabricaHerramientas;
import modelo.herramientas.Herramienta;
import modelo.jugador.InventarioMateriales;

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
        Herramienta picoFino = FabricaHerramientas.crearPicoFino();
        float durabilidadInicialBloqueDiamante = diamante.getDurabilidad();

        picoFino.golpear(diamante);

        assertEquals(durabilidadInicialBloqueDiamante - 20, diamante.getDurabilidad(), 0);

    }

    @Test
    public void test03BloqueDiamanteSeGolpeaConUnHachaDeCualquierMaterialYNoSeReduceSuDurabilidad() {
        Recurso diamante = new BloqueDiamante();
        Herramienta hachaDeMadera = FabricaHerramientas.crearHachaDeMadera();
        Herramienta hachaDePiedra = FabricaHerramientas.crearHachaDePiedra();
        Herramienta hachaDeMetal = FabricaHerramientas.crearHachaDeMetal();
        float durabilidadInicialBloqueDiamante = diamante.getDurabilidad();

        hachaDeMadera.golpear(diamante);
        hachaDePiedra.golpear(diamante);
        hachaDeMetal.golpear(diamante);

        assertEquals(durabilidadInicialBloqueDiamante, diamante.getDurabilidad(), 0);

    }

    @Test
    public void test04BloqueDiamanteSeGolpeaConUnPicoDeCualquierMaterialYNoSeReduceSuDurabilidad() {
        Recurso diamante = new BloqueDiamante();
        Herramienta picoDeMadera = FabricaHerramientas.crearPicoDeMadera();
        Herramienta picoDePiedra = FabricaHerramientas.crearPicoDePiedra();
        Herramienta picoDeMetal = FabricaHerramientas.crearPicoDeMetal();
        float durabilidadInicialBloqueDiamante = diamante.getDurabilidad();

        picoDeMadera.golpear(diamante);
        picoDePiedra.golpear(diamante);
        picoDeMetal.golpear(diamante);

        assertEquals(durabilidadInicialBloqueDiamante, diamante.getDurabilidad(), 0);

    }

    @Test
    public void test05BloqueDiamanteSeGolpeaHastaAgotarDurabilidadYSeAgregaUnDiamanteAlInventarioMaterialesDelJugador(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        InventarioMateriales inventarioMateriales = juego.getJugador().getInventarioMateriales();
        int cantidadInicialDeDiamante = inventarioMateriales.cantidadDiamante();
        Recurso diamante = new BloqueDiamante();
        Herramienta picoFino = FabricaHerramientas.crearPicoFino();

        while (diamante.getDurabilidad() > 0){ picoFino.golpear(diamante); }

        assertEquals(cantidadInicialDeDiamante + 1, inventarioMateriales.cantidadDiamante());
    }

    @Test
    public void test06BloqueDiamanteDevuelveSuImagen(){
        Recurso diamante = new BloqueDiamante();
        assertEquals("tileDiamante.png", diamante.obtenerImagen());
    }

}
