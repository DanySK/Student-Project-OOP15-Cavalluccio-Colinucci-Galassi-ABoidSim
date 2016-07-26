package aboidsim.view;

import java.util.List;

import aboidsim.util.InputInfo;

public interface View {

	/**
	 * 
	 * @return list of inputs and clears it
	 */
	List<InputInfo> getInputs();
	
	
	void start(List<String> boids, List<String> rules);
	
	
	
	
}
