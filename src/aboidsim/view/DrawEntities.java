package aboidsim.view;

import java.util.Set;

import aboidsim.util.Pair;
import aboidsim.util.Vector;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DrawEntities {

	private static final String SEP = System.getProperty("file.separator");

	private static final String backgroundImage = "file:" + DrawEntities.SEP + DrawEntities.SEP + DrawEntities.SEP
			+ System.getProperty("user.dir") + DrawEntities.SEP + "res" + DrawEntities.SEP + "images" + DrawEntities.SEP
			+ "simulationBackground.jpg";

	private static final String boidImages = "file:" + DrawEntities.SEP + DrawEntities.SEP + DrawEntities.SEP
			+ System.getProperty("user.dir") + DrawEntities.SEP + "res" + DrawEntities.SEP + "boids" + DrawEntities.SEP;

	/**
	 *
	 * @param url
	 *            url of the image to draw
	 * @param width
	 *            with of the image
	 * @param height
	 *            height of the image
	 * @return
	 */
	private ImageView createEntity(final String url, final double width, final double height) {
		final ImageView boid = new ImageView(new Image(url, width, height, false, false));
		return boid;
	}

	/**
	 *
	 * @param g
	 *            graphics context used to draw entities
	 * @param entities
	 *            set of the position and the url of the image of each entity to
	 *            draw
	 */
	void drawEntities(final GraphicsContext g,
			final Set<Pair<Pair<Vector, Double>, String>> entities/*
																	 * , final
																	 * int
																	 * rotation
																	 */) {

		g.clearRect(0, 0, SimulationScreen.WIDTH, SimulationScreen.HEIGHT);

		entities.stream().forEach(e -> {
			final ImageView image;
			if (e.getY().equals("tree.png")) {
				image = this.createEntity(DrawEntities.boidImages + e.getY(), SimulationScreen.BOID_HEIGHT,
						SimulationScreen.BOID_HEIGHT);
			} else {
				image = this.createEntity(DrawEntities.boidImages + e.getY(), SimulationScreen.BOID_WIDTH,
						SimulationScreen.BOID_HEIGHT);
			}
			image.setRotate(e.getX().getY());
			final SnapshotParameters param = new SnapshotParameters();
			param.setFill(javafx.scene.paint.Color.TRANSPARENT);
			final Image prova = image.snapshot(param, null);
			// final Image prova = new Image(this.boidImages + e.getY(), 10, 20,
			// false, false);
			g.drawImage(prova, e.getX().getX().getX(), e.getX().getX().getY());
		});

	}

}
