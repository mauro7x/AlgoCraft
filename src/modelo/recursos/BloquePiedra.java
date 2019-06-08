package modelo.recursos;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Material;

public class BloquePiedra extends Recurso {

    public BloquePiedra(){
        this.durabilidad = 30;
    }

    public void serGolpeadoPor(Hacha hacha){
        hacha.gastar();
    }

    public void serGolpeadoPor(Pico pico){
        pico.gastar();
        Material material = pico.getMaterial();
        material.gastarPiedraConPico(this, pico.getFuerza());
    }

    public void serGolpeadoPor(PicoFino picoFino){

    }
}
