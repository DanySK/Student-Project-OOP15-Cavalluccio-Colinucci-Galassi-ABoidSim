package aboidsim.view;

import aboidsim.util.Vector;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DrawEntities {

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
	private Image createBoid(final String url) {
		final Image boid = new Image(url, SimulationScreen.BOID_WIDTH, SimulationScreen.BOID_HEIGHT, false, false);
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
	private void drawBoid(final GraphicsContext g,
			final Vector v/* , final int rotation */) {
		final ImageView image = new ImageView(this.createBoid("triangle.png"));
		// image.setRotate(rotation);
		// bisogna capire come farlo andare
		// image.setOnMouseClicked(e -> System.out.println("hai cliccato
		// sull'immagine!"));

		final Image prova = image.snapshot(new SnapshotParameters(), null);

		g.drawImage(prova, v.getX(), v.getY());
	}

}
