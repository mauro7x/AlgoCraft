package modelo;

import modelo.herramientas.FabricaHerramientas;
import modelo.herramientas.Herramienta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Supplier;

public class Constructor {

    private HashMap<Integer, Supplier<Herramienta>> recetas;

    public Constructor(){
        recetas = new HashMap<>();
        //Hachas
        int[] hachaMadera = {1,1,0,1,1,0,0,1,0}; //Disposicion de los materiales para un hacha de madera.
        int[] hachaPiedra = {2,2,0,2,1,0,0,1,0}; //Disposicion de los materiales para un hacha de piedra.
        int[] hachaMetal = {3,3,0,3,1,0,0,1,0}; //Disposicion de los materiales para un hacha de metal.

        //Picos
        int[] picoMadera = {1,1,1,0,1,0,0,1,0}; //Disposicion de los materiales para un pico de madera.
        int[] picoPiedra = {2,2,2,0,1,0,0,1,0}; //Disposicion de los materiales para un pico de piedra.
        int[] picoMetal = {3,3,3,0,1,0,0,1,0}; //Disposicion de los materiales para un pico de metal.

        //Pico Fino
        int[] picoFino = {3,3,3,2,1,0,0,1,0}; //Disposicion de los materiales para un pico fino.

        recetas.put(Arrays.hashCode(hachaMadera), () -> FabricaHerramientas.crearHachaDeMadera());
        recetas.put(Arrays.hashCode(hachaPiedra), () -> FabricaHerramientas.crearHachaDePiedra());
        recetas.put(Arrays.hashCode(hachaMetal), () -> FabricaHerramientas.crearHachaDeMetal());

        recetas.put(Arrays.hashCode(picoMadera), () -> FabricaHerramientas.crearPicoDeMadera());
        recetas.put(Arrays.hashCode(picoPiedra), () -> FabricaHerramientas.crearPicoDePiedra());
        recetas.put(Arrays.hashCode(picoMetal), () -> FabricaHerramientas.crearPicoDeMetal());

        recetas.put(Arrays.hashCode(picoFino), () -> FabricaHerramientas.crearPicoFino());
    }

    public int construir(int[] receta){
        Herramienta construccion = recetas.getOrDefault(Arrays.hashCode(receta), () -> null).get();

        if (!(construccion == null)){
            Juego.getJuego().getJugador().guardar(construccion);
            return construccion.getId();
        }

        return 0;
    }

    public int comprobarReceta(int[] receta){
        Herramienta construccion = recetas.getOrDefault(Arrays.hashCode(receta), () -> null).get();
        if (!(construccion == null)){
            return construccion.getId();
        }
        return 0;
    }

}
