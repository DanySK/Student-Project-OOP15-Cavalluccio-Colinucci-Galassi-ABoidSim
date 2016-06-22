package aboidsim.model;

import java.util.Set;

import aboidsim.util.Vector;

/**
 *
 * This class shows the basic features of a boid.
 *
 */
public class Boid {

    private final Vector position;
    private final Vector acceleration;
    private final Vector speed;

    private int life; // when life gets lower, hunger grews up
    private Set<Boid> nearBoids; // a list with closest boids

    /**
     *
     * @param pos
     *            Boid position
     * @param acc
     *            Boid acceleration
     * @param sp
     *            Boid speed
     *
     */
    public Boid(final Vector pos, final Vector acc, final Vector sp) {

        this.position = pos;
        this.acceleration = acc;
        this.speed = sp;
        this.life = Lifes.CUSTOM_BOID_LIFE.getLife();
    }

    /**
     * first method this method decrements life each time.
     */
    public void decrementLife() {
        this.life = this.life - 1;
    }

    // metodo 2
    // check if a near (param distance d) is more or less aggressive than this
    // boid.

    // metodo 3
    // inserire, rimuovere e controllare Boid vicini.
}
