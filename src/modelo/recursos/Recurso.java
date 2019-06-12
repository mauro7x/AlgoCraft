package modelo.recursos;
import modelo.mapa.OcupanteDeCelda;
import modelo.objetos.herramientas.*;

public abstract class Recurso implements OcupanteDeCelda {

    protected int durabilidad;

    public float getDurabilidad() {
        return durabilidad;
    }

    public abstract void serGolpeadoPor(Herramienta herramienta);

    public void gastar(float fuerza){
        durabilidad -= fuerza;
    }

    @Override
    public OcupanteDeCelda ocuparPor(OcupanteDeCelda ocupante){
        return this;
    }

}
