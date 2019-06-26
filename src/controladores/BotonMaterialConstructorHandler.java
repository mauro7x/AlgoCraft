package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import vista.VistaConstructor;

import static javafx.scene.paint.Color.YELLOW;

public class BotonMaterialConstructorHandler implements EventHandler<ActionEvent> {
    private final String materialVacio = "Vacio";
    private String material;
    private ToggleButton boton;
    private VistaConstructor vista;
    private Lighting efectoSeleccion;

    public BotonMaterialConstructorHandler(ToggleButton boton, VistaConstructor vista, String material){
        this.boton = boton;
        this.material = material;
        this.vista = vista;

        efectoSeleccion = new Lighting();
        efectoSeleccion.setDiffuseConstant(1.0);
        efectoSeleccion.setSpecularConstant(0.0);
        efectoSeleccion.setSpecularExponent(0.0);
        efectoSeleccion.setSurfaceScale(0.0);
        efectoSeleccion.setLight(new Light.Distant(45, 45, YELLOW));
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (boton.isSelected()) {
            vista.setMaterialActual(material);
            boton.setEffect(efectoSeleccion);}
        else{
            vista.setMaterialActual(materialVacio);
            boton.setEffect(null);
            }
    }
}

