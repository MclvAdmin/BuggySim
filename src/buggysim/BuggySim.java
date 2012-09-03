/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buggysim;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author god
 */
public class BuggySim extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        /*btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });*/
        
        TabPane root = new TabPane();
        Tab render = new Tab("Render");
        EventHandler<Event> e = new EventHandler<Event>(){
            @Override
            public void handle(Event event){
                //@TODO add tab change logic
            }
        };
        render.setOnSelectionChanged(e);
        Tab settings = new Tab("Settings");
        root.getTabs().add(render);
        root.getTabs().add(settings);
        
        Scene scene = new Scene(root, 1000, 1000);
        
        primaryStage.setTitle("Buggy Sim");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
