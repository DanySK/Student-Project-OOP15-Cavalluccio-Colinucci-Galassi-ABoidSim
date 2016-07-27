package aboidsim.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * the main window of the program, it contains all the elements of the interface.
 *
 */
public class MainWindow extends Application {

    private Stage mainStage = new Stage();
    private static final double HEIGHT = 800; 
    private static final double WIDTH = 800;
    private static List<String> boids; //= Arrays.asList("ciao", "hello", "yo");// = new ArrayList<>();
    private static List<String> rules; //= Arrays.asList("dell", "hp", "asus"); //= new ArrayList<>();
    
    
 
    
//    public static void main(String[] args) {
//        launch(args);
//    }
    
    /**
     * 
     */
    public void start(final Stage stage) throws Exception {
        
        this.mainStage = stage;
        mainStage.setTitle("BOIDS");
        mainStage.setWidth(WIDTH);
        mainStage.setHeight(HEIGHT);
        
        final HBox totalLayout = new HBox(8);
        
        final SimulationScreen boidsScreen = new SimulationScreen();
        
        final VBox selections = new VBox(5);
        final RulesSelection rulesSelection = new RulesSelection(rules);
        final BoidSelection boidSelection = new BoidSelection(boids);
        selections.getChildren().addAll(rulesSelection, boidSelection);
        
        totalLayout.getChildren().addAll(boidsScreen, selections);
        
        stage.setScene(new Scene(totalLayout));
        stage.show();
        
        
    }
    
    static void setBoids(List<String> boids) {
        MainWindow.boids = boids;
    }
    
    static void setRules(List<String> rules) {
        MainWindow.rules = rules;
    }
}
