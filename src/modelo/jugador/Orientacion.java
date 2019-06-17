package modelo.jugador;

import javafx.scene.image.Image;
import modelo.herramientas.Herramienta;

public interface Orientacion {
    void golpear(Herramienta herramientaActual);
    Image obtenerImagen(int size);
}
