package modelo.jugador;

import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionIzquierda implements Orientacion {

    @Override
    public void golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        OcupanteDeCelda bloqueIzquierda = Juego.getJuego().getMapa().obtenerBloqueIzquierdaDelJugador(jugador);
        herramientaActual.golpear(bloqueIzquierda);
    }
}
