package controller;

import view.View;

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
	 * The method that starts the loop.
	 */
	void start();
}
