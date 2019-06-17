package modelo.mapa;

import javafx.geometry.Pos;
import org.junit.Test;

import static org.junit.Assert.*;

public class PosicionTest {

    @Test
    public void test01DosPosicionesConLasMismasCoordenadasSonIguales(){
        int x = 1;
        int y = 1;
        Posicion posicionA = new Posicion(x, y);
        Posicion posicionB = new Posicion(x, y);

        assertEquals(posicionA, posicionB);
    }

    @Test
    public void test02DosPosicionesConDistintasCoordenadasNoSonIguales(){
        int x = 1;
        int y = 1;
        Posicion posicionA = new Posicion(x, y);
        Posicion posicionB = new Posicion(x+1, y);

        assertNotSame(posicionA, posicionB);
    }

    @Test
    public void test03PosicionArribaDeUnaPosicionEsLaCorrecta(){
        int x = 5;
        int y = 5;
        Posicion posicion = new Posicion(x, y);

        assertEquals(new Posicion(x, y+1), posicion.getPosicionArriba());
    }

    @Test
    public void test04PosicionAbajoDeUnaPosicionEsLaCorrecta(){
        int x = 5;
        int y = 5;
        Posicion posicion = new Posicion(x, y);

        assertEquals(new Posicion(x, y-1), posicion.getPosicionAbajo());
    }

    @Test
    public void test05PosicionIzquierdaDeUnaPosicionEsLaCorrecta(){
        int x = 5;
        int y = 5;
        Posicion posicion = new Posicion(x, y);

        assertEquals(new Posicion(x-1, y), posicion.getPosicionIzquierda());
    }

    @Test
    public void test06PosicionDerechaDeUnaPosicionEsLaCorrecta(){
        int x = 5;
        int y = 5;
        Posicion posicion = new Posicion(x, y);

        assertEquals(new Posicion(x+1, y), posicion.getPosicionDerecha());
    }

}