package modelo.mapa;

public interface OcupanteDeCelda {

    OcupanteDeCelda ocuparPorOcupanteDe(Celda celdaOrigen);

    void actualizarPosicion(int x, int y);

}
