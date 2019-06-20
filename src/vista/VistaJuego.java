package vista;

import controladores.menuPrincipal.BotonConstructorHandler;
import controladores.menuPrincipal.ControlScrollHandler;
import controladores.menuPrincipal.ControlesMovimientoHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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
    private GridPane itemsInventarioHerramientas;
    private GridPane itemsInventario;

    private Label etiquetaCantidadMadera;
    private Label etiquetaCantidadPiedra;
    private Label etiquetaCantidadMetal;
    private Label etiquetaCantidadDiamante;

    private HashMap<String, Image> imagenes;

    private BotonConstructorHandler constructorHandler;

    public VistaJuego(){
        cuadriculaMapa = new GridPane();
        itemsInventarioHerramientas = new GridPane();
        itemsInventario = new GridPane();

        etiquetaCantidadMadera = new Label();
        etiquetaCantidadPiedra = new Label();
        etiquetaCantidadMetal = new Label();
        etiquetaCantidadDiamante = new Label();

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
        juego.resetear();

        dibujarMapa();

        juego.getJugador().guardar(FabricaHerramientas.crearHachaDePiedra());
        juego.getJugador().guardar(FabricaHerramientas.crearPicoDeMetal());
        juego.getJugador().guardar(FabricaHerramientas.crearPicoFino());
        juego.getJugador().guardar(FabricaHerramientas.crearPicoDeMadera());

        GridPane inventarioHerramientas = generarInventario();

        contenedorPrincipal.setBottom(inventarioHerramientas);
        contenedorPrincipal.setCenter(cuadriculaMapa);

        Scene escena = new Scene(contenedorPrincipal,contenedorPrincipal.getPrefWidth(),contenedorPrincipal.getPrefHeight());

        escena.setOnKeyPressed(new ControlesMovimientoHandler(this, constructorHandler));
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

    private GridPane generarInventario(){

        GridPane inventario = new GridPane();

        //Inventario Herramientas

        itemsInventarioHerramientas.setVgap(0);
        itemsInventarioHerramientas.setHgap(2);
        itemsInventarioHerramientas.setAlignment(Pos.CENTER);
        inventario.setPadding(new Insets(3,0,3,0));

        actualizarInventarioHerramientas();


        //Inventario
        ImageView viewMadera = new ImageView(new Image("media/recursos/madera.png",40,40,false,false));
        itemsInventario.add(viewMadera,0,0);

        ImageView viewPiedra = new ImageView(new Image("media/recursos/piedra.png",40,40,false,false));
        itemsInventario.add(viewPiedra,1,0);

        ImageView viewMetal = new ImageView(new Image("media/recursos/metal.png",40,40,false,false));
        itemsInventario.add(viewMetal,2,0);

        ImageView viewDiamante = new ImageView(new Image("media/recursos/diamante.png",40,40,false,false));
        itemsInventario.add(viewDiamante,3,0);

        itemsInventario.add(etiquetaCantidadMadera,0,1);
        itemsInventario.setHalignment(etiquetaCantidadMadera, HPos.CENTER);

        itemsInventario.add(etiquetaCantidadPiedra,1,1);
        itemsInventario.setHalignment(etiquetaCantidadPiedra, HPos.CENTER);

        itemsInventario.add(etiquetaCantidadMetal,2,1);
        itemsInventario.setHalignment(etiquetaCantidadMetal, HPos.CENTER);

        itemsInventario.add(etiquetaCantidadDiamante,3,1);
        itemsInventario.setHalignment(etiquetaCantidadDiamante, HPos.CENTER);

        itemsInventario.setPadding(new Insets(0,0,0,10));

        String estiloEtiquetas = "-fx-font-size: 15;-fx-font-weight: bold;-fx-text-fill: #ffffff";

        etiquetaCantidadMadera.setStyle(estiloEtiquetas);

        etiquetaCantidadPiedra.setStyle(estiloEtiquetas);
        etiquetaCantidadMetal.setStyle(estiloEtiquetas);
        etiquetaCantidadDiamante.setStyle(estiloEtiquetas);

        actualizarInventario();

        //Constructor
        ImageView iconoConstructor = new ImageView(imagenes.get("picoMadera.png"));
        Button botonConstructor = new Button("", iconoConstructor);
        constructorHandler = new BotonConstructorHandler(this);
        botonConstructor.setOnAction(constructorHandler);
        botonConstructor.setDefaultButton(false);
        botonConstructor.setCancelButton(false);

        botonConstructor.setDisable(true); //No puedo hacer que cuando toco space no se presione.

        ColumnConstraints espacioInventario = new ColumnConstraints();
        espacioInventario.setPercentWidth(33);

        ColumnConstraints espacioInventarioHerramientas = new ColumnConstraints();
        espacioInventarioHerramientas.setPercentWidth(33);

        ColumnConstraints espacioConstructor = new ColumnConstraints();
        espacioConstructor.setPercentWidth(33);
        espacioConstructor.setHalignment(HPos.CENTER);
        inventario.getColumnConstraints().addAll(espacioInventario,espacioInventarioHerramientas,espacioConstructor);

        inventario.add(itemsInventario,0,0);
        inventario.add(itemsInventarioHerramientas,1,0);
        inventario.add(botonConstructor, 2, 0);

        BackgroundImage fondo = new BackgroundImage(new Image("media/hud.jpg",70,70,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        inventario.setBackground(new Background(fondo));

        return inventario;
    }

    public void actualizarInventarioHerramientas(){
        Juego juego = Juego.getJuego();
        Jugador jugador = juego.getJugador();
        ArrayList<Herramienta> herramientas = jugador.getHerramientas();

        itemsInventarioHerramientas.getChildren().clear();

        for(int i=0;i<herramientas.size();i++){
            Herramienta herramientaActual = herramientas.get(i);

            if(jugador.getHerramientaActual() == herramientaActual){
                //Herramienta Actual
                ImageView viewHerramientaActual = new ImageView(imagenes.get(herramientaActual.obtenerImagen()));

                BorderPane bordeHerramientaActual = new BorderPane();
                bordeHerramientaActual.setCenter(viewHerramientaActual);
                bordeHerramientaActual.setStyle("-fx-border-color: #000000;-fx-border-radius: 2px; -fx-border-width: 4px");
                itemsInventarioHerramientas.add(bordeHerramientaActual,1,0);

                //Herramienta Anterior
                Herramienta herramientaAnterior = herramientas.get(Math.floorMod(i-1,herramientas.size()));
                ImageView viewHerramientaAnterior = new ImageView(imagenes.get(herramientaAnterior.obtenerImagen()));
                BorderPane bordeHerramientaAnterior = new BorderPane();
                bordeHerramientaAnterior.setCenter(viewHerramientaAnterior);
                bordeHerramientaAnterior.setStyle("-fx-border-color: #AAAAAA;-fx-border-radius: 2px; -fx-border-width: 1px");
                itemsInventarioHerramientas.add(bordeHerramientaAnterior,0,0);

                //Herramienta Siguiente
                Herramienta herramientaSiguiente = herramientas.get(Math.floorMod(i+1,herramientas.size()));
                ImageView viewHerramientaSiguiente = new ImageView(imagenes.get(herramientaSiguiente.obtenerImagen()));
                BorderPane bordeHerramientaSiguiente = new BorderPane();
                bordeHerramientaSiguiente.setCenter(viewHerramientaSiguiente);
                bordeHerramientaSiguiente.setStyle("-fx-border-color: #AAAAAA;-fx-border-radius: 2px; -fx-border-width: 1px");
                itemsInventarioHerramientas.add(bordeHerramientaSiguiente,2,0);
            }

        }
    }

    public void actualizarInventario(){
        int cantidadMadera = Juego.getJuego().getJugador().getInventarioMateriales().cantidadMadera();
        etiquetaCantidadMadera.setText(Integer.toString(cantidadMadera));

        int cantidadPiedra = Juego.getJuego().getJugador().getInventarioMateriales().cantidadPiedra();
        etiquetaCantidadPiedra.setText(Integer.toString(cantidadPiedra));

        int cantidadMetal = Juego.getJuego().getJugador().getInventarioMateriales().cantidadMetal();
        etiquetaCantidadMetal.setText(Integer.toString(cantidadMetal));

        int cantidadDiamante = Juego.getJuego().getJugador().getInventarioMateriales().cantidadDiamante();
        etiquetaCantidadDiamante.setText(Integer.toString(cantidadDiamante));
    }

}
