package modelo.objetos.materiasPrimas;

import modelo.objetos.GuardableEnInventario;

public class PiedraInventariable implements GuardableEnInventario {
    @Override
    public int getId() {
        return 2;
    }
}
