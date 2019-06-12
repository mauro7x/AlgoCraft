package modelo;

import modelo.mapa.Mapa;

public class Juego {
    private static Juego juego = new Juego();

    private static final int FILAS = 31;
    private static final int COLUMNAS = 51;

    private Constructor constructor;
    private Mapa mapa;
    private Jugador jugador;

    public static Juego getJuego() {
        return juego;
    }

    private Juego() {
        inicializacion();
    }

    private void inicializacion(){
        mapa = new Mapa(FILAS, COLUMNAS);
        jugador = new Jugador(FILAS/2, COLUMNAS/2);
        mapa.ubicarEnElCentro(jugador);
        constructor = new Constructor();
    }

    public void resetear(){
        inicializacion();
    }


    public Jugador getJugador() {
        return jugador;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public Mapa getMapa() {
        return mapa;
    }
}
