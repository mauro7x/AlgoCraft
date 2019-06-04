package modelo.recursos;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Material;

public class BloqueMadera extends Recurso {

    public void serGolpeadoPorHacha(Hacha hacha, Material material, float fuerza){
        hacha.gastar();
        material.gastarMaderaConHacha(this, fuerza);
    }

    public void serGolpeadoPorPico(Pico pico, Material material, float fuerza){
        pico.gastar();
    }

    public void serGolpeadoPorPicoFino(PicoFino picoFino, Material material, float fuerza){
    }
}
