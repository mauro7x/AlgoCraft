package vista;
import controladores.BotonSalirHandler;
import controladores.BotonVolverHandler;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Algocraft");
        stage.getIcons().add(new Image("media/herramientas/picoMetal.png"));

        Scene escenaMenuPrincipal = new VistaMenuPrincipal().generarMenuPrincipal(stage);
        stage.setScene(escenaMenuPrincipal);
        stage.setResizable(false);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                new BotonSalirHandler().handle(null);
                event.consume();
            }
        });

        stage.show();
    }


}
