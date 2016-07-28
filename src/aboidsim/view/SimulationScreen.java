package aboidsim.view;

import java.util.Optional;

import aboidsim.util.Input;
import aboidsim.util.InputInfo;
import aboidsim.util.Vector;
import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * section of the interface containing the moving boids.
 *
 */
public class SimulationScreen extends Group {

	static final int BOID_HEIGHT = 20;
	static final int BOID_WIDTH = 10;
	static final int HEIGHT = 800;
	static final int WIDTH = 800;
	private final String url = "file:" + System.getProperty("file.separator") + System.getProperty("file.separator")
			+ System.getProperty("file.separator") + System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "res" + System.getProperty("file.separator") + "boids"
			+ System.getProperty("file.separator") + "herbivore0.png";

	/**
	 * constructor
	 */
	public SimulationScreen() {
		super();

		final Canvas canvas = new Canvas(SimulationScreen.WIDTH, SimulationScreen.HEIGHT);
		// this.getStylesheets().
		this.getChildren().add(canvas);

		final GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		final Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
		gc.setFont(theFont);

		// print the coordinates of the clicked point and calls addInputs method
		// passing scene's coordinates
		canvas.setOnMouseClicked(e -> {
			System.out.println("x: " + e.getSceneX() + " y:  " + e.getSceneY());
			this.addInputs(new Vector(e.getSceneX(), e.getSceneY()));
		});

	}

	/**
	 * add input to InputHandler, with the pos and the type of the boid selected
	 * in class BoidsSelection
	 */
	private void addInputs(final Vector pos) {
		final Optional<Integer> item = BoidSelection.getSelectedBoid();
		if (item.isPresent()) {
			InputHandler.getInputHandler().addInput(new InputInfo(Input.CREATE_BOID, item.get(), pos));
		}

	}

	/**
	 *
	 * @param url
	 *            boid's image
	 * @param x
	 *            x image's dimension
	 * @param y
	 *            y imege's dimensiony
	 * @return
	 */
	private Image createBoid(final String url, final double x, final double y) {
		final Image boid = new Image(url, x, y, false, false);
		return boid;
	}

	/**
	 * it draws a boid in the given coords with the given rotation
	 *
	 * @param g
	 *            graphicscontext
	 * @param x
	 *            x coord
	 * @param y
	 *            y coord
	 */
	private void drawBoid(final GraphicsContext g, final int x, final int y, final int rotation) {
		final ImageView image = new ImageView(
				this.createBoid("triangle.png", SimulationScreen.BOID_WIDTH, SimulationScreen.BOID_HEIGHT));
		image.setRotate(rotation);
		// bisogna capire come farlo andare
		image.setOnMouseClicked(e -> System.out.println("hai cliccato sull'immagine!"));
		final Image prova = image.snapshot(new SnapshotParameters(), null);

		g.drawImage(prova, x, y);
	}

}
