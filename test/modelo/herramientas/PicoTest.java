package modelo.herramientas;

import modelo.recursos.*;

import org.junit.Test;
import static org.junit.Assert.*;


public class PicoTest {

    // Tests para material madera:
    @Test
    public void test01PicoDeMaderaSeCreaConDurabilidad100() {
        Herramienta picoDeMadera = FabricaHerramientas.crearPicoDeMadera();  

        assertEquals(100, picoDeMadera.getDurabilidad(),0.0001);
    }

    @Test
    public void test02PicoDeMaderaSeCreaConFuerza2() {
        Herramienta picoDeMadera = FabricaHerramientas.crearPicoDeMadera();  
        assertEquals(2, picoDeMadera.getFuerza(),0.0001);
    }

    @Test
    public void test03PicoDeMaderaSeDesgastaEnSuFuerzaContraCualquierMaterial() {
        Herramienta picoDeMadera = FabricaHerramientas.crearPicoDeMadera();  
        float fuerza = picoDeMadera.getFuerza();
        float durabilidadInicial = picoDeMadera.getDurabilidad();
        picoDeMadera.golpear(new BloqueMadera());
        assertEquals(durabilidadInicial-fuerza, picoDeMadera.getDurabilidad(),0.0001);
    }

    // Tests para material piedra:
    @Test
    public void test01PicoDePiedraSeCreaConDurabilidad200() {
        Herramienta picoDePiedra = FabricaHerramientas.crearPicoDePiedra();  
        assertEquals(200, picoDePiedra.getDurabilidad(),0.0001);
    }

    @Test
    public void test02PicoDePiedraSeCreaConFuerza4() {
        Herramienta picoDePiedra = FabricaHerramientas.crearPicoDePiedra();  
        assertEquals(4, picoDePiedra.getFuerza(),0.0001);
    }

    @Test
    public void test03PicoDePiedraSeDesgastaEnSuFuerzaSobreTresMediosContraCualquierMaterial() {
        Herramienta picoDePiedra = FabricaHerramientas.crearPicoDePiedra();  
        float fuerza = picoDePiedra.getFuerza();
        float durabilidadInicial = picoDePiedra.getDurabilidad();
        picoDePiedra.golpear(new BloqueMadera());
        assertEquals(durabilidadInicial-(float)(fuerza/1.5), picoDePiedra.getDurabilidad(),0.0001);

    }

    // Tests para material metal:
    @Test
    public void test01PicoDeMetalSeCreaConDurabilidad400() {
        Herramienta picoDeMetal = FabricaHerramientas.crearPicoDeMetal();  
        assertEquals(400, picoDeMetal.getDurabilidad(),0.0001);
    }

    @Test
    public void test02PicoDeMetalSeCreaConFuerza12() {
        Herramienta picoDeMetal = FabricaHerramientas.crearPicoDeMetal();  
        assertEquals(12, picoDeMetal.getFuerza(),0.0001);
    }

    @Test
    public void test03PicoDeMetalNoSeDesgasta() {
        Herramienta picoDeMetal = FabricaHerramientas.crearPicoDeMetal();  
        float durabilidadInicial = picoDeMetal.getDurabilidad();
        picoDeMetal.golpear(new BloqueMadera());
        assertEquals(durabilidadInicial, picoDeMetal.getDurabilidad(),0.0001);
    }

    @Test
    public void test04PicoDeMetalSeRompeAlDecimoGolpeContraCualquierMaterial() {
        Herramienta picoDeMetal = FabricaHerramientas.crearPicoDeMetal();  
        for(int i =0; i <= 9; i++){
            picoDeMetal.golpear(new BloqueMadera());
        }
        assertEquals(0, picoDeMetal.getDurabilidad(),0.0001);
    }

    //Test de id
    @Test
    public void test01CrearPicoDeMaderaIDEs13(){
        Herramienta pico = FabricaHerramientas.crearPicoDeMadera();
        assertEquals(13,pico.getId());
    }

    @Test
    public void test01CrearPicoDePiedraIDEs14(){
        Herramienta pico = FabricaHerramientas.crearPicoDePiedra();
        assertEquals(14,pico.getId());
    }

    @Test
    public void test01CrearPicoDeMetalIDEs15(){
        Herramienta pico = FabricaHerramientas.crearPicoDeMetal();
        assertEquals(15,pico.getId());
    }

    //Tests de imagen

    @Test
    public void test01PicoMaderaDevuelveSuImagen(){
        Herramienta pico = FabricaHerramientas.crearPicoDeMadera();
        assertEquals("picoMadera",pico.obtenerImagen());
    }

    @Test
    public void test02PicoPiedraDevuelveSuImagen(){
        Herramienta pico = FabricaHerramientas.crearPicoDePiedra();
        assertEquals("picoPiedra",pico.obtenerImagen());
    }

    @Test
    public void test03PicoMetalDevuelveSuImagen(){
        Herramienta pico = FabricaHerramientas.crearPicoDeMetal();
        assertEquals("picoMetal",pico.obtenerImagen());
    }
}