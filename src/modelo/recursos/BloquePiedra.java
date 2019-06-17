package modelo.recursos;

import javafx.scene.image.Image;
import modelo.Juego;
import modelo.herramientas.Herramienta;

public class BloquePiedra extends Recurso {

    private static Image imagen = new Image("media/textures/tilePiedra.png",50,50,false,false);

    public BloquePiedra(){
        this.durabilidad = 30;
    }

    @Override
    public void serGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }

    @Override
    public Image obtenerImagen() {
        return imagen;
    }

    @Override
    public void agregarRecursoAlInventario(){
        Juego.getJuego().getJugador().getInventarioMateriales().agregarPiedra();
    }
}
