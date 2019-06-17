package modelo.jugador;

import javafx.scene.image.Image;
import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionAbajo implements Orientacion {

    private static Image imagen = new Image("media/jugador/jugadorAbajo.png",50,50,false,false);

    @Override
    public void golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        OcupanteDeCelda bloqueAbajo = Juego.getJuego().getMapa().obtenerBloqueAbajoDelJugador(jugador);
        herramientaActual.golpear(bloqueAbajo);
    }

    @Override
    public Image obtenerImagen() {
        return imagen;
    }
}
