package modelo.recursos;

import modelo.Juego;
import modelo.jugador.InventarioMateriales;
import modelo.objetos.materiales.*;
import modelo.objetos.herramientas.*;

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
        Pico picoDeMadera = new Pico(new Madera());
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        picoDeMadera.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra - 2, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test03BloquePiedraSeGolpeaConUnPicoDeBloquePiedraYSeReduceSuDurabilidadEn4() {
        Recurso piedra = new BloquePiedra();
        Pico picoDePiedra = new Pico(new Piedra());
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        picoDePiedra.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra - 4, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test04BloquePiedraSeGolpeaConUnPicoDeMetalYSeReduceSuDurabilidadEn12() {
        Recurso piedra = new BloquePiedra();
        Pico picoDeMetal = new Pico(new Metal());
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        picoDeMetal.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra - 12, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test05BloquePiedraSeGolpeaConUnHachaDeCualquierMaterialYNoSeReduceSuDurabilidad() {
        Recurso piedra = new BloquePiedra();
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
        Recurso piedra = new BloquePiedra();
        PicoFino picoFino = new PicoFino(new Piedra(), new Metal());
        float durabilidadInicialBloquePiedra = piedra.getDurabilidad();

        picoFino.golpear(piedra);

        assertEquals(durabilidadInicialBloquePiedra, piedra.getDurabilidad(), 0);

    }

    @Test
    public void test07BloquePiedraSeGolpeaHastaAgotarDurabilidadYSeAgregaUnPiedraAlInventarioMaterialesDelJugador(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        InventarioMateriales inventarioMateriales = juego.getJugador().getInventarioMateriales();
        int cantidadInicialDePiedra = inventarioMateriales.getCantidadMateriales((new Piedra()).getId());
        Recurso piedra = new BloquePiedra();
        Pico picoMetal = new Pico(new Metal());

        while (piedra.getDurabilidad() > 0){ picoMetal.golpear(piedra); }

        assertEquals(cantidadInicialDePiedra + 1, inventarioMateriales.getCantidadMateriales((new Piedra().getId())));
    }

}
