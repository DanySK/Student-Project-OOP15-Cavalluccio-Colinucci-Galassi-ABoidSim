package aboidsim.view;

import java.util.ArrayList;
import java.util.List;

import aboidsim.util.Input;
import aboidsim.util.InputInfo;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * contains the checkbox for choose the rules to apply to the simulation.
 *
 */
public class RulesSelection extends VBox {

    private static List<String> rules;
    private final List<CheckBox> boxes = new ArrayList<>();

    /**
     *
     * @param rules
     *            list of the rules
     */
    RulesSelection() {
        super();
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        RulesSelection.rules.stream().forEach(e -> {
            final CheckBox c = new CheckBox(e);
            this.boxes.add(c);
            c.setOnAction(r -> {
                System.out.println("regola " + c.getText() + " cambiata");
                this.addInput(this.boxes.indexOf(c));
            });
        });
        this.boxes.stream().forEach(e -> e.setSelected(true));
        final Text titolo = new Text("Seleziona regole da abilitare: ");
        this.getChildren().add(titolo);
        this.getChildren().addAll(this.boxes);

    }

    /**
     * adds a new input info to the list of rules in InputHandler.
     *
     * @param rule
     *            number of the rule selected
     */
    void addInput(final Integer rule) {
        InputHandler.getInputHandler().addInput(new InputInfo(Input.TOGGLE_RULE, rule));
    }

    /**
     * set the list of rules
     *
     * @param rulesList
     *            list of the rule names
     */
    static void setRules(final List<String> rulesList) {
        RulesSelection.rules = rulesList;
    }

}
