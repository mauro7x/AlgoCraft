package modelo.recursos;

import modelo.Juego;
import modelo.herramientas.Herramienta;
import modelo.mapa.Posicion;

public class BloqueMadera extends Recurso {

    private static String imagen = "tileMadera";

    public BloqueMadera(){
        this.durabilidad = 10;
        this.posicion = new Posicion(0,0);
    }
    public BloqueMadera(Posicion posicion){
        this.durabilidad = 10;
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
        Juego.getJuego().getJugador().getInventarioMateriales().agregarMadera();
        Juego.getJuego().notificar("+1 Madera");
    }
}
