package modelo.mapa;

class CuadriculaCeldas {

    private int xMax;
    private int yMax;
    private Celda[] celdas;

    CuadriculaCeldas(int xMax, int yMax){
        this.xMax = xMax;
        this.yMax = yMax;
        celdas = new Celda[xMax*yMax];
        llenarConCeldas();

    }

    private void llenarConCeldas(){

        for (int y = 0; y < yMax; y++){
            for (int x = 0; x < xMax; x++){
                celdas[(y*xMax) + x] = new Celda(x, y);
            }
        }

    }

    Celda getCelda(int x, int y){
        return celdas[(y*xMax) + x];
    }

}
