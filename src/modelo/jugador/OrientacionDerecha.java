package modelo.jugador;

import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionDerecha implements Orientacion {

    private static String imagen = "jugadorDerecha";

    @Override
    public boolean golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        if(jugador.noTieneHerramientas()){return false;}
        OcupanteDeCelda bloqueDerecha = Juego.getJuego().getMapa().obtenerBloqueDerechaDelJugador(jugador);
        return herramientaActual.golpear(bloqueDerecha);
    }

    @Override
    public String obtenerImagen() {
        return imagen;
    }
}
