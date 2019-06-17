package modelo.mapa;

import javafx.scene.image.Image;
import modelo.herramientas.Herramienta;



public interface OcupanteDeCelda {

    OcupanteDeCelda ocuparPorOcupanteDe(Celda celdaOrigen);

    void actualizarPosicion(Posicion posicion);

    void serGolpeadoPor(Herramienta herramienta);

    Image obtenerImagen(int size);
}
