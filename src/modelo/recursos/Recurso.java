package modelo.recursos;

import modelo.Juego;
import modelo.herramientas.Herramienta;
import modelo.mapa.Celda;
import modelo.mapa.CeldaVacia;
import modelo.mapa.OcupanteDeCelda;
import modelo.mapa.Posicion;

public abstract class Recurso implements OcupanteDeCelda {

    protected Posicion posicion;
    protected int durabilidad;

    public float getDurabilidad() {
        return durabilidad;
    }

    public abstract boolean serGolpeadoPor(Herramienta herramienta);

    public abstract void agregarRecursoAlInventario();

    public void gastar(float fuerza){
        durabilidad -= fuerza;
        if (durabilidad <= 0) {
            this.agregarRecursoAlInventario();
            Juego.getJuego().getMapa().setearOcupanteEn(new CeldaVacia(), this.posicion);
            System.out.println("Recurso roto");
        }

        System.out.println("Recurso golpeado");
    }

    @Override
    public OcupanteDeCelda ocuparPorOcupanteDe(Celda celda){
        return this;
    }

    @Override
    public void actualizarPosicion(Posicion posicion){
        // no actualiza nada
    }
}
