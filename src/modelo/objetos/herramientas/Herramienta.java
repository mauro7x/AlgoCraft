package modelo.objetos.herramientas;

import modelo.objetos.GuardableEnInventario;
import modelo.objetos.herramientas.reglas.*;
import modelo.objetos.herramientas.durabilidades.*;
import modelo.recursos.*;

public abstract class Herramienta implements GuardableEnInventario {

    protected Durabilidad durabilidad;
    protected float fuerza;
    protected ReglasDesgasteRecurso reglasDeDesgaste;


    public float getDurabilidad() {
        return (this.durabilidad.getDurabilidad());
    }
    public float getFuerza() {
        return fuerza;
    }

    public void gastar(){
        this.durabilidad.gastar(this.fuerza);
    }

    public void golpear(Recurso recurso){
        recurso.serGolpeadoPor(this);
    }

    public void golpear(BloqueMadera madera){
        gastar();
        reglasDeDesgaste.gastar(madera, fuerza);
    }
    public void golpear(BloquePiedra piedra){
        gastar();
        reglasDeDesgaste.gastar(piedra, fuerza);
    }
    public void golpear(BloqueMetal metal){
        gastar();
        reglasDeDesgaste.gastar(metal, fuerza);
    }
    public void golpear(BloqueDiamante diamante){
        gastar();
        reglasDeDesgaste.gastar(diamante, fuerza);
    }
}
