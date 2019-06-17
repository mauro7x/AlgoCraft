package modelo.herramientas.durabilidades;

public class DurabilidadTrasDiezUsos extends Durabilidad {

    private int usosRestantes = 10;

    @Override
    public void gastar(float fuerza) {
        if (usosRestantes == 1)
            durabilidad = 0;
        else
            usosRestantes--;
    }
}
