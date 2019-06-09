package modelo.jugador;

import modelo.objetos.GuardableEnInventario;
import modelo.objetos.SlotVacio;
import modelo.objetos.herramientas.Hacha;
import modelo.objetos.herramientas.Pico;
import modelo.objetos.herramientas.PicoFino;
import modelo.objetos.materiales.Madera;
import modelo.objetos.materiales.Metal;
import modelo.objetos.materiales.Piedra;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.function.Supplier;

public class Constructor {

    private HashMap<Integer, Supplier<GuardableEnInventario>> recetas;

    public Constructor(){
        recetas = new HashMap<>();
        //Hachas
        int[] hachaMadera = {1,1,0,1,1,0,0,1,0}; //Disposicion de los materiales para un hacha de madera.
        int[] hachaPiedra = {2,2,0,2,1,0,0,1,0}; //Disposicion de los materiales para un hacha de piedra.
        int[] hachaMetal = {3,3,0,3,1,0,0,1,0}; //Disposicion de los materiales para un hacha de piedra.

        //Picos
        int[] picoMadera = {1,1,1,0,1,0,0,1,0};
        int[] picoPiedra = {2,2,2,0,1,0,0,1,0};
        int[] picoMetal = {3,3,3,0,1,0,0,1,0};

        //Pico Fino
        int[] picoFino = {3,3,3,2,1,0,0,1,0};

        recetas.put(Arrays.hashCode(hachaMadera), () -> new Hacha(new Madera()));
        recetas.put(Arrays.hashCode(hachaPiedra), () -> new Hacha(new Piedra()));
        recetas.put(Arrays.hashCode(hachaMetal), () -> new Hacha(new Metal()));

        recetas.put(Arrays.hashCode(picoMadera), () -> new Pico(new Madera()));
        recetas.put(Arrays.hashCode(picoPiedra), () -> new Pico(new Piedra()));
        recetas.put(Arrays.hashCode(picoMetal), () -> new Pico(new Metal()));

        recetas.put(Arrays.hashCode(picoFino), () -> new PicoFino(new Piedra(),new Metal()));
    }

    public GuardableEnInventario construir(GuardableEnInventario[] receta){
        int[] recetaParseada = new int[receta.length];

        for(int i = 0;i<receta.length;i++){
            recetaParseada[i] = receta[i].getId();
        }

        GuardableEnInventario herramientaConstruida = recetas.get(Arrays.hashCode(recetaParseada)).get();

        if (herramientaConstruida != null){
            return herramientaConstruida;
        }
        return new SlotVacio();
    }

}
