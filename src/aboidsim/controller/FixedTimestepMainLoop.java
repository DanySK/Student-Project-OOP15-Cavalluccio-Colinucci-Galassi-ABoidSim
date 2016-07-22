package aboidsim.controller;

import aboidsim.model.Model;
import aboidsim.util.Input;
import aboidsim.view.View;

/**
 * Main loop implementation. This loop runs with a fixed timestep. This means
 * that it always cycle after the same amount of time.
 *
 */
class FixedTimestepMainLoop extends AbstractMainLoop {

	private final long msPerFrame;
	private final Model model;
	private final View view;
	private final Controller controller;

	/**
	 * Constructor.
	 *
	 * @param m
	 *            the Model.
	 * @param v
	 *            the View.
	 * @param c
	 *            the Controller.
	 * @param desiredFps
	 *            the desired frames per second.
	 */
	FixedTimestepMainLoop(final Model m, final View v, final Controller c, final long desiredFps) {
		super(desiredFps);
		this.msPerFrame = 1000 / this.getFPS();
		this.model = m;
		this.controller = c;
		this.view = v;
	}

	@Override // TO DO
	public void run() {
		final long lastTime = System.currentTimeMillis();
		while (this.getStatus().equals(LoopStatus.RUNNING)) {
			// TO DO bisogna collegare il controller, la view e il model

			final InputResolver inputResolver = i -> {
				if (i.getInput().equals(Input.CREATE_BOID)) {
					FixedTimestepMainLoop.this.model.getSimulation().createBoid(i.getPosition(),
							i.getNumber().intValue());
				} else if (i.getInput().equals(Input.DESTROY_BOID)) {
					FixedTimestepMainLoop.this.model.getSimulation().destroyBoid(i.getPosition());
				} else if (i.getInput().equals(Input.TOGGLE_RULE)) {
					// FixedTimestepMainLoop.this.model.toggleRule(inputInfo.getNumber());
					return;
				} else if (i.getInput().equals(Input.PAUSE)) {
					FixedTimestepMainLoop.this.pauseLoop();
				} else if (i.getInput().equals(Input.CLOSE)) {
					FixedTimestepMainLoop.this.abortLoop();
				}
			};
			// inputResolver.resolveInputs(view.getInputs());

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
		System.exit(0);
	}

}
