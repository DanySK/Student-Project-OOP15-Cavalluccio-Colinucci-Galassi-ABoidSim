package aboidsim.view;

import java.util.ArrayList;
import java.util.List;

import aboidsim.util.InputInfo;

/**
 * it handles the input of the interface.
 *
 */
public final class InputHandler {

    private static final InputHandler INPUTHANDLER = new InputHandler();

    private final List<InputInfo> inputs = new ArrayList<>();

    /**
     * private constructor because of the use of the singleton
     */
    private InputHandler() {
    }

    /**
     * 
     * @return the inputHandler
     */
    public static InputHandler getInputHandler() {
        return INPUTHANDLER;
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

    /**
     *  add the input to the list.
     * @param input  InputInfo object
     */
    public void addInput(final InputInfo input) {
        this.inputs.add(input);
    }

}
