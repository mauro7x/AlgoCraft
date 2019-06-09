package modelo.objetos.herramientas;

import modelo.objetos.herramientas.durabilidades.*;
import modelo.objetos.herramientas.reglas.ReglasEstandarPico;
import modelo.objetos.herramientas.reglas.ReglasPicoPiedra;
import modelo.objetos.materiales.*;


public class Pico extends Herramienta {
    private int id;

    public Pico(Madera madera){
        this.durabilidad = new DurabilidadEnFuerza(1);
        this.durabilidad.setDurabilidad(100);
        this.fuerza = 2;
        this.reglasDeDesgaste = new ReglasEstandarPico();
        this.id = 13;
    }

    public Pico(Piedra piedra){
        this.durabilidad = new DurabilidadEnFuerza(1.5f);
        this.durabilidad.setDurabilidad(200);
        this.fuerza = 4;
        this.reglasDeDesgaste = new ReglasPicoPiedra(new ReglasEstandarPico());
        this.id = 14;
    }

    public Pico(Metal metal){
        this.durabilidad = new DurabilidadTrasDiezUsos();
        this.durabilidad.setDurabilidad(400);
        this.fuerza = 12;
        this.reglasDeDesgaste = new ReglasEstandarPico();
        this.id = 15;
    }


    @Override
    public int getId() {
        return this.id;
    }
}
