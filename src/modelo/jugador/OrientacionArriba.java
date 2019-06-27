package modelo.jugador;

import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionArriba implements Orientacion {

    private static String imagen = "jugadorArriba";

    @Override
    public boolean golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        if(jugador.noTieneHerramientas()){return false;}
        OcupanteDeCelda bloqueArriba = Juego.getJuego().getMapa().obtenerBloqueArribaDelJugador(jugador);
        return herramientaActual.golpear(bloqueArriba);
    }

    @Override
    public String obtenerImagen() {
        return imagen;
    }
}
