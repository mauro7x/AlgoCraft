package modelo.recursos;
import modelo.objetos.herramientas.*;

public abstract class Recurso {

    protected int durabilidad;

    public float getDurabilidad() {
        return durabilidad;
    }

    public abstract void serGolpeadoPor(Herramienta herramienta);

    public void gastar(float fuerza){
        durabilidad -= fuerza;
    }
}
