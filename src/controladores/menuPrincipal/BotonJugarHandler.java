package controladores.menuPrincipal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import vista.VistaJuego;

public class BotonJugarHandler implements EventHandler<ActionEvent> {
    private Stage ventanaPrincipal;
    private MediaPlayer reproductorMusicaMenuPrincipal;

    public BotonJugarHandler(Stage ventanaPrincipal, MediaPlayer reproductorMusicaMenuPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        this.reproductorMusicaMenuPrincipal = reproductorMusicaMenuPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Scene vistaJuego = new VistaJuego().generarVistaJuego();
        reproductorMusicaMenuPrincipal.stop();
        ventanaPrincipal.setScene(vistaJuego);
    }

}
