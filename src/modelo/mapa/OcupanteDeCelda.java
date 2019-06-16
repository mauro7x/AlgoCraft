package modelo.mapa;

import modelo.objetos.herramientas.Herramienta;

public interface OcupanteDeCelda {

    OcupanteDeCelda ocuparPorOcupanteDe(Celda celdaOrigen);

    void actualizarPosicion(int x, int y);

    void serGolpeadoPor(Herramienta herramienta);
}
