package modelo;


import modelo.mapa.OcupanteDeCelda;

public class Jugador implements OcupanteDeCelda {

    private int posX;
    private int posY;
    private int orientacion;

    public Jugador(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        this.orientacion = 0;
    }

    public int getPosicionX() {
        return posX;
    }

    public int getPosicionY() {
        return posY;
    }

    public int getOrientacion() {
        return orientacion;
    }

    @Override
    public OcupanteDeCelda ocuparPor(OcupanteDeCelda ocupante) {
        return this;
    }
}
