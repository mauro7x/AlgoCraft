package modelo.objetos.herramientas.reglas;

import modelo.recursos.BloqueDiamante;
import modelo.recursos.BloqueMadera;
import modelo.recursos.BloqueMetal;
import modelo.recursos.BloquePiedra;

public class ReglasEstandarPicoFino implements ReglasDesgasteRecurso {
    @Override
    public void gastar(BloqueMetal metal, float fuerza) {
        // no gasto metal con pico fino
    }

    @Override
    public void gastar(BloqueMadera madera, float fuerza) {
        // no gasto madera con pico fino
    }

    @Override
    public void gastar(BloquePiedra piedra, float fuerza) {
        // no gasto piedra con pico fino
    }

    @Override
    public void gastar(BloqueDiamante diamante, float fuerza) {
        diamante.gastar(fuerza);
    }
}
