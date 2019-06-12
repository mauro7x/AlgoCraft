package modelo.mapa;

public interface OcupanteDeCelda {

    OcupanteDeCelda ocuparPor(OcupanteDeCelda ocupante);

    OcupanteDeCelda ocuparPorOcupanteDe(Celda celdaOrigen);

    void actualizarPosicion(int x, int y);

}
