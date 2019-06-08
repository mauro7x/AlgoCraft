package modelo.objetos.herramientas;

import modelo.objetos.herramientas.durabilidades.*;
import modelo.objetos.materiales.*;
import modelo.recursos.Recurso;

public class Hacha extends Herramienta {

    public Hacha(Madera madera){
        this.durabilidad = new DurabilidadEnFuerza(1);
        this.durabilidad.setDurabilidad(100);
        this.fuerza = 2;
        this.material = madera;
    }

    public Hacha(Piedra piedra){
        this.durabilidad = new DurabilidadEnFuerza(1);
        this.durabilidad.setDurabilidad(200);
        this.fuerza = 5;
        this.material = piedra;
    }

    public Hacha(Metal metal){
        this.durabilidad = new DurabilidadEnFuerza(2);
        this.durabilidad.setDurabilidad(400);
        this.fuerza = 10;
        this.material = metal;
    }

    public void golpear(Recurso recurso){
        recurso.serGolpeadoPor(this);
    }

}
