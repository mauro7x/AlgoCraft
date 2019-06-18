package modelo.herramientas.durabilidades;

import modelo.Juego;

public class DurabilidadDiezPorciento extends Durabilidad {

    @Override
    public void gastar(float fuerza) {
        durabilidad -= (durabilidad*(float)(0.1));
        if(durabilidad < 1){
            durabilidad = 0;
            Juego.getJuego().getJugador().eliminarHerramientaActual();
        }

    }

}
