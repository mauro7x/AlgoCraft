package modelo.recursos;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Material;

public class BloqueDiamante extends Recurso {

    public BloqueDiamante(){
        this.durabilidad = 100;
    }

    public void serGolpeadoPorHacha(Hacha hacha, Material material, float fuerza){
        hacha.gastar();
    }

    public void serGolpeadoPorPico(Pico pico, Material material, float fuerza){
        pico.gastar();
    }

    public void serGolpeadoPorPicoFino(PicoFino picoFino, Material material, float fuerza){
        picoFino.gastar();
        material.gastarDiamanteConPicoFino(this, fuerza);
    }

}
