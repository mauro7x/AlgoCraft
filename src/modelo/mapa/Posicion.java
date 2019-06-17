package modelo.mapa;

import modelo.Juego;

public class Posicion {

    private int x;
    private int y;

    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {

        /*
        if (o == this) {
            return true;
        }

        if (!(o instanceof Posicion)) {
            return false;
        }
        */

        Posicion posicion = (Posicion) o;
        return (this.x == posicion.getX() && this.y == posicion.getY());
    }

    int getX(){ return this.x; }
    int getY(){ return this.y; }

    public Posicion getPosicionArriba(){
        int yMax = Juego.getJuego().getMapa().getYMax();
        Posicion posicionArriba = new Posicion(this.x, Math.abs((this.y+1)%yMax));
        return posicionArriba;
    }
    public Posicion getPosicionAbajo(){
        int yMax = Juego.getJuego().getMapa().getYMax();
        Posicion posicionAbajo = new Posicion(this.x, Math.abs((this.y-1)%yMax));
        return posicionAbajo;
    }
    public Posicion getPosicionIzquierda(){
        int xMax = Juego.getJuego().getMapa().getXMax();
        Posicion posicionIzquierda = new Posicion(Math.abs((this.x-1)%xMax), this.y);
        return posicionIzquierda;
    }
    public Posicion getPosicionDerecha(){
        int xMax = Juego.getJuego().getMapa().getXMax();
        Posicion posicionDerecha = new Posicion(Math.abs((this.x+1)%xMax), this.y);
        return posicionDerecha;
    }
}
