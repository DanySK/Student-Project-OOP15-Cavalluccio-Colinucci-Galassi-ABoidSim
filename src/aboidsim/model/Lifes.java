package aboidsim.model;

/**
 *
 * enum with lifes of single component of the enviroment.
 *
 */

enum Lifes {

    PREDATOR_LIFE(120), CUSTOM_BOID_LIFE(100), HERBIVORE_LIFE(80);

    private final int life;

    Lifes(final int lif) {
        this.life = lif;
    }

    public int getLife() {
        return this.life;
    }
}
