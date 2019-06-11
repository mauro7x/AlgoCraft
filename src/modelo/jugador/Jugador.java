package modelo.jugador;

public class Jugador {

    private static Jugador jugador = new Jugador();

    private int pos_x;
    private int pos_y;
    private int orientacion;

    private Jugador(){
        this.pos_x = 0;
        this.pos_y = 0;
        this.orientacion = 0;
    }

    public static Jugador getJugador() {
        return jugador;
    }

    public int getPosicionX() {
        return pos_x;
    }

    public int getPosicionY() {
        return pos_y;
    }

    public int getOrientacion() {
        return orientacion;
    }
}
