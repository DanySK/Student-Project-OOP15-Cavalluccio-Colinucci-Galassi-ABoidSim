package aboidsim.controller;

import aboidsim.model.Model;
import aboidsim.util.Input;
import aboidsim.util.Vector;
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
			} else if (i.getInput().equals(Input.CLOSE)) {
				FixedTimestepMainLoop.this.abortLoop();
			}
		};

		try {
			System.out.println("Aspetto " + 5 + " secondi per settare la view");
			// sleep per far settare la view
			Thread.sleep(5000);
		} catch (final InterruptedException e) {
			System.out.println("Sleep exception");
			this.abortLoop();
		}
		this.model.getSimulation().createBoid(new Vector(63, 51), 5);
		this.model.getSimulation().createBoid(new Vector(30, 50.50), 5);
		this.model.getSimulation().createBoid(new Vector(50.50, 50.50), 5);
		while (this.getStatus().equals(LoopStatus.RUNNING)) {
			final long lastTime = System.currentTimeMillis();
			// TO DO bisogna collegare il controller, la view e il model
			System.out.println("inputs: " + this.view.getInputs());
			inputResolver.resolveInputList(this.view.getInputs());
			this.model.getSimulation().updateEnvironment();
			System.out.println("entities: " + this.model.getSimulation().getSimulationComponents()); // DEBUG
			this.view.drawEntities(this.model.getSimulation().getSimulationComponents());
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

	@Override // TO DO
	public void abortLoop() {
		this.controller.close();
	}

}
