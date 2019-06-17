package controladores.menuPrincipal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

public class BotonAcercaDeHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Acerca de este juego");
        alert.setContentText("Desarrollado por Mauro Parafati, Santiago Klein y Nicolas Aguerre para Algoritmos y Programacion III." +
                "1° Cuatrimestre 2019.");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }
}
