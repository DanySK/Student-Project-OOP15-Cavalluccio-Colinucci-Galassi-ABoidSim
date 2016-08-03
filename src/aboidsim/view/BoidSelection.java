package aboidsim.view;

import java.util.List;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BoidSelection extends VBox {

    private final GridPane grid;
    private final ComboBox<String> box;
    private static Optional<String> selectedItem = Optional.empty();
    private static List<String> boidList;

    private final RadioButton create = new RadioButton("Create");
    private final RadioButton delete = new RadioButton("Delete");
    private boolean action;

    /**
     * constructor of the class.
     *
     * @param elements
     *            the list of the rules's names
     */
    public BoidSelection(final List<String> elements) {
        super(5);
        this.grid = new GridPane();

        BoidSelection.boidList = elements;
        this.box = new ComboBox<>();
        this.box.setPromptText("seleziona elemento da inserire");
        final Text title = new Text("Seleziona tipo di elemento da inserire");
        this.insertElements(elements);

        this.box.setOnAction(e -> BoidSelection.selectedItem = Optional.of(this.box.getValue()));

        final Button show = new Button("mostra elem selezionato");
        show.setOnAction(e -> this.printSelectedItem());
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(8));
        this.getChildren().addAll(title, this.box, show);

    }

    /**
     *
     * @param list
     *            of elements (es boids) to insert in the combobox
     */
    private void insertElements(final List<String> elem) {
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
     * @return the level of the selected boid (if there is one)
     */
    static Optional<Integer> getSelectedBoid() {
        final Optional<String> item = BoidSelection.selectedItem;
        if (item.isPresent()) {
            return Optional.of(BoidSelection.boidList.indexOf(item.get()));
        } else {
            return Optional.empty();
        }

    }

}
