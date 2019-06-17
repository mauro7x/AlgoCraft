package modelo.mapa;


import javafx.scene.image.Image;
import modelo.herramientas.Herramienta;

public class CeldaVacia implements OcupanteDeCelda {

    private static Image imagen = new Image("media/textures/tileCeldaVacia2.png",50,50,false,false);

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

    @Override
    public Image obtenerImagen(int size) {
        return imagen;
    }

}
