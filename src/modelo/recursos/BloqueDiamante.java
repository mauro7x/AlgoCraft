package modelo.recursos;

import javafx.scene.image.Image;
import modelo.Juego;
import modelo.herramientas.Herramienta;

public class BloqueDiamante extends Recurso {

    private static String imagen = "tileDiamante.png";

    public BloqueDiamante(){
        this.durabilidad = 100;
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
        Juego.getJuego().getJugador().getInventarioMateriales().agregarDiamante();
    }


}
