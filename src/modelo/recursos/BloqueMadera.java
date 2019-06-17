package modelo.recursos;

import javafx.scene.image.Image;
import modelo.Juego;
import modelo.herramientas.Herramienta;

public class BloqueMadera extends Recurso {

    private static Image imagen = new Image("media/textures/tileMadera.png",50,50,false,false);

    public BloqueMadera(){
        this.durabilidad = 10;
    }

    @Override
    public void serGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }

    @Override
    public Image obtenerImagen(int size) {
        return imagen;
    }

    @Override
    public void agregarRecursoAlInventario(){
        Juego.getJuego().getJugador().getInventarioMateriales().agregarMadera();
    }
}
