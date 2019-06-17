package vista;

import controladores.menuPrincipal.ControlScrollHandler;
import controladores.menuPrincipal.ControlesMovimientoHandler;
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
    private GridPane cuadriculaMapa;
    private GridPane itemsInventario;

    public VistaJuego(){
        cuadriculaMapa = new GridPane();
        itemsInventario = new GridPane();
    }


    public Scene generarVistaJuego(){

        BorderPane contenedorPrincipal = new BorderPane();
        cuadriculaMapa.setHgap(0);
        cuadriculaMapa.setVgap(0);
        cuadriculaMapa.setPadding(new Insets(0,0,0,0));

        Juego juego = Juego.getJuego();
        Mapa mapa = juego.getMapa();
        juego.generarRecursos();
        int widthVentana = mapa.getXMax()*dimensionTile;
        int heightVentana = mapa.getYMax()*dimensionTile;

        dibujarMapa();

        juego.getJugador().guardar(FabricaHerramientas.crearHachaDePiedra());
        juego.getJugador().guardar(FabricaHerramientas.crearPicoDeMetal());
        juego.getJugador().guardar(FabricaHerramientas.crearPicoFino());
        juego.getJugador().guardar(FabricaHerramientas.crearPicoDeMadera());

        HBox inventarioHerramientas = generarInventarioHerramientas();

        contenedorPrincipal.setBottom(inventarioHerramientas);
        contenedorPrincipal.setCenter(cuadriculaMapa);
        Scene escena = new Scene(contenedorPrincipal,contenedorPrincipal.getPrefWidth(),contenedorPrincipal.getPrefHeight());

        escena.setOnKeyPressed(new ControlesMovimientoHandler(this));
        escena.setOnScroll(new ControlScrollHandler(this));

        return escena;
    }

    public void dibujarMapa(){
        Juego juego = Juego.getJuego();
        Mapa mapa = juego.getMapa();

        for(int i=0;i<mapa.getXMax();i++){

            for(int j=mapa.getYMax()-1;j>0;j--){

                OcupanteDeCelda celdaActual = mapa.obtenerOcupanteEn(new Posicion(i,j));
                ImageView tile = new ImageView(celdaActual.obtenerImagen(dimensionTile));
                cuadriculaMapa.add(tile,i,mapa.getYMax()-j);

            }

        }

    }

    private HBox generarInventarioHerramientas(){
        HBox inventario = new HBox();
        inventario.setAlignment(Pos.BOTTOM_CENTER);
        inventario.setStyle("-fx-background-color: #096346;");
        itemsInventario.setVgap(0);
        itemsInventario.setHgap(2);
        inventario.setPadding(new Insets(3,0,3,0));

        inventario.getChildren().addAll(itemsInventario);
        actualizarInventarioHerramientas();

        return inventario;
    }

    public void actualizarInventarioHerramientas(){
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
                bordeHerramienta.setStyle("-fx-border-color: #000000;-fx-border-radius: 2px; -fx-border-width: 1px");
            }else{
                bordeHerramienta.setStyle("-fx-border-color: #AAAAAA;-fx-border-radius: 2px; -fx-border-width: 1px");
            }

            itemsInventario.add(bordeHerramienta,i,0);
        }
    }
}
