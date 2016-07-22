package aboidsim.model;

import java.util.Set;

import aboidsim.util.Vector;

/**
 * Interface of the whole simulation.
 *
 */
public interface Environment {

    /**
     * Add a boid to the enviroment.
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
     * Manage all the boid collision and consequences.
     */
    void collision();

    /**
     * Getter for the environment.
     *
     * @return The whole environment
     */
    Set<Boid> getEnviroment();

    /**
     *
     * @return Collision radius of every single component of the simulation
     */
    double getCollisionRadius();
}
