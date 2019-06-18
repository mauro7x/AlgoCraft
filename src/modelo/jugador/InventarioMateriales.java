package modelo.jugador;

import java.util.HashMap;

public class InventarioMateriales {

    private static final int CANTIDAD_MATERIALES = 4;

    private HashMap<Integer, Integer> materiales;

    InventarioMateriales(){
        this.materiales = new HashMap<>();
        for (int i=1; i<=CANTIDAD_MATERIALES; i++){
            this.materiales.put(i, 0);
        }
    }

    public int cantidadMadera(){ return this.materiales.get(1); }
    public int cantidadPiedra(){ return this.materiales.get(2); }
    public int cantidadMetal(){ return this.materiales.get(3); }
    public int cantidadDiamante(){ return this.materiales.get(4); }

    public void agregarMadera(){
        this.materiales.put(1, this.materiales.get(1) + 1);
    }
    public void agregarPiedra(){
        this.materiales.put(2, this.materiales.get(2) + 1);
    }
    public void agregarMetal(){
        this.materiales.put(3, this.materiales.get(3) + 1);
    }
    public void agregarDiamante(){
        this.materiales.put(4, this.materiales.get(4) + 1);
    }

    public int getMadera(){
        if (this.materiales.get(1) == 0) { return 0; }
        this.materiales.put(1, this.materiales.get(1) - 1);
        return 1;
    }
    public int getPiedra(){
        if (this.materiales.get(2) == 0) { return 0; }
        this.materiales.put(2, this.materiales.get(2) - 1);
        return 2;
    }
    public int getMetal(){
        if (this.materiales.get(3) == 0) { return 0; }
        this.materiales.put(3, this.materiales.get(3) - 1);
        return 3;
    }
    public int getDiamante(){
        if (this.materiales.get(4) == 0) { return 0; }
        this.materiales.put(4, this.materiales.get(4) - 1);
        return 4;
    }


}
