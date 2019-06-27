package vista;

import controladores.BotonControlesHandler;
import controladores.BotonSalirHandler;
import controladores.BotonVolverHandler;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VistaPausa {

    public static void mostrar(){
        VBox botonesPausa = new VBox();
        String estiloBotones = "-fx-pref-width: 150";

        Button botonVolverAJugar = new Button("Volver");
        Button botonControles = new Button("Controles");
        Button botonSalir = new Button("Salir");

        botonControles.setOnAction(new BotonControlesHandler());
        botonSalir.setOnAction(new BotonSalirHandler());

        botonVolverAJugar.setStyle(estiloBotones);
        botonControles.setStyle(estiloBotones);
        botonSalir.setStyle(estiloBotones);

        Label pausa = new Label("Juego Pausado");
        pausa.setStyle("-fx-font-weight: bold;-fx-font-size: 15");
        botonesPausa.getChildren().addAll(pausa,botonVolverAJugar,botonControles,botonSalir);
        botonesPausa.setSpacing(20);
        botonesPausa.setPrefSize(200,200);
        botonesPausa.setAlignment(Pos.CENTER);
        Scene vista = new Scene(botonesPausa);

        Stage ventanaPausa = new Stage(StageStyle.UNDECORATED);
        ventanaPausa.setResizable(false);
        ventanaPausa.setScene(vista);
        ventanaPausa.initModality(Modality.APPLICATION_MODAL);

        botonVolverAJugar.setOnAction(new BotonVolverHandler(ventanaPausa));


        ventanaPausa.show();
    }
}
