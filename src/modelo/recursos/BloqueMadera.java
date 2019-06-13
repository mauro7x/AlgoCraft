package modelo.recursos;

import modelo.Juego;
import modelo.objetos.herramientas.Herramienta;
import modelo.objetos.materiales.Madera;

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
        Juego.getJuego().getJugador().getInventarioMateriales().guardar(new Madera());
    }
}
