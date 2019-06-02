package modelo.jugador;

import org.junit.Test;
import static org.junit.Assert.*;


public class JugadorTest {
    //Tests de inicializacion del jugador

    @Test
    public void test01InicializarJugadorCoordenadaXEs0(){
        Jugador jugador = Jugador.getJugador();
        assertEquals(0,jugador.getPosicionX());
    }

    @Test
    public void test02InicializarJugadorCoordenadaYEs0(){
        Jugador jugador = Jugador.getJugador();
        assertEquals(0,jugador.getPosicionY());
    }

    @Test
    public void test03InicializarJugadorOrientacionEsArriba(){
        Jugador jugador = Jugador.getJugador();
        assertEquals(0,jugador.getOrientacion());
    }
}
