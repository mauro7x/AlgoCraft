package modelo;

import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;

public class Juego {
    private static Juego juego = new Juego();

    private static final int X_MAX = 15;
    private static final int Y_MAX = 10;

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
        jugador = new Jugador(new Posicion(X_MAX /2, Y_MAX /2));
        mapa.ubicarEnElCentro(jugador);
        constructor = new Constructor();
    }

    public void generarRecursos(){
        mapa.generarRecursosEnPosicionesAleatorias(20);
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

    public void moverJugadorArriba(Jugador jugador){
        mapa.moverJugadorArriba(jugador);
    }
    public void moverJugadorAbajo(Jugador jugador){
        mapa.moverJugadorAbajo(jugador);
    }
    public void moverJugadorIzquierda(Jugador jugador){
        mapa.moverJugadorIzquierda(jugador);
    }
    public void moverJugadorDerecha(Jugador jugador){
        mapa.moverJugadorDerecha(jugador);
    }


}
