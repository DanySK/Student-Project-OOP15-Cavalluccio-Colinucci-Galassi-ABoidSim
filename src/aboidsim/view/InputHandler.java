package aboidsim.view;

import java.util.ArrayList;
import java.util.List;

import aboidsim.util.InputInfo;

/**
 * it handles the input of the interface
 *
 */
public class InputHandler {

	private static final InputHandler inputHandler = new InputHandler();

	private final List<InputInfo> inputs = new ArrayList<>();

	/**
	 * private constructor because of the use of the sigleton
	 */
	private InputHandler() {
	}

	/**
	 * 
	 * @return the inputHandler
	 */
	static InputHandler getInputHandler() {
		return inputHandler;
	}

	/**
	 * removes all the elements in the list
	 */
	void clearInputs() {
		this.inputs.clear();
	}

	/**
	 * return the list of all inputs of the interface
	 * 
	 * @return
	 */
	List<InputInfo> getInputs() {
		return this.inputs;
	}
	
	
	public void addInput(InputInfo input) {
		this.inputs.add(input);
	}
	
}
