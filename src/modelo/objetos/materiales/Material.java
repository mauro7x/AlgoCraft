package modelo.objetos.materiales;

import modelo.objetos.Objeto;
import modelo.recursos.*;

public abstract class Material implements Objeto {

    public void gastarMaderaConHacha(BloqueMadera madera, float fuerza){
        madera.desgastar(fuerza);
    }
    public void gastarPiedraConPico(BloquePiedra piedra, float fuerza){
        piedra.desgastar(fuerza);
    }
    public void gastarMetalConPico(BloqueMetal metal, float fuerza){
        metal.desgastar(fuerza);
    }
    public void gastarDiamanteConPicoFino(BloqueDiamante diamante, float fuerza){
        diamante.desgastar(fuerza);
    }

}
