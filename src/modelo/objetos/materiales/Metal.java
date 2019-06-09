package modelo.objetos.materiales;

import modelo.objetos.GuardableEnInventario;

public class Metal implements GuardableEnInventario {
    @Override
    public int getId() {
        return 3;
    }
}
