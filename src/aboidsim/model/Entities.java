package aboidsim.model;

/**
 *
 * enum with life of single component of the environment. Enum arguments:
 *
 * - Boid Level - Boid Life - Boid Influence Radius - Max Boids of same group
 *
 */

enum Entities {

	TREE_L0("TREE", "tree.png", 0, 500, 0, 50, 0), HERBIVORE_L1("HERBIVORE - LEVEL 1", "herbivore0.png", 1, 100, 1.5,
			10, 1.1), HERBIVORE_L2("HERBIVORE - LEVEL 2", "herbivore1.png", 2, 200, 2.5, 9, 1.2), HERBIVORE_L3(
					"HERBIVORE - LEVEL 3", "herbivore2.png", 3, 300, 3.5, 8,
					1.3), HERBIVORE_L4("HERBIVORE - LEVEL 4", "herbivore3.png", 4, 400, 4.5, 7, 1.4), HERBIVORE_L5(
							"HERBIVORE - LEVEL 5", "herbivore4.png", 5, 500, 5.5, 6,
							1.5), PREDATOR_L6("PREDATOR - LEVEL 6", "predator0.png", 6, 600, 6.5, 5, 1.6), PREDATOR_L7(
									"PREDATOR - LEVEL 7", "predator1.png", 7, 700, 7.5, 4,
									1.7), PREDATOR_L8("PREDATOR - LEVEL 8", "predator2.png", 8, 800, 8.5, 3,
											1.8), PREDATOR_L9("PREDATOR - LEVEL 9", "predator3.png", 9, 900, 9.5, 2,
													1.9), PREDATOR_L10("PREDATOR - LEVEL 10", "predator4.png", 10, 1000,
															10.5, 1, 2.0);

	private final String image;
	private final String name;
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
	Entities(final String nam, final String img, final int iD, final int lif, final double rad, final int maxM,
			final double avSpeed) {
		this.name = nam;
		this.image = img;
		this.id = iD;
		this.life = lif;
		this.influenceRadius = rad;
		this.maxMembers = maxM;
		this.averageSpeed = avSpeed;
	}

	public String getName() {
		return this.name;
	}

	public String getImage() {
		return this.image;
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
