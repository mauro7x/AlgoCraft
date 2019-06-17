package vista;

import controladores.menuPrincipal.BotonAcercaDeHandler;
import controladores.menuPrincipal.BotonJugarHandler;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class VistaMenuPrincipal {
    public Scene generarMenuPrincipal(Stage ventanaPrincipal) throws IOException {
        String estiloBotones = "-fx-opacity: 50; -fx-pref-width: 200px";

        Button botonJugar = new Button("Jugar");
        Button botonAcercaDe = new Button("Acerca De");

        BotonAcercaDeHandler handlerAcercade = new BotonAcercaDeHandler();
        botonAcercaDe.setOnAction(handlerAcercade);

        BotonJugarHandler handleJugar = new BotonJugarHandler(ventanaPrincipal);
        botonJugar.setOnAction(handleJugar);

        botonJugar.setStyle(estiloBotones);
        botonAcercaDe.setStyle(estiloBotones);

        Image logo = new Image("media/Algocraft.png");
        ImageView vistaLogo = new ImageView(logo);
        VBox contenedorPrincipal = new VBox();

        contenedorPrincipal.getChildren().addAll(vistaLogo,botonJugar,botonAcercaDe);
        contenedorPrincipal.setSpacing(20);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        BackgroundImage fondo1= new BackgroundImage(new Image("media/fondo.jpg",900,500,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        BackgroundImage fondo2= new BackgroundImage(new Image("media/fondo2.jpg",900,500,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        BackgroundImage fondo3= new BackgroundImage(new Image("media/fondo3.jpg",900,500,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        BackgroundImage[] fondos = {fondo1,fondo2,fondo3};

        contenedorPrincipal.setBackground(new Background(fondo1));
        Timeline carruselFondo = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {
            int i = 0;

            @Override
            public void handle(ActionEvent event) {
                i = (i+1)%fondos.length;
                contenedorPrincipal.setBackground(new Background(fondos[i]));
            }
        }));
        carruselFondo.setCycleCount(Timeline.INDEFINITE);
        carruselFondo.play();

        FadeTransition transicion = new FadeTransition(Duration.millis(3500),vistaLogo);
        transicion.setFromValue(0);
        transicion.setToValue(10);
        transicion.play();

        return new Scene(contenedorPrincipal,900,500);
    }
}
