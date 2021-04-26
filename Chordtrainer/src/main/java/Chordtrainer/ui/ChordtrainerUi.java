
package Chordtrainer.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.layout.CornerRadii;
import Chordtrainer.domain.ChordHandler;
import java.util.ArrayList;
import Chordtrainer.domain.Chord;
import javafx.event.ActionEvent;


public class ChordtrainerUi extends Application {
    
    
    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int PRACTICE_VIEW_WIDTH = 600;
    private static final int PRACTICE_VIEW_HEIGHT = 180;
    private static final int RECTANGLE_WIDTH = 50;
    private static final int RECTANGLE_HEIGHT = 2*RECTANGLE_WIDTH;
    private static final int CHORD_START_X = (PRACTICE_VIEW_WIDTH/2)-(RECTANGLE_WIDTH*5/2);
    private static final int CHORD_START_Y = 100;
    ChordHandler handler = new ChordHandler();
    
    
            
    
   
    
    
    @Override
    public void start(Stage window) throws Exception {
        
        BorderPane layout = new BorderPane();
        layout.setPrefSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        
        layout.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        HBox menu = new HBox();
        menu.setPadding(new Insets(10, 0, 0, 0));
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(5);
        
        Button practise = new Button("Harjoittele");
        Button settings = new Button("Asetukset");
        Button shutdown = new Button("Sulje ohjelma");
        
        menu.getChildren().addAll(practise,settings,shutdown);
        
        layout.setTop(menu);
        
        Pane firstLayout = createPractiseView("Valitse harjoiteltava sointuasteikko");
        StackPane secondLayout = createSettingsView("asetusnäkymä");
        
        practise.setOnAction((event) -> layout.setCenter(firstLayout));
        settings.setOnAction((event) -> layout.setCenter(secondLayout));
        shutdown.setOnAction((event) -> window.close()); // closes the program
        
        layout.setCenter(firstLayout);
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
        
    }
    
    private Pane createPractiseView(String text) {
        
        
        Pane canvas = new Pane();
        canvas.setPrefSize(PRACTICE_VIEW_WIDTH, PRACTICE_VIEW_HEIGHT);
        
        Circle circle = new Circle(10);
        circle.relocate (100,100);
        
        canvas.getChildren().addAll(new Label(text),circle);
        
        int l = 0;
        
        ArrayList<Chord> chords = new ArrayList<>();
        
        
        
        Button D = new Button("D");
        canvas.getChildren().add(D);
        D.setOnAction((event) -> {
            ArrayList<Chord> test = handler.placeholdername("dMajorScale");
            
            System.out.println(handler.placeholdername("dMajorScale").get(l).getName());
            
        });
        
        
        
        
        for (int i = 0; i<5; i++) {
            for (int j = 0; j<4; j++) {
                Rectangle rectangle = new Rectangle(RECTANGLE_WIDTH,RECTANGLE_HEIGHT);
                rectangle.relocate(i*RECTANGLE_WIDTH+CHORD_START_X, j*RECTANGLE_HEIGHT+CHORD_START_Y);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                canvas.getChildren().add(rectangle);
                
            }
        }
        
        
        
        return canvas;
    }
    /*
    private StackPane createScaleView(String scalename) {
        //täällä luodaan ikkuna, jossa eri soinnut näytetään.
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(scalename));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(new Circle());
        
        return layout;
    }
    */
    
    
    private StackPane createSettingsView(String text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.TOP_CENTER);
        
        return layout;
    }
    

   
    public static void main(String[] args) {
        launch(ChordtrainerUi.class);  
    }


}
