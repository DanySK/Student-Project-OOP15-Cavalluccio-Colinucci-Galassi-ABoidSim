package aboidsim.model;

import java.util.Set;
import java.util.stream.Collectors;

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
    private int life;

    private final Enviroment env = new Enviroment();

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
     * A treeboid feeds other herbivore boids.
     */
    public void feeding() {
        final Set<Boid> herbivoreBoids = this.env.getEnviroment().stream()
                .filter(b -> b.getLevel() < Levels.BOID_L5.getId()).collect(Collectors.toSet());
        for (final Boid b : herbivoreBoids) {
            if (this.position.dist(b.getPosition()) < this.env.getCollisionRadius()) {
                this.life = this.life - 10;
                b.eating();
            }
        }
    }
}
