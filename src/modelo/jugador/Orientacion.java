package modelo.jugador;

import modelo.herramientas.Herramienta;

public interface Orientacion {
    boolean golpear(Herramienta herramientaActual);

    String obtenerImagen();
}
