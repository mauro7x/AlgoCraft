package modelo.jugador;

import javafx.scene.image.Image;
import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionDerecha implements Orientacion {

    private static String imagen = "jugadorDerecha.png";

    @Override
    public void golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        OcupanteDeCelda bloqueDerecha = Juego.getJuego().getMapa().obtenerBloqueDerechaDelJugador(jugador);
        herramientaActual.golpear(bloqueDerecha);
    }

    @Override
    public String obtenerImagen() {
        return imagen;
    }
}
