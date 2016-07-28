package aboidsim.model;

import java.util.Set;

import aboidsim.util.Vector;

/**
 *
 * General Boid Interface.
 *
 */

interface Boid {

    /**
     * Increment boid life when eating.
     */
    void incrementLife();

    /**
     * decrement life each loop iteration.
     */
    void decrementLife();

    /**
     *
     * @return Is Boid hungry or not
     */
    boolean isHungry();

    /**
     *
     * @return if a boid is a predator or not.
     */
    boolean isPredator();

    /**
     *
     * @return if a boid is a tree or not.
     */
    boolean isNotTree();

    /**
     *
     * @return Boid level
     */
    int getLevel();

    /**
     *
     * @param boid
     *            boid checked.
     * @return if a boid is colliding with another one.
     */
    boolean isCollidingWith(final Boid boid);

    /**
     *
     * @return Boid position
     */
    Vector getPosition();

    /**
     *
     * @return Boid life
     */
    int getLife();

    /**
     *
     * @return a Set of closest boids
     */
    Set<Boid> getSameLevelNearBoids();

    /**
     * @return other level near boids.
     */

    Set<Boid> getOtherLevelNearBoids();

    /**
     *
     * @return Boid acceleration
     */
    Vector getAcceleration();

    /**
     *
     * @return Boid speed
     */
    Vector getSpeed();

    /**
     *
     * @return Boid average speed
     */
    double getAverageSpeed();

    /**
     *
     * @return max Member of a Boid group
     */
    int getMaxMembers();

    /**
     *
     * @return Boid influence radius
     */
    double getInfluenceRadius();
}
