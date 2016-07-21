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
    private int life;
    private final int maxMembers;

    private final double influenceRadius;
    // private final Set<Boid> otherLevelNearBoids;
    private Set<Boid> sameLevelNearBoids; // a list with closest
                                          // boids of same level

    private static final int PREDATOR_HUNGER = 20;
    private static final int HERBIVORE_HUNGER = 10;

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

    }

    @Override
    public void checkSameCloseBoid() {
        final Set<Boid> sameLevelBoid = this.env.getEnviroment().stream().filter(b -> b.level == this.level)
                .collect(Collectors.toSet());
        for (final Boid b : sameLevelBoid) {
            if (this.position.dist(b.position) < this.influenceRadius) {
                if (this.sameLevelNearBoids.size() < this.maxMembers) {
                    this.sameLevelNearBoids.add(b);
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

    @Override
    public void eating() {
        this.life = this.life + 10;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public Vector getPosition() {
        return this.position;
    }

    @Override
    public int getLife() {
        return this.life;
    }

    @Override
    public Set<Boid> getNearBoids() {
        return this.sameLevelNearBoids;
    }

    @Override
    public Vector getAcceleration() {
        return this.acceleration;
    }

    @Override
    public Vector getSpeed() {
        return this.speed;
    }

    @Override
    public double getAverageSpeed() {
        return this.averageSpeed;
    }

    @Override
    public int getMaxMembers() {
        return this.maxMembers;
    }

    @Override
    public double getInfluenceRadius() {
        return this.influenceRadius;
    }

    private Levels getInfo(final int lev) {
        return Arrays.stream(Levels.values()).filter(l -> l.getId() == lev).findFirst().get();
    }

    // metodo collisione
}
