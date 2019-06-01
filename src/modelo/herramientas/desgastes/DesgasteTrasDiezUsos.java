package modelo.herramientas.desgastes;

public class DesgasteTrasDiezUsos implements Desgaste {

    private int usosRestantes = 10;

    @Override
    public float usar(float durabilidad, float fuerza) {
        if (usosRestantes == 1)
            return 0;
        else
            usosRestantes--;
            return durabilidad;

    }
}
