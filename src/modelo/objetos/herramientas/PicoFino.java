package modelo.objetos.herramientas;

import modelo.objetos.herramientas.durabilidades.*;
import modelo.objetos.herramientas.reglas.ReglasEstandarPicoFino;
import modelo.objetos.materiales.Piedra;
import modelo.objetos.materiales.Metal;
import modelo.recursos.*;


public class PicoFino extends Herramienta {
    private int id;

    public PicoFino(Piedra piedra, Metal metal){
        this.durabilidad = new DurabilidadDiezPorciento();
        this.durabilidad.setDurabilidad(1000);
        this.fuerza = 20;
        this.reglasDeDesgaste = new ReglasEstandarPicoFino();
        this.id = 16;
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

    @Override
    public int getId() {
        return this.id;
    }
}
