package vista;

import controladores.BotonCeldaConstructorHandler;
import controladores.BotonMaterialConstructorHandler;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.RowConstraints;
import modelo.Juego;
import modelo.herramientas.*;
import modelo.jugador.InventarioMateriales;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.function.Supplier;

import static javafx.scene.paint.Color.YELLOW;

public class VistaConstructor {

    private final int getDimensionTileConstructor = 40;

    private VistaJuego vistaJuego;

    private GridPane constructorHerramientas;
    private GridPane cuadriculaConstructorHerramientas;
    private GridPane itemsInventario;
    private GridPane resultadoConstructor;
    private GridPane resultadoConstructorImagen;
    private GridPane resultadoConstructorBotonConstruir;

    private String resultado;

    private Label etiquetaCantidadMadera;
    private Label etiquetaCantidadPiedra;
    private Label etiquetaCantidadMetal;
    private Label etiquetaCantidadDiamante;

    private HashMap<String, Image> imagenes;

    private HashMap<Integer, String> materialesDispuestos;

    private HashMap<String, Supplier[]> funciones;

    private HashMap<String, Integer> codigosConstructor;
    
    private String materialActual = "Vacio";

    private Lighting efectoSeleccion;

    public VistaConstructor(VistaJuego vistaJuego) {
        constructorHerramientas = new GridPane();
        cuadriculaConstructorHerramientas = new GridPane();
        itemsInventario = new GridPane();
        resultadoConstructor = new GridPane();
        resultadoConstructorImagen = new GridPane();
        resultadoConstructorBotonConstruir = new GridPane();

        etiquetaCantidadMadera = new Label();
        etiquetaCantidadPiedra = new Label();
        etiquetaCantidadMetal = new Label();
        etiquetaCantidadDiamante = new Label();

        this.vistaJuego = vistaJuego;

        imagenes = new HashMap<>();
        cargarImagenes();

        funciones = new HashMap<>();
        cargarFunciones();

        materialesDispuestos = new HashMap<>();
        vaciarMaterialesDispuestos();

        codigosConstructor = new HashMap<>();
        cargarCodigosConstructor();

        resultado = "Vacio";

        efectoSeleccion = new Lighting();
        efectoSeleccion.setDiffuseConstant(1.0);
        efectoSeleccion.setSpecularConstant(0.0);
        efectoSeleccion.setSpecularExponent(0.0);
        efectoSeleccion.setSurfaceScale(0.0);
        efectoSeleccion.setLight(new Light.Distant(45, 45, YELLOW));
    }

    private void cargarImagenes(){
        Image constructorCeldaVacia = new Image("media/textures/tileConstructorCeldaVacia.png", getDimensionTileConstructor, getDimensionTileConstructor, false, false);
        imagenes.put("Vacio",constructorCeldaVacia);

        Image flechaConstructor = new Image("media/textures/flechaConstructor.png", getDimensionTileConstructor, getDimensionTileConstructor, false, false);
        imagenes.put("Flecha",flechaConstructor);
        
        Image madera = new Image("media/textures/tileConstructorMadera.png", getDimensionTileConstructor, getDimensionTileConstructor, false, false);
        imagenes.put("Madera", madera);

        Image metal = new Image("media/textures/tileConstructorMetal.png", getDimensionTileConstructor, getDimensionTileConstructor, false, false);
        imagenes.put("Metal", metal);

        Image piedra = new Image("media/textures/tileConstructorPiedra.png", getDimensionTileConstructor, getDimensionTileConstructor, false, false);
        imagenes.put("Piedra", piedra);

        Image diamante = new Image("media/textures/tileConstructorDiamante.png", getDimensionTileConstructor, getDimensionTileConstructor, false, false);
        imagenes.put("Diamante", diamante);

        Image hachaMadera = new Image("media/herramientas/hachaMadera.png",getDimensionTileConstructor ,getDimensionTileConstructor ,false,false);
        Herramienta hachaDeMadera = FabricaHerramientas.crearHachaDeMadera();
        imagenes.put(Integer.toString(hachaDeMadera.getId()),hachaMadera);

        Image hachaMetal = new Image("media/herramientas/hachaMetal.png",getDimensionTileConstructor ,getDimensionTileConstructor ,false,false);
        Herramienta hachaDeMetal = FabricaHerramientas.crearHachaDeMetal();
        imagenes.put(Integer.toString(hachaDeMetal.getId()),hachaMetal);

        Image hachaPiedra = new Image("media/herramientas/hachaPiedra.png",getDimensionTileConstructor ,getDimensionTileConstructor ,false,false);
        Herramienta hachaDePiedra = FabricaHerramientas.crearHachaDePiedra();
        imagenes.put(Integer.toString(hachaDePiedra.getId()),hachaPiedra);

        Image picoMadera = new Image("media/herramientas/picoMadera.png",getDimensionTileConstructor ,getDimensionTileConstructor ,false,false);
        Herramienta picoDeMadera = FabricaHerramientas.crearPicoDeMadera();
        imagenes.put(Integer.toString(picoDeMadera.getId()),picoMadera);

        Image picoPiedra = new Image("media/herramientas/picoPiedra.png",getDimensionTileConstructor,getDimensionTileConstructor,false,false);
        Herramienta picoDePiedra = FabricaHerramientas.crearPicoDePiedra();
        imagenes.put(Integer.toString(picoDePiedra.getId()),picoPiedra);

        Image picoMetal = new Image("media/herramientas/picoMetal.png",getDimensionTileConstructor,getDimensionTileConstructor,false,false);
        Herramienta picoDeMetal = FabricaHerramientas.crearPicoDeMetal();
        imagenes.put(Integer.toString(picoDeMetal.getId()),picoMetal);

        Image picoFino = new Image("media/herramientas/picoFino.png",getDimensionTileConstructor,getDimensionTileConstructor,false,false);
        Herramienta picoF = FabricaHerramientas.crearPicoFino();
        imagenes.put(Integer.toString(picoF.getId()),picoFino);

        imagenes.put("0",constructorCeldaVacia);
    }

    private void cargarFunciones(){
        InventarioMateriales inventarioMateriales = Juego.getJuego().getJugador().getInventarioMateriales();

        Supplier[] funcionesMadera = {() -> inventarioMateriales.getMadera(), () -> inventarioMateriales.agregarMadera(), () -> inventarioMateriales.cantidadMadera()};
        Supplier[] funcionesPiedra = {() -> inventarioMateriales.getPiedra(), () -> inventarioMateriales.agregarPiedra(), () -> inventarioMateriales.cantidadPiedra()};
        Supplier[] funcionesMetal = {() -> inventarioMateriales.getMetal(), () -> inventarioMateriales.agregarMetal(), () -> inventarioMateriales.cantidadMetal()};
        Supplier[] funcionesDiamante = {() -> inventarioMateriales.getDiamante(), () -> inventarioMateriales.agregarDiamante(), () -> inventarioMateriales.cantidadDiamante()};
        Supplier[] funcionesVacio = {() -> 0, () -> 0, () -> 0};

        funciones.put("Madera", funcionesMadera);
        funciones.put("Piedra", funcionesPiedra);
        funciones.put("Metal", funcionesMetal);
        funciones.put("Diamante", funcionesDiamante);
        funciones.put("Vacio", funcionesVacio);
    }

    private void cargarCodigosConstructor(){
        codigosConstructor.put("Vacio", 0);
        codigosConstructor.put("Madera", 1);
        codigosConstructor.put("Piedra", 2);
        codigosConstructor.put("Metal", 3);
        codigosConstructor.put("Diamante", 4);
    }


    public Scene generarVistaConstructor(){

        BorderPane contenedorPrincipal = new BorderPane();

        dibujarConstructor();
        dibujarItemsInventario();

        vistaJuego.actualizarInventario();

        contenedorPrincipal.setBottom(itemsInventario);
        BorderPane.setMargin(itemsInventario, new Insets(25,0,0,0));

        contenedorPrincipal.setCenter(constructorHerramientas);
        BorderPane.setMargin(constructorHerramientas, new Insets(25,0,0,0));


        Scene escena = new Scene(contenedorPrincipal,contenedorPrincipal.getPrefWidth(),contenedorPrincipal.getPrefHeight());

        //escena.setOnKeyPressed(new ControlesMovimientoConstructorHandler(this));

        return escena;
    }

    public void dibujarConstructor(){

        cuadriculaConstructorHerramientas.setHgap(0);
        cuadriculaConstructorHerramientas.setVgap(0);
        cuadriculaConstructorHerramientas.setPadding(new Insets(0,0,0,8));
        cuadriculaConstructorHerramientas.setAlignment(Pos.CENTER);

        resultadoConstructor.setVgap(15);
        resultadoConstructor.setHgap(10);
        resultadoConstructor.setAlignment(Pos.CENTER);
        resultadoConstructor.setPadding(new Insets(0,0,0,0));

        resultadoConstructorImagen.setAlignment(Pos.CENTER);
        resultadoConstructorImagen.setPadding(new Insets(0,0,0,0));
        resultadoConstructorBotonConstruir.setAlignment(Pos.BASELINE_LEFT);
        resultadoConstructorBotonConstruir.setPadding(new Insets(0,0,0,0));

        ImageView flechaConstructor = new ImageView(imagenes.get("Flecha"));

        actualizarVistaConstructor();

        ColumnConstraints espacioCuadriculaConstructor = new ColumnConstraints();
        espacioCuadriculaConstructor.setPercentWidth(50);
        espacioCuadriculaConstructor.setHalignment(HPos.LEFT);

        ColumnConstraints espacioFlechaConstructor = new ColumnConstraints();
        espacioFlechaConstructor.setPercentWidth(15);
        espacioFlechaConstructor.setHalignment(HPos.RIGHT);

        ColumnConstraints espacioResultadoConstructor = new ColumnConstraints();
        espacioResultadoConstructor.setPercentWidth(35);
        espacioResultadoConstructor.setHalignment(HPos.CENTER);

        constructorHerramientas.getChildren().clear();
        constructorHerramientas.getColumnConstraints().addAll(espacioCuadriculaConstructor,espacioFlechaConstructor,espacioResultadoConstructor);
        constructorHerramientas.add(cuadriculaConstructorHerramientas, 0, 0);
        constructorHerramientas.add(flechaConstructor, 1, 0);
        constructorHerramientas.add(resultadoConstructor, 2, 0);
    }

    public void actualizarVistaConstructor(){

        int numeroDeCelda;
        cuadriculaConstructorHerramientas.getChildren().clear();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                numeroDeCelda = i+j*3;
                ImageView tileCelda = new ImageView(imagenes.get(materialesDispuestos.get(numeroDeCelda)));
                Button botonCelda = new Button("", tileCelda);
                botonCelda.setOnAction(new BotonCeldaConstructorHandler(this, numeroDeCelda));
                cuadriculaConstructorHerramientas.add(botonCelda,i,j);
            }
        }

        int cantidadMadera = Juego.getJuego().getJugador().getInventarioMateriales().cantidadMadera();
        etiquetaCantidadMadera.setText(Integer.toString(cantidadMadera));

        int cantidadPiedra = Juego.getJuego().getJugador().getInventarioMateriales().cantidadPiedra();
        etiquetaCantidadPiedra.setText(Integer.toString(cantidadPiedra));

        int cantidadMetal = Juego.getJuego().getJugador().getInventarioMateriales().cantidadMetal();
        etiquetaCantidadMetal.setText(Integer.toString(cantidadMetal));

        int cantidadDiamante = Juego.getJuego().getJugador().getInventarioMateriales().cantidadDiamante();
        etiquetaCantidadDiamante.setText(Integer.toString(cantidadDiamante));

        ImageView imagenResultadoConstructor = new ImageView(imagenes.get(resultado));

        Button botonConstruir = new Button("Construir");
        botonConstruir.setOnAction((event) -> {
            construir(false);
            vistaJuego.actualizarInventarioHerramientas();
        });

        resultadoConstructorBotonConstruir.getChildren().clear();
        resultadoConstructorBotonConstruir.add(botonConstruir, 0, 1);

        resultadoConstructorImagen.getChildren().clear();
        resultadoConstructorImagen.add(imagenResultadoConstructor, 0 , 1);

        resultadoConstructor.getChildren().clear();
        resultadoConstructor.add(resultadoConstructorImagen, 0, 1);
        resultadoConstructor.add(resultadoConstructorBotonConstruir,0,2);
    }

    public void dibujarItemsInventario(){

        itemsInventario.setVgap(0);
        itemsInventario.setHgap(5);
        itemsInventario.setAlignment(Pos.CENTER);
        itemsInventario.setPadding(new Insets(0,0,0,10));

        ToggleGroup grupoBotones = new ToggleGroup();

        ImageView viewMadera = new ImageView(new Image("media/recursos/madera.png",40,40,false,false));
        ToggleButton botonMadera = new ToggleButton("", viewMadera);
        itemsInventario.add(botonMadera,0,0);
        botonMadera.setToggleGroup(grupoBotones);
        botonMadera.setOnAction(new BotonMaterialConstructorHandler(botonMadera, this, "Madera"));

        ImageView viewPiedra = new ImageView(new Image("media/recursos/piedra.png",40,40,false,false));
        ToggleButton botonPiedra = new ToggleButton("", viewPiedra);
        itemsInventario.add(botonPiedra,1,0);
        botonPiedra.setToggleGroup(grupoBotones);
        botonPiedra.setOnAction(new BotonMaterialConstructorHandler(botonPiedra, this, "Piedra"));

        ImageView viewMetal = new ImageView(new Image("media/recursos/metal.png",40,40,false,false));
        ToggleButton botonMetal = new ToggleButton("", viewMetal);
        itemsInventario.add(botonMetal,2,0);
        botonMetal.setToggleGroup(grupoBotones);
        botonMetal.setOnAction(new BotonMaterialConstructorHandler(botonMetal, this, "Metal"));


        ImageView viewDiamante = new ImageView(new Image("media/recursos/diamante.png",40,40,false,false));
        ToggleButton botonDiamante = new ToggleButton("", viewDiamante);
        itemsInventario.add(botonDiamante,3,0);
        botonDiamante.setToggleGroup(grupoBotones);
        botonDiamante.setOnAction(new BotonMaterialConstructorHandler(botonDiamante, this, "Diamante"));


        itemsInventario.add(etiquetaCantidadMadera,0,1);
        itemsInventario.setHalignment(etiquetaCantidadMadera, HPos.CENTER);

        itemsInventario.add(etiquetaCantidadPiedra,1,1);
        itemsInventario.setHalignment(etiquetaCantidadPiedra, HPos.CENTER);

        itemsInventario.add(etiquetaCantidadMetal,2,1);
        itemsInventario.setHalignment(etiquetaCantidadMetal, HPos.CENTER);

        itemsInventario.add(etiquetaCantidadDiamante,3,1);
        itemsInventario.setHalignment(etiquetaCantidadDiamante, HPos.CENTER);

        String estiloEtiquetas = "-fx-font-size: 15;-fx-font-weight: bold;-fx-text-fill: #000000";

        etiquetaCantidadMadera.setStyle(estiloEtiquetas);

        etiquetaCantidadPiedra.setStyle(estiloEtiquetas);
        etiquetaCantidadMetal.setStyle(estiloEtiquetas);
        etiquetaCantidadDiamante.setStyle(estiloEtiquetas);

        actualizarVistaConstructor();
    }

    public void vaciarMaterialesDispuestos(){
        for (int i=0; i<9; i++){ materialesDispuestos.put(i,"Vacio"); }
    }

    public void construir(boolean preview){
        int[] receta = new int[9];
        for (int i=0; i<9; i++){ receta[i] = codigosConstructor.get(materialesDispuestos.get(i)); }
        int idConstruccion;

        if(preview){
            idConstruccion = Juego.getJuego().getConstructor().comprobarReceta(receta);
            resultado = Integer.toString(idConstruccion);
        }
        else{
            idConstruccion = Juego.getJuego().getConstructor().construir(receta);
            if(idConstruccion != 0){
                vaciarMaterialesDispuestos();
                resultado = Integer.toString(0);
            }
        }
        actualizarVistaConstructor();
    }

    public void setMaterialActual(String material){ this.materialActual = material; }

    public void setMaterial(int numeroDeCelda){
        int cantidadMaterialDisponible = (int)(funciones.get(materialActual)[2].get());

        if (cantidadMaterialDisponible > 0 || materialActual.equals("Vacio")){
            this.funciones.get(this.materialesDispuestos.get(numeroDeCelda))[1].get(); //Vuelvo a agregar material al inventario si celda estaba ocupada
            funciones.get(materialActual)[0].get();
            this.materialesDispuestos.put(numeroDeCelda, materialActual);
        }
        vistaJuego.actualizarInventario();
        actualizarVistaConstructor();
    }
}
