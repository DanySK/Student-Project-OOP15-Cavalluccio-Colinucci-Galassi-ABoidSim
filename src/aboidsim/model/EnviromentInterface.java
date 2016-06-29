package aboidsim.model;

import java.util.Set;

/**
 * Interface of the whole simulation.
 *
 */
public interface EnviromentInterface {

    /**
     * Add a boid to the enviroment.
     *
     * @param b
     *            Boid to add
     */
    void add(final Boid b);

    /**
     * Getter for the enviroment.
     *
     * @return The whole enviroment
     */
    Set<Boid> getEnviroment();

    /**
     *
     * @return Collision radius of every single component of the simulation
     */
    double getCollisionRadius();

}
