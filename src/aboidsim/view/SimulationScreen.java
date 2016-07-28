package aboidsim.view;

import aboidsim.util.Pair;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
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

	/**
	 * constructor
	 */
	public SimulationScreen() {
		super();

		final Canvas canvas = new Canvas(SimulationScreen.WIDTH, SimulationScreen.HEIGHT);
		this.getChildren().add(canvas);

		final GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		final Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
		gc.setFont(theFont);

		// print the coordinates of the clicked point
		canvas.setOnMouseClicked(e -> System.out.println("x: " + e.getSceneX() + " y:  " + e.getSceneY()));

		this.drawBoid(gc, 200, 200, 30);
		this.drawBoid(gc, 0, 0, 160);
	}

	private void



    /**
     *
     * @param url
     *            boid's image
     * @param x
     *            x image's dimension
     * @param y
     *            y imege's dimension
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
