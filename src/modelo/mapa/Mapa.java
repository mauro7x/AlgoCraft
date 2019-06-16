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
        return celdas.getCelda(new Posicion(xMax/2, yMax/2));
    }

    public Celda getCelda(Posicion posicion) { return celdas.getCelda(posicion); }

    public void ubicarEnElCentro(OcupanteDeCelda ocupante){
        setearOcupanteEn(ocupante, new Posicion(xMax/2, yMax/2));
    }

    public void setearOcupanteEn(OcupanteDeCelda ocupante, Posicion posicion){
        celdas.getCelda(posicion).setOcupante(ocupante);
    }


    public void moverJugadorArriba(Jugador jugador){
        Posicion posicionJugador = jugador.getPosicion();
        Celda celdaActual = celdas.getCelda(posicionJugador);
        Celda celdaNueva = celdas.getCelda(posicionJugador.getPosicionArriba());
        celdaActual.moverA(celdaNueva);
    }
    public void moverJugadorAbajo(Jugador jugador){
        Posicion posicionJugador = jugador.getPosicion();
        Celda celdaActual = celdas.getCelda(posicionJugador);
        Celda celdaNueva = celdas.getCelda(posicionJugador.getPosicionAbajo());
        celdaActual.moverA(celdaNueva);
    }
    public void moverJugadorIzquierda(Jugador jugador){
        Posicion posicionJugador = jugador.getPosicion();
        Celda celdaActual = celdas.getCelda(posicionJugador);
        Celda celdaNueva = celdas.getCelda(posicionJugador.getPosicionIzquierda());
        celdaActual.moverA(celdaNueva);
    }
    public void moverJugadorDerecha(Jugador jugador){
        Posicion posicionJugador = jugador.getPosicion();
        Celda celdaActual = celdas.getCelda(posicionJugador);
        Celda celdaNueva = celdas.getCelda(posicionJugador.getPosicionDerecha());
        celdaActual.moverA(celdaNueva);
    }

    public OcupanteDeCelda obtenerBloqueArribaDelJugador(Jugador jugador){
        Posicion posicionJugador = jugador.getPosicion();
        Celda celdaArriba = celdas.getCelda(posicionJugador.getPosicionArriba());
        return celdaArriba.getOcupante();
    }

    public OcupanteDeCelda obtenerBloqueAbajoDelJugador(Jugador jugador){
        Posicion posicionJugador = jugador.getPosicion();
        Celda celdaAbajo = celdas.getCelda(posicionJugador.getPosicionAbajo());
        return celdaAbajo.getOcupante();
    }

    public OcupanteDeCelda obtenerBloqueIzquierdaDelJugador(Jugador jugador){
        Posicion posicionJugador = jugador.getPosicion();
        Celda celdaIzquierda = celdas.getCelda(posicionJugador.getPosicionIzquierda());
        return celdaIzquierda.getOcupante();
    }

    public OcupanteDeCelda obtenerBloqueDerechaDelJugador(Jugador jugador){
        Posicion posicionJugador = jugador.getPosicion();
        Celda celdaDerecha = celdas.getCelda(posicionJugador.getPosicionDerecha());
        return celdaDerecha.getOcupante();
    }
}
