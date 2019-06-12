package modelo.mapa;

public class Celda {

    private int x;
    private int y;
    private OcupanteDeCelda ocupante;

    Celda(int x, int y){
        this.x = x;
        this.y = y;
        ocupante = new CeldaVacia();
    }

    OcupanteDeCelda getOcupante() {
        return ocupante;
    }

    void setOcupante(OcupanteDeCelda ocupante){
        this.ocupante = ocupante;
    }

    private void actualizarPosicionOcupante(){
        this.ocupante.actualizarPosicion(x, y);
    }


    void ocuparPor(OcupanteDeCelda ocupante){
        this.ocupante = (this.ocupante).ocuparPor(ocupante);
    }

    private void ocuparPorOcupanteDe(Celda celdaOrigen){
        this.ocupante = (this.ocupante).ocuparPorOcupanteDe(celdaOrigen);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    void moverA(Celda celdaDestino){
        celdaDestino.ocuparPorOcupanteDe(this);
        celdaDestino.actualizarPosicionOcupante(); // en caso de que se haya movido, actualiza la pos del jugador
    }

}
