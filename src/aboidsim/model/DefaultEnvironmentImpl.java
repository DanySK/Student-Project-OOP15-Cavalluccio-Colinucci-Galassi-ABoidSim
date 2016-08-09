package aboidsim.model;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

import aboidsim.util.Vector;

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
			final Random r = new Random();
			final int rangeMaxX = EnvironmentImpl.getSimulationDimension().getX();
			final int rangeMaxY = EnvironmentImpl.getSimulationDimension().getY();
			
			//rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			
			IntStream.range(Entities.TREE_L0.getId(), Entities.HERBIVORE_L3.getId()).forEach(x -> {
				IntStream.range(Entities.PREDATOR_L6.getId(), Entities.PREDATOR_L10.getId() + 1).forEach(i -> {
					environment.add(new BoidImpl(new Vector(rangeMaxX * r.nextDouble(), rangeMaxY * r.nextDouble()), i));
				});
			});
			
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
