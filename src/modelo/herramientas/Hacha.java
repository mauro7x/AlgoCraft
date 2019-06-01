package modelo.herramientas;

import modelo.herramientas.desgastes.*;
import modelo.materiales.*;

public class Hacha extends Herramienta {

    public Hacha(Madera madera){
        this.durabilidad = 100;
        this.fuerza = 2;
        this.desgaste = new DesgasteEnFuerza();
    }

    public Hacha(Piedra piedra){
        this.durabilidad = 200;
        this.fuerza = 5;
        this.desgaste = new DesgasteEnFuerza();
    }

    public Hacha(Metal metal){
        this.durabilidad = 400;
        this.fuerza = 10;
        this.desgaste = new DesgasteEnFuerzaSobreDos();
    }

}
