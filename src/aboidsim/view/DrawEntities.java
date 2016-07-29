package aboidsim.view;

import java.util.Set;

import aboidsim.util.Pair;
import aboidsim.util.Vector;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DrawEntities {

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
        final ImageView image = this.createBoid("triangle.png");
        // image.setRotate(rotation);
        final Image prova = image.snapshot(new SnapshotParameters(), null);

        entities.stream().forEach(e -> g.drawImage(prova, e.getX().getX(), e.getX().getY()));

    }

}
