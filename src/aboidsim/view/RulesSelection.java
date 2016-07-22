package aboidsim.view;

import java.util.ArrayList;
import java.util.List;

import aboidsim.util.Input;
import aboidsim.util.InputInfo;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class RulesSelection extends Scene{

    private final List<String> rules;
    private final List<CheckBox> boxes = new ArrayList<>();
    private static VBox layout = new VBox(10);
    private Button conferma = new Button("Conferma");

    
    /**
     * 
     * @param rules list of the rules
     */
    public RulesSelection(final List<String> rules) {
            super(layout);
            layout.setPadding(new Insets(10));
            this.rules = rules;
            this.rules.stream().forEach(e -> this.boxes.add(new CheckBox(e)));
            Text titolo = new Text("Seleziona regole da abilitare: ");
            layout.getChildren().add(titolo);
            layout.getChildren().addAll(this.boxes);
            layout.getChildren().add(conferma);
            
            conferma.setOnAction(e -> this.addInputs());
            
    }
    
    
    /**
     * 
     * @return a list of the selected rules
     */
    public List<Integer> returnSelectedRules() {
        final  List<Integer> list = new ArrayList<>();
        boxes.stream().forEach(e -> {
            if (e.isSelected()) list.add(this.rules.indexOf(e.getText()));
        });
        return list;
    }
    
    /**
     * test method
     */
    private void printSelectedRules() {
        System.out.println(this.returnSelectedRules().toString());
    }
    
	private void addInputs() {
		this.returnSelectedRules().stream()
			.forEach(e -> InputHandler.getInputHandler().addInput(new InputInfo(Input.TOGGLE_RULE, e)));

	}

}
