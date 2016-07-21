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
	View getModel();

	/**
	 * The method that starts the loop.
	 */
	void start();
}
