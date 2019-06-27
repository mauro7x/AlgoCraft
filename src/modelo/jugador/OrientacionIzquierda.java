package modelo.jugador;

import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionIzquierda implements Orientacion {

    private static String imagen = "jugadorIzquierda";

    @Override
    public boolean golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        if(jugador.noTieneHerramientas()){return false;}
        OcupanteDeCelda bloqueIzquierda = Juego.getJuego().getMapa().obtenerBloqueIzquierdaDelJugador(jugador);
        return herramientaActual.golpear(bloqueIzquierda);
    }

    @Override
    public String obtenerImagen() {
        return imagen;
    }
}
