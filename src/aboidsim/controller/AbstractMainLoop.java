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
	 * @throws IllegalArgumentException
	 *             if fps < 1
	 */
	AbstractMainLoop(final long desiredFps) throws IllegalArgumentException {
		this.status = LoopStatus.RUNNING;
		this.fps = desiredFps;
		if (this.fps <= 0) {
			throw new IllegalArgumentException("FPS must be >0");
		}
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

	public abstract void abortLoop();

	public abstract void pauseLoop();

	public abstract void resumeLoop();
}
