package modelo.objetos.materiales;

import modelo.recursos.*;

public abstract class Material {

    public void gastarMaderaConHacha(BloqueMadera madera, float fuerza){
        madera.gastar(fuerza);
    }
    public void gastarPiedraConPico(BloquePiedra piedra, float fuerza){
        piedra.gastar(fuerza);
    }
    public void gastarMetalConPico(BloqueMetal metal, float fuerza){
        metal.gastar(fuerza);
    }
    public void gastarDiamanteConPicoFino(BloqueDiamante diamante, float fuerza){
        diamante.gastar(fuerza);
    }

}
