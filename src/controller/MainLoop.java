package controller;

/**
 * Interface for any type of loop.
 */
public interface MainLoop {

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
	 * This method pause the app.
	 */
	void pause();

	/**
	 * This method resume the previoulsy paused loop.
	 */
	void resume();

	/**
	 * this method kills the app and close the program.
	 */
	void abort();
}
