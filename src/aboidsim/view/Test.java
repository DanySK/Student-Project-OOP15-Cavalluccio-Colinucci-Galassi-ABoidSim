package aboidsim.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import aboidsim.util.Pair;
import aboidsim.util.Vector;

/**
 * test class for the elements of the interface.
 *
 */
public class Test /* extends Application */ {

    /**
     * @throws InterruptedException
     *
     */
    public static void main(final String[] args) throws InterruptedException {
        // MainWindow ciao = new MainWindow(Arrays.asList("ciao", "hello",
        // "yo"), Arrays.asList("dell", "hp", "asus"));
        // window.show();
        final List<String> lista = Arrays.asList("ciao", "hello", "yo");
        // MainWindow.setBoids(lista);
        // MainWindow.setRules(lista);
        // Application.launch(MainWindow.class);
        final Set<Pair<Vector, String>> set = new HashSet<>();
        set.add(new Pair<Vector, String>(new Vector(20, 20), "ciao"));
        // MainWindow.getSimulation()

        final ViewImpl view = new ViewImpl();
        view.start(lista, lista);
        view.drawEntities(set);

    }

}
