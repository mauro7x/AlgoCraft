package modelo.objetos.materiales;

import modelo.recursos.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class PiedraYMetalTest {

    static final float FUERZA_ARBITRARIA = 10;

    @Test
    public void test01PiedraYMetalNoGastaRecursoMaderaConHacha() {
        BloqueMadera recursoMadera = new BloqueMadera();
        PiedraYMetal piedraYMetal = new PiedraYMetal();
        float durabilidadInicialRecurso = recursoMadera.getDurabilidad();

        piedraYMetal.gastarMaderaConHacha(recursoMadera, FUERZA_ARBITRARIA);
        assertEquals(durabilidadInicialRecurso, recursoMadera.getDurabilidad(), 0.0001);
    }

    @Test
    public void test02PiedraYMetalNoGastaRecursoPiedraConPico() {
        BloquePiedra recursoPiedra = new BloquePiedra();
        PiedraYMetal piedraYMetal = new PiedraYMetal();
        float durabilidadInicialRecurso = recursoPiedra.getDurabilidad();

        piedraYMetal.gastarPiedraConPico(recursoPiedra, FUERZA_ARBITRARIA);
        assertEquals(durabilidadInicialRecurso, recursoPiedra.getDurabilidad(), 0.0001);
    }

    @Test
    public void test03PiedraYMetalNoGastaRecursoMetalConPico() {
        BloqueMetal recursoMetal = new BloqueMetal();
        PiedraYMetal piedraYMetal = new PiedraYMetal();
        float durabilidadInicialRecurso = recursoMetal.getDurabilidad();

        piedraYMetal.gastarMetalConPico(recursoMetal, FUERZA_ARBITRARIA);
        assertEquals(durabilidadInicialRecurso, recursoMetal.getDurabilidad(), 0.0001);
    }

    @Test
    public void test04PiedraYMetalGastaRecursoDiamanteConPicoFino() {
        BloqueDiamante recursoDiamante = new BloqueDiamante();
        PiedraYMetal piedraYMetal = new PiedraYMetal();
        float durabilidadInicialRecurso = recursoDiamante.getDurabilidad();

        piedraYMetal.gastarDiamanteConPicoFino(recursoDiamante, FUERZA_ARBITRARIA);
        assertNotEquals(durabilidadInicialRecurso, recursoDiamante.getDurabilidad(), 0.0001);

    }


}
