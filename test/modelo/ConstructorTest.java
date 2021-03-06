package modelo;

import modelo.Juego;
import modelo.Constructor;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructorTest {

    @Test
    public void test01ConstruirHachaDeMadera(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaHachaMadera = { 1,1,0,1,1,0,0,1,0 };
        int resultadoConstruccion = constructor.construir(recetaHachaMadera);
        assertEquals(10,resultadoConstruccion);
    }

    @Test
    public void test02ConstruirHachaDePiedra(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();
        int[] recetaHachaPiedra = { 2,2,0,2,1,0,0,1,0 };
        int resultadoConstruccion = constructor.construir(recetaHachaPiedra);
        assertEquals(11,resultadoConstruccion);
    }

    @Test
    public void test03ConstruirHachaDeMetal(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaHachaMetal = { 3,3,0,3,1,0,0,1,0 };

        int resultadoConstruccion = constructor.construir(recetaHachaMetal);
        assertEquals(12,resultadoConstruccion);
    }

    @Test
    public void test04ConstruirPicoDeMadera(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaPicoMadera = { 1,1,1,0,1,0,0,1,0 };

        int resultadoConstruccion = constructor.construir(recetaPicoMadera);
        assertEquals(13,resultadoConstruccion);
    }

    @Test
    public void test05ConstruirPicoDePiedra(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaPicoPiedra = { 2,2,2,0,1,0,0,1,0 };

        int resultadoConstruccion = constructor.construir(recetaPicoPiedra);
        assertEquals(14,resultadoConstruccion);
    }

    @Test
    public void test06ConstruirPicoDeMetal(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaPicoMetal = { 3,3,3,0,1,0,0,1,0};

        int resultadoConstruccion = constructor.construir(recetaPicoMetal);
        assertEquals(15,resultadoConstruccion);
    }

    @Test
    public void test07ConstruirPicoFino(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaPicoFino = {3,3,3,2,1,0,0,1,0};

        int resultadoConstruccion = constructor.construir(recetaPicoFino);
        assertEquals(16,resultadoConstruccion);
    }

    @Test
    public void test08ConstruirUnaRecetaInexistenteDevuelveSlotVacio(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaInexistente = { 0,0,3,2,1,0,0,1,0 };

        int resultadoConstruccion = constructor.construir(recetaInexistente);
        assertEquals(0,resultadoConstruccion);
    }
}
