package modelo.objetos.herramientas.durabilidades;

public class DurabilidadEnFuerza extends Durabilidad {

    private float FactorReduccion;

    public DurabilidadEnFuerza(float FactorReduccion){
        this.FactorReduccion = FactorReduccion;
    }

    @Override
    public void gastar(float fuerza) {
        durabilidad -=(fuerza/FactorReduccion);
    }
}
