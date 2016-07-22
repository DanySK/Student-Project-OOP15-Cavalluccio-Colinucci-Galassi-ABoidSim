package aboidsim.controller;

/**
 * Interface for any type of loop.
 */
interface MainLoop {

	/**
	 * LoopStatus enumeration.
	 */
	enum LoopStatus {

		RUNNING, PAUSED;
	}

	/**
	 * Setter. This method sets the app status.
	 *
	 * @param status
	 *            the status
	 */
	void setStatus(LoopStatus status);

	/**
	 * Getter. This method returns the status of the main loop.
	 *
	 * @return the main loop status
	 */
	LoopStatus getStatus();

	/**
	 * Setter. This method sets the desired FPS (Frames Per Second).
	 *
	 * @param fps
	 *            the desired fps.
	 */
	void setFPS(long fps);

	/**
	 * Getter. This method returns the current FPS (Frames Per Second).
	 *
	 * @return the fps
	 */
	long getFPS();

	/**
	 * This method starts the loop.
	 */
	void run();

	/**
	 * This method pause the application.
	 */
	void pauseLoop();

	/**
	 * This method resume the previously paused loop.
	 */
	void resumeLoop();

	/**
	 * this method kills the app and close the program.
	 */
	void abortLoop();
}
