package modelo.mapa;

import modelo.Juego;
import modelo.jugador.Jugador;
import modelo.recursos.BloqueMadera;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class MapaTest {

    @Test
    public void test01InicializarMapa10x10DimensionXEsCorrecta(){
        Mapa mapa = new Mapa(10,10);
        assertEquals(mapa.getXMax(),10);
    }

    @Test
    public void test02InicializarMapa10x10DimensionYEsCorrecta(){
        Mapa mapa = new Mapa(10,10);
        assertEquals(mapa.getYMax(),10);
    }

    @Test
    public void test03InicializarMapa10x10CeldaCentralEsCorrecta(){
        Mapa mapa = new Mapa(10,10);
        Posicion posicionCeldaCentral = mapa.getCeldaCentral().getPosicion();
        assertTrue((posicionCeldaCentral.getX() == 5) && (posicionCeldaCentral.getY() == 5));
    }

    @Test
    public void test04InicializarMapaUbicarBloqueMaderaEnCeldaCentral(){
        Mapa mapa = new Mapa(10,10);
        BloqueMadera bloque = new BloqueMadera();
        mapa.ubicarEnElCentro(bloque);
        assertSame(mapa.getCeldaCentral().getOcupante(),bloque);
    }

    @Test
    public void test05ObtenerOcupanteDeCeldaCentralDevuelveJugador(){
        Juego juego = Juego.getJuego();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();

        assertEquals(jugador, mapa.obtenerOcupanteEn(jugador.getPosicion()));
    }


}
