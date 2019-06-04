package modelo.recursos;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Material;

public class BloqueMetal extends Recurso {

    public BloqueMetal(){
        this.durabilidad = 50;
    }

    public void serGolpeadoPor(Hacha hacha, Material material, float fuerza){
        hacha.gastar();
    }

    public void serGolpeadoPor(Pico pico, Material material, float fuerza){
        pico.gastar();
        material.gastarMetalConPico(this, fuerza);
    }

    public void serGolpeadoPor(PicoFino picoFino, Material material, float fuerza){

    }
}
