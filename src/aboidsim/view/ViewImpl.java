package aboidsim.view;

import java.util.List;
import java.util.Set;

import aboidsim.util.InputInfo;
import aboidsim.util.Pair;
import aboidsim.util.Vector;
import javafx.application.Application;

/**
 * used to comunicate with the controller.
 *
 */
public class ViewImpl implements View {

	public List<InputInfo> getInputs() {
		// TODO Auto-generated method stub
		List<InputInfo> list = InputHandler.getInputHandler().getInputs();
		InputHandler.getInputHandler().clearInputs();
		return list;
	}

	public void start(final List<String> boids, final List<String> rules) {
		System.out.println(rules.toString()); // debug
		MainWindow.setBoids(boids);
		MainWindow.setRules(rules);
		Application.launch(MainWindow.class);

	}

	public void drawEntities(final Set<Pair<Vector, String>> entities) {
		// TODO Auto-generated method stub

	}

	public Pair<Integer, Integer> getScreenDimensions() {
		return new Pair<Integer, Integer>(SimulationScreen.WIDTH + SimulationScreen.BOID_HEIGHT,
				SimulationScreen.HEIGHT + SimulationScreen.BOID_HEIGHT);
	}

}
