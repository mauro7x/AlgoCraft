package controladores.menuPrincipal;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modelo.Juego;
import vista.VistaJuego;

public class ControlesMovimientoHandler implements EventHandler<KeyEvent> {

    private VistaJuego vistaJuego;

    public ControlesMovimientoHandler(VistaJuego vistaJuego){
        this.vistaJuego = vistaJuego;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        Juego juego = Juego.getJuego();

        if(keyEvent.getCode() == KeyCode.W){
            juego.getJugador().moverArriba();
            vistaJuego.dibujarMapa();
        }
        if(keyEvent.getCode() == KeyCode.S){
            juego.getJugador().moverAbajo();
            vistaJuego.dibujarMapa();
        }
        if(keyEvent.getCode() == KeyCode.A){
            juego.getJugador().moverIzquierda();
            vistaJuego.dibujarMapa();
        }
        if(keyEvent.getCode() == KeyCode.D){
            juego.getJugador().moverDerecha();
            vistaJuego.dibujarMapa();
        }
    }
}
