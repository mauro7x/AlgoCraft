package modelo.objetos.herramientas;

import modelo.objetos.herramientas.desgastes.*;
import modelo.objetos.materiales.*;
import modelo.recursos.Recurso;

public class Hacha extends Herramienta {

    public Hacha(Madera madera){
        this.durabilidad = 100;
        this.fuerza = 2;
        this.desgaste = new DesgasteEnFuerza();
        this.material = madera;
    }

    public Hacha(Piedra piedra){
        this.durabilidad = 200;
        this.fuerza = 5;
        this.desgaste = new DesgasteEnFuerza();
        this.material = piedra;
    }

    public Hacha(Metal metal){
        this.durabilidad = 400;
        this.fuerza = 10;
        this.desgaste = new DesgasteEnFuerzaSobreDos();
        this.material = metal;
    }

    public void golpear(Recurso recurso){
        recurso.serGolpeadoPor(this, this.material, this.fuerza);
    }

}
