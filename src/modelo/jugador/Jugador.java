package modelo.jugador;


import modelo.Juego;
import modelo.mapa.Celda;
import modelo.mapa.OcupanteDeCelda;
import modelo.objetos.herramientas.Hacha;
import modelo.objetos.herramientas.Herramienta;
import modelo.objetos.materiales.Madera;

public class Jugador implements OcupanteDeCelda {

    private int x;
    private int y;
    private Orientacion orientacion;
    private InventarioHerramientas herramientas;
    private InventarioMateriales materiales;

    public Jugador(int x, int y){
        this.x = x;
        this.y = y;
        this.orientacion = new OrientacionArriba();
        herramientas = new InventarioHerramientas();
        materiales = new InventarioMateriales();
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    @Override
    public OcupanteDeCelda ocuparPorOcupanteDe(Celda celdaOrigen) {
        return this;
    }

    @Override
    public void actualizarPosicion(int x, int y) {
        this.x = x;
        this.y = y;
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
