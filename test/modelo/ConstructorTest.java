package modelo;

import modelo.objetos.GuardableEnInventario;
import modelo.objetos.SlotVacio;
import modelo.objetos.materiales.Madera;
import modelo.objetos.materiales.Metal;
import modelo.objetos.materiales.Piedra;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConstructorTest {

    @Test
    public void test01ConstruirHachaDeMadera(){
        Constructor constructor = Constructor.get();

        GuardableEnInventario[] recetaHachaMadera = {
                new Madera(), new Madera(),new SlotVacio(),
                new Madera(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario hachaMadera = constructor.construir(recetaHachaMadera);
        assertEquals(10,hachaMadera.getId());
    }

    @Test
    public void test02ConstruirHachaDePiedra(){
        Constructor constructor = Constructor.get();

        GuardableEnInventario[] recetaHachaPiedra = {
                new Piedra(), new Piedra(),new SlotVacio(),
                new Piedra(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario hachaPiedra = constructor.construir(recetaHachaPiedra);
        assertEquals(11,hachaPiedra.getId());
    }

    @Test
    public void test03ConstruirHachaDeMetal(){
        Constructor constructor = Constructor.get();

        GuardableEnInventario[] recetaHachaMetal = {
                new Metal(), new Metal(),new SlotVacio(),
                new Metal(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario hachaMetal = constructor.construir(recetaHachaMetal);
        assertEquals(12,hachaMetal.getId());
    }

    @Test
    public void test04ConstruirPicoDeMadera(){
        Constructor constructor = Constructor.get();

        GuardableEnInventario[] recetaPicoMadera = {
                new Madera(), new Madera(),new Madera(),
                new SlotVacio(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario picoMadera = constructor.construir(recetaPicoMadera);
        assertEquals(13,picoMadera.getId());
    }

    @Test
    public void test05ConstruirPicoDePiedra(){
        Constructor constructor = Constructor.get();

        GuardableEnInventario[] recetaPicoPiedra = {
                new Piedra(),new Piedra(),new Piedra(),
                new SlotVacio(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario picoPiedra = constructor.construir(recetaPicoPiedra);
        assertEquals(14,picoPiedra.getId());
    }

    @Test
    public void test06ConstruirPicoDeMetal(){
        Constructor constructor = Constructor.get();

        GuardableEnInventario[] recetaPicoMetal = {
                new Metal(),new Metal(),new Metal(),
                new SlotVacio(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario picoMetal = constructor.construir(recetaPicoMetal);
        assertEquals(15,picoMetal.getId());
    }

    @Test
    public void test07ConstruirPicoFino(){
        Constructor constructor = Constructor.get();

        GuardableEnInventario[] recetaPicoFino = {
                new Metal(),new Metal(),new Metal(),
                new Piedra(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario picoFino = constructor.construir(recetaPicoFino);
        assertEquals(16,picoFino.getId());
    }

    @Test
    public void test08ConstruirUnaRecetaInexistenteDevuelveSlotVacio(){
        Constructor constructor = Constructor.get();

        GuardableEnInventario[] recetaInexistente = {
                new SlotVacio(), new SlotVacio(), new Metal(),
                new Piedra(), new Madera(),new SlotVacio(),
                new SlotVacio(),new Madera(), new SlotVacio()
        };

        GuardableEnInventario slotVacio = constructor.construir(recetaInexistente);
        assertEquals(0,slotVacio.getId());
    }
}
