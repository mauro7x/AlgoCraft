package modelo.recursos;
import modelo.Juego;
import modelo.mapa.Celda;
import modelo.mapa.CeldaVacia;
import modelo.mapa.OcupanteDeCelda;
import modelo.objetos.herramientas.*;

public abstract class Recurso implements OcupanteDeCelda {

    protected int durabilidad;

    public float getDurabilidad() {
        return durabilidad;
    }

    public abstract void serGolpeadoPor(Herramienta herramienta);

    public abstract void agregarRecursoAlInventario();

    public void gastar(float fuerza){
        durabilidad -= fuerza;
        if (durabilidad <= 0) {
            this.agregarRecursoAlInventario();
            this.ocuparPorOcupanteDe(new Celda(0,0)); //Vacio la celda que esta ocupando
        }
    }

    @Override
    public OcupanteDeCelda ocuparPorOcupanteDe(Celda celda){
        return this;
    }

    @Override
    public void actualizarPosicion(int x, int y){
        // no actualiza nada
    }
}
