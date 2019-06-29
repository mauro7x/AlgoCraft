package modelo.recursos;

import modelo.Juego;
import modelo.herramientas.Herramienta;
import modelo.mapa.Posicion;

public class BloqueDiamante extends Recurso {

    private static String imagen = "tileDiamante";

    public BloqueDiamante(){
        this.durabilidad = 100;
        this.posicion = new Posicion(0,0);
    }
    public BloqueDiamante(Posicion posicion){
        this.durabilidad = 100;
        this.posicion = posicion;
    }

    @Override
    public boolean serGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
        return true;
    }

    @Override
    public String obtenerImagen() {
        return imagen;
    }

    @Override
    public void agregarRecursoAlInventario(){
        Juego.getJuego().getJugador().getInventarioMateriales().agregarDiamante();
        Juego.getJuego().notificar("+1 Diamante");
    }


}
