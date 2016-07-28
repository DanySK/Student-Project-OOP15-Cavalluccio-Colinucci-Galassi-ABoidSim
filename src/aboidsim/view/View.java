package aboidsim.view;

import java.util.List;
import java.util.Set;

import aboidsim.util.InputInfo;
import aboidsim.util.Pair;
import aboidsim.util.Vector;

public interface View {

	/**
	 * 
	 * @return list of inputs and clears it
	 */
	List<InputInfo> getInputs();
	
	/**
	 * start the interface
	 * @param boids list of the boids's names
	 * @param rules list of the rules
	 */
	void start(List<String> boids, List<String> rules);
	
	
	/**
	 * draw all the entitities in the simulation screen
	 * @param entities list of the position and level of all the entities to draw
	 */
	void drawEntities(Set<Pair<Vector, String>> entities);
	
	
	
	
}
