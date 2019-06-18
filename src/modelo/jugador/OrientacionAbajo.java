package modelo.jugador;

import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionAbajo implements Orientacion {

    private static String imagen = "jugadorAbajo.png";

    @Override
    public void golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        OcupanteDeCelda bloqueAbajo = Juego.getJuego().getMapa().obtenerBloqueAbajoDelJugador(jugador);
        herramientaActual.golpear(bloqueAbajo);
    }

    @Override
    public String obtenerImagen() {
        return imagen;
    }
}
