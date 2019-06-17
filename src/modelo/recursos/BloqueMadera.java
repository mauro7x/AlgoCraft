package modelo.recursos;

import modelo.Juego;
import modelo.herramientas.Herramienta;

public class BloqueMadera extends Recurso {

    public BloqueMadera(){
        this.durabilidad = 10;
    }

    @Override
    public void serGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }

    @Override
    public void agregarRecursoAlInventario(){
        Juego.getJuego().getJugador().getInventarioMateriales().agregarMadera();
    }
}
