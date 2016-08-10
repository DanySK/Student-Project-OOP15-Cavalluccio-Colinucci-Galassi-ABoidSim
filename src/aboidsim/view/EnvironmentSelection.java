package aboidsim.view;

import java.util.List;
import java.util.Optional;

import aboidsim.util.Input;
import aboidsim.util.InputInfo;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * element of the interface used to select the environment to show in the
 * simulation.
 *
 */
public class EnvironmentSelection extends VBox {

    private static List<String> envList;
    private final ComboBox<String> menu;
    private Optional<String> selectedEnv;

    EnvironmentSelection(final List<String> envs) {

        EnvironmentSelection.envList = envs;
        final Label title = new Label("CONFIGURATION SELECTION");
        final Button load = new Button("Load");
        this.menu = new ComboBox<>();
        this.menu.setPromptText("Select the config to load");
        EnvironmentSelection.envList.forEach(e -> this.menu.getItems().add(e));

        this.menu.setOnAction(e -> this.selectedEnv = Optional.ofNullable(this.menu.getValue()));

        load.setOnAction(e -> {
            if (this.selectedEnv.isPresent()) {
                this.addInput(EnvironmentSelection.envList.indexOf(this.selectedEnv.get()));
            }
        });

        this.setPadding(new Insets(10));
        this.setSpacing(5);
        this.getChildren().addAll(title, this.menu, load);

    }

    void addInput(final int env) {
        InputHandler.getInputHandler().addInput(new InputInfo(Input.LOAD_ENV, env));
    }

}
