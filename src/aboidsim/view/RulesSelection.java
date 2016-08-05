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

    private final List<String> rules;
    private final List<CheckBox> boxes = new ArrayList<>();

    /**
     *
     * @param rules
     *            list of the rules
     */
    RulesSelection(final List<String> rules) {
        super(5);
        this.setPadding(new Insets(10));
        this.rules = rules;
        this.rules.stream().forEach(e -> {
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

    void addInput(final Integer rule) {
        InputHandler.getInputHandler().addInput(new InputInfo(Input.TOGGLE_RULE, rule));
    }

}
