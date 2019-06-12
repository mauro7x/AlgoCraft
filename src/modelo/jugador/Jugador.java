package modelo.jugador;


import modelo.Juego;
import modelo.mapa.Celda;
import modelo.mapa.OcupanteDeCelda;

public class Jugador implements OcupanteDeCelda {

    private int x;
    private int y;
    private int orientacion;
    private InventarioHerramientas herramientas;
    private InventarioMateriales materiales;

    public Jugador(int x, int y){
        this.x = x;
        this.y = y;
        this.orientacion = 0;
        herramientas = new InventarioHerramientas();
        materiales = new InventarioMateriales();
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getOrientacion() {
        return orientacion;
    }

    @Override
    public OcupanteDeCelda ocuparPorOcupanteDe(Celda celdaOrigen) {
        return this;
    }

    @Override
    public void actualizarPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moverArriba(){
        this.orientacion = 0;
        Juego.getJuego().moverJugadorArriba(this);
    }
    public void moverAbajo(){
        this.orientacion = 1;
        Juego.getJuego().moverJugadorAbajo(this);
    }
    public void moverIzquierda(){
        this.orientacion = 2;
        Juego.getJuego().moverJugadorIzquierda(this);
    }
    public void moverDerecha(){
        this.orientacion = 3;
        Juego.getJuego().moverJugadorDerecha(this);
    }

}
