package modelo.jugador;

import modelo.Juego;
import modelo.mapa.Celda;
import modelo.mapa.OcupanteDeCelda;
import modelo.mapa.Posicion;
import modelo.herramientas.Herramienta;

import java.util.ArrayList;

public class Jugador implements OcupanteDeCelda {

    private Posicion posicion;
    private Orientacion orientacion;
    private InventarioHerramientas herramientas;
    private InventarioMateriales materiales;

    public Jugador(Posicion posicionInicial){
        this.posicion = posicionInicial;
        this.orientacion = new OrientacionArriba();
        herramientas = new InventarioHerramientas();
        materiales = new InventarioMateriales();
    }

    public void resetear(Posicion posicionInicialReseteo){
        this.posicion = posicionInicialReseteo;
        this.orientacion = new OrientacionArriba();
    }

    public Posicion getPosicion(){ return this.posicion; }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    @Override
    public OcupanteDeCelda ocuparPorOcupanteDe(Celda celdaOrigen) {
        return this;
    }

    @Override
    public void actualizarPosicion(Posicion posicionNueva) {
        this.posicion = posicionNueva;
    }

    @Override
    public boolean serGolpeadoPor(Herramienta herramienta) {
        throw new RuntimeException("Jugador no puede ser golpeado por nadie");
    }

    @Override
    public String obtenerImagen() {
        return orientacion.obtenerImagen();
    }

    public boolean moverArriba(){
        Posicion posicionJugador = this.getPosicion();
        this.orientacion = new OrientacionArriba();
        Juego.getJuego().moverJugadorArriba(this);
        if (posicionJugador.equals(this.getPosicion())){ return false; };
        return true;
    }
    public boolean moverAbajo(){
        Posicion posicionJugador = this.getPosicion();
        this.orientacion = new OrientacionAbajo();
        Juego.getJuego().moverJugadorAbajo(this);
        if (posicionJugador.equals(this.getPosicion())){ return false; };
        return true;
    }
    public boolean moverIzquierda(){
        Posicion posicionJugador = this.getPosicion();
        this.orientacion = new OrientacionIzquierda();
        Juego.getJuego().moverJugadorIzquierda(this);
        if (posicionJugador.equals(this.getPosicion())){ return false; };
        return true;
    }
    public boolean moverDerecha(){
        Posicion posicionJugador = this.getPosicion();
        this.orientacion = new OrientacionDerecha();
        Juego.getJuego().moverJugadorDerecha(this);
        if (posicionJugador.equals(this.getPosicion())){ return false; };
        return true;
    }

    public void cambiarAHerramientaSiguiente(){
        herramientas.cambiarAHerramientaSiguiente();
    }

    public void cambiarAHerramientaAnterior(){
        herramientas.cambiarAHerramientaAnterior();
    }

    public boolean golpear(){ return this.orientacion.golpear(herramientas.getHerramientaActual()); }

    public InventarioMateriales getInventarioMateriales(){ return this.materiales; }

    public void guardar(Herramienta herramienta){
        herramientas.guardar(herramienta);
    }

    public Herramienta getHerramientaActual(){
        return herramientas.getHerramientaActual();
    }

    public ArrayList<Herramienta> getHerramientas(){
        return herramientas.getHerramientas();
    }

    public void eliminarHerramientaActual() {
        herramientas.eliminarHerramientaActual();
    }

    public boolean noTieneHerramientas(){
        return herramientas.noTieneHerramientas();
    }
}
