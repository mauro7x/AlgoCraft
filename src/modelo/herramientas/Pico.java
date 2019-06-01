package modelo.herramientas;

import modelo.herramientas.desgastes.*;
import modelo.materiales.*;

public class Pico extends Herramienta {

    public Pico(Madera madera){
        this.durabilidad = 100;
        this.fuerza = 2;
        this.desgaste = new DesgasteEnFuerza();
    }

    public Pico(Piedra piedra){
        this.durabilidad = 200;
        this.fuerza = 4;
        this.desgaste = new DesgasteEnFuerzaSobreTresMedios();
    }

    public Pico(Metal metal){
        this.durabilidad = 400;
        this.fuerza = 12;
        this.desgaste = new DesgasteTrasDiezUsos();
    }

}
