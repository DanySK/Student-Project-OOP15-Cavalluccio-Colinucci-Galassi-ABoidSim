package aboidsim.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import aboidsim.util.Vector;

/**
 *
 * This class shows the basic features of a boid.
 *
 */
public class BoidImpl implements Boid {

    private final Vector position;
    private final Vector acceleration;
    private final Vector speed;

    private final int level;
    private final double averageSpeed;
    private int life;
    private final int maxMembers;

    private final double influenceRadius;
    private final Set<Boid> otherLevelNearBoids;
    private final Set<Boid> sameLevelNearBoids; // a list with closest
    // boids of same level

    private static final int PREDATOR_HUNGER = 20;
    private static final int HERBIVORE_HUNGER = 10;

    /**
     *
     * @param pos
     *            Boid position
     * @param liv
     *            Boid level
     */

    public BoidImpl(final Vector pos, final int liv) {

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
        this.sameLevelNearBoids = new HashSet<>();
        this.otherLevelNearBoids = new HashSet<>();
    }

    @Override
    public void decrementLife() {
        this.life = this.life - 1;
    }

    @Override
    public boolean isHungry() {
        if (this.isPredator()) {
            return this.level < BoidImpl.PREDATOR_HUNGER; // isPredator
        } else {
            return this.life < BoidImpl.HERBIVORE_HUNGER; // isHerbivore
        }
    }

    @Override
    public boolean isPredator() {
        return this.level > Levels.HERBIVORE_L5.getId();
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
    public Set<Boid> getSameLevelNearBoids() {
        return this.sameLevelNearBoids;
    }

    @Override
    public Set<Boid> getOtherLevelNearBoids() {
        return this.otherLevelNearBoids;
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
}
