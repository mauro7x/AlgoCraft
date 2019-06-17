package modelo.mapa;

import modelo.herramientas.Herramienta;

public interface OcupanteDeCelda {

    OcupanteDeCelda ocuparPorOcupanteDe(Celda celdaOrigen);

    void actualizarPosicion(Posicion posicion);

    void serGolpeadoPor(Herramienta herramienta);
}
