package modelo.objetos.herramientas.desgastes;

public class DesgasteEnFuerzaSobreDos implements Desgaste {
    @Override
    public float usar(float durabilidad, float fuerza) {
        return (durabilidad-(fuerza/2));
    }
}
