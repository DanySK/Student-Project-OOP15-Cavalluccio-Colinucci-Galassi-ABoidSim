package aboidsim.view;

import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * test class for the elements of the interface.
 *
 */
public class Test /*extends Application */{

    /**
     * 
     * */
    public static void main(final String[] args) {
        //MainWindow ciao = new MainWindow(Arrays.asList("ciao", "hello", "yo"), Arrays.asList("dell", "hp", "asus"));
        //window.show();
        List<String> lista = Arrays.asList("ciao", "hello", "yo");
        MainWindow.setBoids(lista);
        MainWindow.setRules(lista);
        Application.launch(MainWindow.class);
       
    }

    /**
     * lo far� successivamente.
     */
//    public void start(final Stage stage) throws Exception {
//        stage.setTitle("Test");
//
//        final List<String> parole = Arrays.asList("Sony", "Xiaomi", "Huawei");
//        // stage.setScene(new SceltaRegole(parole));
//
//     //   stage.setScene(new BoidSelection(Arrays.asList("ciao", "come", "va")));
//        // stage.setScene(new SceltaRegole(parole));
//        stage.show();
//    }

}
