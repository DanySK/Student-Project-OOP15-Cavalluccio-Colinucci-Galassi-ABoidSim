package aboidsim.model;

import java.util.HashSet;
import java.util.Set;

/**
 * This is an enumeration that shows all the available environments.
 * A user can set one of this environment.
 *
 */
public enum DefaultEnvironmentImpl implements DefaultEnvironment {
	
	/**
	 * Environment with just predator boids.
	 */
	JURASSIC_WORLD("JURASSIC WORLD", 0) {
		@Override
		public Set<Boid> getDefaultEnvironment() {
			final Set<Boid> environment = new HashSet<>();
			return environment;
		}
	},
	
	/**
	 * Environment with just herbivore. "Pacific" because herbivores don't eat each other.
	 */
	PACIFIC_WORLD("PACIFIC WORLD", 1)	{
		@Override
		public Set<Boid> getDefaultEnvironment() {
			final Set<Boid> environment = new HashSet<>();
			return environment;
		}
	}, 
	
	/**
	 * Environment with trees.
	 */
	FOREST("FOREST", 2) {
		@Override
		public Set<Boid> getDefaultEnvironment() {
			final Set<Boid> environment = new HashSet<>();
			return environment;
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
	
	/**
	 * 
	 * @return Environment name
	 */
	public String getEnvironmentName() {
		return this.environmentName;
	}
	
	/**
	 * 
	 * @return Environment ID
	 */
	public int getIdEnv() {
		return this.idEnv;
	}
}
