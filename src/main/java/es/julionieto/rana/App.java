package es.julionieto.rana;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class App extends Application {
    
    //-----<Personaje>-----//
    Group groupPersonaje;
    double posXPersonaje = 375;
    double posYPersonaje = 570;
    
    //-----<OBEJTOS>-----//
    //-----<PRIMERA PARTE>-----//
    //Coches (Autopista)    
    //Fila 1 (abajo)
    final double posicionFila1Coches = 456.5;
    
    //Fila 2 (Arriba)
    final double posicionFila2Coches = 383.5;
    
    //-----<SEGUNDA PARTE>-----//
    //Troncos (Río)
    //Fila 1 (Abajo)
    final double posicionFila1Tronco = 237.5;
    
    //Fila 2 (Arriba)
    final double posicionFila2Tronco = 165.5;
    
    //Nenúfares (Río)
    //Fila 1 (Abajo)
    final double posicionFila1Nenufar = 273.5;
    
    //Fila 2 (Medio)   
    final double posicionFila2Nenufar = 201.5;
    
    //Fila 3 (Arriba)
    final double posicionFila3Nenufar = 129.5;
    
    //-----<Puntuación>-----//
    int puntuacion = 0;
    Text labelMarcador;
    Text labelGameover;    
    boolean gameOver = false;
    private Object paneInfo;
    
    
    @Override
    public void start(Stage stage) {
        
        //Escena
        Pane paneRoot = new Pane();  
        Scene scene = new Scene(paneRoot, 800, 600, Color.LIGHTGRAY);
        stage.setTitle("Frogger");
        stage.setScene(scene);
        stage.show();
        
        //Imagen de fondo
        Image img = new Image(getClass().getResourceAsStream("/images/Background.png"));
        ImageView imgView = new ImageView(img);
        paneRoot.getChildren().add(imgView);
        
        // Panel contenedor para los elementos animados del juego
        Pane paneScrollJuego = new Pane();
        paneRoot.getChildren().add(paneScrollJuego);
        
        /* --- DIBUJO DEL PERSONAJE --- */
        groupPersonaje = new Group();
        paneScrollJuego.getChildren().add(groupPersonaje);
        
        //Cabeza
        Rectangle cabeza = new Rectangle(40, 20, Color.LIGHTGREEN);
        cabeza.setX(20);
        cabeza.setY(0);
        cabeza.setWidth(10);
        cabeza.setHeight(10);
        groupPersonaje.getChildren().add(cabeza);
        
        Rectangle ojoIzq = new Rectangle(5, 5, Color.BLACK);
        ojoIzq.setX(22);
        ojoIzq.setY(2);
        ojoIzq.setWidth(2);
        ojoIzq.setHeight(2);
        groupPersonaje.getChildren().add(ojoIzq);
        
        Rectangle ojoDer = new Rectangle(5, 5, Color.BLACK);
        ojoDer.setX(26);
        ojoDer.setY(2);
        ojoDer.setWidth(2);
        ojoDer.setHeight(2);
        groupPersonaje.getChildren().add(ojoDer);
        
        //Cuerpo
        Rectangle cuerpo = new Rectangle(40, 20, Color.LIGHTGREEN);
        cuerpo.setX(17.5);
        cuerpo.setY(10);
        cuerpo.setWidth(15);
        cuerpo.setHeight(15);
        groupPersonaje.getChildren().add(cuerpo);
        
        //Piernas delanteras
        Rectangle piernaDelIzq = new Rectangle(40, 20, Color.LIGHTGREEN);
        piernaDelIzq.setX(14);
        piernaDelIzq.setY(14);
        piernaDelIzq.setWidth(4);
        piernaDelIzq.setHeight(2);
        groupPersonaje.getChildren().add(piernaDelIzq);
        
        Rectangle piernaDelDer = new Rectangle(40, 20, Color.LIGHTGREEN);
        piernaDelDer.setX(32);
        piernaDelDer.setY(14);
        piernaDelDer.setWidth(4);
        piernaDelDer.setHeight(2);
        groupPersonaje.getChildren().add(piernaDelDer);
        
        Rectangle pieDelIzq = new Rectangle(40, 20, Color.LIGHTGREEN);
        pieDelIzq.setX(14);
        pieDelIzq.setY(8);
        pieDelIzq.setWidth(4);
        pieDelIzq.setHeight(7);
        groupPersonaje.getChildren().add(pieDelIzq);
        
        Rectangle pieDelDer = new Rectangle(40, 20, Color.LIGHTGREEN);
        pieDelDer.setX(32);
        pieDelDer.setY(8);
        pieDelDer.setWidth(4);
        pieDelDer.setHeight(7);
        groupPersonaje.getChildren().add(pieDelDer);
        
        //Piernas traseras
        Rectangle piernaTraIzq = new Rectangle(40, 20, Color.LIGHTGREEN);
        piernaTraIzq.setX(14);
        piernaTraIzq.setY(20);
        piernaTraIzq.setWidth(7);
        piernaTraIzq.setHeight(5);
        groupPersonaje.getChildren().add(piernaTraIzq);
        Rectangle piernaTraDer = new Rectangle(40, 20, Color.LIGHTGREEN);
        piernaTraDer.setX(29);
        piernaTraDer.setY(20);
        piernaTraDer.setWidth(7);
        piernaTraDer.setHeight(5);
        groupPersonaje.getChildren().add(piernaTraDer);
        
        Rectangle pieTraIzq = new Rectangle(40, 20, Color.LIGHTGREEN);
        pieTraIzq.setX(14);
        pieTraIzq.setY(18);
        pieTraIzq.setWidth(4);
        pieTraIzq.setHeight(2);
        groupPersonaje.getChildren().add(pieTraIzq);
        
        Rectangle pieTraDer = new Rectangle(40, 20, Color.LIGHTGREEN);
        pieTraDer.setX(32);
        pieTraDer.setY(18);
        pieTraDer.setWidth(4);
        pieTraDer.setHeight(2);
        groupPersonaje.getChildren().add(pieTraDer);
        
        // Colocar personaje en su posición de inicio
        groupPersonaje.setLayoutX(posXPersonaje);
        groupPersonaje.setLayoutY(posYPersonaje);
        
        //Coches
        Image coche1 = new Image(getClass().getResourceAsStream("/images/Coche_rojo_der.png"));
        ImageView coche1View = new ImageView(coche1);
        coche1View.setX(770); 
        coche1View.setY(posicionFila1Coches);   
        paneRoot.getChildren().add(coche1View);
        
        Image coche2 = new Image(getClass().getResourceAsStream("/images/Coche_rojo_der.png"));
        ImageView coche2View = new ImageView(coche2);
        coche2View.setX(660); 
        coche2View.setY(posicionFila1Coches);   
        paneRoot.getChildren().add(coche2View);
        
        Image coche3 = new Image(getClass().getResourceAsStream("/images/Coche_amarillo_der.png"));
        ImageView coche3View = new ImageView(coche3);
        coche3View.setX(550); 
        coche3View.setY(posicionFila1Coches);   
        paneRoot.getChildren().add(coche3View);
        
        Image coche4 = new Image(getClass().getResourceAsStream("/images/Coche_rojo_der.png"));
        ImageView coche4View = new ImageView(coche4);
        coche4View.setX(440); 
        coche4View.setY(posicionFila1Coches);   
        paneRoot.getChildren().add(coche4View);
        
        Image coche5 = new Image(getClass().getResourceAsStream("/images/Coche_rojo_der.png"));
        ImageView coche5View = new ImageView(coche5);
        coche5View.setX(330); 
        coche5View.setY(posicionFila1Coches);   
        paneRoot.getChildren().add(coche5View);
        
        Image coche6 = new Image(getClass().getResourceAsStream("/images/Coche_rojo_der.png"));
        ImageView coche6View = new ImageView(coche6);
        coche6View.setX(220); 
        coche6View.setY(posicionFila1Coches);   
        paneRoot.getChildren().add(coche6View);
        
        Image coche7 = new Image(getClass().getResourceAsStream("/images/Coche_amarillo_der.png"));
        ImageView coche7View = new ImageView(coche7);
        coche7View.setX(110); 
        coche7View.setY(posicionFila1Coches);   
        paneRoot.getChildren().add(coche7View);
        
        Image coche8 = new Image(getClass().getResourceAsStream("/images/Coche_amarillo_der.png"));
        ImageView coche8View = new ImageView(coche8);
        coche8View.setX(0); 
        coche8View.setY(posicionFila1Coches);   
        paneRoot.getChildren().add(coche8View);
        
        Image coche9 = new Image(getClass().getResourceAsStream("/images/Coche_amarillo_izq.png"));
        ImageView coche9View = new ImageView(coche9);
        coche9View.setX(710); 
        coche9View.setY(posicionFila2Coches);   
        paneRoot.getChildren().add(coche9View);
        
        Image coche10 = new Image(getClass().getResourceAsStream("/images/Coche_rojo_izq.png"));
        ImageView coche10View = new ImageView(coche10);
        coche10View.setX(600); 
        coche10View.setY(posicionFila2Coches);   
        paneRoot.getChildren().add(coche10View);
        
        Image coche11 = new Image(getClass().getResourceAsStream("/images/Coche_amarillo_izq.png"));
        ImageView coche11View = new ImageView(coche11);
        coche11View.setX(490); 
        coche11View.setY(posicionFila2Coches);   
        paneRoot.getChildren().add(coche11View);
        
        Image coche12 = new Image(getClass().getResourceAsStream("/images/Coche_rojo_izq.png"));
        ImageView coche12View = new ImageView(coche12);
        coche12View.setX(380); 
        coche12View.setY(posicionFila2Coches);   
        paneRoot.getChildren().add(coche12View);
        
        Image coche13 = new Image(getClass().getResourceAsStream("/images/Coche_amarillo_izq.png"));
        ImageView coche13View = new ImageView(coche13);
        coche13View.setX(270); 
        coche13View.setY(posicionFila2Coches);   
        paneRoot.getChildren().add(coche13View);
        
        Image coche14 = new Image(getClass().getResourceAsStream("/images/Coche_amarillo_izq.png"));
        ImageView coche14View = new ImageView(coche14);
        coche14View.setX(160); 
        coche14View.setY(posicionFila2Coches);   
        paneRoot.getChildren().add(coche14View);
        
        Image coche15 = new Image(getClass().getResourceAsStream("/images/Coche_rojo_izq.png"));
        ImageView coche15View = new ImageView(coche15);
        coche15View.setX(50); 
        coche15View.setY(posicionFila2Coches);   
        paneRoot.getChildren().add(coche15View);
        
        //CAMBIAR AL SER EL ULTIMO POSICIÓN INICIAL PUEDE CAMBIAR
        Image coche16 = new Image(getClass().getResourceAsStream("/images/Coche_rojo_izq.png"));
        ImageView coche16View = new ImageView(coche16);
        coche16View.setX(-60); 
        coche16View.setY(posicionFila2Coches);   
        paneRoot.getChildren().add(coche16View);
        
        //Troncos
        Image tronco1 = new Image(getClass().getResourceAsStream("/images/tronco_.jpg"));
        ImageView tronco1View = new ImageView(tronco1);
        tronco1View.setX(50); 
        tronco1View.setY(posicionFila1Tronco);   
        paneRoot.getChildren().add(tronco1View);
        
        Image tronco2 = new Image(getClass().getResourceAsStream("/images/tronco_.jpg"));
        ImageView tronco2View = new ImageView(tronco2);
        tronco2View.setX(250); 
        tronco2View.setY(posicionFila1Tronco);   
        paneRoot.getChildren().add(tronco2View);
        
        Image tronco3 = new Image(getClass().getResourceAsStream("/images/tronco_.jpg"));
        ImageView tronco3View = new ImageView(tronco3);
        tronco3View.setX(450); 
        tronco3View.setY(posicionFila1Tronco);   
        paneRoot.getChildren().add(tronco3View);
        
        Image tronco4 = new Image(getClass().getResourceAsStream("/images/tronco_.jpg"));
        ImageView tronco4View = new ImageView(tronco4);
        tronco4View.setX(650); 
        tronco4View.setY(posicionFila1Tronco);   
        paneRoot.getChildren().add(tronco4View);
        
        Image tronco5 = new Image(getClass().getResourceAsStream("/images/tronco_.jpg"));
        ImageView tronco5View = new ImageView(tronco5);
        tronco5View.setX(150); 
        tronco5View.setY(posicionFila2Tronco);   
        paneRoot.getChildren().add(tronco5View);
        
        Image tronco6 = new Image(getClass().getResourceAsStream("/images/tronco_.jpg"));
        ImageView tronco6View = new ImageView(tronco6);
        tronco6View.setX(350); 
        tronco6View.setY(posicionFila2Tronco);   
        paneRoot.getChildren().add(tronco6View);
        
        Image tronco7 = new Image(getClass().getResourceAsStream("/images/tronco_.jpg"));
        ImageView tronco7View = new ImageView(tronco7);
        tronco7View.setX(550); 
        tronco7View.setY(posicionFila2Tronco);   
        paneRoot.getChildren().add(tronco7View);
        
        Image tronco8 = new Image(getClass().getResourceAsStream("/images/tronco_.jpg"));
        ImageView tronco8View = new ImageView(tronco8);
        tronco8View.setX(750); 
        tronco8View.setY(posicionFila2Tronco);   
        paneRoot.getChildren().add(tronco8View);
        
        //POSICIÓN FINAL DESPUES TELETRANSPORTAR A -150
        Image tronco9 = new Image(getClass().getResourceAsStream("/images/tronco_.jpg"));
        ImageView tronco9View = new ImageView(tronco9);
        tronco9View.setX(850); 
        tronco9View.setY(posicionFila2Tronco);   
        paneRoot.getChildren().add(tronco9View);
        
        Image tronco10 = new Image(getClass().getResourceAsStream("/images/tronco_.jpg"));
        ImageView tronco10View = new ImageView(tronco10);
        tronco10View.setX(-50); 
        tronco10View.setY(posicionFila2Tronco);   
        paneRoot.getChildren().add(tronco10View);
        
        Image nenufar1 = new Image(getClass().getResourceAsStream("/images/Nenufar.png"));
        ImageView nenufar1View = new ImageView(nenufar1);
        nenufar1View.setX(565); 
        nenufar1View.setY(posicionFila1Nenufar);   
        paneRoot.getChildren().add(nenufar1View);
        
        Image nenufar2 = new Image(getClass().getResourceAsStream("/images/Nenufar.png"));
        ImageView nenufar2View = new ImageView(nenufar2);
        nenufar2View.setX(200); 
        nenufar2View.setY(posicionFila2Nenufar);   
        paneRoot.getChildren().add(nenufar2View);
        
        /*Image nenufar3 = new Image(getClass().getResourceAsStream("/images/Nenufar.png"));
        ImageView nenufar3View = new ImageView(nenufar3);
        nenufar3View.setX(200); 
        nenufar3View.setY(93.5);   
        paneRoot.getChildren().add(nenufar3View);*/ //IMAGEN PARA MIRAR LA POSICION FINAL DE LA RANA
        //HAY QUE CAMBIAR EL FONDO
        
        Image nenufar3 = new Image(getClass().getResourceAsStream("/images/Nenufar.png"));
        ImageView nenufar3View = new ImageView(nenufar3);
        nenufar3View.setX(595); 
        nenufar3View.setY(posicionFila1Nenufar);
        paneRoot.getChildren().add(nenufar3View);
        
        Image nenufar4 = new Image(getClass().getResourceAsStream("/images/Nenufar.png"));
        ImageView nenufar4View = new ImageView(nenufar4);
        nenufar4View.setX(765); 
        nenufar4View.setY(posicionFila1Nenufar);
        paneRoot.getChildren().add(nenufar4View);
        
        Image nenufar5 = new Image(getClass().getResourceAsStream("/images/Nenufar.png"));
        ImageView nenufar5View = new ImageView(nenufar5);
        nenufar5View.setX(795); 
        nenufar5View.setY(posicionFila1Nenufar);
        paneRoot.getChildren().add(nenufar5View);
        
        VBox paneInfo = new VBox();
        paneInfo.setPrefWidth(scene.getWidth());
        paneInfo.setAlignment(Pos.CENTER);
        
        // Marcador de puntuación
        labelMarcador = new Text(String.valueOf(puntuacion));
        labelMarcador.setFont(new Font(50));
        labelMarcador.setFill(Color.WHITE);
        
        // Texto de fin de partida
        labelGameover = new Text("Fin de partida");
        labelGameover.setVisible(false);
        labelGameover.setFont(new Font(50));
        labelGameover.setFill(Color.WHITE);
        
        paneInfo.getChildren().add(labelMarcador);
        paneInfo.getChildren().add(labelGameover);
        paneRoot.getChildren().add(paneInfo);
        
    }

    public static void main(String[] args) {
        launch();
    }

}