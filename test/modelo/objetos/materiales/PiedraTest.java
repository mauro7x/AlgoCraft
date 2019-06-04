package modelo.objetos.materiales;

import modelo.recursos.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class PiedraTest {

    static final float FUERZA_ARBITRARIA = 10;

    @Test
    public void test01PiedraGastaRecursoMaderaConHacha() {
        BloqueMadera recursoMadera = new BloqueMadera();
        Piedra piedra = new Piedra();
        float durabilidadInicialRecurso = recursoMadera.getDurabilidad();

        piedra.gastarMaderaConHacha(recursoMadera, FUERZA_ARBITRARIA);
        assertNotEquals(durabilidadInicialRecurso, recursoMadera.getDurabilidad(), 0.0001);
    }

    @Test
    public void test02PiedraGastaRecursoPiedraConPico() {
        BloquePiedra recursoPiedra = new BloquePiedra();
        Piedra piedra = new Piedra();
        float durabilidadInicialRecurso = recursoPiedra.getDurabilidad();

        piedra.gastarPiedraConPico(recursoPiedra, FUERZA_ARBITRARIA);
        assertNotEquals(durabilidadInicialRecurso, recursoPiedra.getDurabilidad(), 0.0001);
    }

    @Test
    public void test03PiedraGastaRecursoMetalConPico() {
        BloqueMetal recursoMetal = new BloqueMetal();
        Piedra piedra = new Piedra();
        float durabilidadInicialRecurso = recursoMetal.getDurabilidad();

        piedra.gastarMetalConPico(recursoMetal, FUERZA_ARBITRARIA);
        assertNotEquals(durabilidadInicialRecurso, recursoMetal.getDurabilidad(), 0.0001);
    }

    @Test
    public void test04PiedraNoGastaRecursoDiamanteConPicoFino() {
        BloqueDiamante recursoDiamante = new BloqueDiamante();
        Piedra piedra = new Piedra();
        float durabilidadInicialRecurso = recursoDiamante.getDurabilidad();

        piedra.gastarDiamanteConPicoFino(recursoDiamante, FUERZA_ARBITRARIA);
        assertEquals(durabilidadInicialRecurso, recursoDiamante.getDurabilidad(), 0.0001);

    }
    
}
