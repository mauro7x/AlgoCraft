package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonVolverHandler implements EventHandler<ActionEvent> {
    Stage ventanaPausa;

    public BotonVolverHandler(Stage ventanaPausa){
        this.ventanaPausa = ventanaPausa;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        ventanaPausa.hide();
    }
}
