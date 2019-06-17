package modelo.mapa;


import modelo.herramientas.Herramienta;

public class CeldaVacia implements OcupanteDeCelda {

    @Override
    public OcupanteDeCelda ocuparPorOcupanteDe(Celda celdaOrigen) {
        OcupanteDeCelda ocupanteOrigen = celdaOrigen.getOcupante();
        celdaOrigen.setOcupante(this);
        return ocupanteOrigen;
    }

    @Override
    public void actualizarPosicion(Posicion posicion) {
        // no actualiza nada
    }

    @Override
    public void serGolpeadoPor(Herramienta herramienta) {
        return;
        //La celda vacia no hace nada al ser golpeada.
    }
}