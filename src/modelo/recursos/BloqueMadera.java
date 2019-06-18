package modelo.recursos;

import javafx.scene.image.Image;
import modelo.Juego;
import modelo.herramientas.Herramienta;

public class BloqueMadera extends Recurso {

    private static String imagen = "tileMadera.png";

    public BloqueMadera(){
        this.durabilidad = 10;
    }

    @Override
    public void serGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }

    @Override
    public String obtenerImagen() {
        return imagen;
    }

    @Override
    public void agregarRecursoAlInventario(){
        Juego.getJuego().getJugador().getInventarioMateriales().agregarMadera();
    }
}
