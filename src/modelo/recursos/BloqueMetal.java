package modelo.recursos;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Material;

public class BloqueMetal extends Recurso {

    public BloqueMetal(){
        this.durabilidad = 50;
    }

    public void serGolpeadoPor(Hacha hacha){
        hacha.gastar();
    }

    public void serGolpeadoPor(Pico pico){
        pico.gastar();
        Material material = pico.getMaterial();
        material.gastarMetalConPico(this, pico.getFuerza());
    }

    public void serGolpeadoPor(PicoFino picoFino){

    }
}
