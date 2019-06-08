package modelo.objetos.herramientas;

import modelo.objetos.materiales.Material;
import modelo.objetos.herramientas.durabilidades.*;
import modelo.recursos.*;

public abstract class Herramienta {

    protected Durabilidad durabilidad;
    protected float fuerza;
    protected Material material;


    public float getDurabilidad() {
        return (this.durabilidad.getDurabilidad());
    }
    public float getFuerza() {
        return fuerza;
    }

    public Material getMaterial(){
        return this.material;
    }

    public void gastar(){
        this.durabilidad.gastar(this.fuerza);
    }

    public void golpear(Recurso recurso){
        recurso.serGolpeadoPor(this);
    }
    public abstract void golpear(BloqueMadera madera);
    public abstract void golpear(BloquePiedra piedra);
    public abstract void golpear(BloqueMetal metal);
    public abstract void golpear(BloqueDiamante diamante);
}
