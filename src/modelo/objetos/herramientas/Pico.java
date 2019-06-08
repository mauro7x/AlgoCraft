package modelo.objetos.herramientas;

import modelo.objetos.herramientas.durabilidades.*;
import modelo.objetos.materiales.*;
import modelo.recursos.Recurso;

public class Pico extends Herramienta {

    public Pico(Madera madera){
        this.durabilidad = new DurabilidadEnFuerza(1);
        this.durabilidad.setDurabilidad(100);
        this.fuerza = 2;
        this.material = madera;
    }

    public Pico(Piedra piedra){
        this.durabilidad = new DurabilidadEnFuerza(1.5f);
        this.durabilidad.setDurabilidad(200);
        this.fuerza = 4;
        this.material = piedra;
    }

    public Pico(Metal metal){
        this.durabilidad = new DurabilidadTrasDiezUsos();
        this.durabilidad.setDurabilidad(400);
        this.fuerza = 12;
        this.material = metal;
    }

    public void golpear(Recurso recurso){
        recurso.serGolpeadoPor(this, this.material, this.fuerza);
    }

}
