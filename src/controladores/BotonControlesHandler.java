package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.media.AudioClip;

import java.io.File;

public class BotonControlesHandler implements EventHandler<ActionEvent> {
    private AudioClip sonidoBotonControles;

    public BotonControlesHandler() {
        sonidoBotonControles = new AudioClip(new File("src/media/sonidos/sonidoBotonAcercaDeSeleccionado.mp3").toURI().toString());
        sonidoBotonControles.setVolume(1);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Controles");
        alert.setHeaderText("Controles del juego");
        alert.setContentText("W/UP ARROW - Mover jugador hacia arriba \n\n" +
                "S/DOWN ARROW - Mover jugador hacia abajo\n\n" +
                "D/RIGHT ARROW - Mover jugador hacia la derecha\n\n" +
                "A/LEFT ARROW - Mover jugador hacia la izquierda\n\n" +
                "C - Abrir constructor de herramientas\n\n" +
                "SPACE - Golpear\n\n" +
                "R - Resetear el mapa\n\n" +
                "ESC - Pausa\n\n" +
                "");
        Image image = new Image("media/controles.png", 50,50, false, false);
        ImageView imageView = new ImageView(image);
        alert.setGraphic(imageView);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        sonidoBotonControles.play();
        alert.show();
    }
}
