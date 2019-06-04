package modelo.objetos.herramientas.desgastes;

public class DesgasteEnFuerzaSobreTresMedios implements Desgaste {
    @Override
    public float usar(float durabilidad, float fuerza) {
        return (durabilidad-(float)(fuerza/1.5));
    }
}
