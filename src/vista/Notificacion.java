package vista;

import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Notificacion extends Label {
    FadeTransition transicion;

    public Notificacion(){
        super();
        transicion = new FadeTransition(Duration.millis(2000),this);
        transicion.setFromValue(10);
        transicion.setToValue(0);
    }
    public void escribir(String s){
        transicion.stop();
        this.setText(s);
        transicion.play();
    }
}
