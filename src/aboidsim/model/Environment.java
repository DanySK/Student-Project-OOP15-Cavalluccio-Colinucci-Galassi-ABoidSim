package aboidsim.model;

import java.util.Set;

import aboidsim.util.Pair;
import aboidsim.util.Vector;

/**
 * Interface of the whole simulation.
 *
 */
public interface Environment {

	/**
	 * Add a boid to the environment.
	 *
	 * @param pos
	 *            New boid position.
	 * @param liv
	 *            New boid level.
	 */
	void createBoid(final Vector pos, final int liv);

	/**
	 * Destroy a boid in this position (if present).
	 *
	 * @param pos
	 *            of designated boid.
	 */
	void destroyBoid(final Vector pos);

	/**
	 * Add all the closest boids to the "sameLevelNearBoids" field until max
	 * size (maxMembers).
	 */
	void checkBoidSameLevel();

	/**
	 * Add all the closest boids to the "otherLevelNearBoids" field.
	 */
	void checkBoidOtherLevel();

	/**
	 * Manage all the boid collision and consequences.
	 */
	void collision();

	/**
	 * Rule management.
	 *
	 * @param ruleId
	 *            id rule.
	 */
	void toggleRule(final int ruleId);

	/**
	 *
	 * @return all the entities of the environment with position and level.
	 */
	Set<Pair<Vector, Integer>> getEntities();

	/**
	 * Getter for the environment.
	 *
	 * @return The whole environment
	 */
	Set<Boid> getEnviroment();

	/**
	 *
	 * @return Collision radius of every single component of the simulation
	 */
	double getCollisionRadius();

	/**
	 * This method updates the state of the simulation.
	 */
	void updateEnvironment();
}
