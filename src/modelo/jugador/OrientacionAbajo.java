package modelo.jugador;

import modelo.Juego;
import modelo.mapa.OcupanteDeCelda;
import modelo.herramientas.Herramienta;

public class OrientacionAbajo implements Orientacion {

    private static String imagen = "jugadorAbajo";

    @Override
    public boolean golpear(Herramienta herramientaActual) {
        Jugador jugador = Juego.getJuego().getJugador();
        if(jugador.noTieneHerramientas()){return false;}
        OcupanteDeCelda bloqueAbajo = Juego.getJuego().getMapa().obtenerBloqueAbajoDelJugador(jugador);
        return herramientaActual.golpear(bloqueAbajo);
    }

    @Override
    public String obtenerImagen() {
        return imagen;
    }
}
