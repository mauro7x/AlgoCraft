package modelo.objetos.materiales;

import modelo.objetos.Objeto;
import modelo.recursos.*;

public abstract class Material implements Objeto {

    public abstract void gastarMaderaConHacha(BloqueMadera madera, float fuerza);
    public abstract void gastarPiedraConPico(BloquePiedra piedra, float fuerza);
    public abstract void gastarMetalConPico(BloqueMetal metal, float fuerza);
    public abstract void gastarDiamanteConPicoFino(BloqueDiamante diamante, float fuerza);

}
