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

	@Override
	public void run() {
		final InputResolver inputResolver = i -> {
			if (i.getInput().equals(Input.CREATE_BOID)) {
				System.out.println("A boid has been created");
				FixedTimestepMainLoop.this.model.getSimulation().createBoid(i.getPosition(), i.getNumber().intValue());
			} else if (i.getInput().equals(Input.DESTROY_BOID)) {
				System.out.println("A boid has been destroyed");
				FixedTimestepMainLoop.this.model.getSimulation().destroyBoid(i.getPosition());
			} else if (i.getInput().equals(Input.TOGGLE_RULE)) {
				System.out.println("A rule has been changed");
				FixedTimestepMainLoop.this.model.getSimulation().toggleRule(i.getNumber().intValue());
			} else if (i.getInput().equals(Input.TOGGLE_RULE)) {
				System.out.println("A rule has been changed");
				FixedTimestepMainLoop.this.model.getSimulation().toggleRule(i.getNumber().intValue());

			} else if (i.getInput().equals(Input.CLOSE)) {
				FixedTimestepMainLoop.this.abortLoop();
			}
		};

		final int wait = 3;
		try {
			System.out.println("Aspetto " + wait + " secondi per settare la view");
			// We wait a couple of seconds
			Thread.sleep(wait * 1000);
		} catch (final InterruptedException e) {
			System.out.println("Sleep exception");
			this.abortLoop();
		}
		while (this.getStatus().equals(LoopStatus.RUNNING)) {
			final long lastTime = System.currentTimeMillis();
			inputResolver.resolveInputList(this.view.getInputs());
			// This thread will be used to speed up the application
			final Thread viewThread = new Thread() {
				@Override
				public void run() {
					FixedTimestepMainLoop.this.view
							.drawEntities(FixedTimestepMainLoop.this.model.getSimulation().getSimulationComponents());
				}
			};
			viewThread.start();
			this.model.getSimulation().updateEnvironment();
			try {
				viewThread.join();
			} catch (final InterruptedException e) {
				System.out.println("Error in viewThread join");
			}
			final long timePassed = System.currentTimeMillis() - lastTime;
			System.out.println("last time: " + lastTime); // DEBUG
			System.out.println("time passed: " + timePassed); // DEBUG
			if (timePassed < this.msPerFrame) {
				try {
					System.out.println("sleep for: " + (this.msPerFrame - timePassed)); // DEBUG
					Thread.sleep(this.msPerFrame - timePassed);
				} catch (final InterruptedException e) {
					System.out.println("Sleep exception");
					this.abortLoop();
				}
			}
		}
	}

	@Override
	public void abortLoop() {
		this.controller.close();
	}

}
