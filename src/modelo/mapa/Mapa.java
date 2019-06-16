package modelo.mapa;

import modelo.jugador.Jugador;

public class Mapa {

    private int xMax;
    private int yMax;

    private CuadriculaCeldas celdas;

    public Mapa(int xMax, int yMax){
        celdas = new CuadriculaCeldas(xMax, yMax);
        this.xMax = xMax;
        this.yMax = yMax;
    }


    public int getXMax(){
        return xMax;
    }

    public int getYMax(){
        return yMax;
    }

    public Celda getCeldaCentral(){
        return celdas.getCelda(xMax/2, yMax/2);
    }

    public Celda getCelda(int x, int y) { return celdas.getCelda(x, y); }

    public void ubicarEnElCentro(OcupanteDeCelda ocupante){
        setearOcupanteEn(ocupante, xMax/2, yMax/2);
    }

    public void setearOcupanteEn(OcupanteDeCelda ocupante, int x, int y){
        celdas.getCelda(x, y).setOcupante(ocupante);
    }


    public void moverJugadorArriba(Jugador jugador){
        int jugadorX = jugador.getX();
        int jugadorY = jugador.getY();
        Celda celdaActual = celdas.getCelda(jugadorX, jugadorY);
        Celda celdaNueva = celdas.getCelda(jugadorX, Math.abs((jugadorY+1)%yMax));
        celdaActual.moverA(celdaNueva);
    }
    public void moverJugadorAbajo(Jugador jugador){
        int jugadorX = jugador.getX();
        int jugadorY = jugador.getY();
        Celda celdaActual = celdas.getCelda(jugadorX, jugadorY);
        Celda celdaNueva = celdas.getCelda(jugadorX, Math.abs((jugadorY-1)%yMax));
        celdaActual.moverA(celdaNueva);
    }
    public void moverJugadorIzquierda(Jugador jugador){
        int jugadorX = jugador.getX();
        int jugadorY = jugador.getY();
        Celda celdaActual = celdas.getCelda(jugadorX, jugadorY);
        Celda celdaNueva = celdas.getCelda(Math.abs((jugadorX-1)%xMax), jugadorY);
        celdaActual.moverA(celdaNueva);
    }
    public void moverJugadorDerecha(Jugador jugador){
        int jugadorX = jugador.getX();
        int jugadorY = jugador.getY();
        Celda celdaActual = celdas.getCelda(jugadorX, jugadorY);
        Celda celdaNueva = celdas.getCelda(Math.abs((jugadorX+1)%xMax), jugadorY);
        celdaActual.moverA(celdaNueva);
    }

    public OcupanteDeCelda obtenerBloqueArribaDelJugador(Jugador jugador){
        int jugadorX = jugador.getX();
        int jugadorY = jugador.getY();
        Celda celdaArriba = celdas.getCelda(jugadorX,jugadorY+1);
        return celdaArriba.getOcupante();
    }

    public OcupanteDeCelda obtenerBloqueAbajoDelJugador(Jugador jugador){
        int jugadorX = jugador.getX();
        int jugadorY = jugador.getY();
        Celda celdaAbajo = celdas.getCelda(jugadorX,jugadorY-1);
        return celdaAbajo.getOcupante();
    }

    public OcupanteDeCelda obtenerBloqueIzquierdaDelJugador(Jugador jugador){
        int jugadorX = jugador.getX();
        int jugadorY = jugador.getY();
        Celda celdaIzquierda = celdas.getCelda(jugadorX-1,jugadorY);
        return celdaIzquierda.getOcupante();
    }

    public OcupanteDeCelda obtenerBloqueDerechaDelJugador(Jugador jugador){
        int jugadorX = jugador.getX();
        int jugadorY = jugador.getY();
        Celda celdaDerecha = celdas.getCelda(jugadorX+1,jugadorY);
        return celdaDerecha.getOcupante();
    }
}
