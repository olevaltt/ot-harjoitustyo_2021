
package Chordtrainer.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.layout.CornerRadii;
import Chordtrainer.domain.ChordHandler;
import Chordtrainer.domain.Chord;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import Chordtrainer.domain.Scale;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.application.Platform;
import javafx.scene.control.ToggleButton;


public class ChordtrainerUi extends Application {
    
    
    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int PRACTICE_VIEW_WIDTH = 600;
    private static final int PRACTICE_VIEW_HEIGHT = 600;
    private static final int RECTANGLE_WIDTH = 50;
    private static final int RECTANGLE_HEIGHT = 2 * RECTANGLE_WIDTH;
    private static final int CHORD_START_X = (PRACTICE_VIEW_WIDTH / 2) - (RECTANGLE_WIDTH * 5 / 2) - RECTANGLE_WIDTH / 2;
    private static final int CHORD_START_Y = 100;
    private static final int CIRCLE_RADIUS = 15;
    private ChordHandler handler = new ChordHandler();
    private Scale currentScale;
    
    private int cycleTime;
    private Pane canvas;
    
    
    
    public ChordtrainerUi() {
        this.currentScale = null;
        this.cycleTime = 1000; //cycletime in ms
        this.canvas = new Pane();
        
    }        
    
   
    
    
    @Override
    public void start(Stage window) throws Exception {
        
        BorderPane layout = new BorderPane();
        layout.setPrefSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        
        layout.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        
        canvas.setPrefSize(PRACTICE_VIEW_WIDTH, PRACTICE_VIEW_HEIGHT);
        drawGrid(canvas);
        
        
        ChoiceBox scaleSelect = new ChoiceBox(FXCollections.observableArrayList(
            Scale.A,
            Scale.A_SHARP,
            Scale.B,
            Scale.C,
            Scale.C_SHARP,
            Scale.D,
            Scale.D_SHARP,
            Scale.E,
            Scale.F,
            Scale.F_SHARP,
            Scale.G,
            Scale.G_SHARP,
            Scale.A_M,
            Scale.A_SHARP_M,
            Scale.B_M,
            Scale.C_M,
            Scale.C_SHARP_M,
            Scale.D_M,
            Scale.D_SHARP_M,
            Scale.E_M,
            Scale.F_M,
            Scale.F_SHARP_M,
            Scale.G_M,
            Scale.G_SHARP_M
        ));
        
        scaleSelect.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            currentScale = (Scale) newValue;
            Chord chord = handler.getNextChord(currentScale);
            drawGrid(canvas);
            showChord(chord, canvas);
        });
        
        layout.setTop(scaleSelect);
        
        
        Button nextChord = new Button("Next chord");
        layout.setRight(nextChord);
        nextChord.setOnAction((event) -> {
            Chord chord = handler.getNextChord(currentScale);
            drawGrid(canvas);
            showChord(chord, canvas);    
        });
        
        
        
        
        
        
        ToggleButton cycleChords = new ToggleButton("Cycle chords");
        layout.setBottom(cycleChords);
        
        AtomicBoolean running = new AtomicBoolean();
        
        cycleChords.setOnAction(event -> {
            running.set(cycleChords.isSelected());
            Runnable runnable = () -> {
                while (running.get()) {
                    try {
                        Thread.sleep(cycleTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(() -> {
                        Chord chord = handler.getNextChord(currentScale);
                        drawGrid(canvas);
                        showChord(chord, canvas);
                    });
                };
            };
            try {
                if (running.get()) {
                    Thread t = new Thread(runnable);
                    t.setDaemon(true);
                    t.start();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }   
        });

        
        layout.setCenter(canvas);
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
        
    }
    
    
    
    
    
    
    private static void showChord(Chord chord, Pane canvas) {
        String chordName = chord.getName();
        String chordHeight = Integer.toString(chord.getPosition());
        int[] chordInfo = chord.getChord();
        for (int i = 0; i < 6; i++) {
            
            int current = chordInfo[i];
        
        
            switch (current) {
                case -1:
                    //draw an X atop of string.
                    Text x = new Text(i * RECTANGLE_WIDTH + CHORD_START_X - 7, CHORD_START_Y - 10, "X");
                    x.setFont(new Font(30));
                    canvas.getChildren().add(x);
                    break;

                case 0:
                    //draw nothing
                    
                    break;

                default:
                    //draw a circle to right height
                    
                    Circle circle = new Circle(CIRCLE_RADIUS);
                    circle.relocate(i * RECTANGLE_WIDTH + CHORD_START_X - CIRCLE_RADIUS, RECTANGLE_HEIGHT * current + CHORD_START_Y - RECTANGLE_HEIGHT / 2 - CIRCLE_RADIUS);
                    canvas.getChildren().add(circle);
                    break;

            }
        }
        
        
        Text t = new Text(CHORD_START_X - 45, CHORD_START_Y + RECTANGLE_HEIGHT / 2 + 10, chordHeight);
        t.setFont(new Font(30));
        canvas.getChildren().add(t);
        
        Text name = new Text(PRACTICE_VIEW_WIDTH / 2 - 30, CHORD_START_Y - 50, chordName); //Adjust this later for the end product to look better.
        name.setFont(new Font(60));
        canvas.getChildren().add(name);
        
        
    }
    
    private static void drawGrid(Pane canvas) {
        canvas.getChildren().clear();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Rectangle rectangle = new Rectangle(RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
                rectangle.relocate(i * RECTANGLE_WIDTH + CHORD_START_X, j * RECTANGLE_HEIGHT + CHORD_START_Y);
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
