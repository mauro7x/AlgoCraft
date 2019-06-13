package modelo.jugador;

import modelo.objetos.herramientas.Hacha;
import modelo.objetos.herramientas.Herramienta;
import modelo.objetos.materiales.Madera;

import java.util.ArrayList;

public class InventarioHerramientas{

    private int cantidadDeHerramientas;
    private ArrayList<Herramienta> herramientas;
    private int herramientaActual;

    public InventarioHerramientas(){
        this.herramientaActual = 0;
        this.herramientas = new ArrayList<Herramienta>();
        this.herramientas.add(new Hacha(new Madera()));
        this.cantidadDeHerramientas = 1;
    }

    public int getCantidadHerramientas(){ return this.cantidadDeHerramientas; }

    public void guardar(Herramienta herramienta){
        this.herramientas.add(herramienta);
        this.cantidadDeHerramientas += 1;
    }

    public void eliminarHerramientaActual(){
        if (this.cantidadDeHerramientas == 0) return;
        this.herramientas.remove(herramientaActual);
        this.cantidadDeHerramientas -= 1;
    }

    public void cambiarAHerramientaSiguiente(){
        this.herramientaActual = (this.herramientaActual + 1)%(this.cantidadDeHerramientas);
    }

    public void cambiarAHerramientaAnterior(){
        this.herramientaActual = Math.abs((this.herramientaActual - 1)%(this.cantidadDeHerramientas));
    }

    public Herramienta getHerramientaActual(){
        if (this.cantidadDeHerramientas == 0) return null;
        return herramientas.get(this.herramientaActual);
    }
}
