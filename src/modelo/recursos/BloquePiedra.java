package modelo.recursos;

import modelo.Juego;
import modelo.herramientas.Herramienta;
import modelo.mapa.Posicion;

public class BloquePiedra extends Recurso {

    private static String imagen = "tilePiedra";

    public BloquePiedra(){
        this.durabilidad = 30;
        this.posicion = new Posicion(0,0);
    }
    public BloquePiedra(Posicion posicion){
        this.durabilidad = 30;
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
        Juego.getJuego().getJugador().getInventarioMateriales().agregarPiedra();
        Juego.getJuego().notificar("+1 Piedra");
    }
}
