package modelo.objetos.herramientas;

import modelo.objetos.herramientas.desgastes.*;
import modelo.objetos.materiales.PiedraYMetal;
import modelo.recursos.*;

public class PicoFino extends Herramienta {

    public PicoFino(){
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.desgaste = new DesgasteDiezPorciento();
        this.material = new PiedraYMetal();
    }

    public void golpear(Recurso recurso){
        recurso.serGolpeadoPorPicoFino(this, this.material, this.fuerza);
    }
}
