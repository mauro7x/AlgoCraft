package modelo.jugador;

import modelo.Juego;
import modelo.herramientas.FabricaHerramientas;
import modelo.herramientas.Herramienta;

import java.util.ArrayList;

public class InventarioHerramientas{

    private int cantidadDeHerramientas;
    private ArrayList<Herramienta> herramientas;
    private int herramientaActual;

    public InventarioHerramientas(){
        this.herramientaActual = 0;
        this.herramientas = new ArrayList<>();
        this.herramientas.add(FabricaHerramientas.crearHachaDeMadera());
        this.cantidadDeHerramientas = 1;
    }

    public int getCantidadHerramientas(){ return this.cantidadDeHerramientas; }

    public void guardar(Herramienta herramienta){
        this.herramientas.add(herramienta);
        this.cantidadDeHerramientas += 1;
        Juego.getJuego().imprimirPorConsola("Herramienta construida.");
    }

    public void eliminarHerramientaActual(){
        if (this.cantidadDeHerramientas == 0) return;
        this.herramientas.remove(herramientaActual);
        this.cantidadDeHerramientas -= 1;
        this.cambiarAHerramientaSiguiente();
        Juego.getJuego().imprimirPorConsola("Herramienta rota.");
    }

    public void cambiarAHerramientaSiguiente(){
        if(cantidadDeHerramientas == 0) return;
        this.herramientaActual = Math.floorMod(this.herramientaActual+1,this.cantidadDeHerramientas);
    }

    public void cambiarAHerramientaAnterior(){
        if(cantidadDeHerramientas == 0) return;
        this.herramientaActual = Math.floorMod(this.herramientaActual-1,this.cantidadDeHerramientas);
    }

    public Herramienta getHerramientaActual(){
        if (this.cantidadDeHerramientas == 0) return null;
        return herramientas.get(this.herramientaActual);
    }

    public boolean noTieneHerramientas() {
        return cantidadDeHerramientas == 0;
    }

    public ArrayList<Herramienta> getHerramientas(){
        return herramientas;
    }
}
