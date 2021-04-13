
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

public class ChordtrainerUi extends Application {
    
    @Override
    public void start(Stage window) throws Exception {
        
        BorderPane layout = new BorderPane();
        layout.setPrefSize(600, 600);
        
        HBox menu = new HBox();
        menu.setPadding(new Insets(10, 0, 0, 0));
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(5);
        
        Button practise = new Button("Harjoittele");
        Button settings = new Button("Asetukset");
        Button shutdown = new Button("Sulje ohjelma");
        
        menu.getChildren().addAll(practise,settings,shutdown);
        
        layout.setTop(menu);
        
        GridPane firstLayout = createPractiseView("Valitse harjoiteltava sointuasteikko");
        StackPane secondLayout = createSettingsView("asetusnäkymä");
        
        practise.setOnAction((event) -> layout.setCenter(firstLayout));
        settings.setOnAction((event) -> layout.setCenter(secondLayout));
        shutdown.setOnAction((event) -> window.close()); // closes the program
        
        layout.setCenter(firstLayout);
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
        
    }
    
    private GridPane createPractiseView(String text) {
        
        
        GridPane layout = new GridPane();
        layout.setPrefSize(300, 180);
        layout.add(new Label(text), 0, 0);
        
        
        Button A = new Button("A");
        Button B = new Button("B");
        Button C = new Button("C");
        Button D = new Button("D");
        Button E = new Button("E");
        Button F = new Button("F");
        Button G = new Button("G");
        
        
        layout.add(A, 0, 1);
        layout.add(B, 0, 2);
        layout.add(C, 0, 3);
        layout.add(D, 0, 4);
        layout.add(E, 0, 5);
        layout.add(F, 0, 6);
        layout.add(G, 0, 7);

        return layout;
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
