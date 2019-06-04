package modelo.objetos.materiales;

import modelo.recursos.*;

import org.junit.Test;
import static org.junit.Assert.*;



public class MaderaTest {

    static final float FUERZA_ARBITRARIA = 10;

    @Test
    public void test01MaderaGastaRecursoMaderaConHacha() {
        BloqueMadera recursoMadera = new BloqueMadera();
        Madera madera = new Madera();
        float durabilidadInicialRecurso = recursoMadera.getDurabilidad();

        madera.gastarMaderaConHacha(recursoMadera, FUERZA_ARBITRARIA);
        assertNotEquals(durabilidadInicialRecurso, recursoMadera.getDurabilidad(), 0.0001);
    }

    @Test
    public void test02MaderaGastaRecursoPiedraConPico() {
        BloquePiedra recursoPiedra = new BloquePiedra();
        Madera madera = new Madera();
        float durabilidadInicialRecurso = recursoPiedra.getDurabilidad();

        madera.gastarPiedraConPico(recursoPiedra, FUERZA_ARBITRARIA);
        assertNotEquals(durabilidadInicialRecurso, recursoPiedra.getDurabilidad(), 0.0001);
    }

    @Test
    public void test03MaderaNoGastaRecursoMetalConPico() {
        BloqueMetal recursoMetal = new BloqueMetal();
        Madera madera = new Madera();
        float durabilidadInicialRecurso = recursoMetal.getDurabilidad();

        madera.gastarMetalConPico(recursoMetal, FUERZA_ARBITRARIA);
        assertEquals(durabilidadInicialRecurso, recursoMetal.getDurabilidad(), 0.0001);
    }

    @Test
    public void test04MaderaNoGastaRecursoDiamanteConPicoFino() {
        BloqueDiamante recursoDiamante = new BloqueDiamante();
        Madera madera = new Madera();
        float durabilidadInicialRecurso = recursoDiamante.getDurabilidad();

        madera.gastarDiamanteConPicoFino(recursoDiamante, FUERZA_ARBITRARIA);
        assertEquals(durabilidadInicialRecurso, recursoDiamante.getDurabilidad(), 0.0001);

    }



}
