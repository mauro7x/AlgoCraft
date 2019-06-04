package modelo.objetos.materiales;

import modelo.recursos.*;

public class Piedra extends Material {
    @Override
    public void gastarMaderaConHacha(BloqueMadera madera, float fuerza) {
        madera.desgastar(fuerza);
    }

    @Override
    public void gastarPiedraConPico(BloquePiedra piedra, float fuerza) {
        piedra.desgastar(fuerza);
    }

    @Override
    public void gastarMetalConPico(BloqueMetal metal, float fuerza) {
        metal.desgastar(fuerza);
    }

    @Override
    public void gastarDiamanteConPicoFino(BloqueDiamante diamante, float fuerza) {
        // no existe pico fino de piedra
    }
}
