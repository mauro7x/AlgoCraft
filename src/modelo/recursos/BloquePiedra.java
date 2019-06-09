package modelo.recursos;

import modelo.objetos.herramientas.Herramienta;

public class BloquePiedra extends Recurso {

    public BloquePiedra(){
        this.durabilidad = 30;
    }

    @Override
    public void serGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }
}
