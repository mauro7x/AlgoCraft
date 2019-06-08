package modelo.objetos.herramientas;

import modelo.objetos.herramientas.durabilidades.*;
import modelo.objetos.materiales.PiedraYMetal;
import modelo.recursos.*;


public class PicoFino extends Herramienta {

    public PicoFino(){
        this.durabilidad = new DurabilidadDiezPorciento();
        this.durabilidad.setDurabilidad(1000);
        this.fuerza = 20;
        this.material = new PiedraYMetal();
    }

    @Override
    public void golpear(BloqueMadera madera) {
    }

    @Override
    public void golpear(BloquePiedra piedra) {

    }

    @Override
    public void golpear(BloqueMetal metal) {

    }

    @Override
    public void golpear(BloqueDiamante diamante) {
        gastar();
        diamante.gastar(this.fuerza);
    }
}
