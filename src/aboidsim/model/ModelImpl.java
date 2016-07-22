package aboidsim.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Simulation class. It contains all the enviroment.
 *
 */

public class ModelImpl implements Model {

    private final Environment simulation = new EnvironmentImpl();

    @Override
    public Environment getSimulation() {
        return this.simulation;
    }

    @Override
    public List<Integer> getLevels() {
        return Arrays.stream(Levels.values()).map(values -> values.getId()).collect(Collectors.toList());
    }

}
