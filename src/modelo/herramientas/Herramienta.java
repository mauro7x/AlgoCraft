package modelo.herramientas;

public abstract class Herramienta {

    protected int durabilidad;
    protected int fuerza;


    public int getDurabilidad() {
        return durabilidad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void usar(){
        durabilidad -= fuerza;
    }
}
