package modelo.jugador;

import modelo.Juego;
import modelo.mapa.*;
import modelo.recursos.BloqueMadera;
import modelo.recursos.Recurso;
import org.junit.Test;
import static org.junit.Assert.*;


public class JugadorTest {
    //Tests de inicializacion del jugador

    @Test
    public void test01InicializarJugadorPosicionCentral(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Celda celdaCentral = mapa.getCeldaCentral();
        assertEquals(jugador.getPosicion(), celdaCentral.getPosicion());

    }

    @Test
    public void test03InicializarJugadorOrientacionEsArriba(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        assertTrue(jugador.getOrientacion() instanceof  OrientacionArriba);
    }

    @Test
    public void test04SeMueveCorrectamenteArribaDondeHayCeldaVacia(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Posicion posicionInicialJugador = jugador.getPosicion();
        
        mapa.setearOcupanteEn(new CeldaVacia(), posicionInicialJugador.getPosicionArriba());
        jugador.moverArriba();
        
        assertEquals(posicionInicialJugador.getPosicionArriba(), jugador.getPosicion());
    }

    @Test
    public void test05SeMueveCorrectamenteAbajoDondeHayCeldaVacia(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Posicion posicionInicialJugador = jugador.getPosicion();

        mapa.setearOcupanteEn(new CeldaVacia(), posicionInicialJugador.getPosicionAbajo());
        jugador.moverAbajo();

        assertEquals(posicionInicialJugador.getPosicionAbajo(), jugador.getPosicion());
    }

    @Test
    public void test06SeMueveCorrectamenteADerechaDondeHayCeldaVacia(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Posicion posicionInicialJugador = jugador.getPosicion();

        mapa.setearOcupanteEn(new CeldaVacia(), posicionInicialJugador.getPosicionDerecha());
        jugador.moverDerecha();

        assertEquals(posicionInicialJugador.getPosicionDerecha(), jugador.getPosicion());
    }

    @Test
    public void test07SeMueveCorrectamenteAIzquierdaDondeHayCeldaVacia(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Posicion posicionInicialJugador = jugador.getPosicion();

        mapa.setearOcupanteEn(new CeldaVacia(), jugador.getPosicion().getPosicionIzquierda());
        jugador.moverIzquierda();

        assertEquals(posicionInicialJugador.getPosicionIzquierda(), jugador.getPosicion());
    }

    @Test
    public void test08NoSeMueveArribaDondeHayCeldaOcupada(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();

        Posicion posicionInicialJugador = jugador.getPosicion();
        mapa.setearOcupanteEn(new BloqueMadera(), posicionInicialJugador.getPosicionArriba());
        jugador.moverArriba();

        assertEquals(posicionInicialJugador, jugador.getPosicion());
    }

    @Test
    public void test09NoSeMueveAbajoDondeHayCeldaOcupada(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();

        Posicion posicionInicialJugador = jugador.getPosicion();
        mapa.setearOcupanteEn(new BloqueMadera(), posicionInicialJugador.getPosicionAbajo());
        jugador.moverAbajo();

        assertEquals(posicionInicialJugador, jugador.getPosicion());
    }

    @Test
    public void test10NoSeMueveADerechaDondeHayCeldaOcupada(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Posicion posicionInicialJugador = jugador.getPosicion();

        mapa.setearOcupanteEn(new BloqueMadera(), posicionInicialJugador.getPosicionDerecha());
        jugador.moverDerecha();

        assertEquals(posicionInicialJugador, jugador.getPosicion());
    }

    @Test
    public void test11NoSeMueveAIzquierdaDondeHayCeldaOcupada(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Posicion posicionInicialJugador = jugador.getPosicion();

        mapa.setearOcupanteEn(new BloqueMadera(), posicionInicialJugador.getPosicionIzquierda());
        jugador.moverIzquierda();

        assertEquals(posicionInicialJugador, jugador.getPosicion());
    }

    @Test
    public void test12SiSeMueveArribaLaMismaCantidadDeCeldasQueTieneElMapaTerminaEnElOrigen(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Posicion posicionInicialJugador = jugador.getPosicion();
        int celdasAltura = mapa.getYMax();
        Posicion posicionAuxiliar = posicionInicialJugador;
        for (int i = 0; i<celdasAltura; i++){
            posicionAuxiliar = posicionAuxiliar.getPosicionArriba();
            mapa.setearOcupanteEn(new CeldaVacia(), posicionAuxiliar);
        }
        mapa.ubicarEnElCentro(jugador);

        for (int i = 0; i<celdasAltura; i++){
            jugador.moverArriba();
        }

        assertEquals(posicionInicialJugador, jugador.getPosicion());

    }

    @Test
    public void test13SiSeMueveADerechaLaMismaCantidadDeCeldasQueTieneElMapaTerminaEnElOrigen(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Posicion posicionInicialJugador = jugador.getPosicion();
        int celdasAnchura = mapa.getXMax();
        Posicion posicionAuxiliar = posicionInicialJugador;

        for (int i = 0; i<celdasAnchura; i++){
            posicionAuxiliar = posicionAuxiliar.getPosicionDerecha();
            mapa.setearOcupanteEn(new CeldaVacia(), posicionAuxiliar);
        }
        mapa.ubicarEnElCentro(jugador);

        for (int i = 0; i<celdasAnchura; i++){
            jugador.moverDerecha();
        }

        assertEquals(posicionInicialJugador, jugador.getPosicion());
    }

    @Test
    public void test14SiSeLePideOcuparSuCasillaSeDebeDevolverASiMismo(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();

        OcupanteDeCelda nuevo = jugador.ocuparPorOcupanteDe(mapa.getCeldaCentral());
        assertEquals(nuevo, jugador);
    }

    @Test
    public void test15GolpearBloqueMaderaPosicionadoDebajoLoDesgasta(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Recurso madera = new BloqueMadera();
        float durabilidadMaderaOriginal = madera.getDurabilidad();
        jugador.moverAbajo();
        mapa.setearOcupanteEn(madera, jugador.getPosicion().getPosicionAbajo());
        jugador.golpear();

        assertEquals(durabilidadMaderaOriginal-2,madera.getDurabilidad(),0.001);
    }

    @Test
    public void test16GolpearBloqueMaderaPosicionadoArribaLoDesgasta(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Recurso madera = new BloqueMadera();
        float durabilidadMaderaOriginal = madera.getDurabilidad();
        jugador.moverArriba();
        mapa.setearOcupanteEn(madera, jugador.getPosicion().getPosicionArriba());
        jugador.golpear();

        assertEquals(durabilidadMaderaOriginal-2,madera.getDurabilidad(),0.001);
    }

    @Test
    public void test17GolpearBloqueMaderaPosicionadoDerechaLoDesgasta(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Recurso madera = new BloqueMadera();
        float durabilidadMaderaOriginal = madera.getDurabilidad();
        jugador.moverDerecha();
        mapa.setearOcupanteEn(madera,jugador.getPosicion().getPosicionDerecha());
        jugador.golpear();

        assertEquals(durabilidadMaderaOriginal-2,madera.getDurabilidad(),0.001);
    }

    @Test
    public void test18GolpearBloqueMaderaPosicionadoIzquierdaLoDesgasta(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Recurso madera = new BloqueMadera();
        float durabilidadMaderaOriginal = madera.getDurabilidad();
        jugador.moverIzquierda();
        mapa.setearOcupanteEn(madera, jugador.getPosicion().getPosicionIzquierda());
        jugador.golpear();

        assertEquals(durabilidadMaderaOriginal-2,madera.getDurabilidad(),0.001);
    }
}
