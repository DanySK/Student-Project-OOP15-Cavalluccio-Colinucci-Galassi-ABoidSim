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
	 */
	public static void main() {
		final Model model = null; // TO DO: substitute with actual
		// implementation
		final View view = null; // TO DO: substitute with actual implementation
		final MainLoop mainLoop = new FixedTimestepMainLoop(model, view, 30);
		final Controller controller = new ControllerImpl(model, view, mainLoop);

		// this.controller.setView(this.view);
		controller.start();
	}

	private Application() {
	}
}
