package entregas;

import modelo.Constructor;

import modelo.Juego;
import modelo.objetos.GuardableEnInventario;
import modelo.objetos.SlotVacio;
import modelo.objetos.materiales.*;

import org.junit.Test;
import static org.junit.Assert.*;


public class SegundaEntregaTest {

    //Pruebas de Construccion de herramienta
    @Test
    public void test01HachaDeMaderaSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Constructor constructor = juego.getConstructor();

        GuardableEnInventario[] recetaHachaMadera = {
                new Madera(), new Madera(),new SlotVacio(),
                new Madera(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario hachaMadera = constructor.construir(recetaHachaMadera);
        assertEquals(10,hachaMadera.getId());
    }

    @Test
    public void test02HachaDePiedraSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Constructor constructor = juego.getConstructor();

        GuardableEnInventario[] recetaHachaPiedra = {
                new Piedra(), new Piedra(),new SlotVacio(),
                new Piedra(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario hachaPiedra = constructor.construir(recetaHachaPiedra);
        assertEquals(11,hachaPiedra.getId());
    }

    @Test
    public void test03HachaDeMetalSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Constructor constructor = juego.getConstructor();

        GuardableEnInventario[] recetaHachaMetal = {
                new Metal(), new Metal(),new SlotVacio(),
                new Metal(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario hachaMetal = constructor.construir(recetaHachaMetal);
        assertEquals(12,hachaMetal.getId());
    }

    @Test
    public void test04PicoDeMaderaSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Constructor constructor = juego.getConstructor();

        GuardableEnInventario[] recetaPicoMadera = {
                new Madera(), new Madera(),new Madera(),
                new SlotVacio(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario picoMadera = constructor.construir(recetaPicoMadera);
        assertEquals(13,picoMadera.getId());
    }

    @Test
    public void test05PicoDePiedraSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Constructor constructor = juego.getConstructor();

        GuardableEnInventario[] recetaPicoPiedra = {
                new Piedra(),new Piedra(),new Piedra(),
                new SlotVacio(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario picoPiedra = constructor.construir(recetaPicoPiedra);
        assertEquals(14,picoPiedra.getId());
    }

    @Test
    public void test06PicoDeMetalSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Constructor constructor = juego.getConstructor();

        GuardableEnInventario[] recetaPicoMetal = {
                new Metal(),new Metal(),new Metal(),
                new SlotVacio(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario picoMetal = constructor.construir(recetaPicoMetal);
        assertEquals(15,picoMetal.getId());
    }

    @Test
    public void test07PicoFinoSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Constructor constructor = juego.getConstructor();

        GuardableEnInventario[] recetaPicoFino = {
                new Metal(),new Metal(),new Metal(),
                new Piedra(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario picoFino = constructor.construir(recetaPicoFino);
        assertEquals(16,picoFino.getId());
    }

    //Pruebas de Jugador
    @Test
    public void test01JugadorSeInicializaDeLaFormaCorrectaEnElMapa(){
        
    }

    @Test
    public void test02JugadorPuedeMoverseParaTodasLasDireccionesVacias(){

    }

    //Pruebas de Mapa
    @Test
    public void test01SePuedeOcuparUnCasilleroVacioDelTerreno(){

    }

    @Test
    public void test02NoSePuedeOcuparUnCasilleroOcupadoDelTerreno(){

    }

    @Test
    public void test03MaterialOPersonajePuedenOcuparUnCasilleroVacioDelTerreno(){

    }

    //Pruebas de Juego
    @Test
    public void test01SeIniciaElJuegoConElTerrenoInicializadoYElJugadorInicializado(){

    }
}
