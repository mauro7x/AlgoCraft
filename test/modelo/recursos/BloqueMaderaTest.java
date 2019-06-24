package modelo.recursos;

import modelo.Juego;
import modelo.herramientas.FabricaHerramientas;
import modelo.herramientas.Herramienta;
import modelo.jugador.InventarioMateriales;

import org.junit.Test;
import static org.junit.Assert.*;

public class BloqueMaderaTest {



    @Test
    public void test01BloqueMaderaSeInicializaConDurabilidad10() {
        Recurso madera = new BloqueMadera();
        assertEquals(10, madera.getDurabilidad(), 0);
    }


    @Test
    public void test02BloqueMaderaSeGolpeaConUnHachaMaderaYSeReduceSuDurabilidadEn2() {
        Recurso madera = new BloqueMadera();
        Herramienta hachaDeMadera = FabricaHerramientas.crearHachaDeMadera();
        float durabilidadInicialBloqueMadera = madera.getDurabilidad();

        hachaDeMadera.golpear(madera);

        assertEquals(durabilidadInicialBloqueMadera - 2, madera.getDurabilidad(), 0);

    }


    @Test
    public void test03BloqueMaderaSeGolpeaConUnHachaDePiedraYSeReduceSuDurabilidadEn5() {
        Recurso madera = new BloqueMadera();
        Herramienta hachaDePiedra = FabricaHerramientas.crearHachaDePiedra();
        float durabilidadInicialBloqueMadera = madera.getDurabilidad();

        hachaDePiedra.golpear(madera);

        assertEquals(durabilidadInicialBloqueMadera - 5, madera.getDurabilidad(), 0);

    }


    @Test
    public void test04BloqueMaderaSeGolpeaConUnHachaDeMetalYSeReduceSuDurabilidadEn10() {
        Recurso madera = new BloqueMadera();
        Herramienta hachaDeMetal = FabricaHerramientas.crearHachaDeMetal();
        float durabilidadInicialBloqueMadera = madera.getDurabilidad();

        hachaDeMetal.golpear(madera);

        assertEquals(durabilidadInicialBloqueMadera - 10, madera.getDurabilidad(), 0);

    }


    @Test
    public void test05BloqueMaderaSeGolpeaConUnPicoDeCualquierMaterialYNoSeReduceSuDurabilidad() {
        Recurso madera = new BloqueMadera();
        Herramienta picoDeMadera = FabricaHerramientas.crearPicoDeMadera();
        Herramienta picoDePiedra = FabricaHerramientas.crearPicoDePiedra();
        Herramienta picoDeMetal = FabricaHerramientas.crearPicoDeMetal();
        float durabilidadInicialBloqueMadera = madera.getDurabilidad();

        picoDeMadera.golpear(madera);
        picoDePiedra.golpear(madera);
        picoDeMetal.golpear(madera);

        assertEquals(durabilidadInicialBloqueMadera, madera.getDurabilidad(), 0);

    }


    @Test
    public void test06BloqueMaderaSeGolpeaConUnPicoFinoYNoSeReduceSuDurabilidad() {
        Recurso madera = new BloqueMadera();
        Herramienta picoFino = FabricaHerramientas.crearPicoFino();
        float durabilidadInicialBloqueMadera = madera.getDurabilidad();

        picoFino.golpear(madera);

        assertEquals(durabilidadInicialBloqueMadera, madera.getDurabilidad(), 0);

    }


    @Test
    public void test07BloqueMaderaSeGolpeaHastaAgotarDurabilidadYSeAgregaUnMaderaAlInventarioMaterialesDelJugador(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        InventarioMateriales inventarioMateriales = juego.getJugador().getInventarioMateriales();
        int cantidadInicialDeMadera = inventarioMateriales.cantidadMadera();
        Recurso madera = new BloqueMadera();

        Herramienta hachaMetal = FabricaHerramientas.crearHachaDeMetal();
        while (madera.getDurabilidad() > 0){ hachaMetal.golpear(madera); }
        assertEquals(cantidadInicialDeMadera + 1, inventarioMateriales.cantidadMadera());

    }

    @Test
    public void test06BloqueMaderaDevuelveSuImagen(){
        Recurso madera = new BloqueMadera();
        assertEquals("tileMadera", madera.obtenerImagen());
    }


}
