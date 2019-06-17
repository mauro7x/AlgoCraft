package modelo.herramientas.durabilidades;

import modelo.Juego;

public class DurabilidadEnFuerza extends Durabilidad {

    private float FactorReduccion;

    public DurabilidadEnFuerza(float FactorReduccion){
        this.FactorReduccion = FactorReduccion;
    }

    @Override
    public void gastar(float fuerza) {
        durabilidad -=(fuerza/FactorReduccion);
        if(durabilidad == 0){
            Juego.getJuego().getJugador().eliminarHerramientaActual();
        }
    }
}
