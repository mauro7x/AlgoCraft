package modelo.objetos.materiales;

import modelo.objetos.GuardableEnInventario;

public class Piedra implements GuardableEnInventario {
    @Override
    public int getId() {
        return 2;
    }
}
