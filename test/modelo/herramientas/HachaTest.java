package modelo.herramientas;

import modelo.recursos.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class HachaTest {

    // Tests para material madera:
    @Test
    public void test01HachaDeMaderaSeCreaConDurabilidad100() {
        Herramienta hachaDeMadera = FabricaHerramientas.crearHachaDeMadera(); 
        assertEquals(100, hachaDeMadera.getDurabilidad(),0.0001);
    }

    @Test
    public void test02HachaDeMaderaSeCreaConFuerza2() {
        Herramienta hachaDeMadera = FabricaHerramientas.crearHachaDeMadera(); 
        assertEquals(2, hachaDeMadera.getFuerza(),0.0001);
    }

    @Test
    public void test03HachaDeMaderaSeDesgastaEnSuFuerzaContraCualquierMaterial() {
        Herramienta hachaDeMadera = FabricaHerramientas.crearHachaDeMadera(); 
        float fuerza = hachaDeMadera.getFuerza();
        float durabilidadInicial = hachaDeMadera.getDurabilidad();
        hachaDeMadera.golpear(new BloqueMadera());
        assertEquals(durabilidadInicial-fuerza, hachaDeMadera.getDurabilidad(),0.0001);
    }

    // Tests para material piedra:
    @Test
    public void test01HachaDePiedraSeCreaConDurabilidad200() {
        Herramienta hachaDePiedra = FabricaHerramientas.crearHachaDePiedra(); 
        assertEquals(200, hachaDePiedra.getDurabilidad(),0.0001);
    }

    @Test
    public void test02HachaDePiedraSeCreaConFuerza5() {
        Herramienta hachaDePiedra = FabricaHerramientas.crearHachaDePiedra(); 
        assertEquals(5, hachaDePiedra.getFuerza(),0.0001);
    }

    @Test
    public void test03HachaDePiedraSeDesgastaEnSuFuerzaContraCualquierMaterial() {
        Herramienta hachaDePiedra = FabricaHerramientas.crearHachaDePiedra(); 
        float fuerza = hachaDePiedra.getFuerza();
        float durabilidadInicial = hachaDePiedra.getDurabilidad();
        hachaDePiedra.golpear(new BloqueMadera());
        assertEquals(durabilidadInicial-fuerza, hachaDePiedra.getDurabilidad(),0.0001);
    }

    // Tests para material metal:
    @Test
    public void test01HachaDeMetalSeCreaConDurabilidad400() {
        Herramienta hachaDeMetal = FabricaHerramientas.crearHachaDeMetal(); 
        assertEquals(400, hachaDeMetal.getDurabilidad(),0.0001);
    }

    @Test
    public void test02HachaDeMetalSeCreaConFuerza10() {
        Herramienta hachaDeMetal = FabricaHerramientas.crearHachaDeMetal(); 
        assertEquals(10, hachaDeMetal.getFuerza(),0.0001);
    }

    @Test
    public void test03HachaDeMetalSeDesgastaEnLaMitadDeSuFuerzaContraCualquierMaterial() {
        Herramienta hachaDeMetal = FabricaHerramientas.crearHachaDeMetal(); 
        float fuerza = hachaDeMetal.getFuerza();
        float durabilidadInicial = hachaDeMetal.getDurabilidad();
        hachaDeMetal.golpear(new BloqueMadera());
        assertEquals(durabilidadInicial-(fuerza/2), hachaDeMetal.getDurabilidad(),0.0001);
    }

    //Test de id
    @Test
    public void test01CrearHachaMaderaIDEs10(){
        Herramienta hacha = FabricaHerramientas.crearHachaDeMadera();
        assertEquals(10,hacha.getId());
    }

    @Test
    public void test02CrearHachaPiedraIDEs11(){
        Herramienta hacha = FabricaHerramientas.crearHachaDePiedra();
        assertEquals(11,hacha.getId());
    }

    @Test
    public void test03CrearHachaMetalIDEs12(){
        Herramienta hacha = FabricaHerramientas.crearHachaDeMetal();
        assertEquals(12,hacha.getId());
    }

    //Tests de imagen

    @Test
    public void test01HachaMaderaDevuelveSuImagen(){
        Herramienta hacha = FabricaHerramientas.crearHachaDeMadera();
        assertEquals("hachaMadera",hacha.obtenerImagen());
    }

    @Test
    public void test02HachaPiedraDevuelveSuImagen(){
        Herramienta hacha = FabricaHerramientas.crearHachaDePiedra();
        assertEquals("hachaPiedra",hacha.obtenerImagen());
    }

    @Test
    public void test03HachaMetalDevuelveSuImagen(){
        Herramienta hacha = FabricaHerramientas.crearHachaDeMetal();
        assertEquals("hachaMetal",hacha.obtenerImagen());
    }
}