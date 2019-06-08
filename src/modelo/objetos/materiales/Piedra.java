package modelo.objetos.materiales;

import modelo.recursos.BloqueMetal;

public class Piedra extends Material {

    @Override
    public void gastar(BloqueMetal metal, float fuerza){
        metal.gastar(fuerza);
    }
}
