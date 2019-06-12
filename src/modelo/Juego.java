package modelo;

import modelo.mapa.Mapa;

public class Juego {
    private static Juego juego = new Juego();

    private static final int X_MAX = 51;
    private static final int Y_MAX = 31;

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
        mapa = new Mapa(X_MAX, Y_MAX);
        jugador = new Jugador(X_MAX /2, Y_MAX /2);
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

    void moverJugadorArriba(Jugador jugador){
        mapa.moverJugadorArriba(jugador);
    }
    void moverJugadorAbajo(Jugador jugador){
        mapa.moverJugadorAbajo(jugador);
    }
    void moverJugadorIzquierda(Jugador jugador){
        mapa.moverJugadorIzquierda(jugador);
    }
    void moverJugadorDerecha(Jugador jugador){
        mapa.moverJugadorDerecha(jugador);
    }


}
