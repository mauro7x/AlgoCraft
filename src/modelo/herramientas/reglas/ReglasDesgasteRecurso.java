package modelo.herramientas.reglas;

import modelo.recursos.*;

public interface ReglasDesgasteRecurso {

    void gastar(BloqueMetal metal, float fuerza);
    void gastar(BloqueMadera madera, float fuerza);
    void gastar(BloquePiedra piedra, float fuerza);
    void gastar(BloqueDiamante diamante, float fuerza);

}
