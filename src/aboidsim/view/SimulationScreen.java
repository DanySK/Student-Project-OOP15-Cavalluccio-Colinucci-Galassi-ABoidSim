package aboidsim.view;

import java.util.Optional;
import java.util.Set;

import aboidsim.util.Input;
import aboidsim.util.InputInfo;
import aboidsim.util.Pair;
import aboidsim.util.Vector;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * section of the interface containing the moving boids.
 */
public class SimulationScreen extends Group {

    static final int BOID_HEIGHT = 20;
    static final int BOID_WIDTH = 10;
    static final int HEIGHT = 800;
    static final int WIDTH = 800;
    private final DrawEntities drawEntities = new DrawEntities();
    private final GraphicsContext gc;

    private final String url = "file:" + System.getProperty("file.separator") + System.getProperty("file.separator")
            + System.getProperty("file.separator") + System.getProperty("user.dir")
            + System.getProperty("file.separator") + "res" + System.getProperty("file.separator") + "boids"
            + System.getProperty("file.separator") + "herbivore0.png";

    final String background = "file:" + System.getProperty("file.separator") + System.getProperty("file.separator")
            + System.getProperty("file.separator") + System.getProperty("user.dir")
            + System.getProperty("file.separator") + "res" + System.getProperty("file.separator") + "images"
            + System.getProperty("file.separator") + "simulationBackground.png";

    // prova disegnare boids direttamente da qua
    // final Set<Pair<Vector, String>> set = new HashSet<>();
    // set.add(new Pair<Vector, String>(new Vector(10, 10), "ciao"));
    // this.drawOnScreen(set);

    /**
     * constructor
     */
    public SimulationScreen() {
        super();
        // this.getStyle().
        final Canvas canvas = new Canvas(SimulationScreen.WIDTH, SimulationScreen.HEIGHT);
        // this.getStylesheets().
        this.getChildren().add(canvas);

        this.gc = canvas.getGraphicsContext2D();
        this.gc.setFill(Color.RED);
        this.gc.setStroke(Color.BLACK);
        this.gc.setLineWidth(2);
        final Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
        this.gc.setFont(theFont);

        // print the coordinates of the clicked point and calls addInputs method
        // passing scene's coordinates
        canvas.setOnMouseClicked(e -> {
            System.out.println("x: " + e.getSceneX() + " y:  " + e.getSceneY());
            this.addInputs(new Vector(e.getSceneX(), e.getSceneY()));
        });

        // prova disegnare boids direttamente da qua
        // final Set<Pair<Vector, String>> set = new HashSet<>();
        // set.add(new Pair<Vector, String>(new Vector(10, 10), "ciao"));
        // this.drawOnScreen(set);

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

    void drawOnScreen(final Set<Pair<Vector, String>> entities) {
        this.drawEntities.drawBoid(this.gc, entities);
    }

}
