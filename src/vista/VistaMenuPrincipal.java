package vista;

import controladores.BotonAcercaDeHandler;
import controladores.BotonControlesHandler;
import controladores.BotonJugarHandler;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class VistaMenuPrincipal {
    public Scene generarMenuPrincipal(Stage ventanaPrincipal) throws IOException {
        String estiloBotones = "-fx-opacity: 50; -fx-pref-width: 200px";

        Button botonJugar = new Button("Jugar");
        Button botonAcercaDe = new Button("Acerca De");
        Button botonControles = new Button("Controles");

        BotonAcercaDeHandler handlerAcercade = new BotonAcercaDeHandler();
        botonAcercaDe.setOnAction(handlerAcercade);


        BotonControlesHandler handlerControles = new BotonControlesHandler();
        botonControles.setOnAction(handlerControles);

        botonJugar.setStyle(estiloBotones);
        botonAcercaDe.setStyle(estiloBotones);
        botonControles.setStyle(estiloBotones);

        Image logo = new Image("media/Algocraft.png");
        ImageView vistaLogo = new ImageView(logo);
        VBox root = new VBox();

        root.getChildren().addAll(vistaLogo,botonJugar,botonAcercaDe, botonControles);
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        BackgroundImage[] fondos = cargarFondos();

        root.setBackground(new Background(fondos[0]));
        Timeline carruselFondo = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {
            int i = 0;

            @Override
            public void handle(ActionEvent event) {
                i = (i+1)%fondos.length;
                root.setBackground(new Background(fondos[i]));
            }
        }));
        carruselFondo.setCycleCount(Timeline.INDEFINITE);
        carruselFondo.play();

        FadeTransition transicion = new FadeTransition(Duration.millis(3500),vistaLogo);
        transicion.setFromValue(0);
        transicion.setToValue(10);
        transicion.play();

        Media cancion = new Media(new File("src/media/sonidos/mainMenu.mp3").toURI().toString());
        MediaPlayer reproductor = new MediaPlayer(cancion);
        reproductor.setVolume(0.5);
        reproductor.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                reproductor.seek(Duration.ZERO);
            }
        });
        MediaView vistaReproductor = new MediaView(reproductor);
        root.getChildren().addAll(vistaReproductor);
        reproductor.setAutoPlay(true);

        BotonJugarHandler handleJugar = new BotonJugarHandler(ventanaPrincipal,reproductor);
        botonJugar.setOnAction(handleJugar);

        return new Scene(root,900,500);
    }

    private BackgroundImage[] cargarFondos(){
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
        return fondos;

    }
}
