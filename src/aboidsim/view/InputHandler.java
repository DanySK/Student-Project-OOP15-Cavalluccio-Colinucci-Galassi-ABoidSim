package aboidsim.view;

import java.util.ArrayList;
import java.util.List;

import aboidsim.util.InputInfo;

/**
 * it handles the input of the interface
 *
 */
public class InputHandler {
	
	private final List<InputInfo> inputs = new ArrayList<>(); 
	
	public InputHandler() {
	}
	
	
	/**
	 * removes all the elements in the list
	 */
	public void clearInputs() {
		this.inputs.clear();
	}
	
	/**
	 * return the list of all inputs of the interface
	 * @return
	 */
	public List<InputInfo> getInputs() {
		return this.inputs;
	}
	
	
	public void addInput(InputInfo input) {
		this.inputs.add(input);
	}
	
}
