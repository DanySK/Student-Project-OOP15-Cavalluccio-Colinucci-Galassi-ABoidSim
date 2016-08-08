package aboidsim.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
	
	/**
	 * 
	 * @return All the environment names
	 */
	public List<String> getEnvironmentNames() {
		return Arrays.stream(DefaultEnvironmentImpl.values()).map(e -> e.getEnvironmentName()).collect(Collectors.toList());
	}
}
