package modelo.jugador;

import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.objetos.herramientas.Herramienta;

public class OrientacionAbajo implements Orientacion {
    @Override
    public void golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        OcupanteDeCelda bloqueAbajo = Juego.getJuego().getMapa().obtenerBloqueAbajoDelJugador(jugador);
        herramientaActual.golpear(bloqueAbajo);
    }
}
