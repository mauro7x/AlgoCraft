package modelo.jugador;

import javafx.scene.image.Image;
import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionIzquierda implements Orientacion {

    private static Image imagen = new Image("media/jugador/jugadorIzquierda.png",50,50,false,false);

    @Override
    public void golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        OcupanteDeCelda bloqueIzquierda = Juego.getJuego().getMapa().obtenerBloqueIzquierdaDelJugador(jugador);
        herramientaActual.golpear(bloqueIzquierda);
    }

    @Override
    public Image obtenerImagen() {
        return imagen;
    }
}
