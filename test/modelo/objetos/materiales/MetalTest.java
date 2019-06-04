package modelo.objetos.materiales;

import modelo.recursos.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class MetalTest {


    static final float FUERZA_ARBITRARIA = 10;

    @Test
    public void test01MetalGastaRecursoMaderaConHacha() {
        BloqueMadera recursoMadera = new BloqueMadera();
        Metal metal = new Metal();
        float durabilidadInicialRecurso = recursoMadera.getDurabilidad();

        metal.gastarMaderaConHacha(recursoMadera, FUERZA_ARBITRARIA);
        assertNotEquals(durabilidadInicialRecurso, recursoMadera.getDurabilidad(), 0.0001);
    }

    @Test
    public void test02MetalGastaRecursoPiedraConPico() {
        BloquePiedra recursoPiedra = new BloquePiedra();
        Metal metal = new Metal();
        float durabilidadInicialRecurso = recursoPiedra.getDurabilidad();

        metal.gastarPiedraConPico(recursoPiedra, FUERZA_ARBITRARIA);
        assertNotEquals(durabilidadInicialRecurso, recursoPiedra.getDurabilidad(), 0.0001);
    }

    @Test
    public void test03MetalNoGastaRecursoMetalConPico() {
        BloqueMetal recursoMetal = new BloqueMetal();
        Metal metal = new Metal();
        float durabilidadInicialRecurso = recursoMetal.getDurabilidad();

        metal.gastarMetalConPico(recursoMetal, FUERZA_ARBITRARIA);
        assertEquals(durabilidadInicialRecurso, recursoMetal.getDurabilidad(), 0.0001);
    }

    @Test
    public void test04MetalNoGastaRecursoDiamanteConPicoFino() {
        BloqueDiamante recursoDiamante = new BloqueDiamante();
        Metal metal = new Metal();
        float durabilidadInicialRecurso = recursoDiamante.getDurabilidad();

        metal.gastarDiamanteConPicoFino(recursoDiamante, FUERZA_ARBITRARIA);
        assertEquals(durabilidadInicialRecurso, recursoDiamante.getDurabilidad(), 0.0001);

    }
    
}

