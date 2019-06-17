package controladores.menuPrincipal;

import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;
import modelo.Juego;
import vista.VistaJuego;

public class ControlScrollHandler implements EventHandler<ScrollEvent> {
    private VistaJuego vistaJuego;

    public ControlScrollHandler(VistaJuego vistaJuego){
        this.vistaJuego = vistaJuego;
    }

    @Override
    public void handle(ScrollEvent scrollEvent) {
        if(scrollEvent.getDeltaY() > 0){
            Juego juego = Juego.getJuego();
            juego.getJugador().cambiarAHerramientaSiguiente();
            vistaJuego.actualizarInventarioHerramientas();
        }
        if(scrollEvent.getDeltaY() < 0){
            Juego juego = Juego.getJuego();
            juego.getJugador().cambiarAHerramientaAnterior();
            vistaJuego.actualizarInventarioHerramientas();
        }
    }
}
