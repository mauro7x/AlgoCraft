package modelo.mapa;

public class Matriz {

    private int filas;
    private int columnas;
    private Celda[] celdas;

    public Matriz(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        celdas = new Celda[filas*columnas];
        llenarConCeldas();

    }

    private void llenarConCeldas(){

        for (int x = 0; x < filas; x++){
            for (int y = 0; y < columnas; y++){
                celdas[(x*columnas)+y] = new Celda(x,y);
            }
        }

    }

    public Celda getCelda(int x, int y){
        return celdas[(x*columnas)+y];
    }

}
