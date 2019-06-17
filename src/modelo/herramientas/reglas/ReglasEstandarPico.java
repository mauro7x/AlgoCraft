package modelo.herramientas.reglas;

import modelo.recursos.BloqueDiamante;
import modelo.recursos.BloqueMadera;
import modelo.recursos.BloqueMetal;
import modelo.recursos.BloquePiedra;

public class ReglasEstandarPico implements ReglasDesgasteRecurso {
    @Override
    public void gastar(BloqueMetal metal, float fuerza) {
        // no gasto metal con pico
    }

    @Override
    public void gastar(BloqueMadera madera, float fuerza) {
        // no gasto madera con pico
    }

    @Override
    public void gastar(BloquePiedra piedra, float fuerza) {
        piedra.gastar(fuerza);
    }

    @Override
    public void gastar(BloqueDiamante diamante, float fuerza) {
        // no gasto diamante con pico
    }
}
