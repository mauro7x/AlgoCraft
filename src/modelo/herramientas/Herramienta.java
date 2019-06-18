package modelo.herramientas;

import javafx.scene.image.Image;
import modelo.herramientas.durabilidades.Durabilidad;
import modelo.herramientas.reglas.ReglasDesgasteRecurso;
import modelo.mapa.OcupanteDeCelda;

import modelo.recursos.*;

public abstract class Herramienta {

    int id;
    protected Durabilidad durabilidad;
    protected float fuerza;
    ReglasDesgasteRecurso reglasDeDesgaste;
    String imagen;

    public float getDurabilidad() {
        return (this.durabilidad.getDurabilidad());
    }
    public float getFuerza() {
        return fuerza;
    }

    public void gastar(){
        this.durabilidad.gastar(this.fuerza);
    }

    public void golpear(OcupanteDeCelda recurso){
        recurso.serGolpeadoPor(this);
    }

    public abstract void golpear(BloqueMadera madera);
    public abstract void golpear(BloquePiedra piedra);
    public abstract void golpear(BloqueMetal metal);
    public abstract void golpear(BloqueDiamante diamante);

    public String obtenerImagen(){
        return imagen;
    }

    public int getId() {
        return this.id;
    }
}
