package modelo.objetos.herramientas.reglas;

import modelo.recursos.BloqueDiamante;
import modelo.recursos.BloqueMadera;
import modelo.recursos.BloqueMetal;
import modelo.recursos.BloquePiedra;

public class ReglasPicoPiedra extends ReglasDecorador {
    public ReglasPicoPiedra(ReglasDesgasteRecurso reglas) {
        super(reglas);
    }

    // El pico de piedra puede gastar metal

    @Override
    public void gastar(BloqueMetal metal, float fuerza) {
        getReglas().gastar(metal, fuerza);
        metal.gastar(fuerza); //funcionalidad agregada respecto al pico estandar
    }

    @Override
    public void gastar(BloqueMadera madera, float fuerza) {
        getReglas().gastar(madera, fuerza);
    }

    @Override
    public void gastar(BloquePiedra piedra, float fuerza) {
        getReglas().gastar(piedra, fuerza);
    }

    @Override
    public void gastar(BloqueDiamante diamante, float fuerza) {
        getReglas().gastar(diamante, fuerza);
    }
}
