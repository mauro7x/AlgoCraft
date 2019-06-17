package modelo.herramientas;

import modelo.herramientas.durabilidades.DurabilidadDiezPorciento;
import modelo.herramientas.reglas.ReglasEstandarPicoFino;
import modelo.recursos.*;


public class PicoFino extends Herramienta {

    public PicoFino(){}

    static Herramienta deMetalYPiedra(){
        Herramienta picoFino = new PicoFino();
        picoFino.durabilidad = new DurabilidadDiezPorciento();
        picoFino.durabilidad.setDurabilidad(1000);
        picoFino.fuerza = 20;
        picoFino.reglasDeDesgaste = new ReglasEstandarPicoFino();
        picoFino.id = 16;
        return picoFino;
    }

    @Override
    public void golpear(BloqueMadera madera) {
        reglasDeDesgaste.gastar(madera, fuerza);
    }

    @Override
    public void golpear(BloquePiedra piedra) {
        reglasDeDesgaste.gastar(piedra, fuerza);
    }

    @Override
    public void golpear(BloqueMetal metal) {
        reglasDeDesgaste.gastar(metal, fuerza);
    }

    @Override
    public void golpear(BloqueDiamante diamante) {
        gastar();
        reglasDeDesgaste.gastar(diamante, fuerza);
    }

}
