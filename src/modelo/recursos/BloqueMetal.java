package modelo.recursos;

import modelo.Juego;
import modelo.herramientas.Herramienta;
import modelo.mapa.Posicion;

public class BloqueMetal extends Recurso {

    private static String imagen = "tileMetal";

    public BloqueMetal(){
        this.durabilidad = 50;
        this.posicion = new Posicion(0,0);
    }

    public BloqueMetal(Posicion posicion){
        this.durabilidad = 50;
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
        Juego.getJuego().getJugador().getInventarioMateriales().agregarMetal();
        Juego.getJuego().notificar("+1 Metal");
    }
}
