package modelo.recursos;

import modelo.objetos.herramientas.Herramienta;

public class BloqueMetal extends Recurso {

    public BloqueMetal(){
        this.durabilidad = 50;
    }

    @Override
    public void serGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }
}
