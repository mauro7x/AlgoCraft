package modelo.mapa;

import modelo.herramientas.Herramienta;

public class CeldaVacia implements OcupanteDeCelda {

    private static String imagen = "tileCeldaVacia2";

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
    public boolean serGolpeadoPor(Herramienta herramienta) {
        return false;
        //La celda vacia no hace nada al ser golpeada.
    }

    @Override
    public String obtenerImagen() {
        return imagen;
    }

}
