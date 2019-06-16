package modelo.jugador;


import modelo.Juego;
import modelo.mapa.Celda;
import modelo.mapa.OcupanteDeCelda;
import modelo.mapa.Posicion;
import modelo.objetos.herramientas.Herramienta;

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
        return; //El jugador no puede ser golpeado por otro jugador.
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

    public void golpear(){
        this.orientacion.golpear(herramientas.getHerramientaActual());
    }

    public InventarioMateriales getInventarioMateriales(){ return this.materiales; }
}
