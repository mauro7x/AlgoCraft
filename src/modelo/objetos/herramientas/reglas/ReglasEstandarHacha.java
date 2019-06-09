package modelo.objetos.herramientas.reglas;

import modelo.recursos.BloqueDiamante;
import modelo.recursos.BloqueMadera;
import modelo.recursos.BloqueMetal;
import modelo.recursos.BloquePiedra;

public class ReglasEstandarHacha implements ReglasDesgasteRecurso {
    @Override
    public void gastar(BloqueMetal metal, float fuerza) {
        // no gasto metal con hacha
    }

    @Override
    public void gastar(BloqueMadera madera, float fuerza) {
        madera.gastar(fuerza);
    }

    @Override
    public void gastar(BloquePiedra piedra, float fuerza) {
        // no gasto piedra con hacha
    }

    @Override
    public void gastar(BloqueDiamante diamante, float fuerza) {
        // no gasto diamante con hacha
    }
}
