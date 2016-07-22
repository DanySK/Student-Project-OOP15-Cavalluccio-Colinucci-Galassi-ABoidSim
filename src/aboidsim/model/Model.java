package aboidsim.model;

import java.util.List;

/**
 *
 * Model Interface.
 *
 */
public interface Model {

    /**
     *
     * @return the environment of the simulation.
     */

    Environment getSimulation();

    /**
     *
     * @return get all possible levels.
     */
    List<Integer> getLevels();

    /**
     *
     * @return a list of active rules.
     */
    List<String> getRules();
}
