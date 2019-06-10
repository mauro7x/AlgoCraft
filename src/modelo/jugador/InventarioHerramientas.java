package modelo.jugador;

import modelo.objetos.herramientas.Herramienta;
import java.util.ArrayList;

public class InventarioHerramientas{

    private int cantidadDeSlotsDisponibles;
    private ArrayList<Herramienta> herramientas;
    private Herramienta herramientaEnUso;

    public InventarioHerramientas(int cantidadDeSlots){
        this.cantidadDeSlotsDisponibles = cantidadDeSlots;
        this.herramientas = new ArrayList<Herramienta>();
        this.herramientaEnUso = null;
    }

    public int getCantidadSlotsDisponibles(){ return this.cantidadDeSlotsDisponibles; }

    public boolean guardar(Herramienta herramienta){
        if (this.cantidadDeSlotsDisponibles == 0) return false;
        this.herramientas.add(herramienta);
        this.cantidadDeSlotsDisponibles -= 1;
        return true;
    }

    public void eliminar(int indice){
        if (herramientas.get(indice) == this.herramientaEnUso){
            herramientaEnUso = null;
        }
        this.herramientas.remove(indice);
        this.cantidadDeSlotsDisponibles += 1;
    }

    public void establecerHerramientaEnUso(int indice){
        herramientaEnUso = herramientas.get(indice);
    }

    public Herramienta getHerramientaEnUso(){ return herramientaEnUso; }
}