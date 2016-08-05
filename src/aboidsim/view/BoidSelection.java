package aboidsim.view;

import java.util.List;
import java.util.Optional;

import aboidsim.util.Input;
import aboidsim.util.InputInfo;
import aboidsim.util.Vector;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class BoidSelection extends GridPane {

    private final ChoiceBox<String> box;
    private static Optional<String> selectedItem = Optional.empty();
    private static List<String> boidList;

    private final RadioButton create = new RadioButton("Create");
    private final RadioButton delete = new RadioButton("Delete");
    private static boolean action = true; // create action

    /**
     * constructor of the class.
     *
     * @param elements
     *            the list of the rules's names
     */
    public BoidSelection(final List<String> elements) {
        super();
        BoidSelection.boidList = elements;
        this.box = new ChoiceBox<>();
        final Text title = new Text("Seleziona tipo di elemento da inserire");
        this.insertElements(elements);

        this.box.setOnAction(e -> BoidSelection.selectedItem = Optional.of(this.box.getValue()));

        final ToggleGroup toggleGroup = new ToggleGroup();
        this.create.setToggleGroup(toggleGroup);
        this.delete.setToggleGroup(toggleGroup);

        this.create.selectedProperty().addListener(e -> {
            if (!this.create.isSelected()) {
                this.box.setDisable(true);
                BoidSelection.action = false;
            } else {
                this.box.setDisable(false);
                BoidSelection.action = true;
            }
            System.out.println(BoidSelection.action);
        });

        GridPane.setConstraints(title, 0, 0, 2, 1);
        GridPane.setConstraints(this.create, 0, 1);
        GridPane.setConstraints(this.delete, 0, 2);
        GridPane.setConstraints(this.box, 1, 1);

        this.create.setSelected(true);

        this.create.setOnAction(e -> {
            if (this.create.isSelected()) {
                this.create.setSelected(true);
            }

        });

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(8));
        this.setHgap(10);
        this.setVgap(10);

        this.getChildren().addAll(title, this.create, this.delete, this.box);

    }

    /**
     *
     * @param list
     *            of elements (es boids) to insert in the choisebox
     */
    private void insertElements(final List<String> elem) {
        this.box.setValue(elem.get(0));
        elem.stream().forEach(e -> this.box.getItems().add(e));
    }

    /**
     * test method
     */
    private void printSelectedItem() {
        if (BoidSelection.selectedItem.isPresent()) {
            System.out.println(BoidSelection.boidList.indexOf(BoidSelection.selectedItem.get()));
        } else {
            System.out.println("nessun elemento selezionato");
        }
    }

    /**
     *
     * @return the selected boid in the choise box
     */
    static Optional<Integer> getSelectedBoid() {
        final Optional<String> item = BoidSelection.selectedItem;
        if (item.isPresent()) {
            return Optional.of(BoidSelection.boidList.indexOf(item.get()));
        } else {
            return Optional.of(0);
        }

    }

    /**
     *
     * @param v
     *            position clicked
     * @return the input to add to InputHandler
     */
    static InputInfo getInput(final Vector v) {
        if (BoidSelection.action) {
            return new InputInfo(Input.CREATE_BOID, BoidSelection.getSelectedBoid().get(), v);
        } else {
            return new InputInfo(Input.DESTROY_BOID, v);
        }
    }

}
