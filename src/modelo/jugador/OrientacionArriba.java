package modelo.jugador;

import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.objetos.herramientas.Herramienta;

public class OrientacionArriba implements Orientacion {

    @Override
    public void golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        OcupanteDeCelda bloqueArriba = Juego.getJuego().getMapa().obtenerBloqueArribaDelJugador(jugador);
        herramientaActual.golpear(bloqueArriba);
    }

}
