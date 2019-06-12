package modelo;

import modelo.mapa.Mapa;

public class Juego {
    private static Juego juego = new Juego();

    private static final int FILAS = 71;
    private static final int COLUMNAS = 101;

    private Jugador jugador;
    private Constructor constructor;
    private Mapa mapa;

    public static Juego getJuego() {
        return juego;
    }

    private Juego() {
        jugador = new Jugador();
        constructor = new Constructor();
        mapa = new Mapa(FILAS, COLUMNAS);
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
