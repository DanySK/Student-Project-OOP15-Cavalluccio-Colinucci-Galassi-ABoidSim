package aboidsim.model;

import java.util.List;
import java.util.Set;

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
     * @return a set of active rules.
     */
    Set<RuleImpl> getActiveRules();
}
