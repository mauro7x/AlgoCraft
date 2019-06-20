package controladores.menuPrincipal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vista.VistaJuego;

public class BotonJugarHandler implements EventHandler<ActionEvent> {
    private Stage ventanaPrincipal;

    public BotonJugarHandler(Stage ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Scene vistaJuego = new VistaJuego().generarVistaJuego();
        ventanaPrincipal.setScene(vistaJuego);
    }

}
