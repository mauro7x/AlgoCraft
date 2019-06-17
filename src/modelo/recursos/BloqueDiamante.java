package modelo.recursos;

import javafx.scene.image.Image;
import modelo.Juego;
import modelo.herramientas.Herramienta;

public class BloqueDiamante extends Recurso {

    private static Image imagen = new Image("media/textures/tileDiamante.png",50,50,false,false);

    public BloqueDiamante(){
        this.durabilidad = 100;
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
        Juego.getJuego().getJugador().getInventarioMateriales().agregarDiamante();
    }


}
