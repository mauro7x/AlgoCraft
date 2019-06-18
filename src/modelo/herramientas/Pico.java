package modelo.herramientas;

import modelo.herramientas.durabilidades.DurabilidadEnFuerza;
import modelo.herramientas.durabilidades.DurabilidadTrasDiezUsos;
import modelo.herramientas.reglas.ReglasEstandarPico;
import modelo.herramientas.reglas.ReglasPicoPiedra;
import modelo.recursos.*;


public class Pico extends Herramienta {

    public Pico(){}

    static Herramienta deMadera(){
        Herramienta pico = new Pico();
        pico.durabilidad = new DurabilidadEnFuerza(1);
        pico.durabilidad.setDurabilidad(100);
        pico.fuerza = 2;
        pico.reglasDeDesgaste = new ReglasEstandarPico();
        pico.id = 13;
        pico.imagen = "picoMadera.png";
        return pico;
    }
    static Herramienta dePiedra(){
        Herramienta pico = new Pico();
        pico.durabilidad = new DurabilidadEnFuerza(1.5f);
        pico.durabilidad.setDurabilidad(200);
        pico.fuerza = 4;
        pico.reglasDeDesgaste = new ReglasPicoPiedra(new ReglasEstandarPico());
        pico.id = 14;
        pico.imagen = "picoPiedra.png";
        return pico;
    }
    static Herramienta deMetal(){
        Herramienta pico = new Pico();
        pico.durabilidad = new DurabilidadTrasDiezUsos();
        pico.durabilidad.setDurabilidad(400);
        pico.fuerza = 12;
        pico.reglasDeDesgaste = new ReglasEstandarPico();
        pico.id = 15;
        pico.imagen = "picoMetal.png";
        return pico;
    }

    @Override
    public void golpear(BloqueMadera madera){
        gastar();
        reglasDeDesgaste.gastar(madera, fuerza);
    }

    @Override
    public void golpear(BloquePiedra piedra){
        gastar();
        reglasDeDesgaste.gastar(piedra, fuerza);
    }

    @Override
    public void golpear(BloqueMetal metal){
        gastar();
        reglasDeDesgaste.gastar(metal, fuerza);
    }

    @Override
    public void golpear(BloqueDiamante diamante){
        gastar();
        reglasDeDesgaste.gastar(diamante, fuerza);
    }
}
