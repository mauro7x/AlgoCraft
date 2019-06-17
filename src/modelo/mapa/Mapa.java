package modelo.mapa;

import modelo.Juego;
import modelo.jugador.Jugador;
import modelo.recursos.BloqueDiamante;
import modelo.recursos.BloqueMadera;
import modelo.recursos.BloqueMetal;
import modelo.recursos.BloquePiedra;

import java.util.Random;

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

    public void ubicarEnElCentro(OcupanteDeCelda ocupante){
        setearOcupanteEn(ocupante, new Posicion(xMax/2, yMax/2));
    }

    public void setearOcupanteEn(OcupanteDeCelda ocupante, Posicion posicion){
        celdas.getCelda(posicion).setOcupante(ocupante);
    }

    public void generarRecursosAleatoriamente(int cantidad){
        Random random = new Random();
        int recurso;

        for(int i=0; i<cantidad; i++){
            int x = random.nextInt(xMax);
            int y = random.nextInt(yMax);
            recurso = random.nextInt(10);

            switch(recurso){
                case 0:
                    agregarBloqueDiamante(new Posicion(x,y));
                    break;
                case 1: case 2:
                    agregarBloqueMetal(new Posicion(x,y));
                    break;
                case 3: case 4: case 5:
                    agregarBloquePiedra(new Posicion(x,y));
                    break;
                case 6: case 7: case 8: case 9:
                    agregarBloqueMadera(new Posicion(x,y));
                    break;
            }
        }
    }

    private void agregarBloqueDiamante(Posicion posicion){
        Random random = new Random();
        int recurso = random.nextInt(4);

        switch(recurso){
            case 0: //agrega 1
                setearOcupanteEn(new BloqueDiamante(), posicion);
                break;
            case 1: //agrega 2 horizontalmente
                setearOcupanteEn(new BloqueDiamante(), posicion);
                setearOcupanteEn(new BloqueDiamante(), posicion.getPosicionDerecha());
                break;
            case 2: //agrega 2 verticalmente
                setearOcupanteEn(new BloqueDiamante(), posicion);
                setearOcupanteEn(new BloqueDiamante(), posicion.getPosicionAbajo());
                break;
            case 3: //agrega 4 en bloque
                setearOcupanteEn(new BloqueDiamante(), posicion);
                setearOcupanteEn(new BloqueDiamante(), posicion.getPosicionDerecha());
                setearOcupanteEn(new BloqueDiamante(), posicion.getPosicionAbajo());
                setearOcupanteEn(new BloqueDiamante(), posicion.getPosicionAbajo().getPosicionDerecha());
                break;
        }


    }
    private void agregarBloqueMetal(Posicion posicion){
        Random random = new Random();
        int recurso = random.nextInt(4);
        switch(recurso){
            case 0: //agrega 1
                setearOcupanteEn(new BloqueMetal(), posicion);
                break;
            case 1: //agrega 2 horizontalmente
                setearOcupanteEn(new BloqueMetal(), posicion);
                setearOcupanteEn(new BloqueMetal(), posicion.getPosicionDerecha());
                break;
            case 2: //agrega 2 verticalmente
                setearOcupanteEn(new BloqueMetal(), posicion);
                setearOcupanteEn(new BloqueMetal(), posicion.getPosicionAbajo());
                break;
            case 3: //agrega 4 en bloque
                setearOcupanteEn(new BloqueMetal(), posicion);
                setearOcupanteEn(new BloqueMetal(), posicion.getPosicionDerecha());
                setearOcupanteEn(new BloqueMetal(), posicion.getPosicionAbajo());
                setearOcupanteEn(new BloqueMetal(), posicion.getPosicionDerecha().getPosicionAbajo());
                break;
        }
    }
    private void agregarBloquePiedra(Posicion posicion){
        Random random = new Random();
        int recurso = random.nextInt(4);
        switch(recurso){
            case 0: //agrega 2 horizontalmente
                setearOcupanteEn(new BloquePiedra(), posicion);
                setearOcupanteEn(new BloquePiedra(), posicion.getPosicionDerecha());
                break;
            case 1: //agrega 2 verticalmente
                setearOcupanteEn(new BloquePiedra(), posicion);
                setearOcupanteEn(new BloquePiedra(), posicion.getPosicionAbajo());
                break;
            case 2: //agrega 4 en bloque
                setearOcupanteEn(new BloquePiedra(), posicion);
                setearOcupanteEn(new BloquePiedra(), posicion.getPosicionDerecha());
                setearOcupanteEn(new BloquePiedra(), posicion.getPosicionAbajo());
                setearOcupanteEn(new BloquePiedra(), posicion.getPosicionDerecha().getPosicionAbajo());
                break;
            case 3: //agrega 6 en bloque horizontal
                setearOcupanteEn(new BloquePiedra(), posicion);
                setearOcupanteEn(new BloquePiedra(), posicion.getPosicionDerecha());
                setearOcupanteEn(new BloquePiedra(), posicion.getPosicionAbajo());
                setearOcupanteEn(new BloquePiedra(), posicion.getPosicionDerecha().getPosicionAbajo());
                setearOcupanteEn(new BloquePiedra(), posicion.getPosicionDerecha().getPosicionDerecha());
                setearOcupanteEn(new BloquePiedra(), posicion.getPosicionDerecha().getPosicionDerecha().getPosicionAbajo());
                break;

        }
    }
    private void agregarBloqueMadera(Posicion posicion){
        Random random = new Random();
        int recurso = random.nextInt(4);
        switch(recurso){
            case 0: //agrega bloque de 4
                setearOcupanteEn(new BloqueMadera(), posicion);
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionDerecha());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionAbajo());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionDerecha().getPosicionAbajo());
                break;
            case 1: //agrega bloque de 6 horizontalmente
                setearOcupanteEn(new BloqueMadera(), posicion);
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionDerecha());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionAbajo());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionDerecha().getPosicionAbajo());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionDerecha().getPosicionDerecha());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionDerecha().getPosicionDerecha().getPosicionAbajo());
                break;
            case 2: //agrega bloque de 6 verticalmente
                setearOcupanteEn(new BloqueMadera(), posicion);
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionDerecha());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionAbajo());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionDerecha().getPosicionAbajo());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionAbajo().getPosicionAbajo());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionAbajo().getPosicionAbajo().getPosicionDerecha());
                break;
            case 3: //agrega bloque de 9
                setearOcupanteEn(new BloqueMadera(), posicion);
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionDerecha());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionDerecha().getPosicionDerecha());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionAbajo());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionAbajo().getPosicionDerecha());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionAbajo().getPosicionDerecha().getPosicionDerecha());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionAbajo().getPosicionAbajo());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionAbajo().getPosicionAbajo().getPosicionDerecha());
                setearOcupanteEn(new BloqueMadera(), posicion.getPosicionAbajo().getPosicionAbajo().getPosicionDerecha().getPosicionDerecha());

                break;
        }
    }

    public OcupanteDeCelda obtenerOcupanteEn(Posicion posicion){
        return celdas.getCelda(posicion).getOcupante();
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
