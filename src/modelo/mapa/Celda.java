package modelo.mapa;

public class Celda {

    private OcupanteDeCelda ocupante;
    private Posicion posicion;

    public Celda(Posicion posicion){
        this.posicion = posicion;
        ocupante = new CeldaVacia();
    }

    public OcupanteDeCelda getOcupante() {
        return ocupante;
    }

    void setOcupante(OcupanteDeCelda ocupante){
        this.ocupante = ocupante;
    }

    private void actualizarPosicionOcupante(){
        this.ocupante.actualizarPosicion(posicion);
    }

    private void ocuparPorOcupanteDe(Celda celdaOrigen){
        this.ocupante = (this.ocupante).ocuparPorOcupanteDe(celdaOrigen);
    }

    public Posicion getPosicion() { return this.posicion; }

    void moverA(Celda celdaDestino){
        celdaDestino.ocuparPorOcupanteDe(this);
        actualizarPosicionOcupante();
        celdaDestino.actualizarPosicionOcupante(); // en caso de que se haya movido, actualiza la pos del jugador
    }

}
