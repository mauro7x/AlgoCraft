package modelo.objetos.herramientas;

import modelo.objetos.Objeto;
import modelo.objetos.materiales.Material;
import modelo.objetos.herramientas.durabilidades.*;
import modelo.recursos.Recurso;

public abstract class Herramienta implements Objeto {

    protected Durabilidad durabilidad;
    protected float fuerza;
    protected Material material;


    public float getDurabilidad() {
        return (this.durabilidad.getDurabilidad());
    }
    public float getFuerza() {
        return fuerza;
    }

    public void gastar(){
        this.durabilidad.gastar(this.fuerza);
    }

    public abstract void golpear(Recurso recurso);

}
