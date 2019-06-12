package modelo.jugador;

import modelo.objetos.GuardableEnInventario;

public class InventarioMateriales {

    private int materiales[];

    public InventarioMateriales(int cantidadMateriales){
        this.materiales = new int[cantidadMateriales];
        for (int i=0; i<cantidadMateriales; i++){
            this.materiales[i] = 0;
        }
    }

    public int getCantidadMaterial(int id){ return this.materiales[id - 1]; }

    public void guardar(GuardableEnInventario material){ this.materiales[material.getId() - 1] += 1; }

    public GuardableEnInventario usarMaterial(GuardableEnInventario material){
        if (this.materiales[material.getId() - 1] == 0) { return null; }
        this.materiales[material.getId() - 1] -= 1;
        return material;
    }

}
