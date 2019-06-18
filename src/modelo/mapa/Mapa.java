package modelo.mapa;

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
            Posicion posicion = new Posicion(x,y);
            recurso = random.nextInt(10);
            switch(recurso){
                case 0:
                    agregarBloqueDiamante(posicion);
                    break;
                case 1: case 2:
                    agregarBloqueMetal(posicion);
                    break;
                case 3: case 4: case 5:
                    agregarBloquePiedra(posicion);
                    break;
                case 6: case 7: case 8: case 9:
                    agregarBloqueMadera(posicion);
                    break;
            }
        }
    }

    private void agregarBloqueDiamante(Posicion posicion){
        Random random = new Random();
        int recurso = random.nextInt(4);

        Posicion posDer = posicion.getPosicionDerecha();
        Posicion posAba = posicion.getPosicionAbajo();
        Posicion posDerAba = posAba.getPosicionDerecha();

        switch(recurso){
            case 0: //agrega 1
                setearOcupanteEn(new BloqueDiamante(posicion), posicion);
                break;
            case 1: //agrega 2 horizontalmente
                setearOcupanteEn(new BloqueDiamante(posicion), posicion);
                setearOcupanteEn(new BloqueDiamante(posDer), posDer);
                break;
            case 2: //agrega 2 verticalmente
                setearOcupanteEn(new BloqueDiamante(posicion), posicion);
                setearOcupanteEn(new BloqueDiamante(posAba), posAba);
                break;
            case 3: //agrega 4 en bloque
                setearOcupanteEn(new BloqueDiamante(posicion), posicion);
                setearOcupanteEn(new BloqueDiamante(posDer), posDer);
                setearOcupanteEn(new BloqueDiamante(posAba), posAba);
                setearOcupanteEn(new BloqueDiamante(posDerAba), posDerAba);
                break;
        }


    }
    private void agregarBloqueMetal(Posicion posicion){
        Random random = new Random();
        int recurso = random.nextInt(4);
        
        Posicion posDer = posicion.getPosicionDerecha();
        Posicion posAba = posicion.getPosicionAbajo();
        Posicion posDerAba = posDer.getPosicionAbajo();
        
        switch(recurso){
            case 0: //agrega 1
                setearOcupanteEn(new BloqueMetal(posicion), posicion);
                break;
            case 1: //agrega 2 horizontalmente
                setearOcupanteEn(new BloqueMetal(posicion), posicion);
                setearOcupanteEn(new BloqueMetal(posDer), posDer);
                break;
            case 2: //agrega 2 verticalmente
                setearOcupanteEn(new BloqueMetal(posicion), posicion);
                setearOcupanteEn(new BloqueMetal(posAba), posAba);
                break;
            case 3: //agrega 4 en bloque
                setearOcupanteEn(new BloqueMetal(posicion), posicion);
                setearOcupanteEn(new BloqueMetal(posDer), posDer);
                setearOcupanteEn(new BloqueMetal(posAba), posAba);
                setearOcupanteEn(new BloqueMetal(posDerAba), posDerAba);
                break;
        }
    }
    private void agregarBloquePiedra(Posicion posicion){
        Random random = new Random();
        int recurso = random.nextInt(4);

        Posicion posDer = posicion.getPosicionDerecha();
        Posicion posAba = posicion.getPosicionAbajo();
        Posicion posDerAba = posAba.getPosicionDerecha();
        Posicion posDerDer = posDer.getPosicionDerecha();
        Posicion posDerDerAba = posDerDer.getPosicionAbajo();
        
        switch(recurso){
            case 0: //agrega 2 horizontalmente
                setearOcupanteEn(new BloquePiedra(posicion), posicion);
                setearOcupanteEn(new BloquePiedra(posDer), posDer);
                break;
            case 1: //agrega 2 verticalmente
                setearOcupanteEn(new BloquePiedra(posicion), posicion);
                setearOcupanteEn(new BloquePiedra(posAba), posAba);
                break;
            case 2: //agrega 4 en bloque
                setearOcupanteEn(new BloquePiedra(posicion), posicion);
                setearOcupanteEn(new BloquePiedra(posDer), posDer);
                setearOcupanteEn(new BloquePiedra(posAba), posAba);
                setearOcupanteEn(new BloquePiedra(posDerAba), posDerAba);
                break;
            case 3: //agrega 6 en bloque horizontal
                setearOcupanteEn(new BloquePiedra(posicion), posicion);
                setearOcupanteEn(new BloquePiedra(posDer), posDer);
                setearOcupanteEn(new BloquePiedra(posAba), posAba);
                setearOcupanteEn(new BloquePiedra(posDerAba), posDerAba);
                setearOcupanteEn(new BloquePiedra(posDerDer), posDerDer);
                setearOcupanteEn(new BloquePiedra(posDerDerAba), posDerDerAba);
                break;

        }
    }
    private void agregarBloqueMadera(Posicion posicion){
        Random random = new Random();
        int recurso = random.nextInt(4);

        Posicion posDer = posicion.getPosicionDerecha();
        Posicion posAba = posicion.getPosicionAbajo();
        Posicion posDerAba = posDer.getPosicionAbajo();
        Posicion posDerDer = posDer.getPosicionDerecha();
        Posicion posDerDerAba = posDerDer.getPosicionAbajo();
        Posicion posAbaAba = posAba.getPosicionAbajo();
        Posicion posAbaAbaDer = posAbaAba.getPosicionDerecha();
        Posicion posAbaAbaDerDer = posAbaAbaDer.getPosicionDerecha();
        
        switch(recurso){
            case 0: //agrega bloque de 4
                setearOcupanteEn(new BloqueMadera(posicion), posicion);
                setearOcupanteEn(new BloqueMadera(posDer), posDer);
                setearOcupanteEn(new BloqueMadera(posAba), posAba);
                setearOcupanteEn(new BloqueMadera(posDerAba), posDerAba);
                break;
            case 1: //agrega bloque de 6 horizontalmente
                setearOcupanteEn(new BloqueMadera(posicion), posicion);
                setearOcupanteEn(new BloqueMadera(posDer), posDer);
                setearOcupanteEn(new BloqueMadera(posAba), posAba);
                setearOcupanteEn(new BloqueMadera(posDerAba), posDerAba);
                setearOcupanteEn(new BloqueMadera(posDerDer), posDerDer);
                setearOcupanteEn(new BloqueMadera(posDerDerAba), posDerDerAba);
                break;
            case 2: //agrega bloque de 6 verticalmente
                setearOcupanteEn(new BloqueMadera(posicion), posicion);
                setearOcupanteEn(new BloqueMadera(posDer), posDer);
                setearOcupanteEn(new BloqueMadera(posAba), posAba);
                setearOcupanteEn(new BloqueMadera(posDerAba), posDerAba);
                setearOcupanteEn(new BloqueMadera(posAbaAba), posAbaAba);
                setearOcupanteEn(new BloqueMadera(posAbaAbaDer), posAbaAbaDer);
                break;
            case 3: //agrega bloque de 9
                setearOcupanteEn(new BloqueMadera(posicion), posicion);
                setearOcupanteEn(new BloqueMadera(posDer), posDer);
                setearOcupanteEn(new BloqueMadera(posDerDer), posDerDer);
                setearOcupanteEn(new BloqueMadera(posAba), posAba);
                setearOcupanteEn(new BloqueMadera(posDerAba), posDerAba);
                setearOcupanteEn(new BloqueMadera(posDerDerAba), posDerDerAba);
                setearOcupanteEn(new BloqueMadera(posAbaAba), posAbaAba);
                setearOcupanteEn(new BloqueMadera(posAbaAbaDer), posAbaAbaDer);
                setearOcupanteEn(new BloqueMadera(posAbaAbaDerDer), posAbaAbaDerDer);

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
