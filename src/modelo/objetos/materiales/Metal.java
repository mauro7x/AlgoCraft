package modelo.objetos.materiales;

import modelo.recursos.*;

public class Metal extends Material {

    @Override
    public void gastarMetalConPico(BloqueMetal metal, float fuerza) {
        // el pico de metal no desgasta al metal
    }

    @Override
    public void gastarDiamanteConPicoFino(BloqueDiamante diamante, float fuerza) {
        // no existe pico fino de metal
    }
}
