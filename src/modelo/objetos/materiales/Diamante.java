package modelo.objetos.materiales;

import modelo.objetos.GuardableEnInventario;

public class Diamante implements GuardableEnInventario {
    @Override
    public int getId() {
        return 4;
    }
}
