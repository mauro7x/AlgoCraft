package modelo.recursos;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Material;

public class BloqueMadera extends Recurso {

    public BloqueMadera(){
        this.durabilidad = 10;
    }

    public void serGolpeadoPor(Hacha hacha, Material material, float fuerza){
        hacha.gastar();
        material.gastarMaderaConHacha(this, fuerza);
    }

    public void serGolpeadoPor(Pico pico, Material material, float fuerza){
        pico.gastar();
    }

    public void serGolpeadoPor(PicoFino picoFino, Material material, float fuerza){
    }
}
