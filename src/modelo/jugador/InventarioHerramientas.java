package modelo.jugador;

import modelo.objetos.herramientas.Herramienta;
import java.util.ArrayList;

public class InventarioHerramientas{

    private int cantidadDeHerramientas;
    private ArrayList<Herramienta> herramientas;
    private int herramientaEnUso;

    public InventarioHerramientas(){
        this.herramientaEnUso = 0;
        this.herramientas = new ArrayList<Herramienta>();
        this.cantidadDeHerramientas = 0;
    }

    public int getCantidadHerramientas(){ return this.cantidadDeHerramientas; }

    public void guardar(Herramienta herramienta){
        this.herramientas.add(herramienta);
        this.cantidadDeHerramientas += 1;
    }

    public void eliminarHerramientaEnUso(){
        if (this.cantidadDeHerramientas == 0) return;
        this.herramientas.remove(herramientaEnUso);
        this.cantidadDeHerramientas -= 1;
    }

    public void cambiarAHerramientaSiguiente(){
        this.herramientaEnUso = (this.herramientaEnUso + 1)%(this.cantidadDeHerramientas);
    }

    public void cambiarAHerramientaAnterior(){
        this.herramientaEnUso = Math.abs((this.herramientaEnUso - 1)%(this.cantidadDeHerramientas));
    }

    public Herramienta getHerramientaEnUso(){
        if (this.cantidadDeHerramientas == 0) return null;
        return herramientas.get(this.herramientaEnUso);
    }
}