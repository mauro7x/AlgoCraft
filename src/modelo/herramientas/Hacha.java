package modelo.herramientas;

import javafx.scene.image.Image;
import modelo.herramientas.durabilidades.DurabilidadEnFuerza;
import modelo.herramientas.reglas.ReglasEstandarHacha;
import modelo.recursos.*;


public class Hacha extends Herramienta {

    public Hacha(){}

    static Herramienta deMadera(){
        Herramienta hacha = new Hacha();
        hacha.durabilidad = new DurabilidadEnFuerza(1);
        hacha.durabilidad.setDurabilidad(100);
        hacha.fuerza = 2;
        hacha.reglasDeDesgaste = new ReglasEstandarHacha();
        hacha.id = 10;
        hacha.rutaImagen = "media/herramientas/hachaMadera.png";
        return hacha;
    }
    static Herramienta dePiedra(){
        Herramienta hacha = new Hacha();
        hacha.durabilidad = new DurabilidadEnFuerza(1);
        hacha.durabilidad.setDurabilidad(200);
        hacha.fuerza = 5;
        hacha.reglasDeDesgaste = new ReglasEstandarHacha();
        hacha.id = 11;
        hacha.rutaImagen = "media/herramientas/hachaPiedra.png";
        return hacha;
    }
    static Herramienta deMetal(){
        Herramienta hacha = new Hacha();
        hacha.durabilidad = new DurabilidadEnFuerza(2);
        hacha.durabilidad.setDurabilidad(400);
        hacha.fuerza = 10;
        hacha.reglasDeDesgaste = new ReglasEstandarHacha();
        hacha.id = 12;
        hacha.rutaImagen = "media/herramientas/hachaMetal.png";
        return hacha;
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
