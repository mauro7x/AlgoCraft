package modelo.recursos;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Material;

public class BloqueDiamante extends Recurso {

    public BloqueDiamante(){
        this.durabilidad = 100;
    }

    public void serGolpeadoPor(Hacha hacha){
        hacha.gastar();
    }

    public void serGolpeadoPor(Pico pico){
        pico.gastar();
    }

    public void serGolpeadoPor(PicoFino picoFino){
        picoFino.gastar();
        Material material = picoFino.getMaterial();
        material.gastarDiamanteConPicoFino(this, picoFino.getFuerza());
    }

}
