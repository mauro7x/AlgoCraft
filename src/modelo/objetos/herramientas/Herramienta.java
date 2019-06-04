package modelo.objetos.herramientas;

import modelo.objetos.Objeto;
import modelo.objetos.materiales.Material;
import modelo.objetos.herramientas.desgastes.*;
import modelo.recursos.Recurso;

public abstract class Herramienta implements Objeto {

    protected Desgaste desgaste;
    protected float durabilidad;
    protected float fuerza;
    protected Material material;


    public float getDurabilidad() {
        return durabilidad;
    }
    public float getFuerza() {
        return fuerza;
    }

    public void gastar(){
        this.durabilidad = this.desgaste.usar(this.durabilidad, this.fuerza);
    }

    public abstract void golpear(Recurso recurso);

}
