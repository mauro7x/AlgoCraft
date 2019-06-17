package modelo.herramientas;

public class FabricaHerramientas {

    //Hachas

    static public Herramienta crearHachaDeMadera() {
        return Hacha.deMadera();
    }

    static public Herramienta crearHachaDePiedra() {
        return Hacha.dePiedra();
    }

    static public Herramienta crearHachaDeMetal() {
        return Hacha.deMetal();
    }

    //Picos

    static public Herramienta crearPicoDeMadera() {
        return Pico.deMadera();
    }

    static public Herramienta crearPicoDePiedra() {
        return Pico.dePiedra();
    }

    static public Herramienta crearPicoDeMetal() {
        return Pico.deMetal();
    }

    //PicoFino

    static public Herramienta crearPicoFino(){
        return PicoFino.deMetalYPiedra();
    }

}