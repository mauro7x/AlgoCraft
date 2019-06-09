package modelo.objetos.materiasPrimas;

import modelo.objetos.GuardableEnInventario;
import org.junit.Test;


import static junit.framework.TestCase.assertEquals;

public class MateriasPrimasTest {

    @Test
    public void test01CrearMaderaIDes1(){
        GuardableEnInventario madera = new MaderaInventariable();
        assertEquals(1,madera.getId());
    }

    @Test
    public void test02CrearPiedraIDes2(){
        GuardableEnInventario piedra = new PiedraInventariable();
        assertEquals(2,piedra.getId());
    }

    @Test
    public void test03CrearMetalIDes3(){
        GuardableEnInventario metal = new MetalInventariable();
        assertEquals(3,metal.getId());
    }

    @Test
    public void test04CrearDiamanteIDEs4(){
        GuardableEnInventario diamante = new DiamanteInventariable();
        assertEquals(4,diamante.getId());
    }

}
