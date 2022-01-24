package es.julionieto.rana;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
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
    
    //Personaje
    Group groupPersonaje;
    double posXPersonaje = 375;
    double posYPersonaje = 570;
    
    
    //Puntuación
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
        Image img = new Image(getClass().getResourceAsStream("/images/BackgroundResized.png"));
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
        Rectangle coche1 = new Rectangle (30, 30, Color.RED);
        coche1.setX(770);
        coche1.setY(452.5);
        paneRoot.getChildren().add(coche1);
        
        Rectangle coche2 = new Rectangle (30, 30, Color.RED);
        coche2.setX(670);
        coche2.setY(452.5);
        paneRoot.getChildren().add(coche2);
        
        Rectangle coche3 = new Rectangle (30, 30, Color.RED);
        coche3.setX(570);
        coche3.setY(452.5);
        paneRoot.getChildren().add(coche3);
        
        Rectangle coche4 = new Rectangle (30, 30, Color.RED);
        coche4.setX(470);
        coche4.setY(452.5);
        paneRoot.getChildren().add(coche4);
        
        Rectangle coche5 = new Rectangle (30, 30, Color.RED);
        coche5.setX(370);
        coche5.setY(452.5);
        paneRoot.getChildren().add(coche5);
        
        Rectangle coche6 = new Rectangle (30, 30, Color.RED);
        coche6.setX(270);
        coche6.setY(452.5);
        paneRoot.getChildren().add(coche6);
        
        Rectangle coche7 = new Rectangle (30, 30, Color.RED);
        coche7.setX(170);
        coche7.setY(452.5);
        paneRoot.getChildren().add(coche7);
        
        Rectangle coche8 = new Rectangle (30, 30, Color.RED);
        coche8.setX(60);
        coche8.setY(452.5);
        paneRoot.getChildren().add(coche8);
        
        Rectangle coche9 = new Rectangle (30, 30, Color.RED);
        coche9.setX(720);
        coche9.setY(379.5);
        paneRoot.getChildren().add(coche9);
        
        Rectangle coche10 = new Rectangle (30, 30, Color.RED);
        coche10.setX(620);
        coche10.setY(379.5);
        paneRoot.getChildren().add(coche10);
        
        Rectangle coche11 = new Rectangle (30, 30, Color.RED);
        coche11.setX(520);
        coche11.setY(379.5);
        paneRoot.getChildren().add(coche11);
        
        Rectangle coche12 = new Rectangle (30, 30, Color.RED);
        coche12.setX(420);
        coche12.setY(379.5);
        paneRoot.getChildren().add(coche12);
        
        Rectangle coche13 = new Rectangle (30, 30, Color.RED);
        coche13.setX(320);
        coche13.setY(379.5);
        paneRoot.getChildren().add(coche13);
        
        Rectangle coche14 = new Rectangle (30, 30, Color.RED);
        coche14.setX(220);
        coche14.setY(379.5);
        paneRoot.getChildren().add(coche14);
        
        Rectangle coche15 = new Rectangle (30, 30, Color.RED);
        coche15.setX(120);
        coche15.setY(379.5);
        paneRoot.getChildren().add(coche15);
        
        Rectangle coche16 = new Rectangle (30, 30, Color.RED);
        coche16.setX(10);
        coche16.setY(379.5);
        paneRoot.getChildren().add(coche16);
        
        
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