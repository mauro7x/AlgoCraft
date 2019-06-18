package modelo.jugador;

import modelo.Juego;
import modelo.herramientas.FabricaHerramientas;
import modelo.herramientas.Herramienta;
import modelo.herramientas.Pico;
import modelo.herramientas.PicoFino;
import modelo.mapa.*;
import modelo.recursos.BloqueDiamante;
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
    public void test02InicializarJugadorOrientacionEsArriba(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        assertTrue(jugador.getOrientacion() instanceof  OrientacionArriba);
    }

    @Test
    public void test03SeMueveCorrectamenteArribaDondeHayCeldaVacia(){
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
    public void test04SeMueveCorrectamenteAbajoDondeHayCeldaVacia(){
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
    public void test05SeMueveCorrectamenteADerechaDondeHayCeldaVacia(){
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
    public void test06SeMueveCorrectamenteAIzquierdaDondeHayCeldaVacia(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        Posicion posicionInicialJugador = jugador.getPosicion();

        mapa.setearOcupanteEn(new CeldaVacia(), posicionInicialJugador.getPosicionIzquierda());
        jugador.moverIzquierda();

        assertEquals(posicionInicialJugador.getPosicionIzquierda(), jugador.getPosicion());
    }

    @Test
    public void test07NoSeMueveArribaDondeHayCeldaOcupada(){
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
    public void test08NoSeMueveAbajoDondeHayCeldaOcupada(){
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
    public void test09NoSeMueveADerechaDondeHayCeldaOcupada(){
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
    public void test10NoSeMueveAIzquierdaDondeHayCeldaOcupada(){
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
    public void test11SiSeMueveArribaLaMismaCantidadDeCeldasQueTieneElMapaTerminaEnElOrigen(){
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
    public void test12SiSeMueveADerechaLaMismaCantidadDeCeldasQueTieneElMapaTerminaEnElOrigen(){
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
    public void test13SiSeLePideOcuparSuCasillaSeDebeDevolverASiMismo(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();

        OcupanteDeCelda nuevo = jugador.ocuparPorOcupanteDe(mapa.getCeldaCentral());
        assertEquals(nuevo, jugador);
    }

    @Test
    public void test14GolpearBloqueMaderaPosicionadoDebajoLoDesgasta(){
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
    public void test15GolpearBloqueMaderaPosicionadoArribaLoDesgasta(){
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
    public void test16GolpearBloqueMaderaPosicionadoDerechaLoDesgasta(){
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
    public void test17GolpearBloqueMaderaPosicionadoIzquierdaLoDesgasta(){
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

    @Test
    public void test18GolpearCeldaVaciaNoReduceDurabilidadHerramientaActiva(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();
        float durabilidadInicial = jugador.getHerramientaActual().getDurabilidad();

        jugador.moverIzquierda();
        mapa.setearOcupanteEn(new CeldaVacia(), jugador.getPosicion().getPosicionIzquierda());
        jugador.golpear();

        assertEquals(durabilidadInicial, jugador.getHerramientaActual().getDurabilidad(), 0.001);
    }


    @Test(expected = RuntimeException.class)
    public void test19JugadorEsGolpeadoYSeLanzaExcepcion(){
        Jugador jugador = Juego.getJuego().getJugador();
        jugador.serGolpeadoPor(FabricaHerramientas.crearHachaDeMadera());
    }

    @Test
    public void test20JugadorUtilizaHachaYSeRompe(){
        Juego juego = Juego.getJuego();
        juego.resetear();
        Jugador jugador = juego.getJugador(); //El jugador se inicializa con un hacha de madera.
        BloqueDiamante diamante = new BloqueDiamante();

        for(int i=0;i<50;i++){
            jugador.getHerramientaActual().golpear(diamante); //Se usa el hacha 50 veces hasta que se rompe.
        }

        assertTrue(jugador.noTieneHerramientas());
    }

    @Test
    public void test21JugadorPasaAHerramientaSiguienteYAnteriorCorrectamente(){
        Juego.getJuego().resetear();
        Jugador jugador = Juego.getJuego().getJugador();

        Herramienta hachaMadera = jugador.getHerramientaActual();
        Herramienta picoFino = FabricaHerramientas.crearPicoFino();
        Herramienta hachaMetal = FabricaHerramientas.crearHachaDeMetal();

        jugador.guardar(picoFino);
        jugador.guardar(hachaMetal);

        assertEquals(hachaMadera, jugador.getHerramientaActual());
        jugador.cambiarAHerramientaSiguiente();
        assertEquals(picoFino, jugador.getHerramientaActual());
        jugador.cambiarAHerramientaAnterior();
        assertEquals(hachaMadera, jugador.getHerramientaActual());
    }

    //Tests de imagenes

    @Test
    public void test01ImagenOrientacionArribaEsCorrecta(){
        Juego.getJuego().resetear();
        Jugador jugador = Juego.getJuego().getJugador();
        jugador.moverArriba();
        assertEquals("jugadorArriba.png", jugador.obtenerImagen());
    }

    @Test
    public void test02ImagenOrientacionAbajoEsCorrecta(){
        Juego.getJuego().resetear();
        Jugador jugador = Juego.getJuego().getJugador();
        jugador.moverAbajo();
        assertEquals("jugadorAbajo.png", jugador.obtenerImagen());
    }

    @Test
    public void test03ImagenOrientacionDerechaEsCorrecta(){
        Juego.getJuego().resetear();
        Jugador jugador = Juego.getJuego().getJugador();
        jugador.moverDerecha();
        assertEquals("jugadorDerecha.png", jugador.obtenerImagen());
    }

    @Test
    public void test04ImagenOrientacionIzquierdaEsCorrecta(){
        Juego.getJuego().resetear();
        Jugador jugador = Juego.getJuego().getJugador();
        jugador.moverIzquierda();
        assertEquals("jugadorIzquierda.png", jugador.obtenerImagen());
    }
}
