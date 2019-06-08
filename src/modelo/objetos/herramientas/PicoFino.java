package modelo.objetos.herramientas;

import modelo.objetos.herramientas.durabilidades.*;
import modelo.objetos.materiales.PiedraYMetal;
import modelo.recursos.*;

public class PicoFino extends Herramienta {

    public PicoFino(){
        this.durabilidad = new DurabilidadDiezPorciento();
        this.durabilidad.setDurabilidad(1000);
        this.fuerza = 20;
        this.material = new PiedraYMetal();
    }

    public void golpear(Recurso recurso){
        recurso.serGolpeadoPor(this, this.material, this.fuerza);
    }
}
