package modelo.recursos;

import modelo.objetos.herramientas.Herramienta;


public class BloqueMadera extends Recurso {

    public BloqueMadera(){
        this.durabilidad = 10;
    }

    @Override
    public void serGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }
}
