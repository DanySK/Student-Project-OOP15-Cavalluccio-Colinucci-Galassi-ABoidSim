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
		System.out.println(this.msPerFrame + " " + this.getFPS());
		this.model = m;
		this.controller = c;
		this.view = v;
	}

	@Override // TO DO
	public void run() {
		final InputResolver inputResolver = i -> {
			if (i.getInput().equals(Input.CREATE_BOID)) {
				FixedTimestepMainLoop.this.model.getSimulation().createBoid(i.getPosition(), i.getNumber().intValue());
			} else if (i.getInput().equals(Input.DESTROY_BOID)) {
				FixedTimestepMainLoop.this.model.getSimulation().destroyBoid(i.getPosition());
			} else if (i.getInput().equals(Input.TOGGLE_RULE)) {
				FixedTimestepMainLoop.this.model.getSimulation().toggleRule(i.getNumber().intValue());
			} else if (i.getInput().equals(Input.PAUSE)) {
				FixedTimestepMainLoop.this.pauseLoop();
			} else if (i.getInput().equals(Input.CLOSE)) {
				FixedTimestepMainLoop.this.abortLoop();
			}
		};

		while (this.getStatus().equals(LoopStatus.RUNNING)) {
			final long lastTime = System.currentTimeMillis();
			// TO DO bisogna collegare il controller, la view e il model
			inputResolver.resolveInputList(this.view.getInputs());
			this.model.getSimulation().updateEnvironment();
			// this.view.getEntitiesToDraw(this.model.getSimulation().getEntities());
			final long timePassed = System.currentTimeMillis() - lastTime;

			// System.out.println("last time: " + lastTime); //DEBUG
			// System.out.println("time passed: " + timePassed); //DEBUG
			if (timePassed < this.msPerFrame) {
				try {
					// System.out.println("sleep for: " + (this.msPerFrame -
					// timePassed)); //DEBUG
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
