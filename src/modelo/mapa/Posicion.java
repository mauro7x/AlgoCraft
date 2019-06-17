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
        Posicion posicion = (Posicion) o;
        boolean c1 = (this.x == posicion.getX());
        boolean c2 = (this.y == posicion.getY());
        return (c1 && c2);
    }

    int getX(){ return this.x; }
    int getY(){ return this.y; }

    public Posicion getPosicionArriba(){
        int yMax = Juego.getJuego().getMapa().getYMax();
        return new Posicion(this.x, Math.abs((this.y+1)%yMax));
    }
    public Posicion getPosicionAbajo(){
        int yMax = Juego.getJuego().getMapa().getYMax();
        return new Posicion(this.x, Math.abs((this.y-1)%yMax));
    }
    public Posicion getPosicionIzquierda(){
        int xMax = Juego.getJuego().getMapa().getXMax();
        return new Posicion(Math.abs((this.x-1)%xMax), this.y);
    }
    public Posicion getPosicionDerecha(){
        int xMax = Juego.getJuego().getMapa().getXMax();
        return new Posicion(Math.abs((this.x+1)%xMax), this.y);
    }
}
