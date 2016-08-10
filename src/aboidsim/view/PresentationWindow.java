package aboidsim.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * class used to show information about the simulation.
 *
 */
public class PresentationWindow {

    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private static final String TEXT = System.getProperty("user.dir") + "/res/description.txt";
    private static final String BACKGROUND_IMG = "file:" + DrawEntities.SEP + DrawEntities.SEP + DrawEntities.SEP
            + System.getProperty("user.dir") + DrawEntities.SEP + "res" + DrawEntities.SEP + "images" + DrawEntities.SEP
            + "simulationBackground.jpg";

    /**
     * constructor of the class. it creates a new window with the explanation of
     * the program.
     *
     * @throws FileNotFoundException
     */
    PresentationWindow() {
        final Stage stage = new Stage();
        stage.setTitle("BOIDS PROGRAM DESCRIPTION");
        stage.initModality(Modality.APPLICATION_MODAL);
        final StackPane layout = new StackPane();

        final Image img = new Image(PresentationWindow.BACKGROUND_IMG, PresentationWindow.WIDTH,
                PresentationWindow.HEIGHT, false, false);
        final ImageView image = new ImageView(img);
        image.setOpacity(0.5);

        final VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));

        final Label text = new Label();
        try {
            text.setText(this.readFromFile());
        } catch (final FileNotFoundException e1) {
            e1.printStackTrace();
        }
        final ScrollPane scrollPane = new ScrollPane(text);
        scrollPane.setStyle("-fx-background-color: transparent;");

        final Button confirm = new Button("Ok!");
        confirm.setOnAction(e -> stage.close());

        vbox.getChildren().addAll(scrollPane, confirm);
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(image, vbox);

        final Scene scene = new Scene(layout, PresentationWindow.WIDTH, PresentationWindow.HEIGHT);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.showAndWait();
    }

    /**
     *
     * @return the string representint the content of the text file in res
     * @throws FileNotFoundException
     */
    String readFromFile() throws FileNotFoundException {
        final BufferedReader br = new BufferedReader(new FileReader(new File(PresentationWindow.TEXT)));
        final StringBuffer text = new StringBuffer();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append(System.getProperty("line.separator"));
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

}
