package aboidsim.model;

/**
 *
 * enum with life of single component of the environment. Enum arguments:
 *
 * - Boid Level - Boid Life - Boid Influence Radius - Max Boids of same group
 *
 */

enum Levels {

    TREE_L0(0, 500, 0, 0, 0), HERBIVORE_L1(1, 10, 1.5, 10, 1.1), HERBIVORE_L2(2, 20, 2.5, 9, 1.2), HERBIVORE_L3(3, 30,
            3.5, 8, 1.3), HERBIVORE_L4(4, 40, 4.5, 7, 1.4), HERBIVORE_L5(5, 50, 5.5, 6, 1.5), PREDATOR_L6(6, 60, 6.5, 5,
                    1.6), PREDATOR_L7(7, 70, 7.5, 4, 1.7), PREDATOR_L8(8, 80, 8.5, 3,
                            1.8), PREDATOR_L9(9, 90, 9.5, 2, 1.9), PREDATOR_L10(10, 100, 10.5, 1, 2.0);

    private final int id;
    private final int life;
    private final double influenceRadius;
    private final int maxMembers;
    private final double averageSpeed;

    /**
     *
     * @param id
     *            Boid Level
     * @param lif
     *            Boid Life
     * @param rad
     *            Boid Influence Radius
     * @param max_m
     *            Max Boids of same group
     * @param avSpeed
     *            Boid average speed
     */
    Levels(final int iD, final int lif, final double rad, final int maxM, final double avSpeed) {
        this.id = iD;
        this.life = lif;
        this.influenceRadius = rad;
        this.maxMembers = maxM;
        this.averageSpeed = avSpeed;
    }

    public int getId() {
        return this.id;
    }

    public int getLife() {
        return this.life;
    }

    public double getInfluenceRadius() {
        return this.influenceRadius;
    }

    public int getMaxMembers() {
        return this.maxMembers;
    }

    public double getAverageSpeed() {
        return this.averageSpeed;
    }
}
