package modelo.recursos;

import modelo.Juego;
import modelo.herramientas.Herramienta;

public class BloqueDiamante extends Recurso {

    public BloqueDiamante(){
        this.durabilidad = 100;
    }

    @Override
    public void serGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }

    @Override
    public void agregarRecursoAlInventario(){
        Juego.getJuego().getJugador().getInventarioMateriales().agregarDiamante();
    }
}
