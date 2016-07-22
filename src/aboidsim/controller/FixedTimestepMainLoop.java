package aboidsim.controller;

import aboidsim.model.Model;
import aboidsim.util.Input;
import aboidsim.util.InputInfo;
import aboidsim.view.View;

/**
 * Main loop implementation. This loop runs with a fixed timestep. This means
 * that it always cycle after the same amount of time.
 *
 */
public class FixedTimestepMainLoop extends AbstractMainLoop {

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
	public FixedTimestepMainLoop(final Model m, final View v, final Controller c, final long desiredFps) {
		super(desiredFps);
		this.msPerFrame = 1000 / this.getFPS();
		this.model = m;
		this.controller = c;
		this.view = v;
	}

	class InputResolverImpl implements InputResolver {

		@Override
		public void resolveInput(final InputInfo inputInfo) {
			if (inputInfo.getInput().equals(Input.CREATE_BOID)) {
				FixedTimestepMainLoop.this.model.getSimulation().createBoid(inputInfo.getPosition(),
						inputInfo.getNumber().intValue());
			} else if (inputInfo.getInput().equals(Input.DESTROY_BOID)) {
				FixedTimestepMainLoop.this.model.getSimulation().destroyBoid(inputInfo.getPosition());
			} else if (inputInfo.getInput().equals(Input.TOGGLE_RULE)) {
				// FixedTimestepMainLoop.this.model.toggleRule(inputInfo.getNumber());
				return;
			} else if (inputInfo.getInput().equals(Input.PAUSE)) {
				FixedTimestepMainLoop.this.pauseLoop();
			} else if (inputInfo.getInput().equals(Input.CLOSE)) {
				FixedTimestepMainLoop.this.abortLoop();
			}
		}

	}

	@Override // TO DO
	public void run() {
		final long lastTime = System.currentTimeMillis();
		while (this.getStatus().equals(LoopStatus.RUNNING)) {
			// TO DO bisogna collegare il controller, la view e il model

			// InputResolver inputResolver = new InputResolverImpl();
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
