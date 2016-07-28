package aboidsim.view;

import java.util.List;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BoidSelection extends VBox {

	// private static VBox layout = new VBox(8);
	private final ComboBox<String> box;
	private static Optional<String> selectedItem = Optional.empty();
	private static List<String> boidList;

	/**
	 * constructor of the class.
	 *
	 * @param elements
	 */
	public BoidSelection(final List<String> elements) {
		super(5);
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

	static Integer getSelectedBoid() {
		return BoidSelection.boidList.indexOf(BoidSelection.selectedItem.get());
	}

}
