package modelo.mapa;

public class Mapa {

    private Matriz celdas;

    public Mapa(int filas, int columnas){
        celdas = new Matriz(filas, columnas);
    }

    public Celda getCelda(int x, int y){
        return celdas.getCelda(x, y);
    }

}
