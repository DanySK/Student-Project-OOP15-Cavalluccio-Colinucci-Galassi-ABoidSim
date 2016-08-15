package aboidsim.controller;

import java.util.ConcurrentModificationException;

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
		System.out.println(this.msPerFrame + " " + this.getFPS()); // DEBUG
		this.model = m;
		this.controller = c;
		this.view = v;
	}

	@Override
	public void run() {
		final InputResolver inputResolver = i -> {
			if (i.getInput().equals(Input.CREATE_BOID)) {
				System.out.println("A boid has been created"); // DEBUG
				FixedTimestepMainLoop.this.model.getSimulation().createBoid(i.getPosition(), i.getNumber().intValue());
			} else if (i.getInput().equals(Input.DESTROY_BOID)) {
				System.out.println("A boid has been destroyed"); // DEBUG
				FixedTimestepMainLoop.this.model.getSimulation().destroyBoid(i.getPosition());
			} else if (i.getInput().equals(Input.TOGGLE_RULE)) {
				System.out.println("A rule has been changed"); // DEBUG
				FixedTimestepMainLoop.this.model.getSimulation().toggleRule(i.getNumber().intValue());
			} else if (i.getInput().equals(Input.LOAD_ENV)) {
				System.out.println("A default environment has been loaded"); // DEBUG
				FixedTimestepMainLoop.this.model.getSimulation().loadDefaultEnvironment(i.getNumber().intValue());
			} else if (i.getInput().equals(Input.PAUSE)) {
				System.out.println("The application has been paused"); // DEBUG
				FixedTimestepMainLoop.this.pauseLoop();
			} else if (i.getInput().equals(Input.RESUME)) {
				System.out.println("The application has been resumed"); // DEBUG
				FixedTimestepMainLoop.this.resumeLoop();
			} else if (i.getInput().equals(Input.CLOSE)) {
				System.out.println("The application has been closed"); // DEBUG
				FixedTimestepMainLoop.this.abortLoop();
			}
		};

		final int wait = 3;
		try {
			System.out.println("Aspetto " + wait + " secondi per settare la view"); // DEBUG
			// We wait a couple of seconds
			Thread.sleep(wait * 1000);
		} catch (final InterruptedException e) {
			System.out.println("Sleep exception");
			this.abortLoop();
		}
		// This flag controls how many times we have to check the flocks
		int checkFlockFlag = 0;
		while (!this.getStatus().equals(LoopStatus.KILLED)) {
			final long lastTime = System.currentTimeMillis();
			inputResolver.resolveInputList(this.view.getInputs());
			// This thread will be used to speed up the application
			final Thread viewThread = new Thread() {
				@Override
				public void run() {
					try {
						FixedTimestepMainLoop.this.view.drawEntities(
								FixedTimestepMainLoop.this.model.getSimulation().getSimulationComponents());
					} catch (final ConcurrentModificationException e) {
						/*
						 * The exception is caused by the fact that the
						 * checkNearBoids() method is not called every frame
						 */
					}
				}
			};
			viewThread.start();
			if (this.getStatus().equals(LoopStatus.RUNNING)) {
				if (checkFlockFlag % 3 == 0) {
					this.model.getSimulation().checkNearBoids();
				}
				this.model.getSimulation().updateEnvironment();
				checkFlockFlag++;
			}
			try {
				viewThread.join();
			} catch (final InterruptedException e) {
				System.out.println("Error in viewThread join");
			}
			final long timePassed = System.currentTimeMillis() - lastTime;
			// System.out.println("last time: " + lastTime); // DEBUG
			// System.out.println("time passed: " + timePassed); // DEBUG
			if (timePassed < this.msPerFrame) {
				try {
					// System.out.println("sleep for: " + (this.msPerFrame -
					// timePassed)); // DEBUG
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
		this.setStatus(LoopStatus.KILLED);
		this.controller.close();
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

}
