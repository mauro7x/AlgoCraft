package modelo.herramientas.durabilidades;

import modelo.Juego;

public class DurabilidadTrasDiezUsos extends Durabilidad {

    private int usosRestantes = 10;

    @Override
    public void gastar(float fuerza) {
        if (usosRestantes == 1) {
            durabilidad = 0;
            Juego.getJuego().getJugador().eliminarHerramientaActual();
        }else{
            usosRestantes--;
        }
    }
}
