package aboidsim.controller;

import aboidsim.model.Model;
import aboidsim.view.View;

/**
 * This class starts the program by declaring Controller and View
 * implementation.
 *
 */
public class Application {

	private final Controller controller;
	private final View view;
	private final Model model;

	/**
	 * Constructor.
	 */
	public Application() {
		this.model = null; // TO DO: substitute with actual implementation
		this.controller = null; // TO DO: substitute with actual implementation
		this.view = null; // TO DO: substitute with actual implementation
		this.controller.setView(this.view);
		// this.controller.start();
	}
}
