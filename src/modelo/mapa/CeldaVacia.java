package modelo.mapa;

public class CeldaVacia implements OcupanteDeCelda {
    @Override
    public OcupanteDeCelda ocuparPor(OcupanteDeCelda ocupante) {
        return ocupante;
    }
}
