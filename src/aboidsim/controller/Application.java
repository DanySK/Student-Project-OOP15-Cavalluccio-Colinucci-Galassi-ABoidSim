package aboidsim.controller;

import aboidsim.model.Model;
import aboidsim.view.View;

/**
 * This class starts the program by declaring Controller and View
 * implementation.
 *
 */
public final class Application {
	/**
	 * This methods starts the application.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		final Model model = null; // TO DO: substitute with actual
									// implementation
		final View view = null; // TO DO: substitute with actual implementation
		final Controller controller = new ControllerImpl(model, view);

		// view.setController(controller);
		controller.start();
	}

	private Application() {
	}
}
