package aboidsim.model;

import java.util.Set;

/**
 * This is an enumeration that shows all the available environments.
 * A user can set one of this environment.
 *
 */
public enum DefaultEnvironmentImpl implements DefaultEnvironments {
	
	/**
	 * Environment with just predator boids.
	 */
	JURASSIC_WORLD("JURASSIC WORLD", 0) {
		@Override
		public Set<Boid> getDefaultEnvironment() {
			
			return null;
		}
	},
	
	/**
	 * Environment with just herbivore. "Pacific" because herbivores don't eat each other.
	 */
	PACIFIC_WORLD("PACIFIC WORLD", 1)	{
		@Override
		public Set<Boid> getDefaultEnvironment() {
			
			return null;
		}
	}, 
	
	/**
	 * Environment with trees.
	 */
	FOREST("Forest", 2) {
		@Override
		public Set<Boid> getDefaultEnvironment() {
			
			return null;
		}
	};
	
	private final String environmentName;
	private final int idEnv;	
	
	/**
	 * Private constructor.
	 * @param envName
	 * @param id
	 */
	DefaultEnvironmentImpl(final String envName, final Integer id) {
		this.environmentName = envName;
		this.idEnv = id;
	}

	public String getEnvironmentName() {
		return this.environmentName;
	}

	public int getIdEnv() {
		return this.idEnv;
	}
}
