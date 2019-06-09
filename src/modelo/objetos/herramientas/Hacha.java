package modelo.objetos.herramientas;

import modelo.objetos.herramientas.durabilidades.*;
import modelo.objetos.herramientas.reglas.ReglasEstandarHacha;
import modelo.objetos.materiales.Madera;
import modelo.objetos.materiales.Metal;
import modelo.objetos.materiales.Piedra;


public class Hacha extends Herramienta {

    private int id;

    public Hacha(Madera madera){
        this.durabilidad = new DurabilidadEnFuerza(1);
        this.durabilidad.setDurabilidad(100);
        this.fuerza = 2;
        this.reglasDeDesgaste = new ReglasEstandarHacha();
        this.id = 10;
    }

    public Hacha(Piedra piedra){
        this.durabilidad = new DurabilidadEnFuerza(1);
        this.durabilidad.setDurabilidad(200);
        this.fuerza = 5;
        this.reglasDeDesgaste = new ReglasEstandarHacha();
        this.id = 11;
    }

    public Hacha(Metal metal){
        this.durabilidad = new DurabilidadEnFuerza(2);
        this.durabilidad.setDurabilidad(400);
        this.fuerza = 10;
        this.reglasDeDesgaste = new ReglasEstandarHacha();
        this.id = 12;
    }


    @Override
    public int getId() {
        return this.id;
    }
}
