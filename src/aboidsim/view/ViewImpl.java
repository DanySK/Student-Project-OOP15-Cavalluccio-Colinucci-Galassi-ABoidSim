package aboidsim.view;

import java.util.List;
import java.util.Set;

import aboidsim.controller.Controller;
import aboidsim.util.InputInfo;
import aboidsim.util.Pair;
import aboidsim.util.Vector;
import javafx.application.Application;
import javafx.application.Platform;

/**
 * used to comunicate with the controller.
 *
 */
public class ViewImpl implements View {

	private static Controller controller;
	private static SimulationScreen simulationScreen;

	@Override
	public void setController(final Controller controller) {
		ViewImpl.controller = controller;
	}

	@Override
	public List<InputInfo> getInputs() {
		final List<InputInfo> list = InputHandler.getInputHandler().getInputs();
		// System.out.println("ECCO LA LISTAAAA: " + list.toString());
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
			Platform.runLater(() -> ViewImpl.simulationScreen.drawOnScreen(entities));
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

	static SimulationScreen getSimulationSceen() {
		return ViewImpl.simulationScreen;
	}

	static Controller getController() {
		return ViewImpl.controller;
	}

}
