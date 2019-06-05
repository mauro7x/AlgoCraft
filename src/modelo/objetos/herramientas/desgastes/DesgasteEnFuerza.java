package modelo.objetos.herramientas.desgastes;

public class DesgasteEnFuerza implements Desgaste {

    private float FactorReduccion;

    public DesgasteEnFuerza(float FactorReduccion){
        this.FactorReduccion = FactorReduccion;
    }

    @Override
    public float usar(float durabilidad, float fuerza) {
        return (durabilidad-(fuerza/FactorReduccion));
    }
}
