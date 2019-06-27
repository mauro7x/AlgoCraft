package entregas;

import modelo.Constructor;

import modelo.Juego;

import modelo.jugador.Jugador;
import modelo.mapa.Celda;
import modelo.mapa.CeldaVacia;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import org.junit.Test;

import static org.junit.Assert.*;


public class SegundaEntregaTest {

    //Pruebas de Construccion de herramienta
    @Test
    public void test01HachaDeMaderaSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaHachaMadera = { 1,1,0,1,1,0,0,1,0 };
        int resultadoConstruccion = constructor.construir(recetaHachaMadera);
        assertEquals(10,resultadoConstruccion);
    }

    @Test
    public void test02HachaDePiedraSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();
        int[] recetaHachaPiedra = { 2,2,0,2,1,0,0,1,0 };
        int resultadoConstruccion = constructor.construir(recetaHachaPiedra);
        assertEquals(11,resultadoConstruccion);
    }

    @Test
    public void test03HachaDeMetalSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaHachaMetal = { 3,3,0,3,1,0,0,1,0 };

        int resultadoConstruccion = constructor.construir(recetaHachaMetal);
        assertEquals(12,resultadoConstruccion);
    }

    @Test
    public void test04PicoDeMaderaSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaPicoMadera = { 1,1,1,0,1,0,0,1,0 };

        int resultadoConstruccion = constructor.construir(recetaPicoMadera);
        assertEquals(13,resultadoConstruccion);
    }

    @Test
    public void test05PicoDePiedraSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaPicoPiedra = { 2,2,2,0,1,0,0,1,0 };

        int resultadoConstruccion = constructor.construir(recetaPicoPiedra);
        assertEquals(14,resultadoConstruccion);
    }

    @Test
    public void test06PicoDeMetalSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaPicoMetal = { 3,3,3,0,1,0,0,1,0};

        int resultadoConstruccion = constructor.construir(recetaPicoMetal);
        assertEquals(15,resultadoConstruccion);
    }

    @Test
    public void test07PicoFinoSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaPicoFino = {3,3,3,2,1,0,0,1,0};

        int resultadoConstruccion = constructor.construir(recetaPicoFino);
        assertEquals(16,resultadoConstruccion);
    }

    //Pruebas de Jugador
    @Test
    public void test01JugadorSeInicializaDeLaFormaCorrectaEnElMapa(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Celda celdaCentral = mapa.getCeldaCentral();
        assertEquals(jugador.getPosicion(), celdaCentral.getPosicion());
    }

    @Test
    public void test02JugadorPuedeMoverseParaTodasLasDireccionesVacias(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Posicion posicionInicialJugador = jugador.getPosicion();

        mapa.setearOcupanteEn(new CeldaVacia(), posicionInicialJugador.getPosicionArriba());
        mapa.setearOcupanteEn(new CeldaVacia(), posicionInicialJugador.getPosicionAbajo());
        mapa.setearOcupanteEn(new CeldaVacia(), posicionInicialJugador.getPosicionDerecha());
        mapa.setearOcupanteEn(new CeldaVacia(), posicionInicialJugador.getPosicionIzquierda());

        jugador.moverArriba();
        assertEquals(posicionInicialJugador.getPosicionArriba(), jugador.getPosicion());
        jugador.moverAbajo();
        jugador.moverAbajo();
        assertEquals(posicionInicialJugador.getPosicionAbajo(), jugador.getPosicion());
        jugador.moverArriba();
        jugador.moverDerecha();
        assertEquals(posicionInicialJugador.getPosicionDerecha(), jugador.getPosicion());
        jugador.moverIzquierda();
        jugador.moverIzquierda();
        assertEquals(posicionInicialJugador.getPosicionIzquierda(), jugador.getPosicion());

    }
    
}
