package modelo.objetos.materiasPrimas;

import modelo.objetos.GuardableEnInventario;

public class MetalInventariable implements GuardableEnInventario {
    @Override
    public int getId() {
        return 3;
    }
}
