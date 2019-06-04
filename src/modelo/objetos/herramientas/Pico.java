package modelo.objetos.herramientas;

import modelo.objetos.herramientas.desgastes.*;
import modelo.objetos.materiales.*;
import modelo.recursos.Recurso;

public class Pico extends Herramienta {

    public Pico(Madera madera){
        this.durabilidad = 100;
        this.fuerza = 2;
        this.desgaste = new DesgasteEnFuerza();
        this.material = madera;
    }

    public Pico(Piedra piedra){
        this.durabilidad = 200;
        this.fuerza = 4;
        this.desgaste = new DesgasteEnFuerzaSobreTresMedios();
        this.material = piedra;
    }

    public Pico(Metal metal){
        this.durabilidad = 400;
        this.fuerza = 12;
        this.desgaste = new DesgasteTrasDiezUsos();
        this.material = metal;
    }

    public void golpear(Recurso recurso){
        recurso.serGolpeadoPorPico(this, this.material, this.fuerza);
    }

}
