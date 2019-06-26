package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import vista.VistaConstructor;

import java.awt.event.MouseEvent;

public class BotonCeldaConstructorHandler implements EventHandler<ActionEvent> {
    private VistaConstructor vista;
    private int numeroDeCelda;

    public BotonCeldaConstructorHandler(VistaConstructor vista, int numeroDeCelda) {
        this.vista = vista;
        this.numeroDeCelda = numeroDeCelda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        vista.setMaterial(this.numeroDeCelda);
        vista.construir(true);
    }
}
