package vista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Algocraft");

        Scene escenaMenuPrincipal = new VistaMenuPrincipal().generarMenuPrincipal(stage);
        stage.setScene(escenaMenuPrincipal);
        stage.setResizable(false);
        stage.show();
    }


}
