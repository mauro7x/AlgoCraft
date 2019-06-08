package modelo.recursos;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Material;

public class BloqueMadera extends Recurso {

    public BloqueMadera(){
        this.durabilidad = 10;
    }

    public void serGolpeadoPor(Hacha hacha){
        hacha.gastar();
        Material material = hacha.getMaterial();
        material.gastarMaderaConHacha(this, hacha.getFuerza());
    }

    public void serGolpeadoPor(Pico pico){
        pico.gastar();
    }

    public void serGolpeadoPor(PicoFino picoFino){
    }
}
