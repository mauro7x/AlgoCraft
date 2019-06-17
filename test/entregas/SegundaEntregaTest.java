package entregas;

import modelo.Constructor;

import modelo.Juego;

import org.junit.Test;

import static org.junit.Assert.*;


public class SegundaEntregaTest {

    //Pruebas de Construccion de herramienta
    @Test
    public void test01HachaDeMaderaSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaHachaMadera = { 1,1,0,1,1,0,0,1,0 };
        int resultadoConstruccion = constructor.construir(recetaHachaMadera);
        assertEquals(10,resultadoConstruccion);
    }

    @Test
    public void test02HachaDePiedraSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();
        int[] recetaHachaPiedra = { 2,2,0,2,1,0,0,1,0 };
        int resultadoConstruccion = constructor.construir(recetaHachaPiedra);
        assertEquals(11,resultadoConstruccion);
    }

    @Test
    public void test03HachaDeMetalSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaHachaMetal = { 3,3,0,3,1,0,0,1,0 };

        int resultadoConstruccion = constructor.construir(recetaHachaMetal);
        assertEquals(12,resultadoConstruccion);
    }

    @Test
    public void test04PicoDeMaderaSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaPicoMadera = { 1,1,1,0,1,0,0,1,0 };

        int resultadoConstruccion = constructor.construir(recetaPicoMadera);
        assertEquals(13,resultadoConstruccion);
    }

    @Test
    public void test05PicoDePiedraSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaPicoPiedra = { 2,2,2,0,1,0,0,1,0 };

        int resultadoConstruccion = constructor.construir(recetaPicoPiedra);
        assertEquals(14,resultadoConstruccion);
    }

    @Test
    public void test06PicoDeMetalSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaPicoMetal = { 3,3,3,0,1,0,0,1,0};

        int resultadoConstruccion = constructor.construir(recetaPicoMetal);
        assertEquals(15,resultadoConstruccion);
    }

    @Test
    public void test07PicoFinoSeConstruyeDeLaFormaCorrecta(){
        Juego juego = Juego.getJuego();
        Constructor constructor = juego.getConstructor();

        int[] recetaPicoFino = {3,3,3,2,1,0,0,1,0};

        int resultadoConstruccion = constructor.construir(recetaPicoFino);
        assertEquals(16,resultadoConstruccion);
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
