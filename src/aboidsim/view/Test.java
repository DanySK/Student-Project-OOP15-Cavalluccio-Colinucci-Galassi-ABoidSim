package aboidsim.view;

import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * test class for the elements of the interface.
 *
 */
public class Test extends Application {

    /**
     * 
     * */
    public static void main(final String[] args) {
        launch(args);
    }

    /**
     * lo farò successivamente.
     */
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Test");

        final List<String> parole = Arrays.asList("Sony", "Xiaomi", "Huawei");
        // stage.setScene(new SceltaRegole(parole));

        stage.setScene(new BoidSelection(Arrays.asList("ciao", "come", "va")));
        // stage.setScene(new SceltaRegole(parole));
        stage.show();
    }

}
