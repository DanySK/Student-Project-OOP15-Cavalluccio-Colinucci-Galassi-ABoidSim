package controller;

/**
 * Abstract class.
 */
public abstract class AbstractMainLoop implements MainLoop {

	private LoopStatus status;
	private long fps;

	/**
	 * Constructor.
	 *
	 * @param desiredFps
	 *            the desired fps.
	 */
	public AbstractMainLoop(final long desiredFps) {
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
	public abstract void pause();

	@Override
	public abstract void resume();

	@Override
	public abstract void abort();
}
