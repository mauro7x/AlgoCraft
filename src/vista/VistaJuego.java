package vista;

import controladores.menuPrincipal.ControlScrollHandler;
import controladores.menuPrincipal.ControlesMovimientoHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
import java.util.HashMap;

public class VistaJuego {

    private final int dimensionTile = 50;
    private final int dimensionHerramienta = 40;

    private GridPane cuadriculaMapa;
    private GridPane itemsInventario;
    private HashMap<String, Image> imagenes;



    public VistaJuego(){
        cuadriculaMapa = new GridPane();
        itemsInventario = new GridPane();
        imagenes = new HashMap<>();
        cargarImagenes();
    }

    private void cargarImagenes(){
        Image celdaVacia = new Image("media/textures/tileCeldaVacia2.png",dimensionTile ,dimensionTile ,false,false);
        imagenes.put("tileCeldaVacia2.png",celdaVacia);

        Image tileDiamante = new Image("media/textures/tileDiamante.png",dimensionTile ,dimensionTile ,false,false);
        imagenes.put("tileDiamante.png",tileDiamante);

        Image tileMadera = new Image("media/textures/tileMadera.png",dimensionTile ,dimensionTile ,false,false);
        imagenes.put("tileMadera.png",tileMadera);

        Image tileMetal = new Image("media/textures/tileMetal.png",dimensionTile ,dimensionTile ,false,false);
        imagenes.put("tileMetal.png",tileMetal);

        Image tilePiedra = new Image("media/textures/tilePiedra.png",dimensionTile ,dimensionTile ,false,false);
        imagenes.put("tilePiedra.png",tilePiedra);

        Image jugadorArriba = new Image("media/jugador/jugadorArriba.png",dimensionTile ,dimensionTile ,false,false);
        imagenes.put("jugadorArriba.png",jugadorArriba);

        Image jugadorAbajo = new Image("media/jugador/jugadorAbajo.png",dimensionTile ,dimensionTile ,false,false);
        imagenes.put("jugadorAbajo.png",jugadorAbajo);

        Image jugadorDerecha = new Image("media/jugador/jugadorDerecha.png",dimensionTile ,dimensionTile ,false,false);
        imagenes.put("jugadorDerecha.png",jugadorDerecha);

        Image jugadorIzquierda = new Image("media/jugador/jugadorIzquierda.png",dimensionTile ,dimensionTile ,false,false);
        imagenes.put("jugadorIzquierda.png",jugadorIzquierda);

        Image hachaMadera = new Image("media/herramientas/hachaMadera.png",dimensionHerramienta ,dimensionHerramienta ,false,false);
        imagenes.put("hachaMadera.png",hachaMadera);

        Image hachaMetal = new Image("media/herramientas/hachaMetal.png",dimensionHerramienta ,dimensionHerramienta ,false,false);
        imagenes.put("hachaMetal.png",hachaMetal);

        Image hachaPiedra = new Image("media/herramientas/hachaPiedra.png",dimensionHerramienta ,dimensionHerramienta ,false,false);
        imagenes.put("hachaPiedra.png",hachaPiedra);

        Image picoMadera = new Image("media/herramientas/picoMadera.png",dimensionHerramienta ,dimensionHerramienta ,false,false);
        imagenes.put("picoMadera.png",picoMadera);

        Image picoPiedra = new Image("media/herramientas/picoPiedra.png",dimensionHerramienta,dimensionHerramienta,false,false);
        imagenes.put("picoPiedra.png",picoPiedra);

        Image picoMetal = new Image("media/herramientas/picoMetal.png",dimensionHerramienta,dimensionHerramienta,false,false);
        imagenes.put("picoMetal.png",picoMetal);

        Image picoFino = new Image("media/herramientas/picoFino.png",dimensionHerramienta,dimensionHerramienta,false,false);
        imagenes.put("picoFino.png",picoFino);
    }

    public Scene generarVistaJuego(){

        BorderPane contenedorPrincipal = new BorderPane();
        cuadriculaMapa.setHgap(0);
        cuadriculaMapa.setVgap(0);
        cuadriculaMapa.setPadding(new Insets(0,0,0,0));

        Juego juego = Juego.getJuego();
        juego.generarRecursos();

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

        cuadriculaMapa.getChildren().clear();
        for(int i=0;i<mapa.getXMax();i++){
            for(int j=mapa.getYMax()-1;j>=0;j--){
                OcupanteDeCelda celdaActual = mapa.obtenerOcupanteEn(new Posicion(i,j));
                ImageView tile = new ImageView(imagenes.get(celdaActual.obtenerImagen()));
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

        itemsInventario.getChildren().clear();

        for(int i=0;i<herramientas.size();i++){
            Herramienta herramientaActual = herramientas.get(i);
            ImageView herramienta = new ImageView(imagenes.get(herramientaActual.obtenerImagen()));
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
