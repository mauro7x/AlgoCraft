package controladores;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import modelo.Juego;
import vista.VistaJuego;
import vista.VistaPausa;

public class ControlesTecladoHandler implements EventHandler<KeyEvent> {

    private VistaJuego vistaJuego;
    private BotonConstructorHandler constructorHandler;

    public ControlesTecladoHandler(VistaJuego vistaJuego){
        this.vistaJuego = vistaJuego;
        this.constructorHandler = new BotonConstructorHandler(vistaJuego);
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        Juego juego = Juego.getJuego();

        if(keyEvent.getCode() == KeyCode.W || keyEvent.getCode() == KeyCode.UP){
            boolean seMovioElJugador = juego.getJugador().moverArriba();
            if (seMovioElJugador){vistaJuego.hacerSonidoCaminar();}
            else { vistaJuego.hacerSonidoNoSePuedeMover();};
            vistaJuego.dibujarMapa();
        }
        if(keyEvent.getCode() == KeyCode.S || keyEvent.getCode() == KeyCode.DOWN){
            boolean seMovioElJugador = juego.getJugador().moverAbajo();
            if (seMovioElJugador){vistaJuego.hacerSonidoCaminar();}
            else { vistaJuego.hacerSonidoNoSePuedeMover();};
            vistaJuego.dibujarMapa();
        }
        if(keyEvent.getCode() == KeyCode.A || keyEvent.getCode() == KeyCode.LEFT){
            boolean seMovioElJugador = juego.getJugador().moverIzquierda();
            if (seMovioElJugador){vistaJuego.hacerSonidoCaminar();}
            else { vistaJuego.hacerSonidoNoSePuedeMover();};
            vistaJuego.dibujarMapa();
        }
        if(keyEvent.getCode() == KeyCode.D || keyEvent.getCode() == KeyCode.RIGHT){
            boolean seMovioElJugador = juego.getJugador().moverDerecha();
            if (seMovioElJugador){vistaJuego.hacerSonidoCaminar();}
            else { vistaJuego.hacerSonidoNoSePuedeMover();};
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
            boolean golpeoUnBloque = juego.getJugador().golpear();
            if (golpeoUnBloque){
                System.out.println("Golpeando");
                vistaJuego.hacerSonidoGolpearBloque();
            }
            else{
                vistaJuego.hacerSonidoGolpearNada();
            };
            vistaJuego.actualizarInventario();
            vistaJuego.dibujarMapa();
            vistaJuego.actualizarInventarioHerramientas();
        }


        if(keyEvent.getCode() == KeyCode.R){
            juego.resetearMapa();
            vistaJuego.dibujarMapa();
            vistaJuego.hacerSonidoCambiarMapa();
            juego.imprimirPorConsola("Nuevo mapa generado.");
        }

        if(keyEvent.getCode() == KeyCode.C){
            constructorHandler.accionar();
        }

        if(keyEvent.getCode() == KeyCode.ESCAPE){
            VistaPausa.mostrar();
        }

    }
}
