package modelo.objetos.herramientas;

import modelo.objetos.GuardableEnInventario;
import modelo.objetos.materiales.*;
import modelo.recursos.*;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class PicoTest {

    // Tests para material madera:
    @Test
    public void test01PicoDeMaderaSeCreaConDurabilidad100() {
        Pico picoDeMadera = new Pico(new Madera());

        assertEquals(100, picoDeMadera.getDurabilidad(),0.0001);
    }

    @Test
    public void test02PicoDeMaderaSeCreaConFuerza2() {
        Pico picoDeMadera = new Pico(new Madera());
        assertEquals(2, picoDeMadera.getFuerza(),0.0001);
    }

    @Test
    public void test03PicoDeMaderaSeDesgastaEnSuFuerzaContraCualquierMaterial() {
        Pico picoDeMadera = new Pico(new Madera());
        float fuerza = picoDeMadera.getFuerza();
        float durabilidadInicial = picoDeMadera.getDurabilidad();
        picoDeMadera.golpear(new BloqueMadera());
        assertEquals(durabilidadInicial-fuerza, picoDeMadera.getDurabilidad(),0.0001);
    }

    // Tests para material piedra:
    @Test
    public void test01PicoDePiedraSeCreaConDurabilidad200() {
        Pico picoDePiedra = new Pico(new Piedra());
        assertEquals(200, picoDePiedra.getDurabilidad(),0.0001);
    }

    @Test
    public void test02PicoDePiedraSeCreaConFuerza4() {
        Pico picoDePiedra = new Pico(new Piedra());
        assertEquals(4, picoDePiedra.getFuerza(),0.0001);
    }

    @Test
    public void test03PicoDePiedraSeDesgastaEnSuFuerzaSobreTresMediosContraCualquierMaterial() {
        Pico picoDePiedra = new Pico(new Piedra());
        float fuerza = picoDePiedra.getFuerza();
        float durabilidadInicial = picoDePiedra.getDurabilidad();
        picoDePiedra.golpear(new BloqueMadera());
        assertEquals(durabilidadInicial-(float)(fuerza/1.5), picoDePiedra.getDurabilidad(),0.0001);

    }

    // Tests para material metal:
    @Test
    public void test01PicoDeMetalSeCreaConDurabilidad400() {
        Pico picoDeMetal = new Pico(new Metal());
        assertEquals(400, picoDeMetal.getDurabilidad(),0.0001);
    }

    @Test
    public void test02PicoDeMetalSeCreaConFuerza12() {
        Pico picoDeMetal = new Pico(new Metal());
        assertEquals(12, picoDeMetal.getFuerza(),0.0001);
    }

    @Test
    public void test03PicoDeMetalNoSeDesgasta() {
        Pico picoDeMetal = new Pico(new Metal());
        float durabilidadInicial = picoDeMetal.getDurabilidad();
        picoDeMetal.golpear(new BloqueMadera());
        assertEquals(durabilidadInicial, picoDeMetal.getDurabilidad(),0.0001);
    }

    @Test
    public void test04PicoDeMetalSeRompeAlDecimoGolpeContraCualquierMaterial() {
        Pico picoDeMetal = new Pico(new Metal());
        for(int i =0; i <= 9; i++){
            picoDeMetal.golpear(new BloqueMadera());
        }
        assertEquals(0, picoDeMetal.getDurabilidad(),0.0001);
    }

    //Test de id
    @Test
    public void test01CrearPicoDeMaderaIDEs13(){
        GuardableEnInventario pico = new Pico(new Madera());
        assertEquals(13,pico.getId());
    }

    @Test
    public void test01CrearPicoDePiedraIDEs14(){
        GuardableEnInventario pico = new Pico(new Piedra());
        assertEquals(14,pico.getId());
    }

    @Test
    public void test01CrearPicoDeMetalIDEs15(){
        GuardableEnInventario pico = new Pico(new Metal());
        assertEquals(15,pico.getId());
    }
}