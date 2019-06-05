package modelo.objetos.materiales;

import modelo.recursos.*;

public class Madera extends Material {

    @Override
    public void gastarMetalConPico(BloqueMetal metal, float fuerza) {
        // el pico de madera no desgasta al metal
    }

    @Override
    public void gastarDiamanteConPicoFino(BloqueDiamante diamante, float fuerza) {
        // no existe pico fino de madera
    }
}