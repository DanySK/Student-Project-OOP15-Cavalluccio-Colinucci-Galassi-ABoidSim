package aboidsim.view;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * part of the interface used to show some information about the simulation.
 *
 */
public class InfoBox extends GridPane {

    private final Label title;
    private static final Label numTotBoids = new Label("0");
    private static final Label numHerbivores = new Label("0");
    private static final Label numPredator = new Label("0");
    private static final Label numTrees = new Label("0");

    InfoBox() {
        super();
        this.setPadding(new Insets(10));

        this.title = new Label("INFORMATION BOX");
        final Label totLabel = new Label("Total boids: ");
        final Label herbLabel = new Label("Total herbivores: ");
        final Label predLabel = new Label("Total predators: ");
        final Label treesLabel = new Label("Total predators: ");

        GridPane.setConstraints(this.title, 0, 0, 2, 1);
        GridPane.setConstraints(totLabel, 0, 1);
        GridPane.setConstraints(herbLabel, 0, 2);
        GridPane.setConstraints(predLabel, 0, 3);
        GridPane.setConstraints(treesLabel, 0, 4);
        GridPane.setConstraints(InfoBox.numTotBoids, 1, 1);
        GridPane.setConstraints(InfoBox.numHerbivores, 1, 2);
        GridPane.setConstraints(InfoBox.numPredator, 1, 3);
        GridPane.setConstraints(InfoBox.numTrees, 1, 4);
        this.title.setAlignment(Pos.CENTER);

        this.getChildren().addAll(this.title, totLabel, herbLabel, predLabel, treesLabel, InfoBox.numTotBoids,
                InfoBox.numHerbivores, InfoBox.numPredator, InfoBox.numTrees);

    }

    static void updateInfo(final List<Integer> levels) {
        int herb = 0;
        int tree = 0;
        int pred = 0;

        for (final int i : levels) {
            if (i > 0 && i < 6) {
                herb++;
            } else if (i > 5) {
                pred++;
            } else {
                tree++;
            }
        }

        System.out.println("sto aggiornando le info");
        InfoBox.numTotBoids.setText(String.valueOf(levels.size()));
        InfoBox.numHerbivores.setText(String.valueOf(herb));
        InfoBox.numPredator.setText(String.valueOf(pred));
        InfoBox.numTrees.setText(String.valueOf(tree));

    }

}
