package modelo.jugador;

import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionArriba implements Orientacion {

    private static String imagen = "jugadorArriba.png";

    @Override
    public void golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        OcupanteDeCelda bloqueArriba = Juego.getJuego().getMapa().obtenerBloqueArribaDelJugador(jugador);
        herramientaActual.golpear(bloqueArriba);
    }

    @Override
    public String obtenerImagen() {
        return imagen;
    }
}
