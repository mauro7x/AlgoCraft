package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import javafx.scene.media.AudioClip;

import java.io.File;

public class BotonAcercaDeHandler implements EventHandler<ActionEvent> {
        private AudioClip sonidoBotonAcercaDe;

        public BotonAcercaDeHandler() {
            sonidoBotonAcercaDe = new AudioClip(new File("src/media/sonidos/sonidoBotonAcercaDeSeleccionado.mp3").toURI().toString());
            sonidoBotonAcercaDe.setVolume(0.5);
        }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Acerca de este juego");
        alert.setContentText("Desarrollado por Mauro Parafati, Santiago Klein y Nicolas Aguerre para Algoritmos y Programacion III. \n\n" +
                "1° Cuatrimestre 2019.");
        sonidoBotonAcercaDe.play();
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }
}
