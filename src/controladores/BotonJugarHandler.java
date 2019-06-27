package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import vista.VistaJuego;

import java.io.File;

public class BotonJugarHandler implements EventHandler<ActionEvent> {
    private Stage ventanaPrincipal;
    private MediaPlayer reproductorMusicaMenuPrincipal;
    private AudioClip sonidoBotonJugar;

    public BotonJugarHandler(Stage ventanaPrincipal, MediaPlayer reproductorMusicaMenuPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        this.reproductorMusicaMenuPrincipal = reproductorMusicaMenuPrincipal;
        sonidoBotonJugar = new AudioClip(new File("src/media/sonidos/sonidoBotonJugarSeleccionado.mp3").toURI().toString());
        sonidoBotonJugar.setVolume(1);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonidoBotonJugar.play();
        Scene vistaJuego = new VistaJuego().generarVistaJuego();
        reproductorMusicaMenuPrincipal.stop();
        ventanaPrincipal.setScene(vistaJuego);
    }

}
