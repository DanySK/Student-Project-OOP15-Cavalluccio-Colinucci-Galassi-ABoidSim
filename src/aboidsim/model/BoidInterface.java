package aboidsim.model;

/**
 *
 * General Boid Interface.
 *
 */

public interface BoidInterface {

    /**
     * check closest boids.
     */
    void checkNearBoids();

    /**
     * decrement life each loop iteration.
     */
    void decrementLife();

    /**
     *
     * @return Is Boid hungry or not
     */
    boolean isHungry();

}
