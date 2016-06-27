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

    /**
     * Constructor.
     */
    public Enviroment() {

        this.enviroment = new HashSet<>();
    }

    /**
     * Add a boid to the enviroment.
     *
     * @param b
     *            Boid to add
     */
    public void add(final Boid b) {
        this.enviroment.add(b);
    }

    /**
     * Getter for the enviroment.
     *
     * @return The whole enviroment
     */
    public Set<Boid> getEnviroment() {
        return this.enviroment;
    }
}
