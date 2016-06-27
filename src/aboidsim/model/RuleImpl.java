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
public enum RuleImpl implements Rule {
	/**
	 * Cohesion. This rule keep the boids of the same group close to each other.
	 */
	COHESION("Cohesion", 0) {
		@Override
		public Vector apply(final Boid theBoid, final Set<Boid> boids) {
			return null;
		}
	},
	/**
	 * Alignment. This rule keep the boids of the same group going towards the
	 * same direction.
	 */
	ALIGNMENT("Alignment", 1) {
		@Override
		public Vector apply(final Boid theBoid, final Set<Boid> boids) {
			return null;
		}
	},
	/**
	 * Separation. This rule keep the boids of the same group separated (the
	 * opposite of Cohesion).
	 */
	SEPARATION("Separation", 2) {
		@Override
		public Vector apply(final Boid theBoid, final Set<Boid> boids) {
			return null;
		}
	},;

	private String name;
	private Integer id;

	/**
	 * Private constructor.
	 *
	 * @param n
	 * @param idNumber
	 */
	RuleImpl(final String n, final Integer idNumber) {
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
	 * Static method. This methods return a list of the names of the rules.
	 *
	 * @return the list of the names of the rules.
	 */
	public static List<String> getRuleNames() {
		return Arrays.stream(RuleImpl.values()).map(r -> r.getName()).collect(Collectors.toList());
	}
}
