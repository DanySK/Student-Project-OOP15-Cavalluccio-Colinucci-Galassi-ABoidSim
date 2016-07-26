package aboidsim.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import aboidsim.util.Pair;
import aboidsim.util.Vector;

/**
 *
 * This class show all the components of the simulation environment. Singleton
 * pattern used.
 *
 */
public final class EnvironmentImpl implements Environment {

	private static final EnvironmentImpl ENVIRONMENT_IMPL = new EnvironmentImpl();
	private final Set<Boid> enviroment = new HashSet<>();
	private static final double COLLISION_RADIUS = 0.50;
	private final RuleSet rules = new RuleSet();

	/**
	 * Constructor.
	 */
	EnvironmentImpl() {
	}

	static EnvironmentImpl getEnviromentImpl() {
		return EnvironmentImpl.ENVIRONMENT_IMPL;
	}

	@Override
	public void createBoid(final Vector pos, final int liv) {
		final Boid boid = new BoidImpl(pos, liv);
		this.enviroment.add(boid);
	}

	@Override
	public void destroyBoid(final Vector pos) {
		this.enviroment.remove(this.enviroment.stream()
				.filter(boid -> boid.getPosition().dist(pos) < EnvironmentImpl.COLLISION_RADIUS).findFirst().get());
	}

	@Override
	public void checkBoidSameLevel() {
		for (final Boid boid : this.enviroment) {
			if (boid.isNotTree()) {
				boid.getSameLevelNearBoids()
						.addAll(this.enviroment.stream().filter(b -> boid.getLevel() == b.getLevel())
								.filter(bo -> boid.getPosition().dist(bo.getPosition()) < boid.getInfluenceRadius())
								.limit(boid.getMaxMembers()).collect(Collectors.toSet()));
			}
		}
	}

	@Override
	public void checkBoidOtherLevel() {
		for (final Boid boid : this.enviroment) {
			if (boid.isNotTree()) {
				boid.getOtherLevelNearBoids()
						.addAll(this.enviroment.stream().filter(b -> boid.getLevel() != b.getLevel())
								.filter(bo -> boid.getPosition().dist(bo.getPosition()) < boid.getInfluenceRadius())
								.collect(Collectors.toSet()));
			}
		}
	}

	@Override
	public void collision() {
		for (final Boid boid : this.enviroment) {
			if (boid.isNotTree()) {

			}
		}
	}

	@Override
	public void toggleRule(final int ruleId) {
		final RuleImpl rule = Arrays.stream(RuleImpl.values()).filter(r -> r.getID() == ruleId).findFirst().get();
		if (this.rules.getRules().contains(rule)) {
			this.rules.removeRule(rule);
		} else {
			this.rules.addRule(rule);
		}
	}

	@Override
	public Set<Pair<Vector, Integer>> getEntities() {
		return this.enviroment.stream().map(boid -> new Pair<>(boid.getPosition(), boid.getLevel()))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<Boid> getEnviroment() {
		return this.enviroment;
	}

	@Override
	public double getCollisionRadius() {
		return EnvironmentImpl.COLLISION_RADIUS;
	}

	/**
	 * This method is called once every cycle. It updates the position of every
	 * boid according to the rules.
	 */
	@Override
	public void updateEnvironment() {
		this.checkBoidOtherLevel();
		this.checkBoidSameLevel();
		for (final Boid boid : this.enviroment) {
			final Vector sumVector = new Vector(0.0, 0.0);
			boid.decrementLife(); // Life is decremented here
			if (boid.getLife() <= 0) { // If the boid is dead, we remove it from
										// the simulation
				this.enviroment.remove(boid);
			} else {
				// If the boid is still alive
				final Set<Boid> closeSameLevelBoids = boid.getSameLevelNearBoids();
				final Set<Boid> closeOtherLevelBoids = boid.getOtherLevelNearBoids();
				final Set<Boid> closePredators = closeOtherLevelBoids.stream()
						.filter(pred -> (pred.isPredator() && boid.getLevel() < pred.getLevel()))
						.collect(Collectors.toSet());
				for (final Boid pred : closePredators) {
					/*
					 * if (boid.getPosition() - pred.getPosition() <
					 * this.getCollisionRadius()) { boid.decrementLife();
					 * pred.incrementLife(); }
					 */
				}
				if (!boid.isNotTree()) { // If the boid is a Tree Boid, there is
											// nothing left to do
					if (!closePredators.isEmpty() && this.rules.getRules().contains(RuleImpl.EVASION)) {
						// Safety has the bigger priority
						sumVector.add(RuleImpl.EVASION.apply(boid, closePredators));
						sumVector.mul(boid.getAverageSpeed());
					} else {
						// The boid seeks a target to eat
						if (!closeOtherLevelBoids.isEmpty() && closePredators.isEmpty() && boid.isHungry()) {
							// If there are no predators around
							Optional<Boid> prey = Optional.empty();
							if (boid.isPredator()) {
								/*
								 * The predator boid will look for any lower
								 * level (except the tree) in his radius. HE MAY
								 * WANT TO CHANGE TARGET
								 */
								prey = closeOtherLevelBoids.stream().filter(b -> b.isNotTree()).findFirst();
							} else {
								// This boid in an herbivore
								prey = closeOtherLevelBoids.stream().filter(b -> !b.isNotTree()).findFirst();
							}
							if (prey.isPresent()) {
								/*
								 * If there is an available prey, we want to
								 * boid to approach it
								 */
								final Vector desiredDirection = Vector.sub(prey.get().getPosition(),
										boid.getPosition());
								desiredDirection.norm();
								desiredDirection.mul(boid.getAverageSpeed());
								/*
								 * We want the boid to steer towards the target
								 */
								sumVector.add(Vector.sub(desiredDirection, boid.getSpeed()));
								sumVector.mul(boid.getAverageSpeed());
							}
						} else {
							/*
							 * If there are some same level boids around and the
							 * boid is not seeking food
							 */
							if (!closeSameLevelBoids.isEmpty()) {
								if (this.rules.getRules().contains(RuleImpl.ALIGNMENT)) {
									sumVector.add(RuleImpl.ALIGNMENT.apply(boid, closeSameLevelBoids));
								}
								if (this.rules.getRules().contains(RuleImpl.COHESION)) {
									sumVector.add(RuleImpl.COHESION.apply(boid, closeSameLevelBoids));
								}
								if (this.rules.getRules().contains(RuleImpl.SEPARATION)) {
									sumVector.add(RuleImpl.SEPARATION.apply(boid, closeSameLevelBoids));
								}
							} else {
								/*
								 * Wander. This movement is described as a
								 * random yet believable movement. There are no
								 * rapid turns and it feels more "real"
								 */

							}
						}
					}
					sumVector.mul(boid.getAverageSpeed());
					// We add the combining movements to the boid position
					boid.getSpeed().add(sumVector);
					boid.getPosition().add(boid.getSpeed());
				}
			}

		}
	}
}
