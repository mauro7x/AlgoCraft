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

    public int obtenerCantidad(int id){ return this.materiales[id - 1]; }

    public void guardar(GuardableEnInventario material){ this.materiales[material.getId() - 1] += 1; }

    // Definir como vamos a usar el Inventario, y como se van a obtener sus objetos
    //public void usarMaterial(int id){ }
}
