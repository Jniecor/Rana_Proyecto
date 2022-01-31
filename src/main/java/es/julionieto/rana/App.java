package es.julionieto.rana;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
    final double POSICION_FILA_1_COCHES = 456.5;
    
    //Fila 2 (Arriba)
    final double POSICION_FILA_2_COCHES = 383.5;
    
    //-----<SEGUNDA PARTE>-----//
    //Troncos (Río)
    //Fila 1 (Abajo)
    final double POSICION_FILA_1_TRONCOS = 237.5;
    
    //Fila 2 (Arriba)
    final double POSICION_FILA_2_TRONCOS = 165.5;
    
    //Nenúfares (Río)
    //Fila 1 (Abajo)
    final double POSICION_FILA_1_NENUFARES = 273.5;
    
    //Fila 2 (Medio)   
    final double POSICION_FILA_2_NENUFARES = 201.5;
    
    //Fila 3 (Arriba)
    final double POSICION_FILA_3_NENUFARES = 129.5;
    
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
            //Ojo izquierdo
        Rectangle ojoIzq = new Rectangle(5, 5, Color.BLACK);
        ojoIzq.setX(22);
        ojoIzq.setY(2);
        ojoIzq.setWidth(2);
        ojoIzq.setHeight(2);
        groupPersonaje.getChildren().add(ojoIzq);
            //Ojo derecho
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
            //Pierna delantera izquierda
        Rectangle piernaDelIzq = new Rectangle(40, 20, Color.LIGHTGREEN);
        piernaDelIzq.setX(14);
        piernaDelIzq.setY(14);
        piernaDelIzq.setWidth(4);
        piernaDelIzq.setHeight(2);
        groupPersonaje.getChildren().add(piernaDelIzq);
            //Pierna delantera derecha
        Rectangle piernaDelDer = new Rectangle(40, 20, Color.LIGHTGREEN);
        piernaDelDer.setX(32);
        piernaDelDer.setY(14);
        piernaDelDer.setWidth(4);
        piernaDelDer.setHeight(2);
        groupPersonaje.getChildren().add(piernaDelDer);
            //Pie delantero izquierdo
        Rectangle pieDelIzq = new Rectangle(40, 20, Color.LIGHTGREEN);
        pieDelIzq.setX(14);
        pieDelIzq.setY(8);
        pieDelIzq.setWidth(4);
        pieDelIzq.setHeight(7);
        groupPersonaje.getChildren().add(pieDelIzq);
            //Pie delantero derecho
        Rectangle pieDelDer = new Rectangle(40, 20, Color.LIGHTGREEN);
        pieDelDer.setX(32);
        pieDelDer.setY(8);
        pieDelDer.setWidth(4);
        pieDelDer.setHeight(7);
        groupPersonaje.getChildren().add(pieDelDer);
        
        //Piernas traseras
            //Pierna trasera izquierda
        Rectangle piernaTraIzq = new Rectangle(40, 20, Color.LIGHTGREEN);
        piernaTraIzq.setX(14);
        piernaTraIzq.setY(20);
        piernaTraIzq.setWidth(7);
        piernaTraIzq.setHeight(5);
        groupPersonaje.getChildren().add(piernaTraIzq);
            //Pierna trasera derecha
        Rectangle piernaTraDer = new Rectangle(40, 20, Color.LIGHTGREEN);
        piernaTraDer.setX(29);
        piernaTraDer.setY(20);
        piernaTraDer.setWidth(7);
        piernaTraDer.setHeight(5);
        groupPersonaje.getChildren().add(piernaTraDer);
            //Pie trasero izquierdo
        Rectangle pieTraIzq = new Rectangle(40, 20, Color.LIGHTGREEN);
        pieTraIzq.setX(14);
        pieTraIzq.setY(18);
        pieTraIzq.setWidth(4);
        pieTraIzq.setHeight(2);
        groupPersonaje.getChildren().add(pieTraIzq);
            //Pie trasero derecho
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
        //4 imagenes de los coches 
        Image cocheRojoDer = new Image(getClass().getResourceAsStream("/images/Coche_rojo_der.png"));
        Image cocheRojoIzq = new Image(getClass().getResourceAsStream("/images/Coche_rojo_izq.png"));
        Image cocheAmarilloDer = new Image(getClass().getResourceAsStream("/images/Coche_amarillo_der.png"));
        Image cocheAmarilloIzq = new Image(getClass().getResourceAsStream("/images/Coche_amarillo_izq.png"));
        
        //Array de los coches
        ImageView cocheView[] = new ImageView[16];
        //Primera fila
        cocheView[0] = new ImageView(cocheRojoDer);
        cocheView[0].setX(770);
        
        cocheView[1] = new ImageView(cocheAmarilloDer);
        cocheView[1].setX(660);
        
        cocheView[2] = new ImageView(cocheRojoDer);
        cocheView[2].setX(550);
        
        cocheView[3] = new ImageView(cocheRojoDer);
        cocheView[3].setX(440);
        
        cocheView[4] = new ImageView(cocheAmarilloDer);
        cocheView[4].setX(330);
        
        cocheView[5] = new ImageView(cocheAmarilloDer);
        cocheView[5].setX(220);
        
        cocheView[6] = new ImageView(cocheRojoDer);
        cocheView[6].setX(110);
        
        cocheView[7] = new ImageView(cocheRojoDer);
        cocheView[7].setX(0);
        //Bucle para los primeros 7 coches para que tengan la misma "Y"
        // y aparezcan en pantalla
        for(int i=0; i<8; i++) {
            cocheView[i].setY(POSICION_FILA_1_COCHES);
            paneRoot.getChildren().add(cocheView[i]);
        }
        
        cocheView[8] = new ImageView(cocheRojoIzq);
        cocheView[8].setX(710);
        
        cocheView[9] = new ImageView(cocheAmarilloIzq);
        cocheView[9].setX(600);
        
        cocheView[10] = new ImageView(cocheAmarilloIzq);
        cocheView[10].setX(490);
        
        cocheView[11] = new ImageView(cocheAmarilloIzq);
        cocheView[11].setX(380);
        
        cocheView[12] = new ImageView(cocheRojoIzq);
        cocheView[12].setX(270);
        
        cocheView[13] = new ImageView(cocheAmarilloIzq);
        cocheView[13].setX(160);
        
        cocheView[14] = new ImageView(cocheRojoIzq);
        cocheView[14].setX(50);
        //CAMBIAR AL SER EL ULTIMO POSICIÓN INICIAL PUEDE CAMBIAR
        cocheView[15] = new ImageView(cocheAmarilloIzq);
        cocheView[15].setX(-60);
        //Bucle para los ultimos 8 coches para que tengan la misma "Y"
        // y aparezcan en pantalla
        for(int i=8; i<16; i++) {
            cocheView[i].setY(POSICION_FILA_2_COCHES);
            paneRoot.getChildren().add(cocheView[i]);
        }
        
        //Troncos
        //Unica imagen del objeto tronco
        Image tronco = new Image(getClass().getResourceAsStream("/images/tronco_.jpg"));
        //Array de los troncos
        ImageView troncoView[] = new ImageView[11];
        //Primera fila
        troncoView[0] = new ImageView(tronco);
        troncoView[0].setX(50);
        
        troncoView[1] = new ImageView(tronco);
        troncoView[1].setX(250);
        
        troncoView[2] = new ImageView(tronco);
        troncoView[2].setX(450);
        
        troncoView[3] = new ImageView(tronco);
        troncoView[3].setX(650);
        //POSICIÓN FINAL DESPUES TELETRANSPORTAR A -150
        troncoView[4] = new ImageView(tronco);
        troncoView[4].setX(850);
        //Bucle para los primeros 5 troncos para que tengan la misma "Y"
        // y aparezcan en pantalla
        for(int i=0; i<5; i++) {
            troncoView[i].setY(POSICION_FILA_1_TRONCOS);
            paneRoot.getChildren().add(troncoView[i]);
        }
        
        //Segunda fila
        troncoView[5] = new ImageView(tronco);
        troncoView[5].setX(150);
        
        troncoView[6] = new ImageView(tronco);
        troncoView[6].setX(350);
        
        troncoView[7] = new ImageView(tronco);
        troncoView[7].setX(550);
        
        troncoView[8] = new ImageView(tronco);
        troncoView[8].setX(750);
        
        troncoView[9] = new ImageView(tronco);
        troncoView[9].setX(-50);
        //Bucle para los ultimos 5 troncos para que tengan la misma "Y"
        // y aparezcan en pantalla
        for(int i=5; i<10; i++) {
            troncoView[i].setY(POSICION_FILA_2_TRONCOS);
            paneRoot.getChildren().add(troncoView[i]);
        }
        
        //Nenúfares
        //Única imagen del obejto nenufar
        Image nenufar = new Image(getClass().getResourceAsStream("/images/Nenufar.png"));
        //Array de los nenúfares
        ImageView nenufarView[] = new ImageView[31];
        //Primera fila
        nenufarView[0] = new ImageView(nenufar);
        nenufarView[0].setX(565);
        
        nenufarView[1] = new ImageView(nenufar);
        nenufarView[1].setX(595);
        
        nenufarView[2] = new ImageView(nenufar);
        nenufarView[2].setX(765);
        
        nenufarView[3] = new ImageView(nenufar);
        nenufarView[3].setX(795);
        
        nenufarView[4] = new ImageView(nenufar);
        nenufarView[4].setX(365);
        
        nenufarView[5] = new ImageView(nenufar);
        nenufarView[5].setX(395);
        
        nenufarView[6] = new ImageView(nenufar);
        nenufarView[6].setX(195);
        
        nenufarView[7] = new ImageView(nenufar);
        nenufarView[7].setX(165);
        
        nenufarView[8] = new ImageView(nenufar);
        nenufarView[8].setX(-5);
        
        nenufarView[9] = new ImageView(nenufar);
        nenufarView[9].setX(-35);
        //Bucle para mostrar los primeros 9 nenúfares con la misma "Y"
        for(int i=0; i<10; i++) {
            nenufarView[i].setY(POSICION_FILA_1_NENUFARES);
            paneRoot.getChildren().add(nenufarView[i]);
        }
        
        /*Image nenufar2 = new Image(getClass().getResourceAsStream("/images/Nenufar.png"));
        ImageView nenufar3View = new ImageView(nenufar2);
        nenufar3View.setX(200); 
        nenufar3View.setY(93.5);   /*Image nenufar3 = new Image(getClass().getResourceAsStream("/images/Nenufar.png"));
        ImageView nenufar3View = new ImageView(nenufar3);
        nenufar3View.setX(200); 
        nenufar3View.setY(93.5);   
        paneRoot.getChildren().add(nenufar3View);*/ //IMAGEN PARA MIRAR LA POSICION FINAL DE LA RANA
        //HAY QUE CAMBIAR EL FONDO
        
        //Segunda fila
        nenufarView[10] = new ImageView(nenufar);
        nenufarView[10].setX(565);
        
        nenufarView[11] = new ImageView(nenufar);
        nenufarView[11].setX(595);
        
        nenufarView[12] = new ImageView(nenufar);
        nenufarView[12].setX(765);
        
        nenufarView[13] = new ImageView(nenufar);
        nenufarView[13].setX(795);
        
        nenufarView[14] = new ImageView(nenufar);
        nenufarView[14].setX(365);
        
        nenufarView[15] = new ImageView(nenufar);
        nenufarView[15].setX(395);
        
        nenufarView[16] = new ImageView(nenufar);
        nenufarView[16].setX(195);
        
        nenufarView[17] = new ImageView(nenufar);
        nenufarView[17].setX(165);
        
        nenufarView[18] = new ImageView(nenufar);
        nenufarView[18].setX(-5);
        
        nenufarView[19] = new ImageView(nenufar);
        nenufarView[19].setX(-35);
        //Bucle para mostrar los nenufares 10-19 con la misma "Y"
        for(int i=10; i<20; i++) {
            nenufarView[i].setY(POSICION_FILA_2_NENUFARES);
            paneRoot.getChildren().add(nenufarView[i]);
        }
        //Tercera fila
        nenufarView[20] = new ImageView(nenufar);
        nenufarView[20].setX(565);
        
        nenufarView[21] = new ImageView(nenufar);
        nenufarView[21].setX(595);
        
        nenufarView[22] = new ImageView(nenufar);
        nenufarView[22].setX(765);
        
        nenufarView[23] = new ImageView(nenufar);
        nenufarView[23].setX(795);
        
        nenufarView[24] = new ImageView(nenufar);
        nenufarView[24].setX(365);
        
        nenufarView[25] = new ImageView(nenufar);
        nenufarView[25].setX(395);
        
        nenufarView[26] = new ImageView(nenufar);
        nenufarView[26].setX(195);
        
        nenufarView[27] = new ImageView(nenufar);
        nenufarView[27].setX(165);
        
        nenufarView[28] = new ImageView(nenufar);
        nenufarView[28].setX(-5);
        
        nenufarView[29] = new ImageView(nenufar);
        nenufarView[29].setX(-35);
        //Mostrar los ultimos 10 nenúfares con la misma "Y"
        for(int i=20; i<30; i++) {
            nenufarView[i].setY(POSICION_FILA_3_NENUFARES);
            paneRoot.getChildren().add(nenufarView[i]);
        }
        
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
        
        //Adición de los label a la escena
        paneInfo.getChildren().add(labelMarcador);
        paneInfo.getChildren().add(labelGameover);
        paneRoot.getChildren().add(paneInfo);
        
        //Movimiento de la rana
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()) {
                case UP:
                    stickCurrentSpeed = -6;
                    break;
                case DOWN:
                    stickCurrentSpeed = 6;
                    break;
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }

}