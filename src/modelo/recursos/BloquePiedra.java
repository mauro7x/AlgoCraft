package modelo.recursos;

import modelo.objetos.herramientas.*;
import modelo.objetos.materiales.Material;

public class BloquePiedra extends Recurso {

    public BloquePiedra(){
        this.durabilidad = 30;
    }

    public void serGolpeadoPor(Hacha hacha, Material material, float fuerza){
        hacha.gastar();
    }

    public void serGolpeadoPor(Pico pico, Material material, float fuerza){
        pico.gastar();
        material.gastarPiedraConPico(this, fuerza);
    }

    public void serGolpeadoPor(PicoFino picoFino, Material material, float fuerza){

    }
}
