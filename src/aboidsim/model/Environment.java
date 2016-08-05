package aboidsim.model;

import java.util.Set;

import aboidsim.util.Pair;
import aboidsim.util.Vector;

/**
 * Interface of the whole simulation.
 *
 */
public interface Environment {

    /**
     * Add a boid to the environment.
     *
     * @param pos
     *            New boid position.
     * @param liv
     *            New boid level.
     */
    void createBoid(final Vector pos, final int liv);

    /**
     * Destroy a boid in this position (if present).
     *
     * @param pos
     *            of designated boid.
     */
    void destroyBoid(final Vector pos);

    /**
     * Add all the closest boids to the "sameLevelNearBoids" field until max
     * size (maxMembers).
     */
    void checkBoidSameLevel();

    /**
     * Add all the closest boids to the "otherLevelNearBoids" field.
     */
    void checkBoidOtherLevel();

    /**
     * Rule management.
     *
     * @param ruleId
     *            id rule.
     */
    void toggleRule(final int ruleId);

    /**
     * Set simulation dimension.
     *
     * @param dimension
     *            simulation dimension.
     */
    void setScreenDimension(final Pair<Integer, Integer> dimension);

    /**
     *
     * @return simulation dimension.
     */
    Pair<Integer, Integer> getSimulationDimension();

    /**
     *
     * @return all the entities of the environment with position and image path.
     */
    Set<Pair<Pair<Vector, Double>, Pair<Integer, String>>> getSimulationComponents();

    /**
     * Getter for the environment.
     *
     * @return The whole environment
     */
    Set<Boid> getEnvironment();

    /**
     * This method updates the state of the simulation.
     */
    void updateEnvironment();
}
