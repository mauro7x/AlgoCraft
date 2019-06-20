package controladores.menuPrincipal;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modelo.Juego;
import vista.VistaJuego;


import java.security.Key;

public class ControlesTecladoHandler implements EventHandler<KeyEvent> {

    private VistaJuego vistaJuego;
    private BotonConstructorHandler constructorHandler;

    public ControlesTecladoHandler(VistaJuego vistaJuego, BotonConstructorHandler constructorHandler){
        this.vistaJuego = vistaJuego;
        this.constructorHandler = constructorHandler;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        Juego juego = Juego.getJuego();

        if(keyEvent.getCode() == KeyCode.W || keyEvent.getCode() == KeyCode.UP){
            juego.getJugador().moverArriba();
            vistaJuego.dibujarMapa();
        }
        if(keyEvent.getCode() == KeyCode.S || keyEvent.getCode() == KeyCode.DOWN){
            juego.getJugador().moverAbajo();
            vistaJuego.dibujarMapa();
        }
        if(keyEvent.getCode() == KeyCode.A || keyEvent.getCode() == KeyCode.LEFT){
            juego.getJugador().moverIzquierda();
            vistaJuego.dibujarMapa();
        }
        if(keyEvent.getCode() == KeyCode.D || keyEvent.getCode() == KeyCode.RIGHT){
            juego.getJugador().moverDerecha();
            vistaJuego.dibujarMapa();
        }
        if(keyEvent.getCode() == KeyCode.Q){
            juego.getJugador().cambiarAHerramientaAnterior();
            vistaJuego.actualizarInventarioHerramientas();
        }
        if(keyEvent.getCode() == KeyCode.E){
            juego.getJugador().cambiarAHerramientaSiguiente();
            vistaJuego.actualizarInventarioHerramientas();
        }
        if(keyEvent.getCode() == KeyCode.SPACE){
            System.out.println("Golpeando");
            juego.getJugador().golpear();
            vistaJuego.actualizarInventario();
            vistaJuego.dibujarMapa();
            vistaJuego.actualizarInventarioHerramientas();
        }

        if(keyEvent.getCode() == KeyCode.C){
            constructorHandler.accionar();
        }
    }
}
