package modelo.herramientas;
import modelo.herramientas.desgastes.*;
import modelo.materiales.Material;

public abstract class Herramienta {

    protected Desgaste desgaste;
    protected float durabilidad;
    protected float fuerza;


    public float getDurabilidad() {
        return durabilidad;
    }
    public float getFuerza() {
        return fuerza;
    }


    public void usar(Material material){
        this.durabilidad = this.desgaste.usar(this.durabilidad, this.fuerza);
    }


}
