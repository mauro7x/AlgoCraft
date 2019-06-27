package modelo.mapa;

import modelo.herramientas.Herramienta;



public interface OcupanteDeCelda {

    OcupanteDeCelda ocuparPorOcupanteDe(Celda celdaOrigen);

    void actualizarPosicion(Posicion posicion);

    boolean serGolpeadoPor(Herramienta herramienta);

    String obtenerImagen();
}
