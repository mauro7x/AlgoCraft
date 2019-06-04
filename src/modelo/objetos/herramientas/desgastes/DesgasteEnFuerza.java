package modelo.objetos.herramientas.desgastes;

public class DesgasteEnFuerza implements Desgaste {
    @Override
    public float usar(float durabilidad, float fuerza) {
        return (durabilidad-fuerza);
    }
}
