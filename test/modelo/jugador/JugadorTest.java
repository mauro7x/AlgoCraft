package modelo.jugador;

import modelo.Juego;
import modelo.mapa.Celda;
import modelo.mapa.CeldaVacia;
import modelo.mapa.Mapa;
import modelo.mapa.OcupanteDeCelda;
import modelo.objetos.herramientas.Hacha;
import modelo.objetos.herramientas.Herramienta;
import modelo.objetos.materiales.Madera;
import modelo.recursos.BloqueMadera;
import org.junit.Test;
import static org.junit.Assert.*;


public class JugadorTest {
    //Tests de inicializacion del jugador

    @Test
    public void test01InicializarJugadorCoordenadaXCentral(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Celda celdaCentral = mapa.getCeldaCentral();
        assertEquals(celdaCentral.getX(),jugador.getX());

    }

    @Test
    public void test02InicializarJugadorCoordenadaYCentral(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Celda celdaCentral = mapa.getCeldaCentral();
        assertEquals(celdaCentral.getY(),jugador.getY());
    }

    @Test
    public void test03InicializarJugadorOrientacionEsArriba(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        assertEquals(0,jugador.getOrientacion());
    }

    @Test
    public void test04SeMueveCorrectamenteArribaDondeHayCeldaVacia(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        int posXInicial = jugador.getX();
        int posYInicial = jugador.getY();
        mapa.setearOcupanteEn(new CeldaVacia(), posXInicial, posYInicial+1);
        jugador.moverArriba();
        assertEquals(posXInicial, jugador.getX());
        assertEquals(posYInicial+1, jugador.getY());
    }

    @Test
    public void test05SeMueveCorrectamenteAbajoDondeHayCeldaVacia(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        int posXInicial = jugador.getX();
        int posYInicial = jugador.getY();
        mapa.setearOcupanteEn(new CeldaVacia(), posXInicial, posYInicial-1);
        jugador.moverAbajo();
        assertEquals(posXInicial, jugador.getX());
        assertEquals(posYInicial-1, jugador.getY());
    }

    @Test
    public void test06SeMueveCorrectamenteADerechaDondeHayCeldaVacia(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        int posXInicial = jugador.getX();
        int posYInicial = jugador.getY();
        mapa.setearOcupanteEn(new CeldaVacia(), posXInicial+1, posYInicial);
        jugador.moverDerecha();
        assertEquals(posXInicial+1, jugador.getX());
        assertEquals(posYInicial, jugador.getY());
    }

    @Test
    public void test07SeMueveCorrectamenteAIzquierdaDondeHayCeldaVacia(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        int posXInicial = jugador.getX();
        int posYInicial = jugador.getY();
        mapa.setearOcupanteEn(new CeldaVacia(), posXInicial-1, posYInicial);
        jugador.moverIzquierda();
        assertEquals(posXInicial-1, jugador.getX());
        assertEquals(posYInicial, jugador.getY());
    }

    @Test
    public void test08NoSeMueveArribaDondeHayCeldaOcupada(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        int posXInicial = jugador.getX();
        int posYInicial = jugador.getY();
        mapa.setearOcupanteEn(new BloqueMadera(), posXInicial, posYInicial+1);
        jugador.moverArriba();
        assertEquals(posXInicial, jugador.getX());
        assertEquals(posYInicial, jugador.getY());
    }

    @Test
    public void test09NoSeMueveAbajoDondeHayCeldaOcupada(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        int posXInicial = jugador.getX();
        int posYInicial = jugador.getY();
        mapa.setearOcupanteEn(new BloqueMadera(), posXInicial, posYInicial-1);
        jugador.moverAbajo();
        assertEquals(posXInicial, jugador.getX());
        assertEquals(posYInicial, jugador.getY());
    }

    @Test
    public void test10NoSeMueveADerechaDondeHayCeldaOcupada(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        int posXInicial = jugador.getX();
        int posYInicial = jugador.getY();
        mapa.setearOcupanteEn(new BloqueMadera(), posXInicial+1, posYInicial);
        jugador.moverDerecha();
        assertEquals(posXInicial, jugador.getX());
        assertEquals(posYInicial, jugador.getY());
    }

    @Test
    public void test11NoSeMueveAIzquierdaDondeHayCeldaOcupada(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        int posXInicial = jugador.getX();
        int posYInicial = jugador.getY();
        mapa.setearOcupanteEn(new BloqueMadera(), posXInicial-1, posYInicial);
        jugador.moverIzquierda();
        assertEquals(posXInicial, jugador.getX());
        assertEquals(posYInicial, jugador.getY());
    }

    @Test
    public void test12SiSeMueveArribaLaMismaCantidadDeCeldasQueTieneElMapaTerminaEnElOrigen(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        int posXInicial = jugador.getX();
        int posYInicial = jugador.getY();
        int celdasAltura = mapa.getYMax();

        for (int i = 0; i<celdasAltura; i++){
            mapa.setearOcupanteEn(new CeldaVacia(), posXInicial, i);
        }
        mapa.ubicarEnElCentro(jugador);

        for (int i = 0; i<celdasAltura; i++){
            jugador.moverArriba();
        }

        assertEquals(posXInicial, jugador.getX());
        assertEquals(posYInicial, jugador.getY());

    }

    @Test
    public void test13SiSeMueveADerechaLaMismaCantidadDeCeldasQueTieneElMapaTerminaEnElOrigen(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        int posXInicial = jugador.getX();
        int posYInicial = jugador.getY();
        int celdasAnchura = mapa.getXMax();

        for (int i = 0; i<celdasAnchura; i++){
            mapa.setearOcupanteEn(new CeldaVacia(), i, posYInicial);
        }
        mapa.ubicarEnElCentro(jugador);

        for (int i = 0; i<celdasAnchura; i++){
            jugador.moverDerecha();
        }

        assertEquals(posXInicial, jugador.getX());
        assertEquals(posYInicial, jugador.getY());

    }

    @Test
    public void test14SiSeLePideOcuparSuCasillaSeDebeDevolverASiMismo(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();

        OcupanteDeCelda nuevo = jugador.ocuparPorOcupanteDe(mapa.getCeldaCentral());
        assertSame(nuevo, jugador);

    }
}
