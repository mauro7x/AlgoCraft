package modelo.objetos.materiales;

import modelo.recursos.*;

public class PiedraYMetal extends Material {
    @Override
    public void gastarMaderaConHacha(BloqueMadera madera, float fuerza) {
        // no existe hacha de piedra y metal
    }

    @Override
    public void gastarPiedraConPico(BloquePiedra piedra, float fuerza) {
        // no existe pico de piedra y metal
    }

    @Override
    public void gastarMetalConPico(BloqueMetal metal, float fuerza) {
        // no existe pico de piedra y metal
    }

    @Override
    public void gastarDiamanteConPicoFino(BloqueDiamante diamante, float fuerza) {
        diamante.desgastar(fuerza);
    }
}
