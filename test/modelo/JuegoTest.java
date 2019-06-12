package modelo;

import modelo.mapa.Celda;
import modelo.mapa.Mapa;
import org.junit.Test;
import static org.junit.Assert.*;

public class JuegoTest {

    @Test
    public void test01CorrectaInicializacionDelJugadorEnElCentroDelMapa(){
        Juego juego = Juego.getJuego();
        juego.resetear();

        Mapa mapa = juego.getMapa();
        Celda celdaCentral = mapa.getCeldaCentral();
        Jugador jugador = juego.getJugador();
        assertEquals(celdaCentral.getX(), jugador.getX());
        assertEquals(celdaCentral.getY(), jugador.getY());
    }

    @Test
    public void test02CorrectoReseteoDeTodasLasVariables(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Mapa mapa = juego.getMapa();
        Celda celdaCentral = mapa.getCeldaCentral();
        Jugador jugador = juego.getJugador();

        jugador.moverArriba();
        assertNotEquals(celdaCentral.getY(), jugador.getY());

        juego.resetear();
        jugador = juego.getJugador();
        assertEquals(celdaCentral.getY(), jugador.getY());
    }




}
