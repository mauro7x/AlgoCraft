package modelo;

import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;
import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;

public class Juego {
    private static Juego juego = new Juego();

    private static final int X_MAX = 15;
    private static final int Y_MAX = 11;

    private Constructor constructor;
    private Mapa mapa;
    private Jugador jugador;
    private TextArea consola = null;

    public static Juego getJuego() {
        return juego;
    }

    private Juego() {}

    private void generarMapaYConstructor(){
        mapa = new Mapa(X_MAX, Y_MAX);
        constructor = new Constructor();
    }
    private void generarJugador(){
        jugador = new Jugador(new Posicion(X_MAX /2, Y_MAX /2));
        mapa.ubicarEnElCentro(jugador);
    }
    public void generarRecursos(){
        mapa.generarRecursosAleatoriamente(10);
    }

    public void resetear(){
        generarMapaYConstructor();
        generarRecursos();
        generarJugador();
    }

    public void resetearMapa(){
        mapa = new Mapa(X_MAX, Y_MAX);
        generarRecursos();
        jugador.resetear(new Posicion(X_MAX /2, Y_MAX /2));
        mapa.ubicarEnElCentro(jugador);
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

    public void setConsola(TextArea consola){
        this.consola = consola;
    }

    public void imprimirPorConsola(String texto) {
        if(consola != null){
            consola.appendText(texto+"\n");
        }
    }


}
