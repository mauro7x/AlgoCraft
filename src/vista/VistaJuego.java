package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.Juego;
import modelo.herramientas.FabricaHerramientas;
import modelo.herramientas.Herramienta;
import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.OcupanteDeCelda;
import modelo.mapa.Posicion;

import java.util.ArrayList;

public class VistaJuego {

    private int dimensionTile = 50;

    public Scene generarVistaJuego(){

        BorderPane contenedorPrincipal = new BorderPane();
        GridPane cuadriculaMapa = new GridPane();
        cuadriculaMapa.setHgap(0);
        cuadriculaMapa.setVgap(0);
        cuadriculaMapa.setPadding(new Insets(0,0,0,0));

        Juego juego = Juego.getJuego();
        juego.resetear();
        Mapa mapa = juego.getMapa();

        int widthVentana = mapa.getXMax()*dimensionTile;
        int heightVentana = mapa.getYMax()*dimensionTile;

        dibujarMapa(cuadriculaMapa);

        juego.getJugador().guardar(FabricaHerramientas.crearHachaDePiedra());
        juego.getJugador().guardar(FabricaHerramientas.crearPicoDeMetal());
        juego.getJugador().guardar(FabricaHerramientas.crearPicoFino());
        juego.getJugador().guardar(FabricaHerramientas.crearPicoDeMadera());

        HBox inventarioHerramientas = generarInventarioHerramientas();

        contenedorPrincipal.setBottom(inventarioHerramientas);
        contenedorPrincipal.setCenter(cuadriculaMapa);

        return new Scene(contenedorPrincipal,contenedorPrincipal.getPrefWidth(),contenedorPrincipal.getPrefHeight());
    }

    private void dibujarMapa(GridPane cuadriculaMapa){
        Juego juego = Juego.getJuego();
        Mapa mapa = juego.getMapa();

        for(int i=0;i<mapa.getXMax();i++){
            for(int j=mapa.getYMax()-1;j>=0;j--){
                OcupanteDeCelda celdaActual = mapa.obtenerOcupanteEn(new Posicion(i,j));
                ImageView tile = new ImageView(celdaActual.obtenerImagen(dimensionTile));
                cuadriculaMapa.add(tile,i,j);
            }
        }

    }

    private HBox generarInventarioHerramientas(){
        HBox inventario = new HBox();
        inventario.setAlignment(Pos.BOTTOM_CENTER);
        inventario.setStyle("-fx-background-color: #096346;");
        GridPane itemsInventario = new GridPane();
        itemsInventario.setVgap(0);
        itemsInventario.setHgap(2);
        inventario.setPadding(new Insets(3,0,3,0));

        inventario.getChildren().addAll(itemsInventario);
        actualizarInventarioHerramientas(itemsInventario);

        return inventario;
    }

    public void actualizarInventarioHerramientas(GridPane itemsInventario){
        Juego juego = Juego.getJuego();
        Jugador jugador = juego.getJugador();
        ArrayList<Herramienta> herramientas = jugador.getHerramientas();

        for(int i=0;i<herramientas.size();i++){
            Herramienta herramientaActual = herramientas.get(i);
            ImageView herramienta = new ImageView(herramientaActual.obtenerImagen(40));
            Pane bordeHerramienta = new Pane();
            bordeHerramienta.getChildren().addAll(herramienta);
            bordeHerramienta.setPadding(new Insets(0,0,0,0));
            if(jugador.getHerramientaActual() == herramientaActual){
                bordeHerramienta.setStyle("-fx-border-color: #000000;-fx-border-radius: 2px; -fx-border-width: 2px");
            }else{
                bordeHerramienta.setStyle("-fx-border-color: #AAAAAA;-fx-border-radius: 2px; -fx-border-width: 1px");
            }

            itemsInventario.add(bordeHerramienta,i,0);
        }
    }
}
