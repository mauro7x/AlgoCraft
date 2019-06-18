package modelo;

import modelo.jugador.Jugador;
import modelo.mapa.Celda;
import modelo.mapa.CeldaVacia;
import modelo.mapa.Mapa;
import org.junit.Test;
import static org.junit.Assert.*;

public class JuegoTest {

    @Test
    public void test01CorrectaInicializacionDelJugadorEnElCentroDelMapa(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Mapa mapa = juego.getMapa();
        Jugador jugador = juego.getJugador();

        assertEquals(mapa.getCeldaCentral().getPosicion(), jugador.getPosicion());
    }

    @Test
    public void test02CorrectoReseteoDeTodasLasVariables(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Mapa mapa = juego.getMapa();
        Celda celdaCentral = mapa.getCeldaCentral();
        Jugador jugador = juego.getJugador();

        mapa.setearOcupanteEn(new CeldaVacia(), celdaCentral.getPosicion().getPosicionArriba());
        jugador.moverArriba();
        assertNotSame(celdaCentral.getPosicion(), jugador.getPosicion());

        juego.resetear();
        jugador = juego.getJugador();
        assertEquals(celdaCentral.getPosicion(), jugador.getPosicion());
    }
}
