package modelo.jugador;

import javafx.scene.image.Image;
import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionArriba implements Orientacion {

    private static Image imagen = new Image("media/jugador/jugadorArriba.png",50,50,false,false);

    @Override
    public void golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        OcupanteDeCelda bloqueArriba = Juego.getJuego().getMapa().obtenerBloqueArribaDelJugador(jugador);
        herramientaActual.golpear(bloqueArriba);
    }

    @Override
    public Image obtenerImagen() {
        return imagen;
    }
}
