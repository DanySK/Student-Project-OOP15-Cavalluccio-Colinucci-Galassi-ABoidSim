package aboidsim.view;

import java.util.List;
import java.util.Set;

import aboidsim.controller.Controller;
import aboidsim.util.InputInfo;
import aboidsim.util.Pair;
import aboidsim.util.Vector;

public interface View {

    /**
     * set the controller
     *
     * @param controller
     */
    void setController(final Controller controller);

    /**
     * @return all the input of the interface as a list of IputInfo
     */
    List<InputInfo> getInputs();

    /**
     * start the interface.
     *
     * @param boids
     *            list of the boids's names
     * @param rules
     *            list of the rules
     */
    void start(final List<String> boids, final List<String> rules);

    /**
     * draw all the entities in the simulation screen.
     *
     * @param entities
     *            list of the position and level of all the entities to draw.
     */
    void drawEntities(final Set<Pair<Pair<Vector, Double>, String>> entities);

    /**
     * used to pass to the controller the dimension of the simulation screen i
     * did + height for and appealing reason, to avoid to show cut images
     *
     * @return width and height of the screen that displays the entities
     */
    Pair<Integer, Integer> getScreenDimensions();

}
