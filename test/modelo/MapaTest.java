package modelo;

import modelo.mapa.Mapa;
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
        int xCentral = mapa.getCeldaCentral().getX();
        int yCentral = mapa.getCeldaCentral().getY();
        assertTrue((xCentral == 5) && (yCentral == 5));
    }

    @Test
    public void test04InicializarMapaUbicarBloqueMaderaEnCeldaCentral(){
        Mapa mapa = new Mapa(10,10);
        BloqueMadera bloque = new BloqueMadera();
        mapa.ubicarEnElCentro(bloque);
        assertSame(mapa.getCeldaCentral().getOcupante(),bloque);
    }

}
