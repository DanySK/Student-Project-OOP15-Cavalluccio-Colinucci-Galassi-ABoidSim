package aboidsim.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import aboidsim.util.Input;
import aboidsim.util.InputInfo;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * contains the checkbox for choose the rules to apply to the simulation.
 *
 */
public class RulesSelection extends VBox {

    private final List<String> rules;
    private final List<CheckBox> boxes = new ArrayList<>();
    // private static VBox layout = new VBox(10);
    private final Button conferma = new Button("Conferma");
    private static Set<Integer> selectedRules = new HashSet<>();

    /**
     *
     * @param rules
     *            list of the rules
     */
    public RulesSelection(final List<String> rules) {
        super(5);
        this.setPadding(new Insets(10));
        this.rules = rules;
        this.rules.stream().forEach(e -> this.boxes.add(new CheckBox(e)));
        this.boxes.stream().forEach(e -> e.setSelected(true));
        final Text titolo = new Text("Seleziona regole da abilitare: ");
        this.getChildren().add(titolo);
        this.getChildren().addAll(this.boxes);
        this.getChildren().add(this.conferma);
        this.setSelectedRules();

        this.conferma.setOnAction(e -> {
            RulesSelection.selectedRules.clear();
            this.setSelectedRules();
            // this.printSelectedRules();
        });

    }

    /**
     *
     * @return a list of the selected rules
     */
    public void setSelectedRules() {

        this.boxes.stream().forEach(e -> {
            if (e.isSelected()) {
                RulesSelection.selectedRules.add(this.rules.indexOf(e.getText()));
            }
        });

    }

    /**
     * test method
     */
    private void printSelectedRules() {
        System.out.println(RulesSelection.selectedRules.toString());
    }

    /**
     * add rules to the list in class InputHandler
     */
    static Set<InputInfo> getInputs() {
        final Set<InputInfo> set = new HashSet<>();
        RulesSelection.selectedRules.stream().forEach(e -> set.add(new InputInfo(Input.TOGGLE_RULE, e)));
        return set;

    }

}
