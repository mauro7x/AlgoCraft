package modelo.jugador;

import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionDerecha implements Orientacion {
    @Override
    public void golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        OcupanteDeCelda bloqueDerecha = Juego.getJuego().getMapa().obtenerBloqueDerechaDelJugador(jugador);
        herramientaActual.golpear(bloqueDerecha);
    }
}
