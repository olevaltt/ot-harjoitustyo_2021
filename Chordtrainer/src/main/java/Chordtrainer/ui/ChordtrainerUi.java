
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
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import Chordtrainer.domain.Scale;
import javafx.scene.control.ChoiceBox;
import javafx.collections.ObservableArray;
import javafx.collections.FXCollections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class ChordtrainerUi extends Application {
    
    
    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int PRACTICE_VIEW_WIDTH = 600;
    private static final int PRACTICE_VIEW_HEIGHT = 600;
    private static final int RECTANGLE_WIDTH = 50;
    private static final int RECTANGLE_HEIGHT = 2*RECTANGLE_WIDTH;
    private static final int CHORD_START_X = (PRACTICE_VIEW_WIDTH/2)-(RECTANGLE_WIDTH*5/2)-RECTANGLE_WIDTH/2;
    private static final int CHORD_START_Y = 100;
    private static final int CIRCLE_RADIUS = 15;
    ChordHandler handler = new ChordHandler();
    //Chord currentChord = null;
    Scale currentScale;
    
    
    public ChordtrainerUi() {
        this.currentScale = null;
    }        
    
   
    
    
    @Override
    public void start(Stage window) throws Exception {
        
        BorderPane layout = new BorderPane();
        layout.setPrefSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        
        layout.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        Pane canvas = new Pane();
        canvas.setPrefSize(PRACTICE_VIEW_WIDTH, PRACTICE_VIEW_HEIGHT);
        drawGrid(canvas);
        
        
        ChoiceBox scaleSelect = new ChoiceBox(FXCollections.observableArrayList(Scale.A,Scale.B,Scale.C,Scale.D));
        
        scaleSelect.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            currentScale = (Scale)newValue;
            Chord chord = handler.getNextChord(currentScale);
            drawGrid(canvas);
            showChord(chord,canvas);
        });
        
        layout.setTop(scaleSelect);
        
        
        Button nextChord = new Button("Next chord");
        layout.setRight(nextChord);
        nextChord.setOnAction((event) -> {
            Chord chord = handler.getNextChord(currentScale);
            System.out.println(chord.getName());
            drawGrid(canvas);
            showChord(chord,canvas);    
        });
        

        
        layout.setCenter(canvas);
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
        
    }
    
    
    
    
    private static void showChord(Chord chord, Pane canvas) {
        String chordHeight = Integer.toString(chord.getPosition());
        int[] chordInfo = chord.getChord();
        int current = 0;
        for (int i = 0; i<6; i++) {
            
            current = chordInfo[i];
        
        
            switch(current) {
                case -1:
                    //draw an X atop of string.
                    Text x = new Text(i*RECTANGLE_WIDTH+CHORD_START_X-7, CHORD_START_Y-10, "X");
                    x.setFont(new Font(30));
                    canvas.getChildren().add(x);
                    break;

                case 0:
                    //draw nothing
                    
                    break;

                default:
                    //draw a circle to right height
                    
                    Circle circle = new Circle(CIRCLE_RADIUS);
                    circle.relocate (i*RECTANGLE_WIDTH+CHORD_START_X-CIRCLE_RADIUS,RECTANGLE_HEIGHT*current+CHORD_START_Y-RECTANGLE_HEIGHT/2-CIRCLE_RADIUS);
                    canvas.getChildren().add(circle);
                    break;

            }
        }
        
        
        Text t = new Text(CHORD_START_X-45,CHORD_START_Y+RECTANGLE_HEIGHT/2+10,chordHeight);
        t.setFont(new Font(30));
        canvas.getChildren().add(t);
        
               
        
        
    }
    
    private static void drawGrid(Pane canvas) {
        canvas.getChildren().clear();
        for (int i = 0; i<5; i++) {
            for (int j = 0; j<4; j++) {
                Rectangle rectangle = new Rectangle(RECTANGLE_WIDTH,RECTANGLE_HEIGHT);
                rectangle.relocate(i*RECTANGLE_WIDTH+CHORD_START_X, j*RECTANGLE_HEIGHT+CHORD_START_Y);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                canvas.getChildren().add(rectangle);
                
            }
        }
    }
    
    
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
