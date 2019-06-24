package modelo.jugador;

import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionDerecha implements Orientacion {

    private static String imagen = "jugadorDerecha";

    @Override
    public void golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        if(jugador.noTieneHerramientas()){return;}
        OcupanteDeCelda bloqueDerecha = Juego.getJuego().getMapa().obtenerBloqueDerechaDelJugador(jugador);
        herramientaActual.golpear(bloqueDerecha);
    }

    @Override
    public String obtenerImagen() {
        return imagen;
    }
}
