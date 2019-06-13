package modelo.recursos;

import modelo.Juego;
import modelo.objetos.herramientas.Herramienta;
import modelo.objetos.materiales.Piedra;

public class BloquePiedra extends Recurso {

    public BloquePiedra(){
        this.durabilidad = 30;
    }

    @Override
    public void serGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }

    @Override
    public void agregarRecursoAlInventario(){
        Juego.getJuego().getJugador().getInventarioMateriales().guardar(new Piedra());
    }
}
