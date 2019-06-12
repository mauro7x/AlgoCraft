package modelo;

import modelo.mapa.Celda;
import modelo.mapa.Mapa;
import org.junit.Test;
import static org.junit.Assert.*;


public class JugadorTest {
    //Tests de inicializacion del jugador

    @Test
    public void test01InicializarJugadorCoordenadaXCentral(){
        Juego juego = Juego.getJuego();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Celda celdaCentral = mapa.getCeldaCentral();
        assertEquals(celdaCentral.getX(),jugador.getPosicionX());

    }

    @Test
    public void test02InicializarJugadorCoordenadaYCentral(){
        Juego juego = Juego.getJuego();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Celda celdaCentral = mapa.getCeldaCentral();
        assertEquals(celdaCentral.getY(),jugador.getPosicionY());
    }

    @Test
    public void test03InicializarJugadorOrientacionEsArriba(){
        Juego juego = Juego.getJuego();
        Jugador jugador = juego.getJugador();
        assertEquals(0,jugador.getOrientacion());
    }
}
