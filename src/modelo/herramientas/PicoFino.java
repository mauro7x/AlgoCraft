package modelo.herramientas;

import modelo.herramientas.desgastes.*;
import modelo.materiales.*;

public class PicoFino extends Herramienta {

    public PicoFino(){
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.desgaste = new DesgasteDiezPorciento();
    }

    public void usar(Madera madera){
        // no reduce durabilidad
    }

    public void usar(Piedra piedra){
        // no reduce durabilidad
    }

    public void usar(Metal metal){
        // no reduce durabilidad
    }
}
