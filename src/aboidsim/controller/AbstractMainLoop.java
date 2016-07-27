package aboidsim.controller;

/**
 * Abstract class.
 *
 */
abstract class AbstractMainLoop extends Thread {

	/**
	 * LoopStatus enumeration.
	 */
	enum LoopStatus {

		RUNNING, PAUSED;
	}

	private LoopStatus status;
	private long fps;

	/**
	 * Constructor.
	 *
	 * @param desiredFps
	 *            the desired fps.
	 */
	AbstractMainLoop(final long desiredFps) {
		this.status = LoopStatus.RUNNING;
		this.fps = desiredFps;
	}

	public void setStatus(final LoopStatus newStatus) {
		this.status = newStatus;
	}

	public LoopStatus getStatus() {
		return this.status;
	}

	public void setFPS(final long newFps) {
		this.fps = newFps;
	}

	public long getFPS() {
		return this.fps;
	}

	@Override
	public abstract void run();

	public abstract void pauseLoop();

	public abstract void resumeLoop();

	public abstract void abortLoop();
}
