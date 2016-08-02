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
class BoidImpl implements Boid {

	private final Vector position;
	private final Vector acceleration;
	private final Vector speed;

	private final int level;
	private final double averageSpeed;
	private int life;
	private final int maxMembers;

	private final double influenceRadius;
	private final Set<Boid> otherLevelNearBoids;
	private final Set<Boid> sameLevelNearBoids;

	private static final int PREDATOR_HUNGER = 100;
	private static final int HERBIVORE_HUNGER = 50;

	/**
	 * The speed must be limited at this value.
	 */
	public static final double MAX_SPEED = 10;

	/**
	 * Any force must be limited at this value.
	 */
	public static final double MAX_FORCE = 3;

	/**
	 * The distance of the circle from the boid used in the implementation of
	 * "wandering movement".
	 */
	public static final double WANDER_CIRCLE_DISTANCE = 5;

	/**
	 * The radius of the circle used in the implementation of
	 * "wandering movement".
	 */
	public static final double WANDER_CIRCLE_RADIUS = 3;

	/**
	 *
	 * @param pos
	 *            Boid position
	 * @param liv
	 *            Boid level
	 */

	BoidImpl(final Vector pos, final int liv) {

		final Random r = new Random();

		this.position = pos;
		this.acceleration = new Vector(0, 0);
		final double angleOfSpeed = r.doubles(0, Math.PI * 2).findAny().getAsDouble();
		this.speed = new Vector(Math.cos(angleOfSpeed), Math.sin(angleOfSpeed));
		System.out.println("INITIAL CONDITION"); // DEBUGGGGGGGG
		this.position.print();
		this.speed.print();
		this.acceleration.print();

		final Entities lev = this.getInfo(liv);

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
	public void incrementLife() {
		if (this.isNotTree()) {
			this.life = this.life + 1;
		}
	}

	@Override
	public void decrementLife() {
		if (this.isNotTree()) {
			this.life = this.life - 1;
		}
	}

	@Override
	public boolean isCollidingWith(final Boid boid) {
		return this.position.dist(boid.getPosition()) < EnvironmentImpl.getCollisionRadius();
	}

	@Override
	public boolean isHungry() {
		if (this.isPredator()) {
			return this.life < BoidImpl.PREDATOR_HUNGER; // isPredator
		} else {
			return this.life < BoidImpl.HERBIVORE_HUNGER; // isHerbivore
		}
	}

	@Override
	public boolean isPredator() {
		return this.level > Entities.HERBIVORE_L5.getId();
	}

	@Override
	public boolean isNotTree() {
		return this.level != Entities.TREE_L0.getId();
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

	private Entities getInfo(final int lev) {
		return Arrays.stream(Entities.values()).filter(l -> l.getId() == lev).findFirst().get();
	}
}
