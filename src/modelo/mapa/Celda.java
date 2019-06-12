package modelo.mapa;

public class Celda {

    private int x;
    private int y;
    private OcupanteDeCelda ocupante;

    public Celda(int x, int y){
        this.x = x;
        this.y = y;
        ocupante = new CeldaVacia();
    }

    public OcupanteDeCelda getOcupante() {
        return ocupante;
    }

    public void ocuparPor(OcupanteDeCelda ocupante){
        this.ocupante = (this.ocupante).ocuparPor(ocupante);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
