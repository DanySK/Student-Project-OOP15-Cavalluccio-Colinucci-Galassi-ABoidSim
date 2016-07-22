package aboidsim.controller;

/**
 * Abstract class.
 *
 */
abstract class AbstractMainLoop extends Thread implements MainLoop {

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

	@Override
	public void setStatus(final LoopStatus newStatus) {
		this.status = newStatus;
	}

	@Override
	public LoopStatus getStatus() {
		return this.status;
	}

	@Override
	public void setFPS(final long newFps) {
		this.fps = newFps;
	}

	@Override
	public long getFPS() {
		return this.fps;
	}

	@Override
	public abstract void run();

	@Override
	public abstract void pauseLoop();

	@Override
	public abstract void resumeLoop();

	@Override
	public abstract void abortLoop();
}
