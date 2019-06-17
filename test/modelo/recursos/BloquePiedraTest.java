package modelo.recursos;

import modelo.Juego;
import modelo.herramientas.FabricaHerramientas;
import modelo.herramientas.Herramienta;
import modelo.jugador.InventarioMateriales;


import org.junit.Test;
import static org.junit.Assert.*;

public class BloquePiedraTest {

    @Test
    public void test01BloquePiedraSeInicializaConDurabilidad30() {
        Recurso piedra = new BloquePiedra();
        assertEquals(30, piedra.getDurabilidad(), 0);
    }

    @Test
    public void test02BloquePiedraSeGolpeaConUnPicoDeMaderaYSeReduceSuDurabilidadEn2() {
        Recurso piedra = new BloquePiedra();
        Herramienta picoDeMadera = FabricaHerramientas.crearPicoDeMadera();
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        picoDeMadera.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra - 2, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test03BloquePiedraSeGolpeaConUnPicoDeBloquePiedraYSeReduceSuDurabilidadEn4() {
        Recurso piedra = new BloquePiedra();
        Herramienta picoDePiedra = FabricaHerramientas.crearPicoDePiedra();
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        picoDePiedra.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra - 4, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test04BloquePiedraSeGolpeaConUnPicoDeMetalYSeReduceSuDurabilidadEn12() {
        Recurso piedra = new BloquePiedra();
        Herramienta picoDeMetal = FabricaHerramientas.crearPicoDeMetal();
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        picoDeMetal.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra - 12, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test05BloquePiedraSeGolpeaConUnHachaDeCualquierMaterialYNoSeReduceSuDurabilidad() {
        Recurso piedra = new BloquePiedra();
        Herramienta hachaDeMadera = FabricaHerramientas.crearHachaDeMadera();
        Herramienta hachaDePiedra = FabricaHerramientas.crearHachaDePiedra();
        Herramienta hachaDeMetal = FabricaHerramientas.crearHachaDeMetal();
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        hachaDeMadera.golpear(piedra);
        hachaDePiedra.golpear(piedra);
        hachaDeMetal.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test06BloquePiedraSeGolpeaConUnPicoFinoYNoSeReduceSuDurabilidad() {
        Recurso piedra = new BloquePiedra();
        Herramienta picoFino = FabricaHerramientas.crearPicoFino();
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        picoFino.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test07BloquePiedraSeGolpeaHastaAgotarDurabilidadYSeAgregaUnPiedraAlInventarioMaterialesDelJugador(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        InventarioMateriales inventarioMateriales = juego.getJugador().getInventarioMateriales();
        int cantidadInicialDePiedra = inventarioMateriales.cantidadPiedra();
        Recurso piedra = new BloquePiedra();
        Herramienta picoMetal = FabricaHerramientas.crearPicoDeMetal();

        while (piedra.getDurabilidad() > 0){ picoMetal.golpear(piedra); }

        assertEquals(cantidadInicialDePiedra + 1, inventarioMateriales.cantidadPiedra());
    }

}
