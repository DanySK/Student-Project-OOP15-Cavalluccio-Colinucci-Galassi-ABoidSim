package aboidsim.controller;

/**
 * Main loop implementation. This loop runs with a fixed timestep. This means
 * that it always cycle after the same amount of time.
 *
 */
public class FixedTimestepMainLoop extends AbstractMainLoop {

	private final long msPerFrame;

	/**
	 * Constructor.
	 *
	 * @param desiredFps
	 *            the desired frames per second.
	 */
	public FixedTimestepMainLoop(final long desiredFps) {
		super(desiredFps);
		this.msPerFrame = 1000 / this.getFPS();
	}

	@Override // TO DO
	public void run() {
		final long lastTime = System.currentTimeMillis();
		while (this.getStatus().equals(LoopStatus.RUNNING)) {
			// TO DO bisogna collegare il controller, la view e il model

			final long timePassed = System.currentTimeMillis() - lastTime;
			if (timePassed < this.msPerFrame) {
				try {
					Thread.sleep(this.msPerFrame - timePassed);
				} catch (final InterruptedException e) {
					System.out.println("Sleep exception");
					this.abortLoop();
				}
			}
		}
	}

	@Override
	public void pauseLoop() {
		if (this.getStatus().equals(LoopStatus.RUNNING)) {
			this.setStatus(LoopStatus.PAUSED);
		}
	}

	@Override
	public void resumeLoop() {
		if (this.getStatus().equals(LoopStatus.PAUSED)) {
			this.setStatus(LoopStatus.RUNNING);
		}
	}

	@Override // TO DO
	public void abortLoop() {
	}

}
