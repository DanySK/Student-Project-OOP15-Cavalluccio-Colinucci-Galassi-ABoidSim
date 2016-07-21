package aboidsim.controller;

import aboidsim.model.Model;
import aboidsim.view.View;

/**
 * Controller interface.
 *
 */
public interface Controller {

	/**
	 * Setter. The method sets the view
	 *
	 * @param view
	 *            the view being set.
	 *
	 */
	void setView(View view);

	/**
	 * Getter. The method return the View currently used.
	 *
	 * @return the View
	 */
	View getView();

	/**
	 * Setter. The method sets the model
	 *
	 * @param model
	 *            the model being set.
	 *
	 */
	void setModel(Model model);

	/**
	 * Getter. The method return the Model currently used.
	 *
	 * @return the Model
	 */
	Model getModel();

	/**
	 * Setter. The method sets the main loop.
	 *
	 * @param mainLoop
	 *            loop the main loop being set.
	 *
	 */
	void setMainLoop(MainLoop mainLoop);

	/**
	 * Getter. The method return the MainLoop currently used.
	 *
	 * @return the MainLoop
	 */
	MainLoop getMainLoop();

	/**
	 * The method that starts the loop.
	 */
	void start();
}
