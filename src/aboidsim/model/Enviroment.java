package aboidsim.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * This class show all the components of the simulation enviroment. (Not
 * tree-boids)
 *
 */
public class Enviroment implements EnviromentInterface {

    private final Set<Boid> enviroment;
    private static final double COLLISION_RADIUS = 0.50;

    /**
     * Constructor.
     */
    public Enviroment() {

        this.enviroment = new HashSet<>();
    }

    @Override
    public void add(final Boid b) {
        this.enviroment.add(b);
    }

    @Override
    public Set<Boid> getEnviroment() {
        return this.enviroment;
    }

    @Override
    public double getCollisionRadius() {
        return Enviroment.COLLISION_RADIUS;
    }
}
