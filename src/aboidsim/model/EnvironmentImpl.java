package aboidsim.model;

import java.util.Arrays;
import java.util.HashSet;
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
	public void updateEnvironment() {
		this.checkBoidOtherLevel();
		this.checkBoidSameLevel();
		for (final Boid boid : this.enviroment) {
			final Vector sumVector = new Vector(0.0, 0.0);
			if (boid.getLife() <= 0) { // If the boid is dead, we remove it from
										// the simulation
				this.enviroment.remove(boid);
				return;
			}
			final Set<Boid> closeSameLevelBoids = boid.getSameLevelNearBoids();
			final Set<Boid> closeOtherLevelBoids = boid.getOtherLevelNearBoids();
			final Set<Boid> closePredators = closeOtherLevelBoids.stream()
					.filter(pred -> (pred.isPredator() && boid.getLevel() < pred.getLevel()))
					.collect(Collectors.toSet());

			/*
			 * for (Boid pred : closePredators) { if (boid.getPosition -
			 * pred.getPosition < this.getCollisionRadius()) {
			 * boid.decrementLife(); pred.incrementLife(); } if
			 * (this.rules.getRules().contains(RuleImpl.EVASION)) {
			 * sumVector.add(RuleImpl.EVASION.apply(boid, closePredators)) }
			 *
			 * }
			 */
			if (this.rules.getRules().contains(RuleImpl.ALIGNMENT)) {
				sumVector.add(RuleImpl.ALIGNMENT.apply(boid, closeSameLevelBoids));
			}
			if (this.rules.getRules().contains(RuleImpl.COHESION)) {
				sumVector.add(RuleImpl.COHESION.apply(boid, closeSameLevelBoids));
			}
			if (this.rules.getRules().contains(RuleImpl.SEPARATION)) {
				sumVector.add(RuleImpl.SEPARATION.apply(boid, closeSameLevelBoids));
			}
			sumVector.mul(boid.getAverageSpeed());
			// boid.setPosition(Vector.add(boid.getPosition, sumVector));
		}

	}
}
