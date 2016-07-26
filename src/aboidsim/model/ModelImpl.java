package aboidsim.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Simulation class. It contains all the environment.
 *
 */

public class ModelImpl implements Model {

    private final Environment simulation = EnvironmentImpl.getEnviromentImpl();

    @Override
    public Environment getSimulation() {
        return this.simulation;
    }

    @Override
    public List<String> getEntitiesNames() {
        return Arrays.stream(Entities.values()).map(entity -> entity.getName()).collect(Collectors.toList());
    }

    @Override
    public List<String> getRules() {
        return RuleImpl.getRuleNames();
    }
}
