package modelo.jugador;


import javafx.scene.image.Image;
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
    public void serGolpeadoPor(Herramienta herramienta) {
        throw new RuntimeException("Jugador no puede ser golpeado por nadie");
    }

    @Override
    public Image obtenerImagen(int size) { //TODO: cambiar esto
        return orientacion.obtenerImagen(size);
    }

    public void moverArriba(){
        this.orientacion = new OrientacionArriba();
        Juego.getJuego().moverJugadorArriba(this);
    }
    public void moverAbajo(){
        this.orientacion = new OrientacionAbajo();
        Juego.getJuego().moverJugadorAbajo(this);
    }
    public void moverIzquierda(){
        this.orientacion = new OrientacionIzquierda();
        Juego.getJuego().moverJugadorIzquierda(this);
    }
    public void moverDerecha(){
        this.orientacion = new OrientacionDerecha();
        Juego.getJuego().moverJugadorDerecha(this);
    }

    public void cambiarAHerramientaSiguiente(){
        herramientas.cambiarAHerramientaSiguiente();
    }

    public void cambiarAHerramientaAnterior(){
        herramientas.cambiarAHerramientaAnterior();
    }

    public void golpear(){
        this.orientacion.golpear(herramientas.getHerramientaActual());
    }

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
