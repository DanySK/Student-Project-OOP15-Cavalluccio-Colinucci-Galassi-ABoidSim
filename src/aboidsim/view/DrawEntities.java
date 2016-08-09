package aboidsim.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import aboidsim.util.Pair;
import aboidsim.util.Vector;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * class used to draw all the entities in the simulation screen.
 *
 */
public class DrawEntities {

    static final String SEP = System.getProperty("file.separator");

    private static final String BOID_IMG = "file:" + DrawEntities.SEP + DrawEntities.SEP + DrawEntities.SEP
            + System.getProperty("user.dir") + DrawEntities.SEP + "res" + DrawEntities.SEP + "boids" + DrawEntities.SEP;

    private static List<ImageView> images;

    static void setImages(final List<Pair<Integer, String>> list) {
        DrawEntities.images = new ArrayList<>();
        for (final Pair<Integer, String> p : list) {
            if (p.getX().intValue() == 0) {
                DrawEntities.images.add(DrawEntities.createEntity(DrawEntities.BOID_IMG + p.getY(),
                        SimulationScreen.BOID_HEIGHT, SimulationScreen.BOID_HEIGHT));
            } else {
                DrawEntities.images.add(DrawEntities.createEntity(DrawEntities.BOID_IMG + p.getY(),
                        SimulationScreen.BOID_WIDTH, SimulationScreen.BOID_HEIGHT));
            }
        }
    }

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
    private static ImageView createEntity(final String url, final double width, final double height) {
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
    void drawEntities(final GraphicsContext g, final Set<Pair<Pair<Vector, Double>, Integer>> entities) {

        g.clearRect(0, 0, SimulationScreen.WIDTH, SimulationScreen.HEIGHT);

        entities.stream().forEach(e -> {
            final ImageView image = DrawEntities.images.get(e.getY());
            image.setRotate(e.getX().getY());
            final SnapshotParameters param = new SnapshotParameters();
            param.setFill(javafx.scene.paint.Color.TRANSPARENT);
            final Image prova = image.snapshot(param, null);
            g.drawImage(prova, e.getX().getX().getX(), e.getX().getX().getY());
        });

    }

}
