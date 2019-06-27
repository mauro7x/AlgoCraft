package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.media.AudioClip;
import vista.VistaConstructor;

import java.io.File;

import static javafx.scene.paint.Color.YELLOW;

public class BotonMaterialConstructorHandler implements EventHandler<ActionEvent> {
    private final String materialVacio = "Vacio";
    private String material;
    private ToggleButton boton;
    private VistaConstructor vista;
    private Lighting efectoSeleccion;
    private AudioClip sonidoBotonConstructorSeleccionado;
    private AudioClip sonidoBotonConstructorDeseleccionado;

    public BotonMaterialConstructorHandler(ToggleButton boton, VistaConstructor vista, String material){
        this.boton = boton;
        this.material = material;
        this.vista = vista;

        sonidoBotonConstructorSeleccionado = new AudioClip(new File("src/media/sonidos/sonidoBotonConstructorSeleccionado.mp3").toURI().toString());
        sonidoBotonConstructorSeleccionado.setVolume(0.5);

        sonidoBotonConstructorDeseleccionado = new AudioClip(new File("src/media/sonidos/sonidoBotonConstructorDeseleccionado.mp3").toURI().toString());
        sonidoBotonConstructorDeseleccionado.setVolume(0.5);

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
            boton.setEffect(efectoSeleccion);
            sonidoBotonConstructorSeleccionado.play();
        }
        else{
            vista.setMaterialActual(materialVacio);
            boton.setEffect(null);
            sonidoBotonConstructorDeseleccionado.play();
            }
    }
}

