package controladores.menuPrincipal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import vista.VistaConstructor;

public class BotonMaterialConstructorHandler implements EventHandler<ActionEvent> {
    private final String materialVacio = "Vacio";
    private String material;
    private ToggleButton boton;
    private VistaConstructor vista;

    public BotonMaterialConstructorHandler(ToggleButton boton, VistaConstructor vista, String material){
        this.boton = boton;
        this.material = material;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (boton.isSelected()) { vista.setMaterialActual(material); }
        else{ vista.setMaterialActual(materialVacio); }
        }
}

