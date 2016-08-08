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
    List<String> getEntitiesNames();

    /**
     *
     * @return a list of active rules.
     */
    List<String> getRules();
    
    /**
     * 
     * @return all the environment names.
     */
    List<String> getAllEnvironmentsNames();
}
