package modelo.mapa;


public class CeldaVacia implements OcupanteDeCelda {
    @Override
    public OcupanteDeCelda ocuparPor(OcupanteDeCelda ocupante) {
        return ocupante;
    }

    @Override
    public OcupanteDeCelda ocuparPorOcupanteDe(Celda celdaOrigen) {
        OcupanteDeCelda ocupanteOrigen = celdaOrigen.getOcupante();
        celdaOrigen.setOcupante(this);
        return ocupanteOrigen;
    }

    @Override
    public void actualizarPosicion(int x, int y) {
        // no actualiza nada
    }
}
