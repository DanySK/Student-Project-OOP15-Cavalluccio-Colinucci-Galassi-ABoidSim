package aboidsim.view;

import java.util.Set;

import aboidsim.util.Pair;
import aboidsim.util.Vector;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DrawEntities {

    final String backgroundImage = "file:" + System.getProperty("file.separator") + System.getProperty("file.separator")
            + System.getProperty("file.separator") + System.getProperty("user.dir")
            + System.getProperty("file.separator") + "res" + System.getProperty("file.separator") + "images"
            + System.getProperty("file.separator") + "simulationBackground.jpg";

    final String boidImages = "file:" + System.getProperty("file.separator") + System.getProperty("file.separator")
            + System.getProperty("file.separator") + System.getProperty("user.dir")
            + System.getProperty("file.separator") + "res" + System.getProperty("file.separator") + "boids"
            + System.getProperty("file.separator");

    /**
     *
     * @param url
     * @return
     */
    private ImageView createBoid(final String url) {
        final ImageView boid = new ImageView(
                new Image(url, SimulationScreen.BOID_WIDTH, SimulationScreen.BOID_HEIGHT, false, false));
        return boid;
    }

    /**
     *
     * @param g
     * @param entities
     */
    void drawBoid(final GraphicsContext g,
            final Set<Pair<Vector, String>> entities/* , final int rotation */) {

        // final ImageView background = new ImageView(new
        // Image(this.backgroundImage, 820, 820, false, false));
        // final Image sfondo = background.snapshot(new SnapshotParameters(),
        // null);

        // image.setRotate(rotation);

        // g.drawImage(sfondo, 0, 0);
        g.clearRect(0, 0, 820, 820);
        entities.stream().forEach(e -> {
            final ImageView image = this.createBoid(this.boidImages + e.getY());
            // image.setRotate(45);
            final SnapshotParameters param = new SnapshotParameters();
            param.setFill(javafx.scene.paint.Color.TRANSPARENT);
            final Image prova = image.snapshot(param, null);
            // final Image prova = new Image(this.boidImages + e.getY(), 10, 20,
            // false, false);
            g.drawImage(prova, e.getX().getX(), e.getX().getY());
        });

    }

}
