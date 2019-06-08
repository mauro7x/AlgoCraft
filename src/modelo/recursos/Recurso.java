package modelo.recursos;
import modelo.objetos.herramientas.*;

public abstract class Recurso {

    protected int durabilidad;

    public float getDurabilidad() {
        return durabilidad;
    }

    public abstract void serGolpeadoPor(Hacha hacha);
    public abstract void serGolpeadoPor(Pico pico);
    public abstract void serGolpeadoPor(PicoFino picoFino);

    public void gastar(float fuerza){
        durabilidad -= fuerza;
    }
}
