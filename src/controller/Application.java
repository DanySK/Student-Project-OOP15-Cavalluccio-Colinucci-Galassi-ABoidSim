package controller;

import view.View;

/**
 * This class starts the program by declaring Controller and View
 * implementation.
 *
 */
public class Application {

	private final Controller controller;
	private final View view;

	/**
	 * Constructor.
	 */
	public Application() {
		this.controller = null; // TO DO: substitute with actual implementation
		this.view = null; // TO DO: substitute with actual implementation
		this.controller.setView(this.view);
		this.controller.start();
	}
}
