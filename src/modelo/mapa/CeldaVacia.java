package modelo.mapa;


import modelo.objetos.herramientas.Herramienta;

public class CeldaVacia implements OcupanteDeCelda {

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

    @Override
    public void serGolpeadoPor(Herramienta herramienta) {
        return;
        //La celda vacia no hace nada al ser golpeada.
    }
}
