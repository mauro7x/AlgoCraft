package modelo.mapa;

public class Mapa {

    private int filas;
    private int columnas;

    private Matriz celdas;

    public Mapa(int filas, int columnas){
        celdas = new Matriz(filas, columnas);
        this.filas = filas;
        this.columnas = columnas;
    }

    public Celda getCelda(int x, int y){
        return celdas.getCelda(x, y);
    }

    public Celda getCeldaCentral(){
        return celdas.getCelda(filas/2, columnas/2);
    }

    public void ubicarEnElCentro(OcupanteDeCelda ocupante){
        ubicarOcupanteEn(ocupante, filas/2, columnas/2);
    }

    public void ubicarOcupanteEn(OcupanteDeCelda ocupante, int x, int y){
        Celda celdaDestino = celdas.getCelda(x, y);
        celdaDestino.ocuparPor(ocupante);
    }



}
