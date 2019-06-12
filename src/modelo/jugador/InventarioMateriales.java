package modelo.jugador;

import modelo.objetos.GuardableEnInventario;

import java.util.HashMap;

public class InventarioMateriales {

    private HashMap<Integer, Integer> materiales;

    public InventarioMateriales(int cantidadMateriales){
        this.materiales = new HashMap<Integer, Integer>();
        for (int i=1; i<=cantidadMateriales; i++){
            this.materiales.put(i, 0);
        }
    }

    public int getCantidadMateriales(int id){ return this.materiales.get(id); }

    public void guardar(GuardableEnInventario material){
        int id = material.getId();
        this.materiales.put(id, this.materiales.get(id) + 1);
    }

    public GuardableEnInventario usarMaterial(GuardableEnInventario material){
        int id = material.getId();
        if (this.materiales.get(id) == 0) { return null; }
        this.materiales.put(id, this.materiales.get(id) - 1);
        return material;
    }

}
