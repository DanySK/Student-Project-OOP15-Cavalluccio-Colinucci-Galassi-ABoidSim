package aboidsim.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import aboidsim.util.Vector;

/**
 * This implementation is an enumeration that represent any possible rule that
 * can be considered in the simulation.
 *
 * Each rule describes a different behavior.
 *
 */
enum RuleImpl implements Rule {
	/**
	 * Cohesion. This rule keep the boids of the same group close to each other.
	 */
	COHESION("Cohesion", 0, 1.0) {
		@Override
		public Vector apply(final Boid theBoid, final Set<Boid> boids) {
			final Vector vectorSum = new Vector(0.0, 0.0);
			if (!boids.isEmpty()) {
				for (final Boid boid : boids) {
					vectorSum.add(boid.getPosition());
				}
				vectorSum.div(boids.size());
				vectorSum.print();
				final Vector desiredDirection = Vector.sub(vectorSum, theBoid.getPosition());
				desiredDirection.print();
				desiredDirection.norm();
				desiredDirection.print();
				final Vector steer = Vector.sub(desiredDirection, theBoid.getSpeed());
				steer.print();
				steer.mul(this.getDefaultModifier());
				steer.print();
				steer.limitTo(BoidImpl.MAX_FORCE);
				steer.print();
				return steer;
			} else {
				return vectorSum;
			}
		}
	},
	/**
	 * Alignment. This rule keep the boids of the same group going towards the
	 * same direction.
	 */
	ALIGNMENT("Alignment", 1, 2.0) {
		@Override
		public Vector apply(final Boid theBoid, final Set<Boid> boids) {
			final Vector vectorSum = new Vector(0.0, 0.0);
			if (!boids.isEmpty()) {
				for (final Boid boid : boids) {
					vectorSum.add(boid.getSpeed());
				}
				vectorSum.div(boids.size());
				final Vector desiredDirection = Vector.sub(vectorSum, theBoid.getPosition());
				desiredDirection.norm();
				final Vector steer = Vector.sub(desiredDirection, theBoid.getSpeed());
				steer.mul(this.getDefaultModifier());
				steer.limitTo(BoidImpl.MAX_FORCE);
				return steer;
			} else {
				return vectorSum;
			}
		}
	},
	/**
	 * Separation. This rule keep the boids of the same group separated (the
	 * opposite of Cohesion).
	 */
	SEPARATION("Separation", 2, 1.0) {
		@Override
		public Vector apply(final Boid theBoid, final Set<Boid> boids) {
			final Vector vectorDiff = new Vector(0.0, 0.0);
			if (!boids.isEmpty()) {
				for (final Boid boid : boids) {
					vectorDiff.sub(boid.getPosition());
				}
				vectorDiff.div(boids.size());
				final Vector desiredDirection = Vector.sub(vectorDiff, theBoid.getPosition());
				desiredDirection.norm();
				final Vector steer = Vector.sub(desiredDirection, theBoid.getSpeed());
				steer.mul(this.getDefaultModifier());
				steer.limitTo(BoidImpl.MAX_FORCE);
				return steer;
			} else {
				return vectorDiff;
			}
		}
	},
	/**
	 * Evasion. This rule is the same of Separation, but we define it in a
	 * different way to allow us to implement more complex behaviours towards
	 * enemies/predators.
	 */
	EVASION("Evasion", 3, 1.2) {
		@Override
		public Vector apply(final Boid theBoid, final Set<Boid> closeBoids) {
			return RuleImpl.SEPARATION.apply(theBoid, closeBoids);
		}
	};

	private final String name;
	private final Integer id;
	private final Double defaultModifier;

	/**
	 * Private constructor.
	 *
	 * @param n
	 * @param idNumber
	 */
	RuleImpl(final String n, final Integer idNumber, final Double dM) {
		this.name = n;
		this.id = idNumber;
		this.defaultModifier = dM;
	}

	/**
	 * Getter. This method return the name of the rule.
	 *
	 * @return the name of the rule
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter. This method return the id of the rule.
	 *
	 * @return the id of the rule
	 */
	public Integer getID() {
		return this.id;
	}

	/**
	 * Getter. This method return the default modifier used to "weigh" the
	 * impact of the rule.
	 *
	 * @return the modifier of the rule
	 */
	public Double getDefaultModifier() {
		return this.defaultModifier;
	}

	/**
	 * Static method. This methods return a list of the names of the rules.
	 *
	 * @return the list of the names of the rules.
	 */
	public static List<String> getRuleNames() {
		return Arrays.stream(RuleImpl.values()).map(r -> r.getName()).collect(Collectors.toList());
	}
}
