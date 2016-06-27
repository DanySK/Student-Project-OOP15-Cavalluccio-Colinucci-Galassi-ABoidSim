package aboidsim.model;

import aboidsim.util.Vector;

/**
 *
 * This class show the behavior of a tree static Boid. The TreeBoid can not move
 * and it has more life than other Boids.
 *
 */

public class TreeBoid {

    private static final int TREE_BOID_LIFE = 500;
    private final Vector position;
    private final int life;

    /**
     * Constructor.
     *
     * @param pos
     *            Boid position
     */
    public TreeBoid(final Vector pos) {

        this.position = pos;
        this.life = TreeBoid.TREE_BOID_LIFE;
    }

    /**
     * metodo per il nutrimento dei boid erbivori
     */
}
