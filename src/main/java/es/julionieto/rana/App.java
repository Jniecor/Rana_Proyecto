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
    
    //Personaje
    Group groupPersonaje;
    double posXPersonaje = 370;
    double posYPersonaje = 560;
    
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
        stage.setTitle("PongFX");
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
        cabeza.setWidth(20);
        cabeza.setHeight(20);
        groupPersonaje.getChildren().add(cabeza);
        Rectangle ojoIzq = new Rectangle(5, 5, Color.BLACK);
        ojoIzq.setX(22);
        ojoIzq.setY(2);
        ojoIzq.setWidth(5);
        ojoIzq.setHeight(5);
        groupPersonaje.getChildren().add(ojoIzq);
        Rectangle ojoDer = new Rectangle(5, 5, Color.BLACK);
        ojoDer.setX(32);
        ojoDer.setY(2);
        ojoDer.setWidth(5);
        ojoDer.setHeight(5);
        groupPersonaje.getChildren().add(ojoDer);
        
        //Cuerpo
        Rectangle cuerpo = new Rectangle(40, 20, Color.LIGHTGREEN);
        cuerpo.setX(17.5);
        cuerpo.setY(20);
        cuerpo.setWidth(25);
        cuerpo.setHeight(20);
        groupPersonaje.getChildren().add(cuerpo);
        
        //Piernas delanteras
        Rectangle piernaDelIzq = new Rectangle(40, 20, Color.LIGHTGREEN);
        piernaDelIzq.setX(11);
        piernaDelIzq.setY(20);
        piernaDelIzq.setWidth(7);
        piernaDelIzq.setHeight(5);
        groupPersonaje.getChildren().add(piernaDelIzq);
        Rectangle piernaDelDer = new Rectangle(40, 20, Color.LIGHTGREEN);
        piernaDelDer.setX(42);
        piernaDelDer.setY(20);
        piernaDelDer.setWidth(7);
        piernaDelDer.setHeight(5);
        groupPersonaje.getChildren().add(piernaDelDer);
        Rectangle pieDelIzq = new Rectangle(40, 20, Color.LIGHTGREEN);
        pieDelIzq.setX(11);
        pieDelIzq.setY(10);
        pieDelIzq.setWidth(7);
        pieDelIzq.setHeight(10);
        groupPersonaje.getChildren().add(pieDelIzq);
        Rectangle pieDelDer = new Rectangle(40, 20, Color.LIGHTGREEN);
        pieDelDer.setX(42);
        pieDelDer.setY(10);
        pieDelDer.setWidth(7);
        pieDelDer.setHeight(10);
        groupPersonaje.getChildren().add(pieDelDer);
        
        //Piernas traseras
        Rectangle piernaTraIzq = new Rectangle(40, 20, Color.LIGHTGREEN);
        piernaTraIzq.setX(11);
        piernaTraIzq.setY(35);
        piernaTraIzq.setWidth(7);
        piernaTraIzq.setHeight(5);
        groupPersonaje.getChildren().add(piernaTraIzq);
        Rectangle piernaTraDer = new Rectangle(40, 20, Color.LIGHTGREEN);
        piernaTraDer.setX(42);
        piernaTraDer.setY(35);
        piernaTraDer.setWidth(7);
        piernaTraDer.setHeight(5);
        groupPersonaje.getChildren().add(piernaTraDer);
        Rectangle pieTraIzq = new Rectangle(40, 20, Color.LIGHTGREEN);
        pieTraIzq.setX(11);
        pieTraIzq.setY(30);
        pieTraIzq.setWidth(5);
        pieTraIzq.setHeight(5);
        groupPersonaje.getChildren().add(pieTraIzq);
        Rectangle pieTraDer = new Rectangle(40, 20, Color.LIGHTGREEN);
        pieTraDer.setX(44);
        pieTraDer.setY(30);
        pieTraDer.setWidth(5);
        pieTraDer.setHeight(5);
        groupPersonaje.getChildren().add(pieTraDer);
        
        // Colocar personaje en su posición de inicio
        groupPersonaje.setLayoutX(posXPersonaje);
        groupPersonaje.setLayoutY(posYPersonaje);
        
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