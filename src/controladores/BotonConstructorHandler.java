package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import vista.VistaJuego;
import vista.VistaConstructor;

public class BotonConstructorHandler implements EventHandler<ActionEvent>{
    private VistaConstructor vistaConstructor;
    private Stage escenaConstructor;
    private boolean botonApretado;

    public void cerrarConstructor(){
        escenaConstructor.hide();
        botonApretado = false;
    }

    public void abrirConstructor(){
        vistaConstructor.actualizarVistaConstructor();
        escenaConstructor.show();
        botonApretado = true;
    }

    public BotonConstructorHandler(VistaJuego vistaJuego){
        this.vistaConstructor = new VistaConstructor(vistaJuego);
        botonApretado = false;
        escenaConstructor = new Stage();
        escenaConstructor.setTitle("Constructor");
        escenaConstructor.setScene(vistaConstructor.generarVistaConstructor());
        escenaConstructor.initStyle(StageStyle.UTILITY);
        escenaConstructor.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                cerrarConstructor();
            }
        });
    }

    @Override
    public void handle(ActionEvent actionEvent){ accionar(); }

    public void accionar(){
        if (!botonApretado) { this.abrirConstructor(); }
        else { this.cerrarConstructor(); }
    }

}

