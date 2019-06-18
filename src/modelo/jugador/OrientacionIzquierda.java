package modelo.jugador;

import javafx.scene.image.Image;
import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionIzquierda implements Orientacion {

    private static String imagen = "jugadorIzquierda.png";

    @Override
    public void golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        OcupanteDeCelda bloqueIzquierda = Juego.getJuego().getMapa().obtenerBloqueIzquierdaDelJugador(jugador);
        herramientaActual.golpear(bloqueIzquierda);
    }

    @Override
    public String obtenerImagen() {
        return imagen;
    }
}
