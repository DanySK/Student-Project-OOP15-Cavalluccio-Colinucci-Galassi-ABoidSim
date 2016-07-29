package aboidsim.view;

import java.util.List;
import java.util.Set;

import aboidsim.controller.Controller;
import aboidsim.util.InputInfo;
import aboidsim.util.Pair;
import aboidsim.util.Vector;
import javafx.application.Application;

/**
 * used to comunicate with the controller.
 *
 */
public class ViewImpl implements View {

	private Controller controller;
	private static SimulationScreen simulationScreen;

	@Override
	public void setController(final Controller controller) {
		this.controller = controller;
	}

	@Override
	public List<InputInfo> getInputs() {
		// TODO Auto-generated method stub
		final List<InputInfo> list = InputHandler.getInputHandler().getInputs();
		InputHandler.getInputHandler().clearInputs();
		return list;
	}

	@Override
	public void start(final List<String> boids, final List<String> rules) {
		System.out.println(rules.toString()); // debug
		MainWindow.setBoids(boids);
		MainWindow.setRules(rules);
		Application.launch(MainWindow.class);

	}

	@Override
	public void drawEntities(final Set<Pair<Vector, String>> entities) {
		if (!entities.isEmpty()) {
			System.out.println(entities.toString());
			System.out.println("simulation screen: " + ViewImpl.simulationScreen);
			ViewImpl.simulationScreen.drawOnScreen(entities);
		}
	}

	@Override
	public Pair<Integer, Integer> getScreenDimensions() {
		return new Pair<Integer, Integer>(SimulationScreen.WIDTH + SimulationScreen.BOID_HEIGHT,
				SimulationScreen.HEIGHT + SimulationScreen.BOID_HEIGHT);
	}

	static void setSimulationScreen(final SimulationScreen screen) {
		ViewImpl.simulationScreen = screen;
	}

}
