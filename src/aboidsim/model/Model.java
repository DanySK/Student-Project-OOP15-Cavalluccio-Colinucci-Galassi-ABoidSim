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
     * @return the enviroment of the simulation.
     */

    Environment getSimulation();

    /**
     *
     * @return get all possible levels.
     */
    List<Integer> getLevels();
}
