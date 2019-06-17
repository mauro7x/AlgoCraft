package modelo.recursos;

import modelo.Juego;
import modelo.herramientas.Herramienta;

public class BloqueMetal extends Recurso {

    public BloqueMetal(){
        this.durabilidad = 50;
    }

    @Override
    public void serGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }

    @Override
    public void agregarRecursoAlInventario(){
        Juego.getJuego().getJugador().getInventarioMateriales().agregarMetal();
    }
}
