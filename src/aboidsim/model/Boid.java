package aboidsim.model;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import aboidsim.util.Vector;

/**
 *
 * This class shows the basic features of a boid.
 *
 */
public class Boid implements BoidInterface {

    private final Vector position;
    private final Vector acceleration;
    private final Vector speed;

    private final int level;
    private final double averageSpeed;
    private int life; // when life gets lower, hunger grews up
    private final int maxMembers;

    private static final double COLLISION_RADIUS = 0.50;
    private final double influenceRadius;
    private Set<Boid> nearBoids; // a list with closest boids of same level

    private static final int PREDATOR_HUNGER = 20;
    private static final int HERBIVORE_HUNGER = 20;

    private final Enviroment env = new Enviroment();

    /**
     *
     * @param pos
     *            Boid position
     * @param liv
     *            Boid level
     */

    public Boid(final Vector pos, final int liv) {

        final Random r = new Random();

        this.position = pos;
        this.acceleration = new Vector(0, 0);
        this.speed = new Vector(r.nextDouble(), r.nextDouble());

        final Levels lev = this.getInfo(liv);

        // Boid initialization
        this.level = lev.getId();
        this.life = lev.getLife();
        this.influenceRadius = lev.getInfluenceRadius();
        this.maxMembers = lev.getMaxMembers();
        this.averageSpeed = lev.getAverageSpeed();
    }

    @Override
    public void checkNearBoids() {
        final Set<Boid> sameLevelBoid = this.env.getEnviroment().stream().filter(b -> b.level == this.level)
                .collect(Collectors.toSet());
        for (final Boid b : sameLevelBoid) {
            if (this.position.dist(b.position) < this.influenceRadius) {
                if (this.nearBoids.size() < this.maxMembers) {
                    this.nearBoids.add(b);
                }
            }
        }
    }

    @Override
    public void decrementLife() {
        this.life = this.life - 1;
    }

    @Override
    public boolean isHungry() {
        if (this.level < Levels.BOID_L5.getId()) { // isHerbivore
            return this.life < Boid.HERBIVORE_HUNGER;
        } else {
            return this.level < Boid.PREDATOR_HUNGER; // isPredator
        }
    }

    private Levels getInfo(final int lev) {
        return Arrays.stream(Levels.values()).filter(l -> l.getId() == lev).findFirst().get();
    }

    // metodo collisione
}
