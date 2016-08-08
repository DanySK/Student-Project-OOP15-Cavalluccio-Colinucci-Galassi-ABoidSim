package aboidsim.view;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * the main window of the program, it contains all the elements of the
 * interface.
 *
 */
public class MainWindow extends Application {

    private Stage mainStage = new Stage();
    private static List<String> boids;
    private static List<String> rules;
    private static List<String> envs;

    /**
     *
     */
    @Override
    public void start(final Stage stage) throws Exception {

        this.mainStage = stage;
        this.mainStage.setTitle("BOIDS");

        stage.setResizable(false);
        final HBox totalLayout = new HBox(8);
        final SimulationScreen boidsScreen = new SimulationScreen();
        ViewImpl.setSimulationScreen(boidsScreen);

        final Separator vSeparator = new Separator(Orientation.VERTICAL);

        final VBox selections = new VBox(5);
        final RulesSelection rulesSelection = new RulesSelection(MainWindow.rules);
        final BoidSelection boidSelection = new BoidSelection(MainWindow.boids);
        final EnvironmentSelection envSelection = new EnvironmentSelection(MainWindow.envs);

        final InfoBox infoBox = new InfoBox();
        selections.getChildren().addAll(rulesSelection, new Separator(), boidSelection, new Separator(), infoBox,
                new Separator(), new Separator(), envSelection);
        // selections.getStylesheets().add("aboidsim/view/prova.css");

        totalLayout.getChildren().addAll(boidsScreen, vSeparator, selections);
        totalLayout.setStyle("-fx-background-color: WHITE;");
        final Scene scene = new Scene(totalLayout);
        stage.setScene(scene);

        // da modificare
        stage.setOnCloseRequest(e -> {
            // ViewImpl.getController().close();
            System.exit(0);
        });

        stage.show();

    }

    static void setBoids(final List<String> boidsList) {
        MainWindow.boids = boidsList;
    }

    static void setRules(final List<String> rulesList) {
        MainWindow.rules = rulesList;
    }

    static void setEnvs(final List<String> envsList) {
        MainWindow.envs = envsList;
    }

}
