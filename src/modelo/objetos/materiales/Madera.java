package modelo.objetos.materiales;

import modelo.objetos.GuardableEnInventario;

public class Madera implements GuardableEnInventario {
    @Override
    public int getId() {
        return 1;
    }
}
