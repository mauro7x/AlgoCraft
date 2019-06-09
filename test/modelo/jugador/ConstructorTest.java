package modelo.jugador;

import modelo.objetos.GuardableEnInventario;
import modelo.objetos.SlotVacio;
import modelo.objetos.materiales.Madera;
import modelo.objetos.materiasPrimas.MaderaInventariable;
import modelo.objetos.materiasPrimas.MetalInventariable;
import modelo.objetos.materiasPrimas.PiedraInventariable;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConstructorTest {

    @Test
    public void test01ConstruirHachaDeMadera(){
        Constructor constructor = new Constructor();

        GuardableEnInventario[] recetaHachaMadera = {
                new MaderaInventariable(), new MaderaInventariable(),new SlotVacio(),
                new MaderaInventariable(), new MaderaInventariable(),new SlotVacio(),
                new SlotVacio(),new MaderaInventariable(), new SlotVacio()
        };

        GuardableEnInventario hachaMadera = constructor.construir(recetaHachaMadera);
        assertEquals(10,hachaMadera.getId());
    }

    @Test
    public void test02ConstruirHachaDePiedra(){
        Constructor constructor = new Constructor();

        GuardableEnInventario[] recetaHachaPiedra = {
                new PiedraInventariable(), new PiedraInventariable(),new SlotVacio(),
                new PiedraInventariable(), new MaderaInventariable(),new SlotVacio(),
                new SlotVacio(),new MaderaInventariable(), new SlotVacio()
        };

        GuardableEnInventario hachaPiedra = constructor.construir(recetaHachaPiedra);
        assertEquals(11,hachaPiedra.getId());
    }

    @Test
    public void test03ConstruirHachaDeMetal(){
        Constructor constructor = new Constructor();

        GuardableEnInventario[] recetaHachaMetal = {
                new MetalInventariable(), new MetalInventariable(),new SlotVacio(),
                new MetalInventariable(), new MaderaInventariable(),new SlotVacio(),
                new SlotVacio(),new MaderaInventariable(), new SlotVacio()
        };

        GuardableEnInventario hachaMetal = constructor.construir(recetaHachaMetal);
        assertEquals(12,hachaMetal.getId());
    }

    @Test
    public void test04ConstruirPicoDeMadera(){
        Constructor constructor = new Constructor();

        GuardableEnInventario[] recetaPicoMadera = {
                new MaderaInventariable(), new MaderaInventariable(),new MaderaInventariable(),
                new SlotVacio(), new MaderaInventariable(),new SlotVacio(),
                new SlotVacio(),new MaderaInventariable(), new SlotVacio()
        };

        GuardableEnInventario picoMadera = constructor.construir(recetaPicoMadera);
        assertEquals(13,picoMadera.getId());
    }

    @Test
    public void test05ConstruirPicoDePiedra(){
        Constructor constructor = new Constructor();

        GuardableEnInventario[] recetaPicoPiedra = {
                new PiedraInventariable(),new PiedraInventariable(),new PiedraInventariable(),
                new SlotVacio(), new MaderaInventariable(),new SlotVacio(),
                new SlotVacio(),new MaderaInventariable(), new SlotVacio()
        };

        GuardableEnInventario picoPiedra = constructor.construir(recetaPicoPiedra);
        assertEquals(14,picoPiedra.getId());
    }

    @Test
    public void test06ConstruirPicoDeMetal(){
        Constructor constructor = new Constructor();

        GuardableEnInventario[] recetaPicoMetal = {
                new MetalInventariable(),new MetalInventariable(),new MetalInventariable(),
                new SlotVacio(), new MaderaInventariable(),new SlotVacio(),
                new SlotVacio(),new MaderaInventariable(), new SlotVacio()
        };

        GuardableEnInventario picoMetal = constructor.construir(recetaPicoMetal);
        assertEquals(15,picoMetal.getId());
    }

    @Test
    public void test07ConstruirPicoFino(){
        Constructor constructor = new Constructor();

        GuardableEnInventario[] recetaPicoFino = {
                new MetalInventariable(),new MetalInventariable(),new MetalInventariable(),
                new PiedraInventariable(), new MaderaInventariable(),new SlotVacio(),
                new SlotVacio(),new MaderaInventariable(), new SlotVacio()
        };

        GuardableEnInventario picoFino = constructor.construir(recetaPicoFino);
        assertEquals(16,picoFino.getId());
    }
}