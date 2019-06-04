package modelo.objetos.herramientas.desgastes;

public class DesgasteDiezPorciento implements Desgaste {
    @Override
    public float usar(float durabilidad, float fuerza) {
        return (durabilidad - (durabilidad*(float)(0.1)));
    }
}
