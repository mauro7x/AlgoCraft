package modelo.objetos.herramientas.durabilidades;

public class DurabilidadDiezPorciento extends Durabilidad {

    @Override
    public void gastar(float fuerza) {
        durabilidad -= (durabilidad*(float)(0.1));
    }

}
