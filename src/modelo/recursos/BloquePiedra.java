package modelo.recursos;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Material;

public class BloquePiedra extends Recurso {

    public void serGolpeadoPorHacha(Hacha hacha, Material material, float fuerza){
        hacha.gastar();
    }

    public void serGolpeadoPorPico(Pico pico, Material material, float fuerza){
        pico.gastar();
        material.gastarPiedraConPico(this, fuerza);
    }

    public void serGolpeadoPorPicoFino(PicoFino picoFino, Material material, float fuerza){

    }
}
