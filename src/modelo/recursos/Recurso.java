package modelo.recursos;
import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Material;

public abstract class Recurso {

    protected int durabilidad;

    public float getDurabilidad() {
        return durabilidad;
    }

    public abstract void serGolpeadoPor(Hacha hacha, Material material, float fuerza);
    public abstract void serGolpeadoPor(Pico pico, Material material, float fuerza);
    public abstract void serGolpeadoPor(PicoFino picoFino, Material material, float fuerza);

    public void desgastar(float fuerza){
        durabilidad -= fuerza;
    }
}
