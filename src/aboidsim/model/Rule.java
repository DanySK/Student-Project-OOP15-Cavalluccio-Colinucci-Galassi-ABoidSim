package aboidsim.model;

import java.util.Set;

import aboidsim.util.Vector;

/**
 * Functional interface.
 *
 */
public interface Rule {

	/**
	 * This methods apply the rule to determine how a boid should move according
	 * to the rule.
	 *
	 * @param boids
	 *            the set containing all the nearest boids.
	 * @return the Vector that describes the boid's movement.
	 */
	Vector apply(Set<Boid> boids);
}
